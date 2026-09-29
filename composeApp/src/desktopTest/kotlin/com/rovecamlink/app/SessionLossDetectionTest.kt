package com.rovecamlink.app

import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/**
 * 「相机被关掉之后，App 必须说出来」。
 *
 * The 2026-09-29 report: with the camera powered off (or its hotspot gone) nothing on screen
 * changed — 已连接 stayed up over a frozen picture, the battery and card rows went to dashes —
 * and the user had no way to learn the session was over. The cause was not a missing notice but
 * a missing *signal*: the poll loop's ladder counted exceptions, and no plugin throws, because
 * every read in this app reports failure as `null`/empty and still returns a `DeviceStatus`.
 * [AppState] now asks the transport instead, and this test drives the real thing — a real
 * session, over a real socket, against a camera that is switched off in the middle of it.
 *
 * Desktop/JVM only, like the rest of this source set: it needs `runBlocking` and real sockets,
 * and none of Android's permission dance. No new test dependencies.
 */
class SessionLossDetectionTest {

    /**
     * The camera goes silent, and the app must both end the session and say why.
     *
     * `errorMessage` is the notice the shell draws as its banner and the connect page repeats in
     * its 状态 card, so it is the thing the report says was missing: a session that ends with it
     * null is exactly the silent drop this test exists to prevent.
     */
    @Test
    fun `a camera that stops answering ends the session and says why`(): Unit = runBlocking {
        val camera = FakeCamera()
        val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
        val state = AppState(AppGraph(), scope)
        try {
            state.connect(manualHost = "127.0.0.1:${camera.port}")
            val connected = awaitFor(CONNECT_BUDGET_MS) { state.phase == Phase.Connected }
            assertTrue(connected, "the fake camera was never reached, so this test proves nothing")
            assertEquals(null, state.errorMessage, "a clean connect carries no error")

            // The camera is switched off: the address stops answering. This is the report's
            // scenario, and the state it used to leave the app in — 已连接, dashes, silence.
            camera.stop()

            val dropped = awaitFor(LOSS_BUDGET_MS) { state.session == null && state.phase == Phase.Idle }
            assertTrue(dropped, "the app never noticed the camera had gone (still ${state.phase})")
            assertNotNull(state.errorMessage, "the session ended without anything said about it")
        } finally {
            camera.stop()
            scope.cancel()
        }
    }

    /** Spin until [condition] holds, or give up after [budgetMs]. */
    private suspend fun awaitFor(budgetMs: Long, condition: () -> Boolean): Boolean =
        withTimeoutOrNull(budgetMs) {
            while (!condition()) delay(50)
            true
        } ?: false

    /** A hi3510 camera that answers just enough of the protocol to be identified and polled. */
    private class FakeCamera {
        private val server: HttpServer = HttpServer.create(InetSocketAddress("127.0.0.1", 0), 0)
        private var stopped = false
        val port: Int get() = server.address.port

        init {
            server.createContext("/") { ex: HttpExchange ->
                val body = reply(ex.requestURI.path)
                if (body == null) {
                    ex.sendResponseHeaders(404, -1)
                } else {
                    val bytes = body.toByteArray()
                    ex.responseHeaders.add("Content-Type", "text/plain; charset=UTF-8")
                    ex.sendResponseHeaders(200, bytes.size.toLong())
                    ex.responseBody.use { it.write(bytes) }
                }
                ex.close()
            }
            server.start()
        }

        /**
         * The three endpoints the session needs, in the firmware's own `var …` shape: identity
         * (the probe and `connect` both read it), the mode it is in, and the status the poll
         * reads. Everything else 404s — which is what a real camera does for an endpoint its
         * firmware lacks, and is also how a *failed* read reports itself here. So the status poll
         * has to keep answering for the session to stay up, exactly as in the field: any single
         * answer clears the silence clock.
         */
        private fun reply(path: String): String? = when {
            path.endsWith("/getdeviceattr.cgi") ->
                "var name=\"XTU X7 Pro\";\nvar hardversion=\"NewAPP\";\nvar softversion=\"1.0.4\";\n"
            path.endsWith("/getcurworkmode.cgi") -> "var workmode=\"NormalVideo\";\n"
            path.endsWith("/getcurallinfo.cgi") ->
                "var mode=\"NormalVideo\";\nvar state=\"0\";\nvar event=\"0\";\n"
            path.endsWith("/setsystime.cgi") -> "Success\n"
            else -> null
        }

        fun stop() {
            if (stopped) return
            stopped = true
            server.stop(0)
        }
    }

    private companion object {
        /** The connect flow against localhost: a second, or a few if the machine is busy. */
        const val CONNECT_BUDGET_MS = 30_000L

        /**
         * How long the app may take to notice. The transport's own window is 12 s (see
         * `CAMERA_SILENCE_MS`), and what is left over is the poll tick plus the first request
         * that has to fail before the clock even starts.
         */
        const val LOSS_BUDGET_MS = 40_000L
    }
}
