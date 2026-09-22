package com.rovecamlink.app.core.transport

import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpServer
import java.net.ConnectException
import java.net.InetSocketAddress
import java.util.Collections
import java.util.concurrent.atomic.AtomicInteger
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout

/**
 * The transport rules that keep a camera alive.
 *
 * Written against the 2026-09-22 field log, where the S7PRO stopped answering
 * *anything* 2.5 s after the app started polling, listing and enumerating menus at the
 * same time. [CameraLane] is what makes that impossible, and these tests are the proof
 * that it really serialises, puts the shutter ahead of bookkeeping, and leaves a
 * refusing camera alone instead of hammering it.
 *
 * Desktop/JVM only: it needs `runBlocking`, real threads (a single-threaded dispatcher
 * would pass the concurrency assertions vacuously) and a real HTTP server. No new test
 * dependencies — CI resolves through a proxy that cannot reach Maven.
 */
class CameraLaneTest {

    @Test
    fun oneRequestAtATimeAndCommandsGoFirst() = runBlocking {
        val lane = CameraLane("192.168.0.1:80")
        val order = Collections.synchronizedList(mutableListOf<String>())
        val inFlight = AtomicInteger()
        val peak = AtomicInteger()
        val seen = AtomicInteger()

        withContext(Dispatchers.Default) {
            val jobs: List<Deferred<*>> = (0 until 6).map { i ->
                val job = async {
                    lane.submit(CameraRequestClass.Enumerate) {
                        peak.set(maxOf(peak.get(), inFlight.incrementAndGet()))
                        order.add("enum$i"); delay(40); inFlight.decrementAndGet()
                    }
                }
                // Register one at a time: on a multi-threaded dispatcher six coroutines
                // reach the lane in whatever order the threads hand them over, and the
                // assertion below is about the queue's order, not the scheduler's.
                delay(6)
                job
            }
            delay(10) // enum0 is in the slot, enum1..5 queued
            val command: Deferred<*> = async {
                lane.submit(CameraRequestClass.Command) {
                    peak.set(maxOf(peak.get(), inFlight.incrementAndGet()))
                    order.add("command"); delay(20); inFlight.decrementAndGet()
                }
            }
            delay(10)
            val status: Deferred<*> = async {
                lane.submit(CameraRequestClass.Status) {
                    peak.set(maxOf(peak.get(), inFlight.incrementAndGet()))
                    order.add("status"); delay(20); inFlight.decrementAndGet()
                }
            }
            withTimeout(20_000) { (jobs + command + status).awaitAll() }
            seen.set(order.size)
        }

        assertEquals(1, peak.get(), "the camera serves one connection; the lane must never run two")
        assertEquals(8, seen.get())
        assertEquals("enum0", order.first())
        assertTrue(order.indexOf("command") < order.indexOf("enum5"), "order was $order")
        assertTrue(order.indexOf("command") < order.indexOf("status"), "order was $order")
        assertTrue(order.indexOf("status") < order.indexOf("enum5"), "order was $order")
    }

    @Test
    fun cancelledWaiterNeverStrandsTheLane(): Unit = runBlocking {
        val lane = CameraLane("192.168.0.1:80")
        val releaseHolder = CompletableDeferred<Unit>()
        withContext(Dispatchers.Default) {
            val held = async {
                lane.submit(CameraRequestClass.Command) { releaseHolder.await(); "held" }
            }
            delay(30)
            // Queued behind it, then abandoned before it ever gets the slot.
            val abandoned = async { lane.submit(CameraRequestClass.Enumerate) { "never" } }
            delay(30)
            abandoned.cancel()
            val finished = CompletableDeferred<Unit>()
            val followUp = async {
                lane.submit(CameraRequestClass.Enumerate) { finished.complete(Unit); "ok" }
            }
            delay(30)
            releaseHolder.complete(Unit)
            held.await()
            withTimeout(5_000) { finished.await() }
            assertEquals("ok", followUp.await())
        }
    }

