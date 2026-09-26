package com.rovecamlink.app.core.ota

import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogLevel
import com.rovecamlink.app.core.log.LogTag
import okio.FileSystem
import okio.Path
import okio.Path.Companion.toPath
import okio.openZip

/**
 * What the package's **own header** says about it, read before a single byte is sent.
 *
 * This is guard R1/R2 of `docs/analysis/ota-and-gaps §6.1`, and the reason it exists is in `§6.2`: none of
 * the three official apps ever reads a byte of the image, and the protocol gives the
 * camera nothing but a *file name* to judge the package by. So the camera cannot refuse a
 * wrong image — "this package is for another model" is a decision only the app can make,
 * and until this file existed this app was not making it either.
 *
 * The layout is measured, not guessed (`docs/analysis/ota-and-gaps §5.4`, from real S7PRO images):
 *
 * | offset | bytes | content |
 * |---|---|---|
 * | `0x00` | 8 | magic `15 25 12 08 e3 9c 68 11` |
 * | `0x0c` | 4 | total image length, little-endian |
 * | `0x10` | 4 | header length (256) |
 * | `0x14` | 32 | model, e.g. `XTUS7PRO` |
 * | `0x54` | 32 | version, e.g. `20.8.6.1.20260910` |
 *
 * The magic differs between models, so it carries version information — which is why it is
 * only ever compared as "is this the header shape we know", never as a model test. The
 * model test is the model field.
 *
 * Everything here is pure so it can be tested from `commonTest` without a device, a
 * network or a 50 MB fixture; only [read] touches the disk.
 */
object FirmwareImage {

    /**
     * Bytes read to cover the header. The `0x10` field says the header block is 256 bytes,
     * and the last field we read (version, at `0x54` for 32 bytes) ends at offset 116 — so
     * 256 covers the whole block with room to spare.
     */
    const val HEADER_BYTES = 256

    private val MAGIC = byteArrayOf(
        0x15, 0x25, 0x12, 0x08, 0xE3.toByte(), 0x9C.toByte(), 0x68, 0x11,
    )

    /** The model field's fixed width, and the version field's. */
    private const val MODEL_AT = 0x14
    private const val MODEL_BYTES = 32
    private const val VERSION_AT = 0x54
    private const val VERSION_BYTES = 32

    /** A parsed XTU header. */
    data class Header(
        /** Whitespace-stripped, as the vendor's own model lookup does it. */
        val model: String,
        val version: String?,
        val declaredBytes: Long,
        val headerBytes: Long,
    )

    /** The verdict on one package. */
    sealed interface Check {
        /** The header parsed, the length agrees, and the model is this camera's. */
        data class Ok(val model: String, val version: String?) : Check

        /**
         * The header parsed and names a different model. **This is the bricking case**:
         * same SoC, different sensor/DDR/partition layout (`docs/analysis/ota-and-gaps §5.4`), so it is
         * refused rather than warned about.
         */
        data class WrongModel(val expected: String?, val found: String) : Check

        /** The header's own total length disagrees with the file — truncated or patched. */
        data class Truncated(val declaredBytes: Long, val actualBytes: Long) : Check

        /**
         * Not an image this app can vouch for: no XTU header at all. Refused too, because
         * "we cannot tell what this is" is not a reason to hand it to a bootloader. The
         * one route that overrides this is a hand-picked local file, where the user has
         * explicitly chosen an arbitrary package (`docs/analysis/ota-and-gaps §6.1` R9).
         */
        data class Unrecognised(val reason: String) : Check
    }

    /**
     * Parse [header] (the first [HEADER_BYTES] bytes of the image, or of the `.bin` inside
     * its zip). Null when the bytes are not an XTU image header.
     */
    fun parse(header: ByteArray): Header? {
        if (header.size < VERSION_AT + VERSION_BYTES) return null
        for (i in MAGIC.indices) if (header[i] != MAGIC[i]) return null
        val headerBytes = readU32(header, 0x10)
        // The one field we can sanity-check against itself: a header length of 0 or
        // something wilder than the buffer means these bytes are not what we think.
        if (headerBytes <= 0L || headerBytes > header.size.toLong()) return null
        val model = readText(header, MODEL_AT, MODEL_BYTES).replace(Regex("\\s+"), "")
        if (model.isEmpty()) return null
        val version = readText(header, VERSION_AT, VERSION_BYTES).ifEmpty { null }
        return Header(
            model = model,
            version = version,
            declaredBytes = readU32(header, 0x0c),
            headerBytes = headerBytes,
        )
    }

