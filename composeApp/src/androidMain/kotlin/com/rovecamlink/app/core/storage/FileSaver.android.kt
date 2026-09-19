package com.rovecamlink.app.core.storage

import android.content.ContentValues
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import com.rovecamlink.app.PermissionBridge
import com.rovecamlink.app.androidContext
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
        return try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val resolver = androidContext.contentResolver
                val isVideo = mime.startsWith("video")
                val collection = if (isVideo) MediaStore.Video.Media.EXTERNAL_CONTENT_URI
                else MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                val values = ContentValues().apply {
                    put(MediaStore.MediaColumns.DISPLAY_NAME, displayName)
                    put(MediaStore.MediaColumns.MIME_TYPE, mime)
                    put(
                        MediaStore.MediaColumns.RELATIVE_PATH,
                        (if (isVideo) Environment.DIRECTORY_MOVIES else Environment.DIRECTORY_PICTURES) + "/RoveCamLink",
                    )
                    put(MediaStore.MediaColumns.IS_PENDING, 1)
                }
                val uri = resolver.insert(collection, values) ?: return null
                resolver.openOutputStream(uri)?.use { out -> src.inputStream().use { it.copyTo(out) } }
                values.clear()
                values.put(MediaStore.MediaColumns.IS_PENDING, 0)
                resolver.update(uri, values, null, null)
                uri.toString()
            } else {
                val publicDir = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    "RoveCamLink",
                )
                if (!publicDir.exists()) publicDir.mkdirs()
                val out = File(publicDir, displayName)
                src.copyTo(out, overwrite = true)
                // Make it visible to the media scanner.
                runCatching {
                    android.media.MediaScannerConnection.scanFile(
                        androidContext, arrayOf(out.absolutePath), arrayOf(mime), null,
                    )
                }
                out.absolutePath
            }
        } catch (t: Throwable) {
            null
        }
    }
}

private class AndroidPermissions : PermissionController {
    override suspend fun ensureWifiPermissions(): Boolean {
        val perms = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arrayOf(
                android.Manifest.permission.NEARBY_WIFI_DEVICES,
                android.Manifest.permission.ACCESS_FINE_LOCATION,
            )
        } else {
            arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION)
        }
        return PermissionBridge.request(perms)
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
