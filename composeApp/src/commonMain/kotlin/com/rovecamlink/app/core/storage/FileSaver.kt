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
 * separators and `..` must never reach the filesystem. Windows' own naming rules
 * (reserved device names, trailing dots/spaces and DEL) are applied as well: the
 * same name is handed to Android, desktop and iOS, and it must be openable on all.
 */
fun sanitizeFileName(name: String): String {
    val base = name.substringAfterLast('/').substringAfterLast('\\').trim()
    val cleaned = base
        .replace("..", "_")
        .replace(Regex("""[<>:"/\\|?*\x00-\x1F\x7F]"""), "_")
        .trimEnd('.', ' ')
        .let { if (it.substringBefore('.').trim().uppercase() in WINDOWS_RESERVED_NAMES) "_$it" else it }
        .ifEmpty { "download" }
    return cleaned.truncateToCodePoints(MAX_FILE_NAME_CODE_POINTS)
}

/** Longest basename we will hand to a filesystem, counted in code points. */
private const val MAX_FILE_NAME_CODE_POINTS = 120

/**
 * Windows refuses these as names even with an extension (`CON.mp4`) in any directory,
 * so an underscore is prefixed to keep the name usable rather than dropping the file.
 */
private val WINDOWS_RESERVED_NAMES = setOf(
    "CON", "PRN", "AUX", "NUL",
    "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9",
    "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9",
)

/** Truncates to at most [max] code points, so a cut can never split a surrogate pair. */
private fun String.truncateToCodePoints(max: Int): String {
    if (length <= max) return this
    var count = 0
    var end = 0
    while (end < length && count < max) {
        end += if (this[end].isHighSurrogate() && end + 1 < length) 2 else 1
        count++
    }
    return substring(0, end)
}

/** Runtime permission broker (location/nearby-wifi for connecting, storage for saving). */
interface PermissionController {
    suspend fun ensureWifiPermissions(): Boolean
    suspend fun ensureStoragePermissions(): Boolean
}

expect fun createPermissionController(): PermissionController
