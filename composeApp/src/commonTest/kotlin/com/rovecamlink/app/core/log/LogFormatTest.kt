package com.rovecamlink.app.core.log

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlinx.datetime.TimeZone

/**
 * The text contract of an exported file. These assertions are deliberately about
 * exact strings: the file is read by someone who is not running the app, so the
 * grammar has to be stable across releases.
 */
class LogFormatTest {

    private val utc = TimeZone.UTC

    @Test
    fun wallStampIsIsoLocalWithOffset() {
        // 2025-09-21T10:32:11.482Z
        val millis = 1_758_450_731_482L
        assertEquals("2025-09-21T10:32:11.482+00:00", LogFormat.wall(millis, utc))
        assertEquals(
            "2025-09-21T18:32:11.482+08:00",
            LogFormat.wall(millis, TimeZone.of("Asia/Shanghai")),
        )
        assertEquals(480, LogFormat.utcOffsetMinutes(millis, TimeZone.of("Asia/Shanghai")))
    }

    @Test
    fun lineHasTheSixColumnsThenTheMessage() {
        val rec = LogRecord(
            level = LogLevel.INFO, tag = LogTag.HTTP, op = "7:capture",
            text = "#12 GET http://192.168.0.1/cgi-bin/hi3510/photo.cgi  -> 200 12ms 7ch",
            epochMillis = 1_758_450_731_482L, elapsedMillis = 12_345L,
        ).apply { seq = 451; annotation = "run=20 avg=13ms max=41ms" }

        val line = LogFormat.line(rec, utc)
        assertEquals(
            "000451 2025-09-21T10:32:11.482+00:00 +12.345s I HTTP  op=7:capture " +
                "#12 GET http://192.168.0.1/cgi-bin/hi3510/photo.cgi  -> 200 12ms 7ch" +
                "   run=20 avg=13ms max=41ms",
            line,
        )
        // Columns are fixed width (tag is padded), so a run of spaces separates them.
        val cols = line.trim().split(Regex(" +"))
        assertEquals("000451", cols[0])
        assertEquals("2025-09-21T10:32:11.482+00:00", cols[1])
        assertEquals("+12.345s", cols[2])
        assertEquals("I", cols[3])
        assertEquals("HTTP", cols[4])
        assertEquals("op=7:capture", cols[5])
        assertEquals("#12", cols[6])
    }

    @Test
    fun bodiesGoOnPipeContinuationLines() {
        val block = LogFormat.bodyBlock("var name=\"X7\";\r\nvar softversion=\"20250101.0\";", 1_024, keepSecrets = true)
        val lines = block.lines()
        assertEquals(2, lines.size)
        assertTrue(lines.all { it.startsWith(LogFormat.CONT) }, "every payload line must be prefixed")
        assertTrue(lines[0].contains("var name="))
    }

    @Test
    fun truncationIsAnnouncedNotSilent() {
        val long = "x".repeat(3_000)
        val block = LogFormat.bodyBlock(long, 100, keepSecrets = true)
        assertTrue(block.contains("...truncated 2900 chars of 3000"), block)
    }

    @Test
    fun secretQueryValuesAreMaskedWithTheirLength() {
        val url = "http://192.168.0.1/cgi-bin/hi3510/setwifi.cgi?&-wifissid=XTU-X7&-wifikey=supersecret1&-channel=6"
        val redacted = LogFormat.redactUrl(url)
        assertFalse(redacted.contains("supersecret1"), redacted)
        assertTrue(redacted.contains("wifikey=***#12"), redacted)
        // Everything a protocol diagnosis needs has to survive masking.
        assertTrue(redacted.contains("setwifi.cgi"))
        assertTrue(redacted.contains("wifissid=XTU-X7"))
        assertTrue(redacted.contains("channel=6"))
        assertEquals(url, LogFormat.redactUrl(url, keepSecrets = true))
    }

