package com.cstcompany.plugins

import com.cstcompany.data.BlogPost
import com.cstcompany.pageLocation
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import java.io.File

fun Application.configureRouting(posts: MutableList<BlogPost>) {
    routing {
        static("/tutorial-images") {
            staticRootFolder = File("src/main/resources/pages")
            file("profile.jpg")
            static("/ktor/1") {
                staticRootFolder = File(staticRootFolder!!.path + "/tutorials/ktor/1")
                file("newproject.png")
                file("nameproject.png")
                file("addplugin.png")
                file("tree.png")
                file("fulltree.png")
                file("helloworld.png")
            }
        }

        get("/love") {
            val index = File("pages/KarinaVers.html")
            call.respondFile(index)
        }

        get("/") {
            val index = FreeMarkerContent("index.ftl", mapOf("posts" to posts))
            call.respond(index)
        }

        get("/feedback") {
            if (call.request.queryParameters["Name"] != null && call.request.queryParameters["Message"] != null) {
                call.application.environment.log.info("New message -> ${call.request.queryParameters["Name"]} : ${call.request.queryParameters["Message"]}")
                // TODO save message to database
                call.respondRedirect("/")
            }
            call.response.status(HttpStatusCode.BadRequest)
        }

        get("/tutorials/{name}") {
            val post = posts.find {
                it.redirectLocation == call.parameters["name"]
            }

            if (post == null) {
                call.respond(HttpStatusCode.BadRequest, "Invalid url")
            } else {
                var content = ""
                content = File(post.contentLocation).readText()
                val index = FreeMarkerContent(
                    "contentBase.ftl",
                    mapOf(
                        "title" to post.title,
                        "image" to post.image,
                        "content" to content,
                        "url" to "/feedback"
                    )
                )
                call.respond(index)
            }
        }
    }
}
