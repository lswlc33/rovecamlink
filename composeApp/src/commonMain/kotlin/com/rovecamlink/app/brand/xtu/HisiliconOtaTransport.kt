package com.rovecamlink.app.brand.xtu

import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.ota.OtaTransport
import com.rovecamlink.app.core.transport.CameraHttp
import io.ktor.http.ContentType
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
        val attr = HiVarParser.parse(http.getText("${cgi(session)}/getdeviceattr.cgi")) ?: return null
        return attr["softversion"]?.trim()?.ifEmpty { null }
    }

    override suspend fun install(
        session: CameraSession,
        fileName: String,
        fileBytes: ByteArray,
        onProgress: (Float) -> Unit,
    ): CmdResult {
        val boundary = "RoveCamLinkFW-" + Random.nextLong().toString(16)
        val body = buildMultipart(fileName, fileBytes, boundary)
        val ct = ContentType.MultiPart.FormData.withParameter("boundary", boundary)

        val upload = http.post("${cgi(session)}/fileupload.cgi", body, ct, onProgress = onProgress)
        if (upload == null) return CmdResult.Failure("fileupload.cgi did not accept the package")

        // Once the bytes are on the card, tell the firmware to apply them.
        val trigger = http.getText("${cgi(session)}/upgrade.cgi")
        return if (trigger != null) CmdResult.Ok
        else CmdResult.Failure("upgrade.cgi did not acknowledge the install")
    }

    private fun buildMultipart(fileName: String, bytes: ByteArray, boundary: String): ByteArray {
        // encodeToByteArray() rather than toByteArray(): this is commonMain, and
        // Kotlin/Native has no charset-free String overload. Both parts are ASCII.
        val head = (
            "--$boundary\r\n" +
                "Content-Disposition: form-data; name=\"sd\"; filename=\"$fileName\"\r\n" +
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
}