    @Test
    fun menuTrafficIsDroppedWhileTheCameraIsRefusing(): Unit = runBlocking {
        val lane = CameraLane("192.168.0.1:80")
        // What a wedged camera looks like from the transport's side.
        repeat(3) {
            assertFailsWith<ConnectException> {
                lane.submit<String?>(CameraRequestClass.Status) { throw ConnectException("Connection refused") }
            }
        }
        // Three failures in a row ⇒ cooldown: enumeration must not even open a socket,
        // while an explicit user command still reaches the camera.
        assertFailsWith<CameraRefusing> {
            lane.submit<String?>(CameraRequestClass.Enumerate) { error("must not run") }
        }
        assertEquals("Success", lane.submit(CameraRequestClass.Command) { "Success" })
    }

    @Test
    fun bulkTransfersRunOutsideTheLaneAndStillReportHealth(): Unit = runBlocking {
        val lanes = CameraLanes()
        val lane = lanes.lane("192.168.0.1:80")
        withContext(Dispatchers.Default) {
            val controlStarted = CompletableDeferred<Unit>()
            val control = async {
                lane.submit<String?>(CameraRequestClass.Command) { controlStarted.complete(Unit); delay(120); null }
            }
            withTimeout(5_000) { controlStarted.await() }
            // A download must be able to start while the command lane is busy — that is
            // the whole point of the separate bulk slot.
            val started = CompletableDeferred<Unit>()
            val result = lanes.withBulk("192.168.0.1:80") {
                started.complete(Unit)
                delay(20)
                -1L
            }
            withTimeout(5_000) { started.await() }
            assertEquals(-1L, result)
            control.await()
            // Two more refusals tip the lane over its threshold.
            repeat(2) {
                assertFailsWith<ConnectException> {
                    lane.submit<String?>(CameraRequestClass.Status) { throw ConnectException("Connection refused") }
                }
            }
        }
        // The failed control calls must have been counted by the lane: enumeration is
        // now held back, and that is what lets a wedged camera breathe.
        assertFailsWith<CameraRefusing> {
            lane.submit<String?>(CameraRequestClass.Enumerate) { error("must not run") }
        }
    }

    @Test
    fun thumbnailsComeBackIntactAndOversizedBodiesAreRefused() = runBlocking {
        val server = startServer()
        try {
            val http = CameraHttp()
            val small = http.getBytes("${server.base}/small.THM", maxBytes = 1024 * 1024)
            // The S7PRO's .THM files are 6–28 KB. If ktor's readBytes(cap) demanded a
            // full `cap`-sized body, the field log's "thumb unavailable (bytes=null)"
            // would show up right here as an empty result for every thumbnail.
            assertEquals(SMALL_BODY, small?.size ?: -1, "getBytes must return a body smaller than its cap")
            assertEquals(null, http.getBytes("${server.base}/big.bin", maxBytes = 1024 * 1024))
        } finally {
            server.stop()
        }
    }

    @Test
    fun targetKeysKeepDistinctHostsIndependent() {
        assertEquals("192.168.0.1:80", targetOf("http://192.168.0.1:80/cgi-bin/hi3510/getdeviceattr.cgi"))
        assertEquals("192.168.1.1:80", targetOf("http://192.168.1.1/api/device/status"))
        assertEquals("127.0.0.1:9999", targetOf("http://127.0.0.1:9999/x?y=1"))
    }

    private class FakeServer(val base: String, private val server: HttpServer) {
        fun stop() = server.stop(0)
    }

    private fun startServer(): FakeServer {
        val server = HttpServer.create(InetSocketAddress("127.0.0.1", 0), 0)
        server.createContext("/") { ex: HttpExchange ->
            val body = if (ex.requestURI.path.endsWith("/big.bin")) {
                ByteArray(2 * 1024 * 1024)
            } else {
                ByteArray(SMALL_BODY) { (it % 251).toByte() }
            }
            ex.responseHeaders.add("Content-Type", "application/octet-stream")
            ex.sendResponseHeaders(200, body.size.toLong())
            ex.responseBody.use { it.write(body); it.flush() }
        }
        server.start()
        return FakeServer("http://127.0.0.1:${server.address.port}", server)
    }

    private companion object {
        const val SMALL_BODY = 20_480
    }
}
