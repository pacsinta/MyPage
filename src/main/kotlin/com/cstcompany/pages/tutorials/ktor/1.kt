package com.cstcompany.pages.tutorials.ktor

import com.cstcompany.pageLocation
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Route.ktor1(){
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