package com.rovecamlink.app.core.log

import android.app.ActivityManager
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.ApplicationInfo
import android.media.MediaScannerConnection
import android.os.BatteryManager
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import androidx.core.content.FileProvider
import com.rovecamlink.app.androidContext
import okio.Path
import okio.Path.Companion.toPath
import java.io.File
import java.util.Locale
import java.util.TimeZone

/** `System.nanoTime()` is the only monotonic clock available on the JVM/ART. */
actual fun monotonicMillis(): Long = System.nanoTime() / 1_000_000L

/** Phone-side facts that change how a camera session behaves (build, OS, battery, locale). */
actual fun platformDiagnostics(): List<Pair<String, String>> {
    val ctx = androidContext
    val version = runCatching {
        ctx.packageManager.getPackageInfo(ctx.packageName, 0).versionName
    }.getOrNull() ?: "?"
    val debuggable = runCatching {
        (ctx.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE) != 0
    }.getOrDefault(false)
    // Passing null as the receiver is the documented way to read a sticky broadcast.
    val status = runCatching {
        ctx.registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }.getOrNull()

    return buildList {
        add("app.version" to version)
        add("app.build" to if (debuggable) "debug" else "release")
        add("platform" to "android")
        add("os.android" to "${Build.VERSION.RELEASE} (API ${Build.VERSION.SDK_INT})")
        add("device" to "${Build.MANUFACTURER} ${Build.MODEL} / ${Build.DEVICE}")
        add("device.build" to Build.ID)
        add("device.abi" to Build.SUPPORTED_ABIS.joinToString(","))
        add("app.locale" to Locale.getDefault().toString())
        add("app.timezone" to TimeZone.getDefault().id)
        status?.let { s ->
            val level = s.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale = s.getIntExtra(BatteryManager.EXTRA_SCALE, 100)
            if (level >= 0 && scale > 0) add("phone.battery" to "${level * 100 / scale}%")
            add("phone.charging" to if ((s.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0)) != 0) "yes" else "no")
        }
        val ram = (ctx.getSystemService(Context.ACTIVITY_SERVICE) as? ActivityManager)?.memoryClass
        ram?.let { add("phone.ram_class_mb" to "$it") }
    }
}

/**
 * Log files live in the app's external files dir (visible to a file manager, no
 * permission needed). Export offers two exits: the share sheet (FileProvider) and
 * a copy in public Downloads, because the fastest path is usually "send it to
 * myself" while Downloads is the one that survives without another app installed.
 */
private class AndroidLogStore : LogStore {

    private fun dir(): File {
        val base = androidContext.getExternalFilesDir(null) ?: androidContext.filesDir
        val d = File(base, "logs")
        if (!d.exists()) d.mkdirs()
        return d
    }

    override fun logsDir(): Path = dir().absolutePath.toPath()

    override fun save(fileName: String, content: String): String? {
        val local = File(dir(), File(fileName).name)
        if (!runCatching { local.writeText(content) }.isSuccess) return null
        return runCatching { publishToDownloads(local, File(fileName).name) }.getOrNull()
            ?: local.absolutePath
    }

    override fun share(fileName: String, content: String): Boolean {
        val local = File(dir(), File(fileName).name)
        if (!runCatching { local.writeText(content) }.isSuccess) return false
        val uri = runCatching {
            FileProvider.getUriForFile(
                androidContext, "${androidContext.packageName}.fileprovider", local,
            )
        }.getOrNull() ?: return false
        val send = Intent(Intent.ACTION_SEND)
            .setType("text/plain")
            .putExtra(Intent.EXTRA_STREAM, uri)
            .putExtra(Intent.EXTRA_SUBJECT, "RoveCamLink diagnostics ($fileName)")
            .addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        val chooser = Intent.createChooser(send, "Send RoveCamLink log")
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        return runCatching { androidContext.startActivity(chooser); true }.getOrDefault(false)
    }

    /** API 29+ has to go through MediaStore; below that a plain file copy works. */
    private fun publishToDownloads(src: File, name: String): String? {
        val ctx = androidContext
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val values = ContentValues().apply {
                put(MediaStore.MediaColumns.DISPLAY_NAME, name)
                put(MediaStore.MediaColumns.MIME_TYPE, "text/plain")
                put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS + "/RoveCamLink")
                put(MediaStore.MediaColumns.IS_PENDING, 1)
            }
            val resolver = ctx.contentResolver
            val uri = resolver.insert(MediaStore.Files.getContentUri("external"), values) ?: return null
            try {
                resolver.openOutputStream(uri)?.use { out -> src.inputStream().use { it.copyTo(out) } }
                    ?: throw java.io.IOException("MediaStore refused the stream")
                values.clear()
                values.put(MediaStore.MediaColumns.IS_PENDING, 0)
                resolver.update(uri, values, null, null)
                "Downloads/RoveCamLink/$name"
            } catch (t: Throwable) {
                runCatching { resolver.delete(uri, null, null) }
                null
            }
        } else {
            val publicDir = File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                "RoveCamLink",
            )
            if (!publicDir.exists() && !publicDir.mkdirs()) return null
            val dst = File(publicDir, name)
            runCatching { src.copyTo(dst, overwrite = true) }.getOrNull() ?: return null
            runCatching {
                MediaScannerConnection.scanFile(ctx, arrayOf(dst.absolutePath), arrayOf("text/plain"), null)
            }
            dst.absolutePath
        }
    }
}

actual fun createLogStore(): LogStore = AndroidLogStore()
