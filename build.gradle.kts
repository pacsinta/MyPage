val ktor_version = "2.0.2"
val kotlin_version = "1.6.10"
val logback_version = "1.2.11"

plugins {
    application
    kotlin("jvm") version "1.6.10"
    id("com.github.johnrengelman.shadow") version "7.1.2"
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
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    //FreeMarker
    implementation("io.ktor:ktor-server-freemarker:$ktor_version")

    //ClassGraph
    implementation("io.github.classgraph:classgraph:4.8.149")

    //HttpRedirect
    implementation("io.ktor:ktor-server-http-redirect:$ktor_version")

    //KMongo
    implementation("org.litote.kmongo:kmongo:4.6.1")
}