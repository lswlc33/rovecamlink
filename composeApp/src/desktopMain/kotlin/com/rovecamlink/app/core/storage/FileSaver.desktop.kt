package com.rovecamlink.app.core.storage

import okio.FileSystem
import okio.Path
import okio.Path.Companion.toPath

private class DesktopFileSaver : FileSaver {
    private val dir: Path = "downloads".toPath()
    override fun downloadsDir(): Path {
        FileSystem.SYSTEM.createDirectories(dir)
        return dir
    }
    // Desktop has no system gallery: the file lives in the downloads directory. Reporting
    // that as "published" made the shared UI claim a save that never happened, so this is
    // an honest null and the caller keeps the file where it already is.
    override suspend fun publishToGallery(localFile: Path, displayName: String, mime: String): String? = null
}

private class DesktopPermissions : PermissionController {
    override suspend fun ensureWifiPermissions(): Boolean = true
    override suspend fun ensureStoragePermissions(): Boolean = true
}

actual fun createFileSaver(): FileSaver = DesktopFileSaver()
actual fun createPermissionController(): PermissionController = DesktopPermissions()
