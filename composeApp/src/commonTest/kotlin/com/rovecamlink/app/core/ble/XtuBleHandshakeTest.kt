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

    /** The camera refusing a code is our problem to retry, not the user.s. */
    @Test
    fun aRefusedCodeIsRotatedSilentlyBeforeBotheringAnyone() {
        val h = handshake()
        h.start()
        val retry = h.onNotify(notify("KEY=0"))
        assertIs<BleProgress.Send>(retry)
        assertTrue(retry.frames.single().bytes.decodeToString().startsWith("R003_"))
        h.onNotify(notify("KEY=0"))
        h.onNotify(notify("KEY=0"))
        val givenUp = h.onNotify(notify("KEY=0"))
        assertIs<BleProgress.Failed>(givenUp)
        // A dead stage must stop producing work, otherwise the caller spins.
        assertEquals(emptyList(), h.onTick(now + 60_000L))
        assertIs<BleProgress.Waiting>(h.onNotify(notify("Status=1,Pin=1234")))
    }

    @Test
    fun retriesThePendingCommandOnCadenceAndThenStops() {
        val h = handshake()
        h.start()
        assertEquals(emptyList(), sent(h.onTick(now + 1_000L)))
        assertEquals(listOf("R003_1234"), sent(h.onTick(now + 1_600L)))
        // MAX_SENDS covers the first write, so 7 more retries then silence.
        var t = now + 1_600L
        repeat(7) { t += 1_600L; sent(h.onTick(t)) }
        assertEquals(emptyList(), sent(h.onTick(t + 1_600L)))
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
}
