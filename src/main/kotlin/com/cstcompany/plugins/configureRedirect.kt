package com.cstcompany.plugins

import com.cstcompany.HTTPS_PORT
import io.ktor.server.application.*
import io.ktor.server.plugins.httpsredirect.*

fun Application.configureRedirect(){
    install(HttpsRedirect){
        sslPort = HTTPS_PORT
        permanentRedirect = true
    }
}