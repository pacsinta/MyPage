package com.cstcompany.pages.tutorials

import com.cstcompany.data.BlogPost
import com.cstcompany.database.impl.MainDataMongodbImpl
import com.cstcompany.pageLocation
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.index(posts: List<BlogPost>) {
    val mainDataRepository = MainDataMongodbImpl

    static("/tutorial-images") {
        staticBasePackage = pageLocation
        preCompressed {
            resource("profile.jpg")
        }
    }

    static{
        staticBasePackage = pageLocation
        preCompressed {
            file("/", "index.html")
        }
    }

    // TODO
    get("/old") {
        val index = FreeMarkerContent("index.ftl", mapOf("posts" to posts))
        mainDataRepository.incrementViewCount("index")
        call.respond(index)
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