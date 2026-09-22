package com.rovecamlink.app.core.transport

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

/**
 * JVM raw socket over `java.net.Socket`, with every blocking call parked on
 * [Dispatchers.IO]. The desktop actual is the same code — the two source sets are
 * separate compilations for separate targets, and sharing one file would need a new
 * `jvmCommon` source set, which is not worth a build-script change for sixty lines.
 */
private class JvmCameraTcp : CameraTcp {
    override suspend fun open(host: String, port: Int, timeoutMs: Int): CameraTcpConnection =
        withContext(Dispatchers.IO) {
            val socket = Socket()
            try {
                socket.connect(InetSocketAddress(host, port), timeoutMs)
            } catch (t: Throwable) {
                runCatching { socket.close() }
                throw IOException("TCP connect $host:$port failed: ${t.message ?: t.javaClass.simpleName}", t)
            }
            // Nagle off on purpose: the firmware channel's first act is a 72-byte header
            // followed immediately by a reply read. Coalescing that write with a later one
            // only delays the handshake, which is exactly what the flush() in the contract
            // is there to prevent.
            socket.tcpNoDelay = true
            // The handshake read is bounded by the same budget the connect got — the
            // official client's setSoTimeout(5000) (SendSoftActivity.java:109). Bulk
            // transfers never read, so leaving this armed costs nothing.
            socket.soTimeout = timeoutMs
            JvmCameraTcpConnection(socket)
        }
}

private class JvmCameraTcpConnection(private val socket: Socket) : CameraTcpConnection {
    @Volatile
    private var closed = false

    override suspend fun write(bytes: ByteArray, offset: Int, count: Int) {
        withContext(Dispatchers.IO) {
            socket.getOutputStream().write(bytes, offset, count)
        }
    }

    override suspend fun readFully(dst: ByteArray): Boolean = withContext(Dispatchers.IO) {
        val input = socket.getInputStream()
        var off = 0
        while (off < dst.size) {
            val n = try {
                input.read(dst, off, dst.size - off)
            } catch (t: IOException) {
                // EOF, a reset, or the handshake timeout — the caller treats them alike.
                return@withContext false
            }
            if (n <= 0) return@withContext false
            off += n
        }
        true
    }

    override fun flush() {
        runCatching { socket.getOutputStream().flush() }
    }

    override suspend fun close() {
        if (closed) return
        closed = true
        withContext(Dispatchers.IO) {
            // A camera that accepted a firmware image drops the link hard; closing an
            // already-dead socket is normal here, not an error worth propagating.
            runCatching {
                if (!socket.isClosed) socket.close()
            }
        }
    }
}

actual fun createCameraTcp(): CameraTcp = JvmCameraTcp()
