package com.rovecamlink.app.core.transport

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.prepareGet
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsChannel
import io.ktor.client.statement.bodyAsText
import io.ktor.client.statement.readBytes
import io.ktor.http.contentLength
import io.ktor.http.isSuccess
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.core.writeFully
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okio.FileSystem
import okio.Path
import okio.Sink
import okio.buffer
import okio.use

/**
 * Thin, dependency-light HTTP transport used by every protocol plugin.
 *
 * On Android the process is bound to the camera's WiFi network (see core.wifi)
 * before any call here, so CIO sockets transparently route to the device even
 * though it has no internet. Camera hosts are always literal IPs, so DNS is
 * never involved.
 */
class CameraHttp(
    private val client: HttpClient = defaultClient(),
) {
    companion object {
        /** Media transfers are bounded by socket inactivity, not this cap (24h). */
        private const val STREAM_TIMEOUT_MS = 24 * 60 * 60 * 1000L

        fun defaultClient(): HttpClient = HttpClient(CIO) {
            expectSuccess = false
            engine { requestTimeout = 20_000 }
            install(HttpTimeout) {
                requestTimeoutMillis = 20_000
                connectTimeoutMillis = 8_000
                socketTimeoutMillis = 60_000
            }
        }
    }

    /**
     * Media transfers legitimately outlive the 20s budget that keeps discovery
     * probes snappy, so they get a client whose reads are bounded by socket
     * inactivity instead of a whole-request cap.
     */
    private val streamClient: HttpClient by lazy {
        HttpClient(CIO) {
            expectSuccess = false
            engine { requestTimeout = STREAM_TIMEOUT_MS }
            install(HttpTimeout) {
                requestTimeoutMillis = STREAM_TIMEOUT_MS
                connectTimeoutMillis = 8_000
                socketTimeoutMillis = 60_000
            }
        }
    }

    /** GET returning the body as text, or null on any transport/HTTP failure. */
    suspend fun getText(url: String): String? = try {
        val resp: HttpResponse = client.get { url(url) }
        if (resp.status.isSuccess()) resp.bodyAsText() else null
    } catch (_: Throwable) {
        null
    }

    /** GET returning raw bytes (thumbnails, small binaries). */
    suspend fun getBytes(url: String): ByteArray? = try {
        val resp = client.get { url(url) }
        if (resp.status.isSuccess()) resp.readBytes() else null
    } catch (_: Throwable) {
        null
    }

    /**
     * Streamed download to an okio [Path], reporting progress 0f..1f.
     *
     * Returns bytes on disk, or -1 when the transfer failed **or ended short**.
     * A truncated body is deliberately a failure rather than a success: cameras
     * drop connections under load, and a silently half-written video is far
     * worse than a retry. The partial file is left in place so the caller can
     * resume it by passing its size as [alreadyHaveBytes].
     */
    suspend fun download(
        url: String,
        destination: Path,
        alreadyHaveBytes: Long = 0,
        onProgress: (Float) -> Unit = {},
    ): Long = withContext(Dispatchers.IO) {
        try {
            streamClient.prepareGet {
                url(url)
                if (alreadyHaveBytes > 0) header("Range", "bytes=$alreadyHaveBytes-")
            }.execute { resp ->
                if (!resp.status.isSuccess()) return@execute -1L
                val reported = resp.contentLength() ?: -1L
                // Only 206 proves the Range was honoured; a plain 200 sends the whole
                // file and appending it to the partial copy would corrupt it.
                val resumed = alreadyHaveBytes > 0 && resp.status.value == 206
                val have = if (resumed) alreadyHaveBytes else 0L
                val expectedTotal = if (reported > 0) reported + have else -1L
                val fs = FileSystem.SYSTEM
                destination.parent?.let { fs.createDirectories(it) }
                var written = have
                val sink: Sink = if (resumed) fs.appendingSink(destination) else fs.sink(destination)
                sink.buffer().use { out ->
                    val channel: ByteReadChannel = resp.bodyAsChannel()
                    val buf = ByteArray(64 * 1024)
                    while (true) {
                        val n = channel.readAvailable(buf, 0, buf.size)
                        if (n < 0) break
                        if (n == 0) {
                            // Nothing buffered *yet* — suspend until more arrives or the
                            // channel closes; only -1 from readAvailable means EOF.
                            channel.awaitContent()
                            continue
                        }
                        out.write(buf, 0, n)
                        written += n
                        if (expectedTotal > 0) {
                            onProgress((written.toFloat() / expectedTotal).coerceIn(0f, 1f))
                        }
                    }
                }
                if (expectedTotal > 0 && written != expectedTotal) return@execute -1L
                onProgress(1f)
                written
            }
        } catch (_: Throwable) {
            -1L
        }
    }
}
