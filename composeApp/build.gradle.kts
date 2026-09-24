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
        // iosX64 (the Intel simulator) is gone: Compose 1.12 publishes no artifact for it,
        // which makes the whole appleMain source set fail to resolve. Do not add it back
        // without checking the runtime/foundation variants exist for that version.
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

            implementation(libs.miuix.ui)
            implementation(libs.miuix.preference)
            implementation(libs.miuix.icons)
            // The bar blur. Its Android artifact declares minSdk 32 (RuntimeShader), while
            // this app ships to 24, so the manifest overrides that library — see the
            // `uses-sdk` note in androidMain/AndroidManifest.xml — and every call site is
            // gated on `isRuntimeShaderSupported()`. On anything older the bars simply stay
            // solid, which is what they look like today.
            implementation(libs.miuix.blur)

            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.kotlinx.datetime)
            implementation(libs.okio)

            implementation(libs.ktor.core)
            implementation(libs.ktor.cio)
            implementation(libs.ktor.network)
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
    // miuix 0.9.4 的每个 aar 都在 metadata 里要求 compileSdk >= 37，写在 35 上
    // :checkDebugAarMetadata 会直接红。targetSdk 留在 35：运行时行为不动，
    // AAR 检查只卡 compileSdk。
    compileSdk = 37

    defaultConfig {
        applicationId = "com.rovecamlink.app"
        minSdk = 24
        targetSdk = 35
        versionCode = 4
        // 这一行是全仓库唯一的版本号来源：nightly.yml 与 release.yml 都用 sed 从它取
        // versionName（前者拼进包名，后者比对 tag）。换成变量会让 CI 取到空值：nightly
        // 包名变成 unknown，release 的 tag 校验直接红。桌面包在下面的 compose.desktop
        // 块里回读同一个值，不再单独写第二份。
        versionName = "0.1.3"
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

    // 体积问题只在「没裁剪的代码」上：不开 R8 时 30182 个类全被打进包里（Guava 2107、
    // Compose 约 7700、miuix 1765、Media3 约 2600、CameraX 约 1700、Ktor 约 1900、
    // zxing 291……其中绝大多数从未被引用），19.93MB 的包里 dex 占 18.16MB，而全部原生库
    // 只有 0.18MB、资源 0.67MB。所以 R8 只开在 release 上，nightly 与正式版都发它。
    // 实测（本机全新构建）：release 3.64MB(1 个 dex)。
    //
    // debug 保持不裁剪。它只服务本地与模拟器调试，体积无所谓；一旦开裁剪，坏处全落在
    // 本地迭代链路上而收益为零：①R8 每次 debug 构建都要跑一遍，拖慢「改一行→装上模拟器」；
    // ②没被引用的类会被删掉，想 step 进去看的时候类已经不存在；③资源收缩可能误删只在
    // 运行时按名字取用的资源，而这种问题只会在你本机复现。以前给 debug 开裁剪的唯一理由是
    // 「nightly 发的就是 debug」，现在 nightly 改发 release（见 .github/workflows/nightly.yml），
    // 那个理由已经不成立了。
    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            if (hasSharedSigningKey) {
                signingConfig = signingConfigs.getByName("rovrecamlink")
            }
        }
        // release 是唯一开 R8 的：裁剪 + 资源收缩 + optimize 规则（比默认规则多做内联/合并）。
        // 混淆被 proguard-rules.pro 里的 -dontobfuscate 关掉，代价只有 0.06MB，换来诊断日志
        // 里的崩溃堆栈直接可读——core/log/CrashRecorder.kt 就是靠它把现场带回来的。
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
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
            // 回读 android 那份版本号，桌面包不再单独写死（以前写死 1.0.0，
            // 「应用和功能」里显示的是一个和 App 无关的版本）。
            packageVersion = android.defaultConfig.versionName
                ?: error("android.defaultConfig.versionName is null")
            vendor = "RoveCamLink"
            // 只能 ASCII：jpackage.exe 用本机 ANSI 码页（这里是 GBK）读 Gradle 写给它的
            // @argfile，中文的 UTF-8 字节会让它在 "Input length = 1" 直接失败。
            // App 界面本身仍是全中文，这里只是安装器元数据。
            description = "RoveCamLink - action camera connection and media manager"
            copyright = "Copyright 2026 RoveCamLink contributors"

            windows {
                // 不打图标的话 exe、任务栏、快捷方式全是 jpackage 默认的 Java 杯子。
                // .ico 由 tools/IconGen.java 从 相机 app/icon.png 生成。
                iconFile = project.file("icons/RoveCamLink.ico")
                // 装到当前用户，不弹 UAC、不需要管理员；这台机器上就是自己用。
                perUserInstall = true
                menuGroup = "RoveCamLink"
                shortcut = true
            }

            macOS {
                // Apple 的打包格式要求 MAJOR > 0，而 App 现在还是 0.x.y，所以只有 .dmg
                // 这两个字段顶成 1.0.0；Windows 与 Debian 包照用 versionName。
                // 版本到 1.0.0 之后可以连着这两行一起删掉。
                dmgPackageVersion = "1.0.0"
                dmgPackageBuildVersion = "1.0.0"
            }
        }
    }
}

// 把生成的 Res 类固定在 com.rovecamlink.app 包下,UI/状态层可直接 import。
compose.resources {
    publicResClass = true
    packageOfResClass = "com.rovecamlink.app"
}
