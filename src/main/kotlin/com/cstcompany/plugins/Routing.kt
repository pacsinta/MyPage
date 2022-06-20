package com.cstcompany.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import java.io.File

fun Application.configureRouting() {

    routing {
        get("/love") {
            val index = File("pages/KarinaVers.html")
            call.respondFile(index)
        }

        get("/") {
            call.respond(FreeMarkerContent("index.ftl", mapOf("test" to "<h1>Kotlin</h1>")))
        }

        get("/tutorials/ktor-1"){

        }
    }
}
