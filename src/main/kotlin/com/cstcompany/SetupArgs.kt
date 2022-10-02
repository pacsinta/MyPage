package com.cstcompany

import com.cstcompany.plugins.configureDatabase

fun setup(args: Array<String>) {
    // Load the configurations from the args
    val config: MutableMap<String, String> = mutableMapOf()
    args.forEach { arg ->
        val split = arg.split("=")
        if (split.size == 2) {
            config[split[0]] = split[1]
        }
    }


    pageLocation = if (!config.containsKey("pageLocation")) {
        "pages"
    } else {
        config["pageLocation"].toString()
    }

    if (config.containsKey("https")) {
        ENABLE_HTTPS = config["https"] == "1"
    }
    if (config.containsKey("localhost")) {
        LOCALHOST_ONLY = config["localhost"] == "1"
    }
    if (config.containsKey("refreshDelay")) {
        POST_REFRESH_DELAY = config["refreshDelay"]!!.toLong()
    }
    if (config.containsKey("database_name")) {
        DATABASE_NAME = config["database_name"]!!
    }
    if (config.containsKey("mongo_name") && config.containsKey("mongo_pwd") && config.containsKey("mongo_database")) {
        configureDatabase(
            name = config["mongo_name"],
            pwd = config["mongo_pwd"],
            database = config["mongo_database"]
        )
    } else if (config.containsKey("mongo_name") || config.containsKey("mongo_pwd") || config.containsKey("mongo_database")) {
        throw Error("A name and a password is needed to configure mongodb!")
    } else {
        var file = "kmongoConfig"
        if (config.containsKey("kmongo_file")) {
            file = config["kmongo_file"]!!
        }
        configureDatabase(file = file)
    }
}