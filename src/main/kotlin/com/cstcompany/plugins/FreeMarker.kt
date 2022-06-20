package com.cstcompany.plugins

import freemarker.cache.ClassTemplateLoader
import io.ktor.server.application.*
import io.ktor.server.freemarker.*

fun Application.configureFreeMarker(){
    install(FreeMarker){
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "pages")
    }
}