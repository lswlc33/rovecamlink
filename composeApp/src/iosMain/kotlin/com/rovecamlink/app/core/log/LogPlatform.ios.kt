@file:OptIn(kotlinx.cinterop.ExperimentalForeignApi::class)

package com.rovecamlink.app.core.log

import okio.FileSystem
import okio.Path
import okio.Path.Companion.toPath
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSProcessInfo
import platform.Foundation.NSTemporaryDirectory
import platform.Foundation.NSUserDomainMask

/** `systemUptime` is the monotonic clock on Darwin (it does not follow clock updates). */
actual fun monotonicMillis(): Long = (NSProcessInfo.processInfo.systemUptime * 1000.0).toLong()

/**
 * iOS facts, deliberately limited to `NSProcessInfo` and the sandbox path:
 *
 *  - this runs on the logger's writer thread, and `UIDevice` is main-thread-only, so
 *    the marketing model name is left out;
 *  - the user-chosen device name ("李工的 iPhone") is personal data with no business in
 *    a file the user is about to share;
 *  - `NSLocale`/`NSTimeZone` class accessors do not resolve from Kotlin/Native the way
 *    they read on the JVM, and every record already carries a device-local wall clock
 *    plus the header's `device.tz=`, which pins the offset down far enough.
 */
actual fun platformDiagnostics(): List<Pair<String, String>> {
    val info = NSProcessInfo.processInfo
    return listOf(
        "app.version" to "dev",
        "app.build" to "ios",
        "platform" to "ios",
        "process.name" to info.processName,
        "process.uptime_s" to info.systemUptime.toLong().toString(),
        "cpu.cores" to info.activeProcessorCount.toString(),
        // physicalMemory is a ULong, so the scaling has to happen in Double.
        "mem.ram_mb" to (info.physicalMemory.toDouble() / 1048576.0).toLong().toString(),
        "app.sandbox" to NSTemporaryDirectory(),
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