    /**
     * Judge a parsed header against the file it came from and the camera it would go to.
     *
     * [expectedModel] is the camera's own model in the same whitespace-stripped form the
     * firmware index uses ([GkuFirmwareIndex.firmwareModelOf]); null means the camera did
     * not report one, in which case the model cannot be checked, only the length is, and
     * the result is [Check.Ok] — a null model is "not checkable", not "mismatched" (pinned
     * by `a model mismatch outranks nothing` in the tests).
     *
     * The length check can never be skipped: a declared total of 0 means the field the
     * image uses to describe its own size is missing or unset, so the file cannot be shown
     * to be complete and is refused rather than waved through on a technicality.
     */
    fun judge(header: Header?, actualBytes: Long, expectedModel: String?): Check {
        if (header == null) {
            return Check.Unrecognised("文件里没有可识别的固件头（前 256 字节不是已知的镜像头）")
        }
        if (header.declaredBytes <= 0L) {
            return Check.Unrecognised("固件头的总长字段不可信（为 0），无法确认文件是否完整")
        }
        if (actualBytes > 0L && header.declaredBytes != actualBytes) {
            return Check.Truncated(header.declaredBytes, actualBytes)
        }
        if (expectedModel != null && header.model.uppercase() != expectedModel.uppercase()) {
            return Check.WrongModel(expectedModel, header.model)
        }
        return Check.Ok(header.model, header.version)
    }

    /**
     * Read the first [HEADER_BYTES] bytes of the image at [path], plus the byte count they
     * should be checked against.
     *
     * Two shapes are real here (`docs/analysis/ota-and-gaps §5.4`): the S7PRO ships a `.bin` and the vendor's
     * index serves it inside a `.zip`, so a zip is opened and its single entry is read —
     * the entry's *uncompressed* length is what the header's total-length field describes,
     * not the zip's size on disk. Anything else is read as a plain file.
     */
    fun read(fs: FileSystem, path: Path): Pair<ByteArray, Long>? = runCatching {
        if (path.name.endsWith(".zip", ignoreCase = true)) {
            readFromZip(fs, path)
        } else {
            val total = fs.metadata(path).size ?: return null
            head(fs, path, total) to total
        }
    }.getOrElse {
        Diag.at(LogLevel.WARN, LogTag.OTA, "cannot read image header from ${path.name}: ${it.message}")
        null
    }

    private fun readFromZip(fs: FileSystem, path: Path): Pair<ByteArray, Long>? {
        val zip = fs.openZip(path)
        // The images measured in `docs/analysis/ota-and-gaps §5.4` hold exactly one `.bin`; if a future one
        // holds several, the largest is the image and the rest are notes. The entry's
        // *uncompressed* length is what the header's total-length field describes, which is
        // why this is the metadata size and not the zip's size on disk.
        // No close(): okio's common `FileSystem` exposes no close(), so the ZipFileSystem
        // handle cannot be released from commonMain. Noted, not silently ignored.
        val image = zip.listRecursively("/".toPath())
            .mapNotNull { entry ->
                val meta = zip.metadataOrNull(entry) ?: return@mapNotNull null
                if (meta.isRegularFile) entry to (meta.size ?: 0L) else null
            }
            .maxByOrNull { it.second } ?: return null
        return head(zip, image.first, image.second) to image.second
    }

    /** Read at most [HEADER_BYTES] bytes from the start of [path] on [fs]. */
    private fun head(fs: FileSystem, path: Path, total: Long): ByteArray =
        fs.read(path) { readByteArray(minOf(HEADER_BYTES.toLong(), total)) }

    /** Little-endian u32; 0 when the field is absent from [bytes]. */
    private fun readU32(bytes: ByteArray, at: Int): Long {
        if (at + 4 > bytes.size) return 0L
        return (bytes[at].toLong() and 0xFF) or
            ((bytes[at + 1].toLong() and 0xFF) shl 8) or
            ((bytes[at + 2].toLong() and 0xFF) shl 16) or
            ((bytes[at + 3].toLong() and 0xFF) shl 24)
    }

    /** NUL- and space-padded ASCII, as the vendor writes these two fields. */
    private fun readText(bytes: ByteArray, at: Int, count: Int): String {
        val end = minOf(at + count, bytes.size)
        val sb = StringBuilder(count)
        for (i in at until end) {
            val b = bytes[i].toInt() and 0xFF
            if (b == 0) break
            sb.append(b.toChar())
        }
        return sb.toString().trim()
    }
}
