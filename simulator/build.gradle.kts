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
    /**
     * `-PsimMain=` picks which fake `run` boots; the default is the hi3510 one, unchanged.
     * The per-fake doc comments referenced this switch before it existed — this makes
     * `gradlew :simulator:run -PsimMain=IcatchSimulatorKt` (or `SjcamSimulatorKt`) work.
     */
    val simMain = providers.gradleProperty("simMain").orElse("MainKt")
    mainClass.set(simMain.map { "com.rovecamlink.simulator.$it" })
}

kotlin {
    jvmToolchain(17)
}
