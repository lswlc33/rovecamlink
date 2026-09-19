package com.rovecamlink.app.core.storage

import okio.FileSystem
import okio.Path
import okio.Path.Companion.toPath
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

private class IosFileSaver : FileSaver {
    private fun documents(): Path {
        val paths = NSFileManager.defaultManager.URLsForDirectory(NSDocumentDirectory, NSUserDomainMask)
        val url = paths.firstOrNull() as? platform.Foundation.NSURL
        val base = url?.path ?: NSTemporaryDirectorySafe()
        val dir = "$base/RoveCamLink".toPath()
        FileSystem.SYSTEM.createDirectories(dir)
        return dir
    }
    private fun NSTemporaryDirectorySafe(): String = platform.Foundation.NSTemporaryDirectory()
    override fun downloadsDir(): Path = documents()
    override suspend fun publishToGallery(localFile: Path, displayName: String, mime: String): String =
        localFile.toString()
}

private class IosPermissions : PermissionController {
    override suspend fun ensureWifiPermissions(): Boolean = true
    override suspend fun ensureStoragePermissions(): Boolean = true
}

actual fun createFileSaver(): FileSaver = IosFileSaver()
actual fun createPermissionController(): PermissionController = IosPermissions()
