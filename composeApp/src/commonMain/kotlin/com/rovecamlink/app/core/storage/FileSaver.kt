package com.rovecamlink.app.core.storage

import okio.Path

/**
 * Saves downloaded media to a user-visible location. On Android this stages to
 * app storage then publishes into MediaStore (Downloads/RoveCamLink) so files
 * appear in the gallery without scoped-storage pain.
 */
interface FileSaver {
    /** Working directory for in-progress / completed downloads. */
    fun downloadsDir(): Path

    /**
     * Where fetched firmware packages live until they are sent to the camera.
     *
     * Separate from [downloadsDir] on purpose: that one holds user media and gets
     * offered to the gallery, while a 54 MB firmware image is neither media nor
     * something to leave lying around in a user-visible folder. Defaults to a
     * subdirectory so no platform has to implement it; the subdirectory is
     * app-private storage on every platform that has one.
     */
    fun firmwareDir(): Path = downloadsDir() / "firmware"

    /** Publish a finished file to the public gallery/downloads. Returns a display path or null. */
    suspend fun publishToGallery(localFile: Path, displayName: String, mime: String): String?
}

expect fun createFileSaver(): FileSaver

/**
 * Reduces a device-supplied file name to a safe basename. A camera's file listing
 * is attacker-controllable — any hotspot we happen to join can answer it — so
 * separators and `..` must never reach the filesystem.
 */
fun sanitizeFileName(name: String): String {
    val base = name.substringAfterLast('/').substringAfterLast('\\').trim()
    val cleaned = base.replace("..", "_").replace(Regex("""[<>:"/\\|?*\x00-\x1F]"""), "_")
    return cleaned.ifEmpty { "download" }.take(120)
}

/** Runtime permission broker (location/nearby-wifi for connecting, storage for saving). */
interface PermissionController {
    suspend fun ensureWifiPermissions(): Boolean
    suspend fun ensureStoragePermissions(): Boolean
}

expect fun createPermissionController(): PermissionController
