package com.cstcompany.plugins

import com.cstcompany.data.KmongoData
import java.io.File

lateinit var kmongoData: KmongoData
fun configureDatabase(pwd: String? = null, name: String? = null, database: String? = null, file: String = "kmongoConfig") {
    kmongoData = if(pwd == null || name == null || database == null){
        val kmongoFile = File(file)
        val kmongoConfig = kmongoFile.readText().split("\n")
        KmongoData(
            pwd = kmongoConfig[0].replace("\r", ""),
            user = kmongoConfig[1].replace("\r", ""),
            database = kmongoConfig[2].replace("\r", "")
        )
    }else{
        KmongoData(pwd, name, database)
    }
}