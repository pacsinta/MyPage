package com.cstcompany.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import java.io.File

fun Application.configureJWT(configFile: String?){
    val jwtConfigFile = File(configFile ?: "jwtConfig")
    val jwtConfig = jwtConfigFile.readText().split("\n")


    install(Authentication){
        jwt{
            /*secret = jwtConfig[0].replace("\r", ""),
            issuer = jwtConfig[1].replace("\r", ""),
            audience = jwtConfig[2].replace("\r", ""),
            realm = jwtConfig[3].replace("\r", "")*/
        }
    }
}