package com.cstcompany.pages.karina

import com.cstcompany.pageLocation
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

fun Route.karinavers1() {
    staticBasePackage = pageLocation
    authenticate("jwtAuth") {
        static("/love") {
            preCompressed {
                resource("", "KarinaVers.html")
            }
        }
    }
}