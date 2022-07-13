package com.cstcompany

import com.cstcompany.data.BlogPost
import com.cstcompany.data.Image
import com.cstcompany.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import java.io.File
import java.io.FileInputStream
import java.security.KeyStore

const val HTTP_PORT = 8088
const val HTTPS_PORT = 443
const val ENABLE_HTTPS = false
const val LOCALHOST_ONLY = false
fun main() {
    fun convert(path: String): MutableList<BlogPost> {
        val posts = mutableListOf<BlogPost>()
        File("$path/tutorials").walk().forEach {
            if (it.isFile && it.name == "description.txt") {
                val lines = it.readLines()
                posts.add(
                    BlogPost(
                        title = lines[0],
                        title2 = lines[1],
                        contentLocation = it.parent + "/index.html",
                        description = lines[2],
                        image = if (lines.size > 4) Image(name = lines[4], url = it.parent + "/image1") else Image(
                            "",
                            ""
                        ),
                        redirectLocation = lines[3]
                    )
                )
            }
        }

        return posts
    }

    //Load contents
    val contentDescriptionsPath = object {}.javaClass.getResource("/pages/")?.path!!
    val posts = convert(contentDescriptionsPath)

    var ks: KeyStore? = null
    var keyPassword: String? = null
    var jksPassword: String? = null
    var alias: String? = null
    if (ENABLE_HTTPS) {
        //Setup ssh key
        ks = KeyStore.getInstance("JKS")
        val pwd = File("pwd")

        val passwords = pwd.readText().split(';')
        keyPassword = passwords[0]
        jksPassword = passwords[1]
        alias = passwords[2]

        FileInputStream("keystore.jks").use { file ->
            ks.load(file, keyPassword.toCharArray())
        }
    }

    val environment = applicationEngineEnvironment {
        module {
            configureFreeMarker()
            configureRouting(posts)
        }

        connector {
            port = HTTP_PORT
            if (LOCALHOST_ONLY) {
                host = "127.0.0.1"
            }
        }

        if (ENABLE_HTTPS) {
            sslConnector(
                keyStore = ks!!,
                keyAlias = alias!!,
                keyStorePassword = { jksPassword!!.toCharArray() },
                privateKeyPassword = { keyPassword!!.toCharArray() },
            ) {
                port = HTTPS_PORT
            }
        }
    }

    embeddedServer(Netty, environment = environment).start(wait = true)
}
