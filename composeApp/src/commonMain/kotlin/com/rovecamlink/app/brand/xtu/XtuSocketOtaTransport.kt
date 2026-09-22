package com.rovecamlink.app.brand.xtu

import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.ota.FirmwarePackage
import com.rovecamlink.app.core.ota.OtaTransport
import com.rovecamlink.app.core.transport.CameraHttp
import com.rovecamlink.app.core.transport.CameraTcp
import com.rovecamlink.app.core.transport.CameraTcpConnection
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okio.Buffer
import okio.FileSystem
import okio.HashingSource
import okio.buffer
import okio.use

/**
 * The firmware path the official XTU app actually walks on the S7PRO class: a raw TCP
 * socket to `<camera ip>:8080`, a 72-byte [TcpMsgS] header, then the MD5, then the file
 * (SendSoftActivity.java:104-192, `_work/xtu_src/sources/com/gku/SendSoftActivity.java`).
 *
 * Why this exists next to [HisiliconOtaTransport] rather than replacing it: the CGI
 * transport is the documented Hi35xx way, but this repo has never seen it complete an
 * upgrade on real hardware — no field log, no camera that answered `upgrade.cgi` with
 * anything but `no firmware`. This one has the opposite evidence profile: it is lifted
 * from shipping app code that runs on the exact model line, and it is the *only* place
 * the official app talks to a camera without HTTP (`getSocketFactory().createSocket(ip,
 * 8080)`, SendSoftActivity.java:108). Field proof is still outstanding, which is why the
 * two transports coexist and the app can be pointed at either.
 *
 * The sequence, with the official error codes we mirror on failure
 * (SendSoftActivity.java:32-40):
 *
 *  1. connect `:8080`, read timeout 5000 ms                              `-100001`
 *  2. send `RECV_FILE` with the file's byte length and its **name**      `-100002`
 *  3. read exactly 72 bytes back, proceed on `cmd == RECV_FILE`          `-100006` / `-100004`
 *  4. write the file's MD5 as 32 lowercase ASCII hex characters          `-100009`
 *  5. stream the raw file in 65536-byte chunks                           `-100007`
 *  6. declare success — see the note on step 5 about why there is no 7
 *
 * Step 4 sends the MD5 of the whole file. `FileUtils.getFileMD5` is the reference for the
 * format (lowercase hex, each digest byte padded to two characters,
 * `_work/xtu_src/sources/com/gku/base/utils/FileUtils.java:234-266`), and it is built off
 * disk in 64 KB pieces rather than over one array, because [FirmwarePackage] hands a path
 * for exactly that reason.
 *
 * The name goes through unchanged: what the vendor cloud hands out **is** a `.zip` and the
 * official client pushes those bytes verbatim — there is no unzip step anywhere on the
 * live path — so whatever the caller picked is what the firmware expects to receive.
 */
