package com.rovecamlink.app.brand.xtu

import com.rovecamlink.app.core.model.FileType
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant

/**
 * Facts about one file on the camera's SD card, kept out of
 * [HisiliconProtocol] so they can be pinned against the bytes a real card
 * produced.
 *
 * The listing this reads comes from `getfilelistinfoios.cgi`, which answers a JSON
 * array — verbatim from the 2026-09-21 XTU S7PRO session:
 *
 *     {"path":"sd/DCIM/100XTUDV/NORM0011.MP4","create":"2026-09-21 18:37:52",
 *      "time":"27","size":"69935925","rotation":"0"}
 *
 * [time] (the clip's duration in seconds) and [rotation] are read by nobody here
 * and must not break the parse: `RemoteFile` has no field for either, and a
 * listing row that fails to decode costs the user a file they can see on the
 * camera but not in the app.
 */
object HiFiles {

    /** Video/photo from the extension alone — the firmware's `type` field does not exist. */
    fun typeOf(path: String): FileType {
        val lower = path.lowercase()
        return when {
            lower.endsWith(".mp4") || lower.endsWith(".lrv") || lower.endsWith(".mov") -> FileType.VIDEO
            lower.endsWith(".jpg") || lower.endsWith(".jpeg") ||
                lower.endsWith(".dng") || lower.endsWith(".png") -> FileType.PHOTO
            else -> FileType.UNKNOWN
        }
    }

    /**
     * The card's own preview file: the sibling `.THM` next to the original, for
     * **both** photos and videos.
     *
     * Pointing a thumbnail at the original was the crash this avoids — a 12–48 MP
     * JPEG decoded as a grid preview is far more than this app's heap, so a photo
     * listing could kill the process just by scrolling. Null (no preview) is the
     * answer for a name with no extension to swap; the original is never a fallback.
     */
    fun thumbnailPath(path: String): String? {
        val name = path.substringAfterLast('/')
        val dot = name.lastIndexOf('.')
        if (dot <= 0 || dot == name.length - 1) return null
        return path.substring(0, path.length - (name.length - dot)) + ".THM"
    }

    /**
     * The firmware's downscaled preview under `/thumb`, for files whose `.THM` sibling
     * does not answer. The S7PRO's card serves `.THM` for video but answers `500` for a
     * photo's (2026-09-24 log: `GET …/SING0001.THM -> 500`) — and the official app carries
     * a second endpoint for exactly that case, `http://<ip>/thumb/<path without
     * extension>.jpg` (`docs/08 …/02-XTUGO-档案.md` §2.4, the SigmaStar branch of
     * `Hisi_CameraPicFragment`). Null when there is no extension to swap.
     */
    fun thumbJpgPath(path: String): String? {
        val name = path.substringAfterLast('/')
        val dot = name.lastIndexOf('.')
        if (dot <= 0 || dot == name.length - 1) return null
        return "thumb/" + path.substring(0, path.length - (name.length - dot)) + ".jpg"
    }

    /**
     * A firmware timestamp as epoch millis, local time (camera file names are local
     * too), or null when the string is not a timestamp at all.
     *
     * Two spellings are live in the field: the `yyyyMMddHHmmss` the legacy
     * `Setting.getfilelistinfo` era sent, and the `yyyy-MM-dd HH:mm:ss` this
     * firmware answers in `getfilelistinfoios.cgi` — the official app branches on the
     * very dash (`SSResponseParse.java:140` `create.contains("-")`), so neither is a
     * typo to be fixed later. Reducing both to their digits and reading the first
     * fourteen also absorbs the `T`-separated ISO variant and a trailing `.000`.
     */
    @OptIn(kotlin.time.ExperimentalTime::class)
    fun parseCreate(raw: String?, zone: TimeZone = TimeZone.currentSystemDefault()): Long? {
        if (raw.isNullOrBlank()) return null
        val digits = buildString(raw.length) {
            for (c in raw) if (c.isDigit()) append(c)
        }
        if (digits.length < 14) return null
        return runCatching {
            LocalDateTime(
                year = digits.substring(0, 4).toInt(),
                monthNumber = digits.substring(4, 6).toInt(),
                dayOfMonth = digits.substring(6, 8).toInt(),
                hour = digits.substring(8, 10).toInt(),
                minute = digits.substring(10, 12).toInt(),
                second = digits.substring(12, 14).toInt(),
            ).toInstant(zone).toEpochMilliseconds()
        }.getOrNull() // an out-of-range field (month 19) is not a date; say "unknown"
    }
}
