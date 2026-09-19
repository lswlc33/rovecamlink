plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.kotlinSerialization)
    application
}

group = "com.rovecamlink.simulator"
version = "0.1.0"

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.cio)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.datetime)
}

application {
    mainClass.set("com.rovecamlink.simulator.MainKt")
}

kotlin {
    jvmToolchain(17)
}
