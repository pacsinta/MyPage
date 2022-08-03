package com.cstcompany.pages.karina

import com.cstcompany.database.impl.MainDataMongodbImpl
import com.cstcompany.images
import com.cstcompany.pageLocation
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.imageShow(){
    val mainDataRepository = MainDataMongodbImpl

    staticBasePackage = pageLocation
    resource("song.mp3")
    for(image in images){
        staticBasePackage = "$pageLocation/love_img"
        resource(image)
    }


    get("/loveyou"){
        val index = FreeMarkerContent(
            "LoveYou100.ftl",
            mapOf(
                "posts" to images.shuffled()
            )
        )

        mainDataRepository.incrementViewCount("loveyou")
        call.respond(index)
    }
}