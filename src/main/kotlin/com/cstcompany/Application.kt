package com.cstcompany

import com.cstcompany.plugins.*
import com.mongodb.client.MongoDatabase
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.litote.kmongo.getCollection
import java.io.Console
import java.io.File
import java.io.FileInputStream
import java.security.KeyStore


const val HTTP_PORT = 8088
const val HTTPS_PORT = 8087
var ENABLE_HTTPS = true
var LOCALHOST_ONLY = true
var POST_REFRESH_DELAY = 1000L //* 60 * 10  // 10 minutes in milliseconds
var MONGODB_CLUSTER = "cluster0.hgi0p"

lateinit var pageLocation: String
fun main(args: Array<String>) {
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
    if(config.containsKey("mongo_name") && config.containsKey("mongo_pwd") && config.containsKey("mongo_database")){
        configureDatabase(
            name = config["mongo_name"],
            pwd = config["mongo_pwd"],
            database = config["mongo_database"]
        )
    }else if(config.containsKey("mongo_name") || config.containsKey("mongo_pwd") || config.containsKey("mongo_database")){
        throw Error("A name and a password is needed to configure mongodb!")
    }else{
        var file = "kmongoConfig"
        if(config.containsKey("kmongo_file")){
            file = config["kmongo_file"]!!
        }
        configureDatabase(file = file)
    }

    data class Test(val counter: Int)

    //Load data from database
    val database = kmongoData.client.getDatabase("MyPage")
    val counter = database.getCollection<Test>("MainData")
    counter.insertOne(Test(1))
    val t = counter.find().first()
    if (t != null) {
        println(t.counter)
    }

    //Load contents
    val posts = readData(pageLocation)

    // Configure https if enabled
    var ks: KeyStore? = null
    var keyPassword: String? = null
    var jksPassword: String? = null
    var alias: String? = null
    if (ENABLE_HTTPS) {
        //Setup ssh key
        ks = KeyStore.getInstance("JKS")
        val pwd = File("pwd")

        val passwords = pwd.readText().split(';')
        keyPassword = passwords[0]
        jksPassword = passwords[1]
        alias = passwords[2]

        FileInputStream("keystore.jks").use { file ->
            ks.load(file, keyPassword.toCharArray())
        }
    }

    // Configure the server
    val environment = applicationEngineEnvironment {
        module {
            configureFreeMarker()
            configureRouting(posts)
            configureRedirect()
        }

        connector {
            port = HTTP_PORT
            if (LOCALHOST_ONLY) {
                host = "127.0.0.1"
            }
        }

        if (ENABLE_HTTPS) {


            sslConnector(
                keyStore = ks!!,
                keyAlias = alias!!,
                keyStorePassword = { jksPassword!!.toCharArray() },
                privateKeyPassword = { keyPassword!!.toCharArray() },
            ) {
                port = HTTPS_PORT
                if (LOCALHOST_ONLY) {
                    host = "127.0.0.1"
                }
            }
        }
    }

    embeddedServer(Netty, environment = environment).start(wait = true)
}
