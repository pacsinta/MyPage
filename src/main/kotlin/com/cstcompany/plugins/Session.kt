package com.cstcompany.plugins

import io.ktor.server.application.*
import io.ktor.server.sessions.*

fun Application.configureSession(){
    install(Sessions){
        
    }
}