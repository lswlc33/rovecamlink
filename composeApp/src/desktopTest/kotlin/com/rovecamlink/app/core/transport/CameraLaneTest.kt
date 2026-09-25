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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.yield

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

        // The holder is held open until every other request is registered, and each
        // registration waits for the lane to actually take it before the next one starts.
        // The old version sequenced this with `delay(6)`/`delay(40)`, which was a race in
        // both directions under load: a slow dispatch let a later request reach the lane
        // first, and a fast one let the holder finish before the queue was built — either
        // way the assertions below were about the scheduler rather than about the lane.
        val holderStarted = CompletableDeferred<Unit>()
        val releaseHolder = CompletableDeferred<Unit>()

        // Occupancy as the camera sees it: this is what must never exceed one. The
        // decrement sits in a `finally` so a failed or cancelled block cannot leave the
        // count high and quietly weaken the assertion below.
        suspend fun track(name: String, body: suspend () -> Unit) {
            peak.set(maxOf(peak.get(), inFlight.incrementAndGet()))
            order.add(name)
            try {
                body()
            } finally {
                inFlight.decrementAndGet()
            }
        }

        withContext(Dispatchers.Default) {
            val specs = buildList {
                add("enum0" to CameraRequestClass.Enumerate)
                (1..5).forEach { add("enum$it" to CameraRequestClass.Enumerate) }
                add("command" to CameraRequestClass.Command)
                add("status" to CameraRequestClass.Status)
            }
            val jobs = specs.mapIndexed { index, (name, clazz) ->
                val job = async {
                    lane.submit(clazz) {
                        track(name) {
                            if (index == 0) {
                                holderStarted.complete(Unit)
                                releaseHolder.await()
                            } else {
                                delay(20)
                            }
                        }
                    }
                }
                if (index == 0) withTimeout(5_000) { holderStarted.await() }
                else awaitWaiting(lane, index) // enum0 holds, so the k-th arrival is the k-th queued
                job
            }
            releaseHolder.complete(Unit)
            withTimeout(20_000) { jobs.awaitAll() }
            seen.set(order.size)
        }

        assertEquals(1, peak.get(), "the camera serves one connection; the lane must never run two")
        assertEquals(8, seen.get())
        assertEquals("enum0", order.first())
        assertTrue(order.indexOf("command") < order.indexOf("enum5"), "order was $order")
        assertTrue(order.indexOf("command") < order.indexOf("status"), "order was $order")
        assertTrue(order.indexOf("status") < order.indexOf("enum5"), "order was $order")
    }

    /**
     * A Command arriving exactly as the holder finishes must not share the slot with the
     * waiter that was queued behind it.
     *
     * This is the race the hand-off has to close: releasing the slot and promoting the next
     * waiter in two separate critical sections leaves a window where a newly arriving
     * Command sees a free slot — its queued Enumerate rival does not outrank it — and takes
     * it, while the promotion then hands the same slot to the waiter. Both callers run and
     * the camera gets two overlapping requests.
     *
     * Repeated because it is a race: one round lands in the window only by luck. Both
     * parties in the overlap hold the slot briefly, so a collision is *observed* rather
     * than merely won by a nose — and the wait for the second request to be queued is a
     * `yield` spin, not `delay` polling: on Windows a `delay` costs a full ~15 ms timer
     * tick, which is 25 seconds over these rounds.
     */
    @Test
    fun aCommandArrivingAsTheHolderFinishesNeverSharesTheSlot() = runBlocking {
        val inFlight = AtomicInteger()
        val peak = AtomicInteger()
        val overlaps = Collections.synchronizedList(mutableListOf<String>())

        suspend fun track(name: String, body: suspend () -> Unit) {
            val live = inFlight.incrementAndGet()
            if (live > 1) overlaps.add("$name saw $live in flight")
            peak.set(maxOf(peak.get(), live))
            try {
                body()
            } finally {
                inFlight.decrementAndGet()
            }
        }

        withContext(Dispatchers.Default) {
            repeat(ROUNDS) { round ->
                val lane = CameraLane("127.0.0.1:$round")
                val holderStarted = CompletableDeferred<Unit>()
                val releaseHolder = CompletableDeferred<Unit>()

                val holder = async {
                    lane.submit(CameraRequestClass.Enumerate) {
                        track("holder") { holderStarted.complete(Unit); releaseHolder.await() }
                    }
                }
                withTimeout(5_000) { holderStarted.await() }

                // One Enumerate queued behind the holder. Its presence is what makes the
                // collision a bug rather than a legitimate claim: the promotion that follows
                // the hand-off has somewhere to go, so the arriving Command and the promoted
                // waiter can both end up holding the slot.
                val queued = async {
                    lane.submit(CameraRequestClass.Enumerate) { track("queued") { delay(HOLD_MS) } }
                }
                awaitQueued(lane, 1)

                // The collision: a Command reaches the lane in the same breath as the
                // holder's completion, and the two do not overtake each other.
                val arriving = async {
                    lane.submit(CameraRequestClass.Command) { track("arriving") { delay(HOLD_MS) } }
                }
                releaseHolder.complete(Unit)

                withTimeout(5_000) { holder.await() }
                withTimeout(5_000) { queued.await() }
                withTimeout(5_000) { arriving.await() }
            }
        }

        assertEquals(
            1,
            peak.get(),
            "two requests ran against the same camera at once — ${overlaps.take(3)}",
        )
    }

    /**
     * Spin (without a timer) until the lane holds [expected] queued requests.
     *
     * `delay(1)` polling — what [awaitWaiting] does — costs a full timer tick per iteration,
     * and the collision test's cost is dominated by those ticks rather than by its logic.
     */
    private suspend fun awaitQueued(lane: CameraLane, expected: Int) {
        withTimeout(2_000) {
            while (lane.waitingCount() != expected) yield()
        }
    }

    @Test
    fun cancelledWaiterNeverStrandsTheLane(): Unit = runBlocking {
        val lane = CameraLane("192.168.0.1:80")
        val holderStarted = CompletableDeferred<Unit>()
        val releaseHolder = CompletableDeferred<Unit>()
        withContext(Dispatchers.Default) {
            val held = async {
                lane.submit(CameraRequestClass.Command) {
                    holderStarted.complete(Unit)
                    releaseHolder.await()
                    "held"
                }
            }
            // Every wait below is on an observable fact rather than a sleep: this test used
            // to sequence four coroutines with `delay(30)` and lost the race whenever the
            // machine was busy (see CameraLane.waitingCount).
            holderStarted.await()
            // Queued behind it, then abandoned before it ever gets the slot.
            val abandoned = async { lane.submit(CameraRequestClass.Enumerate) { "never" } }
            awaitWaiting(lane, 1)
            abandoned.cancel()
            awaitWaiting(lane, 0)
            val finished = CompletableDeferred<Unit>()
            val followUp = async {
                lane.submit(CameraRequestClass.Enumerate) { finished.complete(Unit); "ok" }
            }
            releaseHolder.complete(Unit)
            held.await()
            withTimeout(5_000) { finished.await() }
            assertEquals("ok", followUp.await())
        }
    }

    /** Spin until [lane] has exactly [expected] requests queued, or fail after a second. */
    private suspend fun awaitWaiting(lane: CameraLane, expected: Int) {
        withTimeout(1_000) {
            while (lane.waitingCount() != expected) delay(1)
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

        /**
         * Rounds for [aCommandArrivingAsTheHolderFinishesNeverSharesTheSlot]. Each round is
         * one hand-off racing an arrival, and the race window is a few instructions wide, so
         * this is far more than one: it has to fail loudly on a split hand-off rather than
         * once in a hundred runs.
         */
        const val ROUNDS = 150

        /**
         * How long each party in a potential overlap stays inside its block.
         *
         * Long enough that a second caller entering the same slot is caught red-handed
         * instead of slipping in after the first has left; short enough that a round costs
         * one timer tick rather than a dozen.
         */
        const val HOLD_MS = 3L
    }
}
