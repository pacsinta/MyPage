package com.cstcompany

import com.cstcompany.data.BlogPost
import com.cstcompany.data.Image
import com.cstcompany.plugins.configureFreeMarker
import com.cstcompany.plugins.configureRedirect
import com.cstcompany.plugins.configureRouting
import io.github.classgraph.ClassGraph
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.net.URL
import java.security.KeyStore


const val HTTP_PORT = 8088
const val HTTPS_PORT = 443
var ENABLE_HTTPS = true
var LOCALHOST_ONLY = true

lateinit var pageLocation: String
fun main(args: Array<String>) {
    fun convert(path: String): List<BlogPost> {
        val posts = mutableListOf<BlogPost>()

        var resourceNames: List<URL?>
        ClassGraph()
            .acceptPaths("$path/tutorials")
            .scan().use { scanResult -> resourceNames = scanResult.allResources.urLs }

        resourceNames.forEach { resourceName ->
            if (resourceName != null) {
                if (resourceName.path.contains("description.txt")) {
                    val stream = resourceName.openStream()
                    val lines = BufferedReader(InputStreamReader(stream)).readLines()

                    val parentFolder = resourceName.path.removeSuffix("/description.txt").replaceBefore("/pages/", "")

                    if (lines[0] != "not ready") {
                        posts.add(
                            BlogPost(
                                title = lines[0],
                                title2 = lines[1],
                                contentLocation = "$parentFolder/index.html",
                                description = lines[2],
                                image = if (lines.size > 4) Image(
                                    name = lines[4],
                                    url = "$parentFolder/image1"
                                ) else Image(
                                    "",
                                    ""
                                ),
                                redirectLocation = lines[3]
                            )
                        )
                    } else if (LOCALHOST_ONLY) {
                        posts.add(
                            BlogPost(
                                title = lines[1],
                                title2 = lines[2],
                                contentLocation = "$parentFolder/index.html",
                                description = lines[3],
                                image = if (lines.size > 5) Image(
                                    name = lines[5],
                                    url = "$parentFolder/image1"
                                ) else Image(
                                    "",
                                    ""
                                ),
                                redirectLocation = lines[4]
                            )
                        )
                    }
                }
            }
        }

        return posts.reversed()
    }

    val config: MutableMap<String, String> = mutableMapOf()
    args.forEach { arg ->
        val split = arg.split("=")
        if (split.size == 2) {
            config[split[0]] = split[1]
        }
    }

    pageLocation = if (!config.containsKey("pageLocation")) {
        "pages"
    } else {
        config["pageLocation"].toString()
    }

    if (config.containsKey("https")) {
        ENABLE_HTTPS = config["https"] == "1"
    }
    if (config.containsKey("localhost")) {
        LOCALHOST_ONLY = config["localhost"] == "1"
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
            configureRedirect()
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
                if (LOCALHOST_ONLY) {
                    host = "127.0.0.1"
                }
            }
        }
    }

    embeddedServer(Netty, environment = environment).start(wait = true)
}
