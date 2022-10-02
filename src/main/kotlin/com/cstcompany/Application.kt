package com.cstcompany

import com.cstcompany.plugins.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import java.io.File
import java.io.FileInputStream
import java.security.KeyStore

const val HTTP_PORT = 8088
const val HTTPS_PORT = 8087
const val DOMAIN = "cstcompany.ddns.net"

var ENABLE_HTTPS = false
var LOCALHOST_ONLY = true
var POST_REFRESH_DELAY = 1000L //* 60 * 10  // 10 minutes in milliseconds
var MONGODB_CLUSTER = "cluster0.hgi0p"
var DATABASE_NAME = "MyPageTest"
const val JWT_LIFETIME = 60000  // 1 minute in milliseconds

lateinit var pageLocation: String
var images: List<String> = mutableListOf()
fun main(args: Array<String>) {
    setup(args)

    //Load contents
    val posts = readData(pageLocation)
    images = readData2("pages/love_img")

    // Configure https if enabled
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


    // Configure the server
    val environment = applicationEngineEnvironment {
        module {
            configureFreeMarker()
            configureSession()
            configureJWT()
            configureRouting(posts)
            if(ENABLE_HTTPS){
                configureRedirect()
            }
            configureCompression()
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
