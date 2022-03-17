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

        get("/.well-known/pki-validation/8222F3F2C0686ECF94B8EE94E2BEFF5C.txt"){
            val sslAuthFile = File("8222F3F2C0686ECF94B8EE94E2BEFF5C.txt")

            call.respondFile(sslAuthFile)
        }
    }
}
