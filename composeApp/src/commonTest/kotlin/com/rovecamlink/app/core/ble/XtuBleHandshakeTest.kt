package com.rovecamlink.app.core.ble

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue

/**
 * The BLE handshake is the one part of provisioning that a real camera can refuse
 * over a trivial formatting detail, so every rule learned from the official client
 * is pinned here rather than left to a device test.
 */
class XtuBleHandshakeTest {

    private var now = 1_000L
    private val clock: () -> Long = { now }
    private val accepted = mutableListOf<String>()
    private val camera = BleCamera("1C:4E:A2:F9:E5:E2", "XTU_S7Pro_f9e5e2", -53, XtuBleProfile.ID)

    private fun handshake(key: String = "1234") =
        XtuBleHandshake(camera, key, clock) { accepted += it }

    /** What a second visit to the same camera looks like: the store already has a code. */
    private fun resuming(key: String = "6874") =
        XtuBleHandshake(camera, key, clock, resumeWithStoredKey = true) { accepted += it }

    private fun notify(text: String) = text.encodeToByteArray()

    private fun sent(progress: BleProgress): List<String> = when (progress) {
        is BleProgress.Send -> progress.frames.map { it.bytes.decodeToString() }
        else -> emptyList()
    }

    private fun sent(frames: List<BleFrame>): List<String> = frames.map { it.bytes.decodeToString() }

    @Test
    fun happyPathWalksTheThreeCommandsInOrder() {
        val h = handshake()
        assertEquals(listOf("R003_1234"), sent(h.start()))

        val opened = h.onNotify(notify("Status=1,Pin=1234"))
        assertEquals(listOf("R001_1234"), sent(opened))
        assertEquals("opening-hotspot", h.stage())

        val confirmed = h.onNotify(notify("SSID=XTU_S7Pro_f9e5e2,PWD=abcdefgh"))
        assertEquals(listOf("R002_1234"), sent(confirmed))

        val offer = h.onNotify(notify("WiFi_Status=1"))
        assertIs<BleProgress.Offered>(offer)
        assertEquals("XTU_S7Pro_f9e5e2", offer.ssid)
        assertEquals("abcdefgh", offer.password)
        assertEquals("ready", h.stage())
        assertEquals(listOf("1234"), accepted)
    }

    /**
     * Which of the two codes gets kept for next time.
     *
     * The store has to hold the code the camera **showed on its screen**, because that
     * is the one it will recognise on the next visit — `saveDeviceWithPin(name, Pin)` in
     * the official client (`BLEConnectUtils.java:648-649`). This firmware echoes the code
     * we wrote, so the two agree in the test above; a camera that answers its own value
     * is the case this pins down.
     */
    @Test
    fun theCamerasEchoedPinIsWhatGetsStoredForNextTime() {
        val h = handshake("1234")
        h.start()
        val open = h.onNotify(notify("Status=1,Pin=9876"))
        assertEquals(listOf("9876"), accepted, "the next visit must offer the code the camera displayed")
        assertEquals(listOf("R001_1234"), sent(open), "this session keeps the code the camera took from us")
    }

    /** The camera refusing a code is our problem to retry, not the user.s. */
    @Test
    fun aRefusedCodeIsRotatedSilentlyBeforeBotheringAnyone() {
        val h = handshake()
        h.start()
        val retry = h.onNotify(notify("KEY=0"))
        assertIs<BleProgress.Send>(retry)
        assertTrue(retry.frames.single().bytes.decodeToString().startsWith("R003_"))
        repeat(XtuBleHandshake.MAX_ROTATIONS - 1) {
            assertIs<BleProgress.Send>(h.onNotify(notify("KEY=0")), "refusal ${it + 2} must still rotate")
        }
        val givenUp = h.onNotify(notify("KEY=0"))
        assertIs<BleProgress.Failed>(givenUp)
        // A dead stage must stop producing work, otherwise the caller spins.
        assertEquals(emptyList(), h.onTick(now + 60_000L))
        assertIs<BleProgress.Waiting>(h.onNotify(notify("Status=1,Pin=1234")))
    }

