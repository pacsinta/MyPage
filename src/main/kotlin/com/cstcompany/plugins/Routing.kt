package com.cstcompany.plugins

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.cstcompany.*
import com.cstcompany.data.BlogPost
import com.cstcompany.database.impl.MainDataMongodbImpl
import com.cstcompany.pages.karina.imageShow
import com.cstcompany.pages.karina.karinavers1
import com.cstcompany.pages.tutorials.index
import com.cstcompany.pages.tutorials.ktor.ktor1
import com.cstcompany.pages.tutorials.ktor.ktor2
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.*

fun Application.configureRouting(posts: List<BlogPost>) {
    val mainDataRepository = MainDataMongodbImpl

    routing {
        staticBasePackage = pageLocation
        preCompressed {
            resource("google0dee9f0367abf7ae.html")
            resource("28b51a4b5486b2348815fa26b5a6262e.html")
        }
        static("/tutorial-images") {
            ktor1()
            ktor2()
        }

        get("/feedback") {
            if (call.request.queryParameters["Name"] != null && call.request.queryParameters["Message"] != null) {
                call.application.environment.log.info("New message -> ${call.request.queryParameters["Name"]} : ${call.request.queryParameters["Message"]}")

                mainDataRepository.saveMessage(
                    call.request.queryParameters["Name"]!!,
                    call.request.queryParameters["Message"]!!
                )

                call.respondRedirect("/")
            }
            call.response.status(HttpStatusCode.BadRequest)
        }

        get("/getToken") {
            val name = call.request.queryParameters["name"]
            val pwd = call.request.queryParameters["pwd"]

            if (name == "pacsinta" && pwd == rootPassword) {
                val token = JWT.create()
                    .withAudience(jwtAudience)
                    .withIssuer(jwtIssuer)
                    .withClaim("name", name)
                    .withExpiresAt(Date(System.currentTimeMillis() + JWT_LIFETIME))
                    .sign(Algorithm.HMAC512(jwtSecret))

                call.respond(hashMapOf("token" to token))
            } else {
                call.respondText("Wrong credentials: $name, $pwd", ContentType.Text.Plain, HttpStatusCode.Unauthorized)
            }
        }

        imageShow()
        karinavers1()
        index(posts)
    }
}
