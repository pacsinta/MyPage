package com.cstcompany.pages.tutorials.ktor

import com.cstcompany.pageLocation
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Route.ktor2() {
    static("/ktor/2") {
        staticBasePackage = "$pageLocation/tutorials/ktor/2"
        resource("request.png")
        resource("mainFun.png")
    }
}