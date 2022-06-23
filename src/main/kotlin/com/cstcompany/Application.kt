package com.cstcompany

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
const val LOCALHOST_ONLY = true
fun main() {
    //Load contents
    fun getResourceAsText(path: String): String? = object {}.javaClass.getResource(path)?.readText()

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
        module(Application::configureRouting)
        module(Application::configureFreeMarker)

        connector {
            port = HTTP_PORT
            if(LOCALHOST_ONLY){
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