    /**
     * The refusal this camera actually sends, in the volume it actually sends it.
     *
     * The 2026-09-22 field log shows `Status=0,Pin=3056` … `Pin=5226` … `Pin=1881` …
     * `Pin=8616` and then a failed handshake, while a retry seconds later was accepted
     * on the third such reply. Four of these therefore may **not** end the attempt.
     */
    @Test
    fun fourStatusZeroRepliesDoNotEndTheAttempt() {
        val h = handshake()
        h.start()
        listOf("3056", "5226", "1881", "8616").forEach { pin ->
            assertIs<BleProgress.Send>(
                h.onNotify(notify("Status=0,Pin=$pin")),
                "a Status=0 reply must keep the handshake alive, not rotate it out",
            )
        }
        val accepted = h.onNotify(notify("Status=1,Pin=6874"))
        assertEquals("opening-hotspot", h.stage())
        assertTrue(
            sent(accepted).single().startsWith("R001_"),
            "the accepted reply must open the hotspot, got ${sent(accepted)}",
        )
    }

    /**
     * Every pairing retry has to offer a **different** code.
     *
     * The 2026-09-22 20:46 run is the whole case: this app wrote `R003_6874` — the code
     * the camera had accepted in an earlier session — twelve times in a row, the stack
     * confirmed every write with `status=0`, and the camera sent **zero** notifications
     * in 45 seconds. It answers a code it has not seen; a code it has already refused
     * or used is dead air, so repeating one is not "patient", it is silence.
     */
    @Test
    fun pairingRetriesOfferAFreshCodeEveryTime() {
        val h = handshake("6874")
        val codes = mutableListOf(sent(h.start()).single())
        var t = now
        repeat(6) { t += 1_600L; codes += sent(h.onTick(t)).single() }
        assertEquals(
            codes.size,
            codes.toSet().size,
            "a repeated pairing code is a code the camera will not answer: $codes",
        )
        assertTrue(
            codes.drop(1).none { it == "R003_6874" },
            "only the first offer may be the remembered code: $codes",
        )
        assertTrue(codes.all { it.startsWith("R003_") && it.length == 9 }, "shape: $codes")
    }

    @Test
    fun retriesOnCadenceAndEventuallyStop() {
        val h = handshake()
        h.start()
        assertEquals(emptyList(), sent(h.onTick(now + 1_000L)))
        assertTrue(sent(h.onTick(now + 1_600L)).single().startsWith("R003_"))
        // Rotating codes are bounded too: once MAX_ROTATIONS is spent the code stops
        // changing, and then MAX_SENDS ends the writes, so a camera that is switched off
        // becomes an error instead of an infinite loop.
        var t = now + 1_600L
        repeat(XtuBleHandshake.MAX_ROTATIONS + XtuBleHandshake.MAX_SENDS + 4) {
            t += 1_600L
            sent(h.onTick(t))
        }
        assertEquals(emptyList(), sent(h.onTick(t + 1_600L)))
    }

    /**
     * The retry budget has to outlast the camera's own answer latency.
     *
     * Measured on the XTU S7PRO on 2026-09-22: the first pairing notification landed 7
     * to 17 seconds after the link was up, and the old budget of eight writes at 1.5 s
     * went quiet at ~12 s — the camera answered a question this app had stopped asking.
     */
    @Test
    fun keepsWritingWhileTheCameraTakesItsTimeOnTheFirstReply() {
        val slowestFirstReplyMs = 17_000L
        assertTrue(
            XtuBleHandshake.MAX_ROTATIONS * XtuBleHandshake.RETRY_INTERVAL_MS >= slowestFirstReplyMs,
            "pairing must still be offering codes at ${slowestFirstReplyMs}ms",
        )
    }

    @Test
    fun apReadyWithoutAnSsidFallsBackToTheAdvertiseName() {
        val h = handshake()
        h.start()
        h.onNotify(notify("Status=1,Pin=1234"))
        h.onNotify(notify("SSID=XTU_S7Pro_f9e5e2,PWD=abcdefgh"))
        val offer = h.onNotify(notify("WiFi_Status=1"))
        assertIs<BleProgress.Offered>(offer)
        assertEquals("XTU_S7Pro_f9e5e2", offer.ssid)
    }

