package com.rovecamlink.app.core.log

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import okio.FileSystem
import okio.Path
import okio.Path.Companion.toPath
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSLocale
import platform.Foundation.NSProcessInfo
import platform.Foundation.NSTemporaryDirectory
import platform.Foundation.NSTimeZone
import platform.Foundation.NSUserDomainMask

/** `systemUptime` is the monotonic clock on Darwin (it does not follow clock updates). */
actual fun monotonicMillis(): Long = (NSProcessInfo.processInfo.systemUptime * 1000.0).toLong()

/**
 * iOS facts, deliberately from `NSProcessInfo`/`Foundation` only: this is called from
 * the logger's writer thread, and `UIDevice` is main-thread-only. The vendor device
 * name (`UIDevice.name`, "李工的 iPhone") is also personal data that has no business
 * inside a file the user is about to share.
 */
actual fun platformDiagnostics(): List<Pair<String, String>> {
    val info = NSProcessInfo.processInfo
    val os = info.operatingSystemVersion
    val local = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    return listOf(
        "app.version" to "dev",
        "app.build" to "ios",
        "platform" to "ios",
        "os.ios" to "${os.majorVersion}.${os.minorVersion}.${os.patchVersion}",
        "device.locale" to (NSLocale.currentLocale.languageCode ?: "?"),
        "app.timezone" to NSTimeZone.localTimeZone.name,
        "app.local_time" to local.toString(),
        "app.home" to NSTemporaryDirectory(),
        "mem.ram_mb" to (info.physicalMemory / 1048576.0).toLong().toString(),
        "cpu.cores" to info.activeProcessorCount.toString(),
        "process.name" to info.processName,
    )
}

/**
 * iOS writes into the app's Documents directory; Files.app can browse it.
 * A share sheet is not wired up (no device to validate it), so `share` reports
 * "not available" and the UI falls back to showing the saved path.
 */
private class IosLogStore : LogStore {

    private fun dir(): Path {
        val paths = NSFileManager.defaultManager.URLsForDirectory(NSDocumentDirectory, NSUserDomainMask)
        val url = paths.firstOrNull() as? platform.Foundation.NSURL
        val base = url?.path ?: NSTemporaryDirectory()
        val logs = "$base/RoveCamLink/logs".toPath()
        runCatching { FileSystem.SYSTEM.createDirectories(logs) }
        return logs
    }

    override fun logsDir(): Path = dir()

    override fun save(fileName: String, content: String): String? {
        val target = dir() / fileName
        return runCatching {
            FileSystem.SYSTEM.write(target) { writeUtf8(content) }
            target.toString()
        }.getOrNull()
    }

    override fun share(fileName: String, content: String): Boolean = false
}

actual fun createLogStore(): LogStore = IosLogStore()
