val ktor_version = "2.1.1"
val kotlin_version = "1.6.10"
val logback_version = "1.4.1"

plugins {
    application
    kotlin("jvm") version "1.6.10"
}

group = "com.cstcompany"
version = "0.0.1"
application {
    mainClass.set("com.cstcompany.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-server-sessions-jvm:2.1.1")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    //FreeMarker
    implementation("io.ktor:ktor-server-freemarker:$ktor_version")

    //ClassGraph
    implementation("io.github.classgraph:classgraph:4.8.149")

    //HttpRedirect
    implementation("io.ktor:ktor-server-http-redirect:$ktor_version")

    //KMongo
    implementation("org.litote.kmongo:kmongo:4.7.1")

    //Compression
    implementation("io.ktor:ktor-server-compression:$ktor_version")

    // Jwt
    implementation("io.ktor:ktor-server-auth:$ktor_version")
    implementation("io.ktor:ktor-server-auth-jwt:$ktor_version")
}