package com.cstcompany.plugins

import com.cstcompany.DOMAIN
import com.cstcompany.LOCALHOST_ONLY
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.compression.*

fun Application.configureCompression() {
    install(Compression) {
        gzip{
            if(!LOCALHOST_ONLY){
                condition {
                    request.headers[HttpHeaders.Referrer]?.startsWith("https://$DOMAIN/") == true
                }
            }
        }
    }
}