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

/** Runtime permission broker (location/nearby-wifi for connecting, storage for saving). */
interface PermissionController {
    suspend fun ensureWifiPermissions(): Boolean
    suspend fun ensureStoragePermissions(): Boolean
}

expect fun createPermissionController(): PermissionController
