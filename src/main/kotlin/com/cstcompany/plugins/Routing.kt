package com.cstcompany.plugins

import com.cstcompany.data.BlogPost
import com.cstcompany.data.Image
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import java.io.File
import kotlin.math.log

fun Application.configureRouting(posts: MutableList<BlogPost>) {

    routing {
        get("/love") {
            val index = File("pages/KarinaVers.html")
            call.respondFile(index)
        }

        get("/") {
            val index = FreeMarkerContent("index.ftl", mapOf("posts" to posts))
            call.respond(index)
        }

        get("/tutorials/{name}"){
            val post = posts.find {
                it.redirectLocation == call.parameters["name"]
            }

            if(post==null){
                call.respond(HttpStatusCode.BadRequest, "Invalid url")
            }else{
                val index = FreeMarkerContent("contentBase.ftl", mapOf("title" to post.title))
                call.respond(index)
            }
        }
    }
}
