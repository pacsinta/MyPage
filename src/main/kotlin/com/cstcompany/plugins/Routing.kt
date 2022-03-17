package com.cstcompany.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import java.io.File

fun Application.configureRouting() {

    routing {
        get("/") {
            val index = File("index.html")
            call.respondFile(index)
        }
    }
}