    @Test
    fun openHotspotReportsAnEmptyPasswordAndSurvives() {
        val h = handshake()
        h.start()
        h.onNotify(notify("Status=1,Pin=1234"))
        h.onNotify(notify("SSID=XTU_OPEN,PWD="))
        val offer = h.onNotify(notify("WiFi_Status=1"))
        assertIs<BleProgress.Offered>(offer)
        assertEquals("XTU_OPEN", offer.ssid)
        assertEquals(null, offer.password)
    }

    /**
     * The fast path the official client uses on a camera it already paired with:
     * `BLEConnectUtils.java:859-878` never writes `R003_` when it holds a code, it opens
     * the hotspot with `R001_` straight away — and that is why pairing looks like a
     * one-time confirmation over there.
     */
    @Test
    fun aKnownCameraOpensItsHotspotWithoutAnyPairingOffer() {
        val h = resuming("6874")
        assertEquals(listOf("R001_6874"), sent(h.start()))
        assertEquals(
            listOf("R002_6874"),
            sent(h.onNotify(notify("SSID=XTUCam_f9e5e2,PWD=abcdefgh"))),
            "the SSID reply must move straight to the confirm step",
        )
        val offer = h.onNotify(notify("WiFi_Status=1"))
        assertIs<BleProgress.Offered>(offer)
        assertEquals("XTUCam_f9e5e2", offer.ssid)
        assertEquals("abcdefgh", offer.password)
        assertEquals("ready", h.stage())
        assertEquals(emptyList(), accepted, "a resumed session has nothing new to remember")
    }

    /** Silence, not a refusal, is how a camera that forgot the code answers it. */
    @Test
    fun aStoredCodeThatGoesUnansweredFallsBackToPairing() {
        val h = resuming("6874")
        val wire = mutableListOf<String>()
        wire += sent(h.start())
        var t = now
        var guard = 0
        while (wire.last().startsWith("R001_") && guard++ < 20) {
            t += XtuBleHandshake.RETRY_INTERVAL_MS + 100L
            wire += sent(h.onTick(t))
        }
        assertEquals(
            XtuBleHandshake.RESUME_PROBE_SENDS,
            wire.count { it.startsWith("R001_") },
            "the bet should be called quickly, not after the whole send budget: $wire",
        )
        val last = wire.last()
        assertTrue(
            last.startsWith("R003_") && last != "R003_6874",
            "a stale stored code must end in a fresh pairing offer, got $last",
        )
        assertEquals("pairing", h.stage())
    }

    @Test
    fun aRefusedStoredCodeGoesBackToPairingAtOnce() {
        val h = resuming("6874")
        assertEquals(listOf("R001_6874"), sent(h.start()))
        val retry = h.onNotify(notify("Status=0,Pin=6874"))
        assertIs<BleProgress.Send>(retry)
        val text = retry.frames.single().bytes.decodeToString()
        assertTrue(
            text.startsWith("R003_") && text != "R003_6874",
            "a camera that says no to the stored code must be offered a new one, got $text",
        )
        assertEquals("pairing", h.stage())
    }

    /**
     * The decision is the profile's, not the caller's: only a code that came from the
     * store may skip the pairing offer.
     */
    @Test
    fun onlyACameraWithAStoredCodeTakesTheFastPath() {
        val keys = MemoryPairingKeyStore()
        val profile = XtuBleProfile(keys) { now }

        val first = sent(profile.newSession(camera, null).start()).single()
        assertTrue(
            first.startsWith("R003_"),
            "an unknown camera has never seen a code, so it must be offered one, got $first",
        )

        keys.remember(camera.name, "4321")
        assertEquals(listOf("R001_4321"), sent(profile.newSession(camera, null).start()))
        assertEquals(
            listOf("R001_9999"),
            sent(profile.newSession(camera, "9999").start()),
            "a code handed in by the caller is a remembered code too",
        )
    }
}