class XtuSocketOtaTransport(
    private val tcp: CameraTcp,
    private val http: CameraHttp,
) : OtaTransport {

    companion object {
        /** Hard-coded in the official client; it is not the CGI port and not derived from it. */
        const val OTA_TCP_PORT: Int = 8080

        /** `setSoTimeout(5000)` — bounds both the connect and the handshake read. */
        private const val HANDSHAKE_TIMEOUT_MS: Int = 5_000

        /** The official chunk size (`byte[] bArr2 = new byte[65536]`, SendSoftActivity.java:140). */
        private const val CHUNK_BYTES: Int = 65_536

        // The official app's failure codes, kept so a field log here reads the same as one
        // from the vendor app and the two can be compared line for line.
        const val ERR_CONNECT: Int = -100001
        const val ERR_HEADER_WRITE: Int = -100002
        const val ERR_CMD_MISMATCH: Int = -100004
        const val ERR_HANDSHAKE_READ: Int = -100006
        const val ERR_BODY_WRITE: Int = -100007
        const val ERR_MD5_WRITE: Int = -100009
    }

    private fun cgi(session: CameraSession) = "http://${session.host}:${session.port}/cgi-bin/hi3510"

    /**
     * `getdeviceattr.cgi` → `softversion`, the same read [HisiliconOtaTransport.readVersion]
     * does. It is duplicated rather than shared because that file is off-limits to this
     * change and the socket transport has no other reason to depend on it — the version
     * never comes back over the OTA socket, so the post-install confirmation the
     * [com.rovecamlink.app.core.ota.OtaCoordinator] does has to ride HTTP regardless.
     */
    override suspend fun readVersion(session: CameraSession): String? {
        val attr = HiVarParser.parse(http.getText("${cgi(session)}/getdeviceattr.cgi"))
        return attr["softversion"]?.trim()?.ifEmpty { null }
    }

    override suspend fun install(
        session: CameraSession,
        pkg: FirmwarePackage,
        onProgress: (Float) -> Unit,
    ): CmdResult = Diag.inOp("xtu-tcp-ota", "package=${pkg.fileName} size=${pkg.sizeBytes}B") {
        // The 72-byte header carries an int32 length, so anything past 2 GiB cannot be
        // announced correctly. No vendor package is close to that today; the guard is
        // here so a future one fails with a sentence rather than a negative length.
        if (pkg.sizeBytes <= 0L || pkg.sizeBytes > Int.MAX_VALUE.toLong()) {
            Diag.e(LogTag.OTA) { "refusing to push a ${pkg.sizeBytes}B package over the 32-bit header" }
            return@inOp CmdResult.Failure(
                "固件包大小无法用 32 位长度声明（${pkg.sizeBytes} 字节），不送包",
                ERR_HEADER_WRITE,
            )
        }
        val target = "${session.host}:$OTA_TCP_PORT"

        // MD5 first, and deliberately *before* the socket opens: a package that cannot
        // be read to the end must fail while the camera still knows nothing about it,
        // not halfway through a handshake it has already agreed to.
        val digest = runCatching { md5OfFile(pkg) }
            .getOrElse {
                Diag.e(LogTag.OTA) { "cannot read ${pkg.path} for hashing: ${it::class.simpleName}: ${it.message}" }
                return@inOp CmdResult.Failure("读不到本地的固件包（${pkg.fileName}），请重新下载", ERR_MD5_WRITE)
            }
        Diag.info(LogTag.OTA, "opening firmware socket $target (CGI channel is ${session.host}:${session.port}), md5=$digest")
        try {
            val conn = tcp.open(session.host, OTA_TCP_PORT, HANDSHAKE_TIMEOUT_MS)
            try {
                push(conn, target, pkg, digest, onProgress)
            } finally {
                // A camera that took the image drops the link itself; close() is idempotent
                // and its failures are not interesting here.
                conn.close()
            }
        } catch (t: CancellationException) {
            throw t
        } catch (t: Throwable) {
            Diag.e(LogTag.OTA) { "firmware socket $target broke: ${t::class.simpleName}: ${t.message}" }
            CmdResult.Failure("firmware socket $target failed: ${t.message ?: "no connection"}", ERR_CONNECT)
        }
    }

    private suspend fun push(
        conn: CameraTcpConnection,
        target: String,
        pkg: FirmwarePackage,
        md5: String,
        onProgress: (Float) -> Unit,
    ): CmdResult {
        val total = pkg.sizeBytes

        // ---- 1. announce the file ----------------------------------------------------
        // length = the FILE's byte length, name slot = the file name, per the official
        // `s32DataLen = (int) file.length()` / `szData = file.getName()` (SendSoftActivity.java:111-113).
        val header = TcpMsgS.encode(TcpMsgType.RECV_FILE.code, total.toInt(), pkg.fileName)
        try {
            conn.write(header, 0, header.size)
            conn.flush()
        } catch (t: Throwable) {
            return refused("sending the RECV_FILE header", target, t, ERR_HEADER_WRITE)
        }

        // ---- 2. wait for the go-ahead ------------------------------------------------
        // The reply is read as a fixed 72 bytes with a fill-loop, exactly like
        // `for (int i = 0; i < 72; i += in.read(bArr, i, 72 - i))` (SendSoftActivity.java:119-123),
        // minus that loop's habit of spinning forever on a 0-length read.
        val reply = ByteArray(TcpMsgS.SIZE)
        if (!conn.readFully(reply)) {
            return refused("reading the 72-byte answer", target, null, ERR_HANDSHAKE_READ)
        }
        val ack = TcpMsgS.decode(reply)
        if (ack.cmd != TcpMsgType.RECV_FILE.code) {
            Diag.e(LogTag.OTA) { "$target answered cmd=${ack.cmd} (want ${TcpMsgType.RECV_FILE.code}=RECV_FILE), length=${ack.length}, name=${ack.name}" }
            return CmdResult.Failure(
                "$target refused the package: answer cmd=${ack.cmd} != RECV_FILE (code $ERR_CMD_MISMATCH)",
                ERR_CMD_MISMATCH,
            )
        }
        Diag.i(LogTag.OTA) { "$target accepted RECV_FILE (answer cmd=${ack.cmd} length=${ack.length} name=${ack.name.ifEmpty { "<none>" }})" }

        // ---- 3. MD5, as its own write, before the bytes -------------------------------
        try {
            val tag = md5.encodeToByteArray() // 32 ASCII chars; UTF-8 and ASCII agree here
            conn.write(tag, 0, tag.size)
            conn.flush()
        } catch (t: Throwable) {
            return refused("sending the MD5", target, t, ERR_MD5_WRITE)
        }

        // ---- 4. the bytes, streamed off disk in the official's own chunk size ---------
        // Sixty-four kilobytes at a time, never the whole image: this is the call site the
        // 54 MB S7PRO package was sized against, and holding it in memory alongside the
        // socket buffer is how a low-heap phone dies mid-flash (`FirmwarePackage`).
        try {
            val file = withContext(Dispatchers.Default) { FileSystem.SYSTEM.source(pkg.path).buffer() }
            file.use { source ->
                val buf = ByteArray(CHUNK_BYTES)
                var written = 0L
                while (written < total) {
                    val wanted = minOf(CHUNK_BYTES.toLong(), total - written).toInt()
                    // Blocking file read, and [OtaCoordinator.run] runs on the UI scope: hop
                    // off it per chunk. The socket write hops again inside [CameraTcp].
                    val n = withContext(Dispatchers.Default) { source.read(buf, 0, wanted) }
                    if (n <= 0) {
                        // The file shrank or vanished under us. Stopping here leaves the
                        // camera with a short stream it will reject on its own CRC check —
                        // which is the outcome we want, versus padding it out and hoping.
                        Diag.e(LogTag.OTA) { "$pkg.fileName read ended at $written of $total bytes" }
                        return refused("reading the package from disk after $written bytes", target, null, ERR_BODY_WRITE)
                    }
                    conn.write(buf, 0, n)
                    written += n
                    // Bytes on the wire is the only progress the channel offers: nothing
                    // comes back until the camera reboots, so a stall is invisible from here.
                    onProgress(written.toFloat() / total.toFloat())
                }
                conn.flush()
            }
        } catch (t: Throwable) {
            return refused("streaming the package", target, t, ERR_BODY_WRITE)
        }

        // ---- 5. done -----------------------------------------------------------------
        // No completion packet is waited for, and that is not laziness: the firmware
        // reboots (or at least kills the link) as it takes the image, so the official
        // client's last write is followed by `outputStream.close(); return closeSocket(0)`
        // — code 0, success — at SendSoftActivity.java:191-192. Waiting for an ack would
        // time out on every successful update.
        Diag.i(LogTag.OTA) { "pushed $total bytes to $target; camera applies the image and reboots (no ack expected)" }
        return CmdResult.Ok
    }

    private suspend fun refused(
        step: String,
        target: String,
        cause: Throwable?,
        code: Int,
    ): CmdResult {
        val detail = cause?.let { ": ${it.message ?: it::class.simpleName}" } ?: ": no answer before the 5 s read timeout"
        Diag.e(LogTag.OTA) { "$target failed while $step$detail (code $code)" }
        return CmdResult.Failure("firmware socket $target failed while $step (code $code)$detail", code)
    }

    /**
     * Lowercase hex MD5 of the package on disk — the 32 ASCII characters written ahead
     * of the file, matching `FileUtils.bytesToHexString` (each digest byte padded to two
     * characters, `_work/xtu_src/sources/com/gku/base/utils/FileUtils.java:234-266`) over
     * the whole stream, which is what the official client's `getFileMD5(File)` produces.
     *
     * okio's `HashingSource` rather than `Buffer().write(bytes).md5()`: hashing has to be
     * incremental, because the 64 KB chunks that go out over the wire are the same chunks
     * the digest is built from and the 54 MB image never sits in memory as one array.
     * okio is already a commonMain dependency, so this costs no new coordinate — which
     * matters, because CI cannot resolve one.
     */
    private suspend fun md5OfFile(pkg: FirmwarePackage): String = withContext(Dispatchers.Default) {
        FileSystem.SYSTEM.source(pkg.path).buffer().use { source ->
            HashingSource.md5(source).use { hashed ->
                // `Source.read` only speaks okio's Buffer — the ByteArray overload is a
                // BufferedSource convenience, and this one has to stay a plain Source for
                // the hash to see the bytes go by.
                val scratch = Buffer()
                while (hashed.read(scratch, CHUNK_BYTES.toLong()) != -1L) {
                    // Digest only; the bytes are dropped and read again for the wire.
                    scratch.clear()
                }
                hashed.hash.hex()
            }
        }
    }
}
