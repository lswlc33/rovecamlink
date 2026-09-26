package com.rovecamlink.app.brand.xtu

import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogFormat
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.model.LiveConfig
import com.rovecamlink.app.core.transport.CameraTcp
import com.rovecamlink.app.core.transport.CameraTcpConnection
import kotlinx.coroutines.CancellationException

/**
 * The RTMP hand-off on the hi3510 firmware socket (port 8080), `cmd = 4` = `RECV_RTMP`.
 *
 * This is the **only** live-streaming path the official XTU GO app has for a non-Ambarella
 * camera, and the Hi35xx family — the X7 Pro / S7PRO line this app targets — is exactly
 * that. There is no `*.cgi` for it anywhere in the APK: the whole command face of "start a
 * live stream" is one payload on the same socket the firmware image is pushed through
 * (`docs/evidence/data/xtugo/catalog-http.md` holds no live endpoint;
 * `BroadcastDouyinFragment3.sendRtmp2Hisi`, `_work/xtu_src/sources/com/gku/actioncam/amba/ui/stream/BroadcastDouyinFragment3.java:247-302`).
 *
 * The exchange, in the order the official client walks it:
 *
 *  1. `createSocket(<camera ip>, 8080)` + `setSoTimeout(5000)`
 *  2. write a 72-byte [TcpMsgS] frame: `cmd = RECV_RTMP(4)`, `length = payload.length()`,
 *     name slot left zero-filled — a *plain* frame, with none of `RECV_FILE`'s MD5 or
 *     file-body follow-up. The name slot is deliberately empty: the payload is announced
 *     by the length field alone.
 *  3. read exactly 72 bytes back. **This is the go-ahead** — the camera answers with the
 *     same command it was asked with, and the payload must not be written before it lands.
 *  4. if the answer's `cmd == RECV_RTMP`, write the payload as UTF-8 and close. Anything
 *     else is a refusal and the payload is never sent, which is what keeps a wrong
 *     `live_type` from leaving a half-configured camera pushing to nowhere.
 *
 * Two quirks are copied rather than corrected, because the firmware on the other end was
 * written against them:
 *
 *  - `s32DataLen` is `payload.length()` in **characters**, while the bytes written in step
 *    4 are UTF-8. For the ASCII payloads a camera accepts the two agree; a non-ASCII SSID
 *    or URL would report a short length, and sending the byte count instead would change
 *    the length field the camera has always been handed. [TcpMsgS] documents the same
 *    char-vs-byte split on the `RECV_FILE` side.
 *  - The socket is closed by the sender. The official client's `closeSocket(0)` runs before
 *    the camera has said anything about the push actually starting, so success here means
 *    "the camera took the parameters", not "the stream is up".
 *
 * **There is no stop command on this channel.** The vendor app's 关播 is Bluetooth
 * (`R008_<code>`, `BLEConnectUtils.endLive`, `:289-300`) or a Douyin cloud call, and
 * neither exists on the TCP path — see the same file for the `isNewLive` branch that
 * decides between them. The UI therefore offers no stop for this transport, and says so.
 */
