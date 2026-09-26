package com.rovecamlink.app.brand.xtu

import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.ota.FirmwarePackage
import com.rovecamlink.app.core.ota.OtaTransport
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogFormat
import com.rovecamlink.app.core.log.LogLevel
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.transport.CameraHttp
import io.ktor.http.ContentType
import okio.FileSystem
import kotlin.random.Random

/**
 * Hisilicon Hi35xx CGI firmware transport (doc 04 §1.2(b)).
 *
 *  - upload  → `POST /cgi-bin/hi3510/fileupload.cgi`   multipart/form-data, field name "sd"
 *  - trigger → `GET  /cgi-bin/hi3510/upgrade.cgi`      (no params; it picks up the upload's fixed landing spot)
 *  - version → `getdeviceattr.cgi` `softversion` (a `\d{8}` date stamp, see [FirmwareVersion]).
 *
 * The official app hand-crafts a loose multipart whose field header omits the
 * `Content-Disposition: form-data; ` prefix; the firmware parses it loosely, so a
 * standards-compliant multipart (the same field name, `sd`) works on the same
 * devices and is what we send here.
 */
class HisiliconOtaTransport(private val http: CameraHttp) : OtaTransport {

    private fun cgi(session: CameraSession) = "http://${session.host}:${session.port}/cgi-bin/hi3510"

    override suspend fun readVersion(session: CameraSession): String? {
        val attr = HiVarParser.parse(http.getText("${cgi(session)}/getdeviceattr.cgi"))
        return attr["softversion"]?.trim()?.ifEmpty { null }
    }

    override suspend fun install(
        session: CameraSession,
        pkg: FirmwarePackage,
        onProgress: (Float) -> Unit,
    ): CmdResult = Diag.inOp("hi3510-ota", "package=${pkg.fileName} size=${pkg.sizeBytes}B") {
        // This channel hands `CameraHttp` one byte array for the whole multipart body,
        // so its peak cost is twice the package. Every real XTU package measured so far
        // is 16–54 MB (docs/analysis/ota-and-gaps §5), which is why this transport is the *fallback* and the
        // socket channel is the default; refusing here is honest, and an OOM in the
        // middle of a firmware push is the one failure mode this app must not offer.
        if (pkg.sizeBytes > MAX_IN_MEMORY_PACKAGE) {
            Diag.at(
                LogLevel.WARN, LogTag.OTA,
                "cgi channel refuses ${LogFormat.size(pkg.sizeBytes)} package ${pkg.fileName} (cap ${LogFormat.size(MAX_IN_MEMORY_PACKAGE)}); needs the socket channel",
            )
            return@inOp CmdResult.Failure(
                "HTTP 上传通道要把整包读进内存，超过 ${LogFormat.size(MAX_IN_MEMORY_PACKAGE)} 的固件包它接不了",
            )
        }
        val bytes = runCatching { FileSystem.SYSTEM.read(pkg.path) { readByteArray() } }.getOrNull()
        if (bytes == null) {
            Diag.at(LogLevel.ERROR, LogTag.OTA, "cannot read ${pkg.path} for upload")
            return@inOp CmdResult.Failure("读不到本地的固件包（${pkg.fileName}），请重新下载")
        }
        if (bytes.size.toLong() != pkg.sizeBytes) {
            Diag.at(
                LogLevel.ERROR, LogTag.OTA,
                "${pkg.path.name} is ${bytes.size}B on disk but was handed as ${pkg.sizeBytes}B",
            )
            return@inOp CmdResult.Failure("本地固件包大小与记录不符，请重新下载")
        }

        val boundary = "RoveCamLinkFW-" + Random.nextLong().toString(16)
        val body = buildMultipart(pkg.fileName, bytes, boundary)
        val ct = ContentType.MultiPart.FormData.withParameter("boundary", boundary)
        Diag.i(LogTag.OTA) { "POST fileupload.cgi field=sd bytes=${body.size} (firmware bytes are never logged)" }

        val upload = http.post("${cgi(session)}/fileupload.cgi", body, ct, onProgress = onProgress)
        if (upload == null) {
            Diag.e(LogTag.OTA) { "fileupload.cgi did not accept the package" }
            return@inOp CmdResult.Failure("fileupload.cgi did not accept the package")
        }
        Diag.i(LogTag.OTA) { "upload accepted, reply=${LogFormat.bodyField(upload, Diag.config.captureSecrets)}" }

        // Once the bytes are on the card, tell the firmware to apply them.
        val trigger = http.getText("${cgi(session)}/upgrade.cgi")
        Diag.i(LogTag.OTA) { "upgrade.cgi reply=${LogFormat.bodyField(trigger, Diag.config.captureSecrets)}" }
        if (trigger != null) CmdResult.Ok
        else CmdResult.Failure("upgrade.cgi did not acknowledge the install")
    }

    private fun buildMultipart(fileName: String, bytes: ByteArray, boundary: String): ByteArray {
        // encodeToByteArray() rather than toByteArray(): this is commonMain, and
        // Kotlin/Native has no charset-free String overload. Both parts are ASCII.
        //
        // The name is only ever one we built (`safePackageName`) or a local file's own,
        // but a `"` in it would end this header early and let the rest of the name inject
        // multipart fields — so it is stripped rather than trusted.
        val safeName = fileName.replace("\"", "")
        val head = (
            "--$boundary\r\n" +
                "Content-Disposition: form-data; name=\"sd\"; filename=\"$safeName\"\r\n" +
                "Content-Type: application/octet-stream\r\n\r\n"
            ).encodeToByteArray()
        val tail = "\r\n--$boundary--\r\n".encodeToByteArray()
        return ByteArray(head.size + bytes.size + tail.size).also { out ->
            var p = 0
            head.copyInto(out, p); p += head.size
            bytes.copyInto(out, p); p += bytes.size
            tail.copyInto(out, p)
        }
    }

    companion object {
        /**
         * Ceiling for a package this channel will load into memory.
         *
         * 24 MB is not a round number chosen for looks: it is roughly what the
         * smallest real vendor package (idGoLive's 16 MB ja build, `docs/analysis/ota-and-gaps §5.3`) plus
         * its multipart envelope costs, so a hand-picked small image still goes through
         * this path while the 54 MB S7PRO build is refused with a reason instead of an
         * OutOfMemoryError halfway through a flash.
         */
        const val MAX_IN_MEMORY_PACKAGE: Long = 24L * 1024 * 1024
    }
}