    @Test
    fun secretsInsideBodiesAreMaskedToo() {
        // Some firmware echoes the passphrase back in a var-assignment body.
        val body = "var wifissid=\"XTU-1\";\r\nvar wifikey=\"letmein123\";\r\n"
        val field = LogFormat.bodyField(body, keepSecrets = false)
        assertFalse(field.contains("letmein123"), field)
        assertTrue(field.contains("***#10"), field)
        assertTrue(field.contains("wifikey="), field)
        assertTrue(field.contains("\\r\\n"), "newlines must be escaped inside a field: $field")
    }

    @Test
    fun menuIndirectPasswordsAreMaskedViaTheirSiblingParameter() {
        // TUWIN: /api/menu/setparameter?id=wifi_passwd&value=<pw>
        val tuwin = LogFormat.redactUrl("http://1.2.3.4/api/menu/setparameter?id=wifi_passwd&value=hunter2pass")
        assertFalse(tuwin.contains("hunter2pass"), tuwin)
        assertTrue(tuwin.contains("value=***#11"), tuwin)
        assertTrue(tuwin.contains("id=wifi_passwd"), "the setting name stays readable: $tuwin")

        // XTU new-app menu: setcurparameter.cgi?-name=Wifi Key&-value=<pw>
        val xtu = LogFormat.redactUrl("http://1.2.3.4/cgi-bin/hi3510/setcurparameter.cgi?-workmode=NormalVideo&-name=Wifi+Key&-value=s3cr3tword")
        assertFalse(xtu.contains("s3cr3tword"), xtu)
        assertTrue(xtu.contains("-value=***#10"), xtu)

        // An ordinary setting must NOT be masked, or the log is useless.
        val normal = LogFormat.redactUrl("http://1.2.3.4/cgi-bin/hi3510/setcurparameter.cgi?-name=Resolution&-value=4K30")
        assertTrue(normal.contains("-value=4K30"), normal)
    }

    @Test
    fun urlUserInfoCredentialsAreMasked() {
        val masked = LogFormat.redactUrl("http://admin:camera999@192.168.0.1/index.html")
        assertFalse(masked.contains("camera999"), masked)
        assertTrue(masked.contains("@192.168.0.1"), "the host must stay reachable: $masked")
    }

    @Test
    fun rtmpStreamKeysAreMaskedButTheServerStaysReadable() {
        // The classic shape: app + key. The key is what lets anyone push into the
        // channel, so it never travels in an export; host and app do.
        val masked = LogFormat.redactStreamUrl("rtmp://push.example.com/live/key-19abC")
        assertFalse(masked.contains("key-19abC"), masked)
        assertTrue(masked.contains("rtmp://push.example.com/live/"), masked)
        assertTrue(masked.contains("/***#9"), masked)

        // The other shape hosts use: key as the first path segment.
        val appless = LogFormat.redactStreamUrl("rtmp://a.b-cdn.net/9f8e7d6c5b4a")
        assertFalse(appless.contains("9f8e7d6c5b4a"), appless)
        assertTrue(appless.startsWith("rtmp://a.b-cdn.net/"), appless)
    }

    @Test
    fun rtmpWithoutAKeySegmentAndNonRtmpUrlsPassThrough() {
        // Nothing after the authority: no key exists, and masking the host would erase
        // the one fact the line is there to record.
        assertEquals("rtmp://192.168.1.10:1935", LogFormat.redactStreamUrl("rtmp://192.168.1.10:1935"))
        // Ordinary URLs keep the redactUrl behaviour unchanged — the key mask is for pushes.
        val http = "http://192.168.0.1/cgi-bin/hi3510/getdeviceattr.cgi"
        assertEquals(LogFormat.redactUrl(http), LogFormat.redactStreamUrl(http))
    }

    @Test
    fun aBodyIsMaskedExactlyOnce() {
        // Regression: a second redaction pass used to re-mask its own `***#10` output.
        val out = LogFormat.redactText("var wifikey=\"letmein123\";")
        assertEquals("var wifikey=\"***#10\";", out)
    }

