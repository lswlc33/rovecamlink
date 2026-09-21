package com.rovecamlink.app.core.transport

import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.monotonicMillis
import com.rovecamlink.app.core.log.LogFormat
import com.rovecamlink.app.core.log.LogTag
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.prepareGet
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsChannel
import io.ktor.client.statement.bodyAsText
import io.ktor.client.statement.readBytes
import io.ktor.http.ContentType
import io.ktor.http.contentLength
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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
 *
 * **Every exchange is logged** (see [Diag]): method, full URL with secret-looking
 * query values masked, status, duration, response headers, a capped body preview,
 * and — for failures — the whole cause chain. The body of a non-2xx reply is what
 * actually explains a camera refusing a command, so it is captured even though the
 * caller still just sees `null`.
 */
class CameraHttp(
    private val client: HttpClient = defaultClient(),
) {
    companion object {
        /** Media transfers are bounded by socket inactivity, not this cap (24h). */
        private const val STREAM_TIMEOUT_MS = 24 * 60 * 60 * 1000L

        /** A request slower than this is worth a line while it is still in flight. */
        private const val PENDING_WARN_MS = 3_000L

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
    suspend fun getText(url: String): String? = exchange("GET", url) { call ->
        try {
            val resp: HttpResponse = client.get { url(url) }
            val body = resp.bodyAsText()
            val ok = resp.status.isSuccess()
            call.reply(resp, body?.length ?: 0, body)
            if (ok) body else null
        } catch (t: Throwable) {
            call.fail(t)
            null
        }
    }

    /** GET returning raw bytes (thumbnails, small binaries). */
    suspend fun getBytes(url: String): ByteArray? = exchange("GET", url) { call ->
        try {
            val resp = client.get { url(url) }
            val bytes = resp.readBytes()
            val ok = resp.status.isSuccess()
            call.reply(
                resp, bytes.size,
                bodyPreview = if (ok) null else bytes.decodeToString(0, minOf(bytes.size, 512), throwOnInvalidSequence = false),
            )
            if (ok) bytes else null
        } catch (t: Throwable) {
            call.fail(t)
            null
        }
    }

    /**
     * POST [body] as [contentType] with optional extra [headers], returning the
     * response text on HTTP success or null on any failure. Used for OTA uploads
     * (e.g. the Hisilicon `fileupload.cgi` multipart body) where the app has to
     * control the exact bytes and content-type.
     *
     * The request bytes are never logged — a firmware image is megabytes of binary.
     */
    suspend fun post(
        url: String,
        body: ByteArray,
        contentType: ContentType,
        headers: Map<String, String> = emptyMap(),
        onProgress: (Float) -> Unit = {},
    ): String? = exchange("POST", url, note = "sent=${body.size}B") { call ->
        try {
            val resp = client.post {
                this.url(url)
                headers.forEach { (k, v) -> header(k, v) }
                this.contentType(contentType)
                setBody(body)
            }
            val text = resp.bodyAsText()
            val ok = resp.status.isSuccess()
            call.reply(resp, text.length, text)
            if (ok) {
                onProgress(1f)
                text
            } else {
                null
            }
        } catch (t: Throwable) {
            call.fail(t)
            null
        }
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
    ): Long = exchange("GET", url, note = "to=${destination.name} resume=$alreadyHaveBytes") { call ->
        withContext(Dispatchers.Default) {
            var written = alreadyHaveBytes
            var expectedTotal = -1L
            try {
                streamClient.prepareGet {
                    url(url)
                    if (alreadyHaveBytes > 0) header("Range", "bytes=$alreadyHaveBytes-")
                }.execute { resp ->
                    val status = resp.status.value
                    val reported = resp.contentLength() ?: -1L
                    // Only 206 proves the Range was honoured; a plain 200 sends the whole
                    // file and appending it to the partial copy would corrupt it.
                    val resumed = alreadyHaveBytes > 0 && status == 206
                    if (alreadyHaveBytes > 0 && !resumed && status == 200) {
                        Diag.w(LogTag.DL) { "server ignored Range (200, not 206); restarting the file from 0 bytes url=${LogFormat.redactUrl(url)}" }
                    }
                    if (!resp.status.isSuccess()) {
                        call.reply(resp, 0, null, note = "download refused")
                        return@execute -1L
                    }
                    written = if (resumed) alreadyHaveBytes else 0L
                    expectedTotal = if (reported > 0) reported + written else -1L
                    // One free-form line so a long transfer is visible while it runs;
                    // the counted exchange is the final one below.
                    Diag.info(
                        LogTag.HTTP,
                        "STREAM ${LogFormat.endpointKey(url)} $status ${resp.contentType()} " +
                            "resume_from=$alreadyHaveBytes expected=$expectedTotal to=${destination.name}",
                    )
                    val fs = FileSystem.SYSTEM
                    destination.parent?.let { fs.createDirectories(it) }
                    val sink: Sink = if (resumed) fs.appendingSink(destination) else fs.sink(destination)
                    val t0 = monotonicMillis()
                    var nextMilestone = 10
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
                                val pct = (written * 100 / expectedTotal).toInt()
                                if (pct >= nextMilestone) {
                                    nextMilestone = (pct / 10 + 1) * 10
                                    Diag.i(LogTag.DL) { "progress $pct% ${LogFormat.size(written)}/${LogFormat.size(expectedTotal)} ${LogFormat.size(rate(written, t0))}/s ${destination.name}" }
                                }
                                onProgress((written.toFloat() / expectedTotal).coerceIn(0f, 1f))
                            }
                        }
                    }
                    if (expectedTotal > 0 && written != expectedTotal) {
                        call.fail(null, note = "truncated at $written of $expectedTotal bytes")
                        -1L
                    } else {
                        onProgress(1f)
                        call.reply(resp, written.toIntOrMinus(), null, note = "streamed ${written}B")
                        written
                    }
                }
            } catch (t: Throwable) {
                call.fail(t, note = "after ${LogFormat.size(written)}" +
                    if (expectedTotal > 0) " of ${LogFormat.size(expectedTotal)}" else "")
                -1L
            }
        }
    }

    // ---------- exchange plumbing ----------

    /**
     * Wrap one logical exchange: run [block] with a [Call] that reports how it
     * ended, and shout if it is still hanging after [PENDING_WARN_MS].
     */
    private suspend fun <T> exchange(method: String, url: String, note: String = "", block: suspend (Call) -> T): T =
        coroutineScope {
            val call = Call(method, url, note)
            val watchdog = launch {
                delay(PENDING_WARN_MS)
                Diag.httpPending(method, url, call.elapsedMs())
            }
            try {
                block(call)
            } finally {
                watchdog.cancel()
                if (!call.finished) call.fail(null)
            }
        }

    private inner class Call(private val method: String, private val url: String, private val note: String) {
        private val t0 = monotonicMillis()
        var finished = false
            private set

        fun elapsedMs(): Long = monotonicMillis() - t0

        /** Report the response that ended the exchange. */
        suspend fun reply(resp: HttpResponse, bodyChars: Int, bodyPreview: String?, note: String = "") {
            if (finished) return
            finished = true
            Diag.httpExchange(
                method = method, url = url, status = resp.status.value, ms = elapsedMs(),
                bodyChars = bodyChars, contentType = resp.contentType()?.toString(),
                headers = headerSummary(resp), bodyPreview = bodyPreview,
                note = listOf(this.note, note).filter { it.isNotEmpty() }.joinToString(" "),
            )
        }

        /**
         * Report that the exchange produced nothing usable ([t] null when the camera
         * answered, wrongly). A cancelled call is not a camera failure: disconnecting
         * tears down the in-flight status polls, and logging that as ERROR would point
         * a reader at the wrong end of the session.
         */
        suspend fun fail(t: Throwable?, note: String = "") {
            if (finished) return
            finished = true
            if (t is CancellationException) {
                Diag.debug(
                    LogTag.HTTP,
                    "$method ${LogFormat.redactUrl(url, Diag.config.captureSecrets)} cancelled ${elapsedMs()}ms" +
                        if (note.isEmpty()) "" else " $note",
                )
                return
            }
            Diag.httpExchange(
                method = method, url = url, status = 0, ms = elapsedMs(), bodyChars = 0,
                contentType = null, headers = null, bodyPreview = null, error = t,
                note = listOf(this.note, note).filter { it.isNotEmpty() }.joinToString(" "),
            )
        }

    }

    /**
     * Response headers worth a column of their own. Content-Type/-Length are dropped
     * because the line already carries them; `Server` and `Date` are exactly the
     * ones that identify a firmware family and its clock skew.
     */
    private fun headerSummary(resp: HttpResponse): String = runCatching {
        resp.headers.entries()
            .filterNot { (name, _) -> name.equals("content-type", true) || name.equals("content-length", true) }
            .joinToString("; ") { (name, values) -> "$name=${values.joinToString(",")}" }
            .take(200)
    }.getOrDefault("")

    private fun rate(bytes: Long, startedMono: Long): Long {
        val ms = (monotonicMillis() - startedMono).coerceAtLeast(1L)
        return bytes * 1000 / ms
    }

    private fun Long.toIntOrMinus(): Int = if (this > Int.MAX_VALUE) -1 else this.toInt()
}
