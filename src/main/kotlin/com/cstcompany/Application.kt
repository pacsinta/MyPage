package com.cstcompany

import com.cstcompany.data.BlogPost
import com.cstcompany.data.Image
import com.cstcompany.plugins.*
import io.github.classgraph.ClassGraph
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import java.io.*
import java.net.URL
import java.nio.charset.StandardCharsets
import java.security.KeyStore
import java.util.stream.Collectors.toList


const val HTTP_PORT = 8088
const val HTTPS_PORT = 443
const val ENABLE_HTTPS = false
const val LOCALHOST_ONLY = false

lateinit var pageLocation: String
fun main(args: Array<String>) {
    fun convert(path: String): MutableList<BlogPost> {
        val posts = mutableListOf<BlogPost>()

        var resourceNames: List<URL?>
        ClassGraph()
            .acceptPaths("$path/tutorials")
            .scan().use { scanResult -> resourceNames = scanResult.allResources.urLs }

        resourceNames.forEach { resourceName ->
            if (resourceName != null) {
                if(resourceName.path.contains("description.txt")) {
                    val stream = resourceName.openStream()
                    val lines = BufferedReader(InputStreamReader(stream)).readLines()

                    val parentFolder = resourceName.path.removeSuffix("/description.txt")

                    posts.add(
                        BlogPost(
                            title = lines[0],
                            title2 = lines[1],
                            contentLocation = "$parentFolder/index.html",
                            description = lines[2],
                            image = if (lines.size > 4) Image(name = lines[4], url = "$parentFolder/image1") else Image(
                                "",
                                ""
                            ),
                            redirectLocation = lines[3]
                        )
                    )
                }
            }
        }

        return posts
    }

    pageLocation = if (args.isEmpty()) {
        "pages"
    } else {
        args[0]
    }

    //Load contents
    val posts = convert(pageLocation)

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