    @Test
    fun controlCharsNeverBreakALine() {
        val s = LogFormat.safe("a\nb\tc\rd\u0000e")
        assertFalse(s.contains('\n'), s)
        assertFalse(s.contains('\t'), s)
        assertFalse(s.contains('\r'), s)
        assertEquals("a\\nb\\tc\\rd?e", s)
    }

    @Test
    fun endpointKeysStayLowCardinality() {
        assertEquals(
            "cgi:getdeviceattr",
            LogFormat.endpointKey("http://192.168.0.1:80/cgi-bin/hi3510/getdeviceattr.cgi?"),
        )
        assertEquals("api:device/status", LogFormat.endpointKey("http://1.2.3.4/api/device/status"))
        assertEquals(
            "media:.mp4",
            LogFormat.endpointKey("http://192.168.0.1/MOVIE/2026010112000000.MP4"),
        )
        assertEquals(
            "media:.thm",
            LogFormat.endpointKey("http://192.168.0.1/MOVIE/2026010112000000.THM"),
        )
        assertEquals("root:192.168.0.1", LogFormat.endpointKey("http://192.168.0.1/"))
    }

    @Test
    fun hexPreviewShowsBothFormsAndTheRealLength() {
        val bytes = ByteArray(40) { (it % 250).toByte() }
        val p = LogFormat.hexPreview(bytes, 8)
        assertTrue(p.startsWith("00 01 02 03 04 05 06 07 "), p)
        assertTrue(p.contains("...(+32 of 40B)"), p)
    }

    @Test
    fun sizesAreReadable() {
        assertEquals("0 B", LogFormat.size(0))
        assertEquals("512 B", LogFormat.size(512))
        assertEquals("1.0 MB", LogFormat.size(1024L * 1024))
        assertEquals("1.5 GB", LogFormat.size((1.5 * 1024 * 1024 * 1024).toLong()))
    }

    @Test
    fun causeChainEndsAtTheRootCause() {
        val root = IllegalStateException("connection reset")
        val mid = RuntimeException("http engine failed", root)
        val top = IllegalArgumentException("request failed", mid)
        assertEquals(
            "IllegalArgumentException: request failed <- RuntimeException: http engine failed " +
                "<- IllegalStateException: connection reset",
            Diag.causeChain(top),
        )
    }

    @Test
    fun statsSummaryIsThePartWorthReadingFirst() {
        val stats = LogStats()
        stats.noteRequest("cgi:getcamerastatus")
        stats.noteRequest("cgi:getcamerastatus")
        stats.noteRequest("cgi:getcamerastatus")
        stats.noteRequest("cgi:photo")
        stats.noteResponse("cgi:getcamerastatus", 200, 12)
        stats.noteResponse("cgi:getcamerastatus", 200, 48)
        stats.noteFailure("cgi:photo", IllegalStateException("boom"), 20_000)
        stats.noteOperation("capture", true)
        stats.noteOperation("capture", false)
        val text = stats.summary(0L, 123_456L)

        // Columns, not substring luck: "HTTP 200" also contains "20".
        fun row(name: String): List<String> = text.lineSequence()
            .first { it.startsWith(name) }
            .removePrefix(name)
            .trim()
            .split(Regex("\\s+"))

        // endpoint n answered fail non2xx avg_ms max_ms last...
        val status = row("cgi:getcamerastatus")
        assertEquals(listOf("3", "2", "0", "0", "30", "48"), status.take(6), status.toString())
        assertEquals("HTTP", status[6])
        val photo = row("cgi:photo")
        assertEquals(listOf("1", "0", "1", "0", "0", "20000"), photo.take(6), photo.toString())
        assertEquals("IllegalStateException", photo[6])

        assertTrue(text.contains("operations=capture 1ok/1FAIL"), text)
        assertTrue(text.contains("socket_errors=1*IllegalStateException"), text)
        assertTrue(text.contains("http: requests=4"), text)
    }
}