class XtuRtmpPush(
    private val tcp: CameraTcp,
) {

    suspend fun start(session: CameraSession, config: LiveConfig): CmdResult =
        Diag.inOp("xtu-live", "res=${config.resolution.wire} fps=${config.fps.wire} bitrate=${config.bitrate.wire}") {
            val payload = payload(config)
            val target = "${session.host}:$RTMP_TCP_PORT"
            // The URL's last segment is the stream key, and an exported log is built to be
            // attached to a public issue — the push URL only travels masked (LogFormat).
            Diag.info(
                LogTag.PROTO,
                "live hand-off to $target (payload ${payload.length} chars, url=${LogFormat.redactStreamUrl(config.rtmpUrl)})",
            )

            val conn = try {
                tcp.open(session.host, RTMP_TCP_PORT, TIMEOUT_MS)
            } catch (t: CancellationException) {
                throw t
            } catch (t: Throwable) {
                return@inOp refused("opening $target", t, ERR_CONNECT)
            }
            try {
                handOff(conn, target, payload)
            } finally {
                // A camera that took the parameters drops the link itself; close() is
                // idempotent and its failures are not interesting here.
                conn.close()
            }
        }

    private suspend fun handOff(
        conn: CameraTcpConnection,
        target: String,
        payload: String,
    ): CmdResult {
        // ---- 1. announce the payload -------------------------------------------------
        // Empty name slot on purpose (see the class comment): the camera takes the payload
        // straight off the socket once it has agreed to the command.
        val header = TcpMsgS.encode(TcpMsgType.RECV_RTMP.code, payload.length, "")
        try {
            conn.write(header, 0, header.size)
            conn.flush()
        } catch (t: Throwable) {
            return refused("sending the RECV_RTMP header", t, ERR_HEADER_WRITE)
        }

        // ---- 2. the go-ahead ---------------------------------------------------------
        val reply = ByteArray(TcpMsgS.SIZE)
        if (!conn.readFully(reply)) {
            return refused("reading the 72-byte answer", null, ERR_HANDSHAKE_READ)
        }
        val ack = TcpMsgS.decode(reply)
        if (ack.cmd != TcpMsgType.RECV_RTMP.code) {
            Diag.error(
                LogTag.PROTO,
                "$target refused the live hand-off: answer cmd=${ack.cmd} (want ${TcpMsgType.RECV_RTMP.code}=RECV_RTMP), " +
                    "length=${ack.length}, name=${ack.name.ifEmpty { "<none>" }}",
            )
            return CmdResult.Failure(
                "相机没有接受推流参数（应答 cmd=${ack.cmd}，期望 ${TcpMsgType.RECV_RTMP.code}）",
                ERR_CMD_MISMATCH,
            )
        }
        Diag.i(LogTag.PROTO) { "$target accepted RECV_RTMP (answer length=${ack.length})" }

        // ---- 3. the payload ----------------------------------------------------------
        try {
            val bytes = payload.encodeToByteArray()
            conn.write(bytes, 0, bytes.size)
            conn.flush()
        } catch (t: Throwable) {
            return refused("writing the live payload", t, ERR_PAYLOAD_WRITE)
        }

        // No completion packet is waited for: the official client writes the payload,
        // flushes and closes, and the camera starts joining the network from there. A
        // camera that refuses the *parameters* has already refused the command in step 2.
        Diag.i(LogTag.PROTO) { "$target took the live parameters; the camera pushes from here" }
        return CmdResult.Ok
    }

    private fun refused(step: String, cause: Throwable?, code: Int): CmdResult {
        val detail = cause?.let { ": ${it.message ?: it::class.simpleName}" } ?: ": no answer before the ${TIMEOUT_MS / 1000} s read timeout"
        Diag.error(LogTag.PROTO, "live hand-off failed while $step$detail (code $code)")
        return CmdResult.Failure("推流参数下发失败（$step，错误码 $code）$detail", code)
    }

    companion object {
        /**
         * Hard-coded in the official client and shared with the firmware push — it is not
         * the CGI port and not derived from it (`NetworkDeviceUtils.getIpDevice(), 8080`).
         */
        const val RTMP_TCP_PORT: Int = 8080

        /** `setSoTimeout(5000)`, the same budget the OTA socket uses. */
        private const val TIMEOUT_MS: Int = 5_000

        // The official app's own failure codes, kept so a field log from here reads the
        // same as one from the vendor app and the two can be compared line for line
        // (BroadcastDouyinFragment3.java:44-49).
        const val ERR_CONNECT: Int = -100001
        const val ERR_HEADER_WRITE: Int = -100002
        const val ERR_PAYLOAD_WRITE: Int = -100003
        const val ERR_HANDSHAKE_READ: Int = -100004
        const val ERR_CMD_MISMATCH: Int = -100005

        /**
         * The payload the firmware takes, **verbatim** from the vendor app
         * (`TCPClient.format`). Field order, the `;` between and after every field, and
         * `res`/`fps` travelling as strings while `bitrate` travels as an int are all the
         * official shape — a "tidier" rendering is a different command to the firmware.
         */
        fun payload(config: LiveConfig): String = buildString {
            append("ssid:").append(config.ssid).append(';')
            append("pwd:").append(config.password).append(';')
            append("live_type:").append(config.liveType).append(';')
            append("res:").append(config.resolution.wire).append(';')
            append("fps:").append(config.fps.wire).append(';')
            append("rtmp_url:").append(config.rtmpUrl).append(';')
        }
    }
}
