package com.rovecamlink.app.core.storage

import android.content.ContentValues
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import com.rovecamlink.app.PermissionBridge
import com.rovecamlink.app.androidContext
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogTag
import okio.Path
import okio.Path.Companion.toPath
import java.io.File

private class AndroidFileSaver : FileSaver {

    override fun downloadsDir(): Path {
        val base = androidContext.getExternalFilesDir(null) ?: androidContext.filesDir
        val dir = File(base, "downloads")
        if (!dir.exists()) dir.mkdirs()
        return dir.absolutePath.toPath()
    }

    override suspend fun publishToGallery(localFile: Path, displayName: String, mime: String): String? {
        val src = File(localFile.toString())
        if (!src.exists()) return null
        val safeName = sanitizeFileName(displayName)
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val resolver = androidContext.contentResolver
            val isVideo = mime.startsWith("video")
            val collection = if (isVideo) MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            else MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            val values = ContentValues().apply {
                put(MediaStore.MediaColumns.DISPLAY_NAME, safeName)
                put(MediaStore.MediaColumns.MIME_TYPE, mime)
                put(
                    MediaStore.MediaColumns.RELATIVE_PATH,
                    (if (isVideo) Environment.DIRECTORY_MOVIES else Environment.DIRECTORY_PICTURES) + "/RoveCamLink",
                )
                put(MediaStore.MediaColumns.IS_PENDING, 1)
            }
            val uri = resolver.insert(collection, values) ?: return null
            try {
                // A null stream used to be skipped silently, publishing a 0-byte
                // entry that looked like a successful save.
                val out = resolver.openOutputStream(uri)
                    ?: throw java.io.IOException("gallery refused the stream")
                out.use { dst -> src.inputStream().use { it.copyTo(dst) } }
                values.clear()
                values.put(MediaStore.MediaColumns.IS_PENDING, 0)
                resolver.update(uri, values, null, null)
                uri.toString()
            } catch (t: Throwable) {
                // Otherwise the half-written row stays IS_PENDING=1 forever, invisible
                // to the user but squatting on the file name.
                runCatching { resolver.delete(uri, null, null) }
                null
            }
        } else {
            try {
                val publicDir = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    "RoveCamLink",
                )
                if (!publicDir.exists()) publicDir.mkdirs()
                val out = File(publicDir, safeName)
                src.copyTo(out, overwrite = true)
                // Make it visible to the media scanner.
                runCatching {
                    android.media.MediaScannerConnection.scanFile(
                        androidContext, arrayOf(out.absolutePath), arrayOf(mime), null,
                    )
                }
                out.absolutePath
            } catch (t: Throwable) {
                null
            }
        }
    }
}

private class AndroidPermissions : PermissionController {
    override suspend fun ensureWifiPermissions(): Boolean {
        val nearby = android.Manifest.permission.NEARBY_WIFI_DEVICES
        val fineLocation = android.Manifest.permission.ACCESS_FINE_LOCATION
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            return PermissionBridge.request(arrayOf(fineLocation))
        }
        // Ask for both, but judge the outcome by the one that actually gates us:
        // NEARBY_WIFI_DEVICES is what lets the camera's AP be seen at all, while fine
        // location only adds the SSID *text* to `connectionInfo`. Requiring both turned
        // "the user granted one" into "cannot connect", with nothing on screen to
        // explain why.
        PermissionBridge.request(arrayOf(nearby, fineLocation))
        if (!PermissionBridge.isGranted(fineLocation)) {
            Diag.warn(
                LogTag.WIFI,
                "no fine location: camera networks stay discoverable but show no SSID",
            )
        }
        return PermissionBridge.isGranted(nearby)
    }

    override suspend fun ensureStoragePermissions(): Boolean {
        // API 29+ saves via MediaStore (no permission). Older needs WRITE_EXTERNAL_STORAGE.
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            true
        } else {
            PermissionBridge.request(arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE))
        }
    }
}

actual fun createFileSaver(): FileSaver = AndroidFileSaver()
actual fun createPermissionController(): PermissionController = AndroidPermissions()
