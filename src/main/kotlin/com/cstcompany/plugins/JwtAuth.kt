package com.cstcompany.plugins

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import java.io.File

lateinit var jwtAudience: String
lateinit var jwtIssuer: String
lateinit var jwtSecret: String
lateinit var jwtRealm: String
lateinit var rootPassword: String
fun Application.configureJWT(configFile: String? = null) {
    val jwtConfigFile = File(configFile ?: "jwtConfig")
    val jwtConfig = jwtConfigFile.readText().split("\n")

    jwtAudience = jwtConfig[0].replace("\r", "")
    jwtIssuer = jwtConfig[1].replace("\r", "")
    jwtSecret = jwtConfig[2].replace("\r", "")
    jwtRealm = jwtConfig[3].replace("\r", "")
    rootPassword = jwtConfig[4].replace("\r", "")

    install(Authentication) {
        jwt("jwtAuth") {
            realm = jwtRealm
            verifier(
                JWT
                    .require(Algorithm.HMAC512(jwtSecret))
                    .withAudience(jwtAudience)
                    .withIssuer(jwtIssuer)
                    .build()
            )

            challenge { _, _ ->
                call.respond(HttpStatusCode.Unauthorized, "Token is not valid or has expired")
            }
        }
    }
}