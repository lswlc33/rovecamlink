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
