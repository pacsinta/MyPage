package com.cstcompany.pages.karina

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

fun Route.karinavers1(){
    get("/love") {
        val index = File("pages/KarinaVers.html")
        call.respondFile(index)
    }
}