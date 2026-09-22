import java.io.File
import java.util.Properties
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.kotlinCompose)
}

kotlin {
    androidTarget {
        compilerOptions {
            // Local dev machines only have a JDK 17; JVM-21 bytecode would make
            // tests and the desktop app impossible to run locally.
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }

    jvm("desktop") {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        val desktopMain by getting

        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            implementation(libs.cupertino)
            implementation(libs.cupertino.icons.extended)

            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.kotlinx.datetime)
            implementation(libs.okio)

            implementation(libs.ktor.core)
            implementation(libs.ktor.cio)
            implementation(libs.ktor.content.negotiation)
            implementation(libs.ktor.serialization.json)
        }

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.androidx.core.ktx)
            implementation(libs.androidx.lifecycle.runtime)
            implementation(libs.kotlinx.coroutines.android)
            implementation(libs.media3.exoplayer)
            implementation(libs.media3.exoplayer.rtsp)
            implementation(libs.media3.ui)
            implementation(libs.camera.core)
            implementation(libs.camera.camera2)
            implementation(libs.camera.lifecycle)
            implementation(libs.camera.view)
            implementation(libs.zxing.core)
        }

        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            // Deliberately no new test artifacts: CI resolves dependencies through a
            // proxy that is not reachable there, so only cached coordinates may appear
            // here. Tests that need real coroutines live in desktopTest (JVM, runBlocking).
        }
    }
}

android {
    namespace = "com.rovecamlink.app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.rovecamlink.app"
        minSdk = 24
        targetSdk = 35
        versionCode = 2
        versionName = "0.1.1"
    }

    // 一把密钥签所有包：debug 与 release 共用同一份签名配置。
    // 原因：debug 默认走 Android SDK 的 debug.keystore，CI 每次在临时 runner 上现生成
    // 一把新密钥，于是每个 nightly 的证书都不一样，覆盖安装必然报「签名不符」。
    // 密钥来源优先环境变量（CI 解码 secret 后导出），其次仓库根的 keystore.properties
    // （本机开发用，已 gitignore，指回 _work 里的备份密钥）；两者都没有时退回默认的
    // debug 密钥，保证刚 clone 的人仍能构建，release 则产出未签名包。
    val signingProps = Properties().apply {
        val local = rootProject.file("keystore.properties")
        if (local.isFile) local.inputStream().use { load(it) }
    }
    val signingSetting: (String, String) -> String? = { name, env ->
        (System.getenv(env) ?: signingProps.getProperty(name))?.trim()?.takeIf { it.isNotEmpty() }
    }
    val signingStoreFile =
        signingSetting("keystore.file", "ROVECAMLINK_RELEASE_STORE_FILE")
    val signingStorePassword =
        signingSetting("keystore.password", "ROVECAMLINK_RELEASE_STORE_PASSWORD")
    val signingKeyAlias = signingSetting("key.alias", "ROVECAMLINK_RELEASE_KEY_ALIAS")
    val signingKeyPassword = signingSetting("key.password", "ROVECAMLINK_RELEASE_KEY_PASSWORD")
    val hasSharedSigningKey =
        listOf(signingStoreFile, signingStorePassword, signingKeyAlias, signingKeyPassword)
            .all { it != null }
    if (hasSharedSigningKey) {
        // ASCII on purpose: a Windows console renders Chinese Gradle log lines as mojibake.
        println("RoveCamLink: signing debug + release with the shared key $signingStoreFile")
    }

    signingConfigs {
        if (hasSharedSigningKey) {
            create("rovrecamlink") {
                val path = signingStoreFile!!
                val store = File(path)
                storeFile = if (store.isAbsolute) store else rootProject.file(path)
                storePassword = signingStorePassword
                keyAlias = signingKeyAlias
                keyPassword = signingKeyPassword
            }
        }
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            if (hasSharedSigningKey) {
                signingConfig = signingConfigs.getByName("rovrecamlink")
            }
        }
        getByName("release") {
            isMinifyEnabled = false
            if (hasSharedSigningKey) {
                signingConfig = signingConfigs.getByName("rovrecamlink")
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

compose.desktop {
    application {
        mainClass = "com.rovecamlink.app.MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Msi, TargetFormat.Dmg, TargetFormat.Deb)
            packageName = "RoveCamLink"
            packageVersion = "1.0.0"
        }
    }
}

// 把生成的 Res 类固定在 com.rovecamlink.app 包下,UI/状态层可直接 import。
compose.resources {
    publicResClass = true
    packageOfResClass = "com.rovecamlink.app"
}
