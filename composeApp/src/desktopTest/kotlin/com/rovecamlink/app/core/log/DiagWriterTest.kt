package com.rovecamlink.app.core.log

import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlinx.coroutines.runBlocking

/**
 * Behaviour of the writer itself: operation correlation, steady-state sampling,
 * ring bounds and what the export promises about all three.
 */
class DiagWriterTest {

    private val url = "http://192.168.0.1/cgi-bin/hi3510/getcamerastatus.cgi"

    @AfterTest
    fun restore() = runBlocking {
        Diag.clear()
        Diag.config.minLevel = LogLevel.DEBUG
        Diag.config.sampleSteadyTraffic = true
        Diag.config.captureSecrets = false
        Diag.config.ringCapacity = 12_000
    }

    private suspend fun poll(ms: Long = 12) =
        Diag.httpExchange("GET", url, status = 200, ms = ms, bodyChars = 7, contentType = "text/plain", headers = null, bodyPreview = "var x=\"1\";")

    @Test
    fun steadyPollingIsSampledAndTheHiddenPartIsStillKept() = runBlocking {
        // Lives in desktopTest rather than commonTest: the actor needs a real
        // dispatcher to be asserted on, and `runBlocking` is JVM-only while
        // kotlinx-coroutines-test cannot be resolved in CI.
        Diag.clear()
        repeat(30) { poll(ms = 10L + it) }
        Diag.awaitDrained()

        val kept = Diag.tail(100, level = LogLevel.INFO)
        // #1 is the baseline, #21 closes the first sampled run; the rest sit at TRACE.
        assertEquals(2, kept.size, "only the sampled lines stay at INFO: ${kept.map { it.text.take(60) }}")
        assertTrue(kept[0].annotation == null, "the first occurrence needs no annotation")
        assertTrue(kept[1].annotation?.contains("run=21") == true, kept[1].annotation ?: "no annotation")
        assertTrue(kept[1].annotation!!.contains("max=30ms"), kept[1].annotation!!)

        val all = Diag.tail(100, level = LogLevel.TRACE)
        assertEquals(30, all.size, "sampling demotes, it never drops")
        assertTrue(all.last().annotation!!.startsWith("(same x"), all.last().annotation!!)
    }

    @Test
    fun aChangedReplyBreaksTheRun() = runBlocking {
        Diag.clear()
        repeat(3) { poll() }
        Diag.httpExchange("GET", url, status = 500, ms = 5, bodyChars = 4, contentType = null, headers = null, bodyPreview = "err")
        poll()
        Diag.awaitDrained()

        val visible = Diag.tail(100, level = LogLevel.INFO)
        assertEquals(3, visible.size, "first, the non-2xx, and the first reply after it: ${visible.map { it.level }}")
        assertEquals(LogLevel.WARN, visible[1].level)
    }

    @Test
    fun theFirstRepliesAfterAnOutageAreNeverSampledAway() = runBlocking {
        Diag.clear()
        repeat(4) { poll() } // #1 shown, #2..#4 folded
        Diag.httpExchange(
            "GET", url, status = 0, ms = 20_000, bodyChars = 0, contentType = null,
            headers = null, bodyPreview = null, error = IllegalStateException("read timed out"),
        )
        poll(); poll(); poll()
        Diag.awaitDrained()

        val visible = Diag.tail(100, level = LogLevel.INFO)
        // The first poll of the session, the failure, and the first poll after it: an
        // outage that ends has to be as visible as one that starts. The two polls after
        // that are folded again, so the steady state stays quiet.
        assertEquals(3, visible.size, visible.map { "${it.level}:${it.text.take(40)}" }.toString())
        assertEquals(LogLevel.ERROR, visible[1].level)
        assertTrue(visible[2].text.contains("  -> 200"), visible[2].text)
        val everything = Diag.tail(100, level = LogLevel.TRACE)
        assertEquals(7, everything.count { "  -> 200" in it.text }, "all seven polls are still retained")
    }

    @Test
    fun operationsCorrelateEveryNestedLine() = runBlocking {
        Diag.clear()
        Diag.inOp("capture", "mode=photo") {
            poll()
            Diag.i(LogTag.PROTO) { "nested protocol decision" }
        }
        Diag.awaitDrained()

        val lines = Diag.tail(50).map { it.op }
        assertEquals(4, lines.size, "BEGIN, the exchange, the nested decision, END")
        assertTrue(lines.all { it != null && it.endsWith(":capture") }, lines.toString())
        assertTrue(lines.first()!!.toCharArray().any { it.isDigit() }, "the id is unique per operation")

        val text = Diag.tail(50).map { it.text }
        assertTrue(text[0].startsWith("BEGIN capture mode=photo"), text[0])
        assertTrue(text[1].contains("#"), "the exchange carries its own request id: ${text[1]}")
        assertTrue(text[2] == "nested protocol decision", text[2])
        assertTrue(text[3].startsWith("END capture ok "), text[3])
    }

    @Test
    fun aThrownOperationIsRecordedAsAFailure() = runBlocking {
        Diag.clear()
        val boom = runCatching {
            Diag.inOp("formatSd") { throw IllegalStateException("card busy") }
        }.exceptionOrNull()
        Diag.awaitDrained()

        assertEquals("card busy", boom?.message)
        val last = Diag.tail(10).last()
        assertEquals(LogLevel.ERROR, last.level)
        assertTrue(last.text.contains("END formatSd FAIL"), last.text)
        assertTrue(last.text.contains("IllegalStateException: card busy"), last.text)
    }

    @Test
    fun ringEvictionIsVisibleInTheExportHeader() = runBlocking {
        Diag.clear()
        Diag.config.ringCapacity = 8
        Diag.config.sampleSteadyTraffic = false
        repeat(25) { Diag.info(LogTag.APP, "noise $it") }
        Diag.awaitDrained()

        assertEquals(8, Diag.count())
        val bundle = Diag.exportBundle()
        assertTrue(bundle.contains("8 in memory"), bundle.substringBefore("\n", ""))
        assertTrue(bundle.contains("17 evicted"), "the header must admit what it dropped")
        // Newest kept, oldest gone: exactly what makes a truncated file still usable.
        assertTrue(bundle.contains("noise 24") && !bundle.contains("noise 3"))
    }

    @Test
    fun theBundleDescribesItselfSoItCanBeReadCold() = runBlocking {
        Diag.clear()
        Diag.warn(LogTag.WIFI, "gateway not resolvable")
        Diag.awaitDrained()
        val bundle = Diag.exportBundle()

        for (required in listOf(
            "format=", "grammar=", "legend=", "app.start=", "device.tz=", "config:",
            "==== RECORDS", "==== SUMMARY ====", "==== END ====",
        )) {
            assertTrue(bundle.contains(required), "missing '$required' in:\n${bundle.take(1200)}")
        }
        assertTrue(bundle.lineSequence().first { it.startsWith("0") }.startsWith("000"), "records start after the header")
        assertTrue(bundle.contains("W WIFI  op=- gateway not resolvable"), bundle)
    }
}
