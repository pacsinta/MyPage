package com.cstcompany.plugins

import com.cstcompany.POST_REFRESH_DELAY
import com.cstcompany.data.BlogPost
import com.cstcompany.database.impl.MainDataMongodbImpl
import com.cstcompany.pageLocation
import com.cstcompany.readData
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.File

fun Application.configureRouting(posts: List<BlogPost>) {
    val mainDataRepository = MainDataMongodbImpl

    routing {
        staticBasePackage = pageLocation
        resource("google0dee9f0367abf7ae.html")
        static("/tutorial-images") {
            staticBasePackage = pageLocation
            resource("profile.jpg")
            static("/ktor/1") {
                staticBasePackage = "$pageLocation/tutorials/ktor/1"
                resource("newproject.png")
                resource("nameproject.png")
                resource("addplugin.png")
                resource("tree.png")
                resource("fulltree.png")
                resource("helloworld.png")
            }
        }

        get("/love") {
            val index = File("pages/KarinaVers.html")
            call.respondFile(index)
        }

        get("/") {
            val index = FreeMarkerContent("index.ftl", mapOf("posts" to posts))
            mainDataRepository.incrementViewCount("index")
            call.respond(index)
        }

        get("/feedback") {
            if (call.request.queryParameters["Name"] != null && call.request.queryParameters["Message"] != null) {
                call.application.environment.log.info("New message -> ${call.request.queryParameters["Name"]} : ${call.request.queryParameters["Message"]}")

                mainDataRepository.saveMessage(call.request.queryParameters["Name"]!!, call.request.queryParameters["Message"]!!)

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
                val content = object {}.javaClass.getResource(post.contentLocation)?.readText()
                if (content == null) {
                    call.respond(HttpStatusCode.BadRequest, "Invalid url")
                    return@get
                }

                val index = FreeMarkerContent(
                    "contentBase.ftl",
                    mapOf(
                        "title" to post.title,
                        "image" to post.image,
                        "content" to content,
                        "url" to "/feedback"
                    )
                )
                mainDataRepository.incrementViewCount(post.title)
                call.respond(index)
            }
        }
    }
}
