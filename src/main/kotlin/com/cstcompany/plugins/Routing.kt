package com.cstcompany.plugins

import com.cstcompany.POST_REFRESH_DELAY
import com.cstcompany.data.BlogPost
import com.cstcompany.database.impl.MainDataMongodbImpl
import com.cstcompany.images
import com.cstcompany.pageLocation
import com.cstcompany.pages.karina.imageShow
import com.cstcompany.pages.karina.karinavers1
import com.cstcompany.pages.tutorials.index
import com.cstcompany.pages.tutorials.ktor.ktor1
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
            ktor1()
        }



        get("/feedback") {
            if (call.request.queryParameters["Name"] != null && call.request.queryParameters["Message"] != null) {
                call.application.environment.log.info("New message -> ${call.request.queryParameters["Name"]} : ${call.request.queryParameters["Message"]}")

                mainDataRepository.saveMessage(call.request.queryParameters["Name"]!!, call.request.queryParameters["Message"]!!)

                call.respondRedirect("/")
            }
            call.response.status(HttpStatusCode.BadRequest)
        }

        imageShow()
        karinavers1()
        index(posts)
    }
}
