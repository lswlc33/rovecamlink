package com.rovecamlink.app.core.transport

/**
 * A live raw TCP socket to the camera.
 *
 * Deliberately small: byte-granular write / blocking-read-into-buffer, which is all
 * the firmware-push framing on port 8080 needs (see
 * [com.rovecamlink.app.brand.xtu.XtuSocketOtaTransport]). It is **not** a stream
 * abstraction — the point of the seam is that nothing sits between us and the wire,
 * because that channel's protocol is "72 header bytes, then 32 MD5 characters, then
 * the file, all on one connection" and any buffering or re-framing in between breaks it.
 *
 * Why the seam exists at all: Ktor is the only HTTP client here and it cannot carry
 * this. `HttpClientEngineConfig` in 2.3.12 exposes only `threadsCount`, `pipelining`
 * and `proxy` — there is no socket factory, no connection hook, nothing that hands out
 * the underlying socket or lets us keep one open across request boundaries. So the
 * non-HTTP protocols get their own platform operation rather than being contorted
 * through the HTTP engine.
 */
interface CameraTcpConnection {
    /**
     * Send [count] bytes of [bytes] starting at [offset]. Throws on a write failure —
     * the caller maps that to the firmware's own error code (the official app's
     * `-100002`/-100007`/-100009` family, see
     * _work/xtu_src/sources/com/gku/SendSoftActivity.java:210,187,199).
     */
    suspend fun write(bytes: ByteArray, offset: Int, count: Int)

    /**
     * Block until [dst] is completely filled, returning false if the peer closed the
     * connection first, the read timed out, or the stream broke.
     *
     * "False" rather than an exception because the caller's decision is the same for
     * every one of those cases (the camera did not answer the handshake), and because
     * the underlying reads are only partially reliable — a fixed-size header read has
     * to loop, and `read()` returning 0 is not covered by the official app's own
     * fill-loop at all (SendSoftActivity.java:122 advances `i` by whatever it got, so a
     * 0 turns into an infinite read; we bail instead).
     */
    suspend fun readFully(dst: ByteArray): Boolean

    /** Push whatever is buffered out to the wire. Cheap no-op when the platform does not buffer. */
    fun flush()

    /** Close the socket. Safe to call twice — the OTA path closes in a `finally` after already closing on failure. */
    suspend fun close()
}

/** Opens raw TCP connections; see [createCameraTcp]. */
interface CameraTcp {
    /**
     * Connect to `host:port`, giving up after [timeoutMs] on the connect **and** using
     * the same budget as the read timeout, which is what bounds the handshake read.
     * (The official client does exactly this: `createSocket(ip, 8080)` then
     * `setSoTimeout(5000)` — SendSoftActivity.java:108-109.)
     *
     * Throws with a readable message when the port is closed or the host is gone.
     */
    suspend fun open(host: String, port: Int, timeoutMs: Int): CameraTcpConnection
}

/**
 * Platform seam for [CameraTcp]. Android and desktop ride `java.net.Socket`; iOS has no
 * implementation yet and fails loudly, because a half-wired Darwin socket would be worse
 * than an honest "not supported" (iOS is a compile-along target in this project).
 */
expect fun createCameraTcp(): CameraTcp
