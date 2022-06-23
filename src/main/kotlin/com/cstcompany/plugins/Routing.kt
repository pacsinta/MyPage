package com.cstcompany.plugins

import com.cstcompany.data.BlogPost
import com.cstcompany.data.Image
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
            val testContent = listOf(BlogPost("Test", "Test", "Test", Image("", "Test"), "Test"))
            val index = FreeMarkerContent("index.ftl", mapOf("posts" to testContent))
            call.respond(index)
        }

        get("/tutorials/ktor-1"){

        }
    }
}
