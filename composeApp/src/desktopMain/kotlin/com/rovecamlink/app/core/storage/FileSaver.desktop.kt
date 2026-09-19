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
    override suspend fun publishToGallery(localFile: Path, displayName: String, mime: String): String =
        localFile.toString()
}

private class DesktopPermissions : PermissionController {
    override suspend fun ensureWifiPermissions(): Boolean = true
    override suspend fun ensureStoragePermissions(): Boolean = true
}

actual fun createFileSaver(): FileSaver = DesktopFileSaver()
actual fun createPermissionController(): PermissionController = DesktopPermissions()
