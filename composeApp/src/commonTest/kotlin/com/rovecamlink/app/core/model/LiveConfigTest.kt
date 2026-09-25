package com.rovecamlink.app.core.model

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

/**
 * The three gates and the three encoder slots, pinned before a camera ever sees them.
 *
 * Every one of these values ends up in a single `;`-separated payload on a socket that
 * answers nothing when the parameters are wrong (`XtuRtmpPush`) — there is no way to
 * find out on a device that `res:` wanted `1080` and got `1080P`. The blocker order
 * matters for the same reason: the payload carries one Wi-Fi network *and* one URL, and
 * the message a user gets has to name the field they still have to fill.
 */
class LiveConfigTest {

    private val valid = LiveConfig(
        ssid = "LiveNet",
        password = "secret",
        rtmpUrl = "rtmp://push.example.com/live/key123",
    )

    @Test
    fun `a filled config has nothing blocking it`() {
        assertNull(valid.blocker)
        assertTrue(valid.isSendable)
    }

    @Test
    fun `a blank config names the network first`() {
        // Both fields are empty; the network is the one the camera needs first, and the
        // URL message would send the user to the wrong field.
        assertEquals(LiveBlocker.NoNetwork, LiveConfig().blocker)
        assertFalse(LiveConfig().isSendable)
    }

    @Test
    fun `a network without a url is blocked on the url`() {
        assertEquals(LiveBlocker.NoUrl, valid.copy(rtmpUrl = "").blocker)
        assertEquals(LiveBlocker.NoUrl, valid.copy(rtmpUrl = "   ").blocker)
    }

    @Test
    fun `a url that is not rtmp is refused rather than sent`() {
        // The vendor's own gate is a `startsWith("rtmp")` on the prepared URL
        // (CustomLiveActivity.isLivePrepared). An `http://` address is what a user pastes
        // when they copy the wrong thing off the platform's console.
        assertEquals(LiveBlocker.NotRtmp, valid.copy(rtmpUrl = "http://push.example.com/live").blocker)
        assertEquals(LiveBlocker.NotRtmp, valid.copy(rtmpUrl = "//push.example.com/live").blocker)
    }

    @Test
    fun `the rtmp scheme check is case-insensitive`() {
        // No vendor UI ever offers `RTMP://`, but a URL pasted from a console can carry it
        // and the firmware does not care about the case.
        assertNull(valid.copy(rtmpUrl = "RTMP://push.example.com/live").blocker)
    }

    @Test
    fun `an open network is allowed through`() {
        // The vendor UI demands a passphrase (SelectLiveWifiActivity answers
        // 请选择可用的Wi-Fi密码), but `pwd:;` expresses an open network fine and refusing
        // it here would block a case the payload supports.
        assertNull(valid.copy(password = "").blocker)
    }

    @Test
    fun `resolution travels as a bare number string`() {
        // `res:%s` — a `1080P` here is a different command to the firmware.
        assertEquals(listOf("720", "1080"), LiveResolution.entries.map { it.wire })
        assertEquals(LiveResolution.R1080, LiveResolution.fromWire("1080"))
        assertEquals(LiveResolution.R720, LiveResolution.fromWire(" 720 "))
        assertNull(LiveResolution.fromWire("1080P"))
        assertNull(LiveResolution.fromWire(null))
    }

    @Test
    fun `frame rate travels as a bare number string`() {
        assertEquals(listOf("25", "30"), LiveFps.entries.map { it.wire })
        assertEquals(LiveFps.F25, LiveFps.fromWire("25"))
        assertNull(LiveFps.fromWire("60"))
    }

    @Test
    fun `bitrate is the only int on the wire and stays a flag`() {
        // The payload formats this one with `%d` while every other field is `%s`, and the
        // vendor app only ever sends 0 or 1 — never a kbps figure.
        assertEquals(listOf(0, 1), LiveBitrate.entries.map { it.wire })
        assertEquals(LiveBitrate.Smooth, LiveBitrate.fromWire(0))
        assertEquals(LiveBitrate.High, LiveBitrate.fromWire(1))
        assertNull(LiveBitrate.fromWire(2))
        assertNull(LiveBitrate.fromWire(null))
    }

    @Test
    fun `the default live type is the vendor's protocol slot value`() {
        // `BroadcastRTMPFragment2:354` sends `tiktokCN` even on the custom-RTMP screen, so
        // it is a protocol constant rather than a platform the user picks.
        assertEquals("tiktokCN", LiveConfig.DEFAULT_LIVE_TYPE)
        assertEquals("tiktokCN", LiveConfig().liveType)
    }

    @Test
    fun `the defaults are the ones the vendor screen opens on`() {
        val fresh = LiveConfig()
        assertEquals(LiveResolution.R1080, fresh.resolution)
        assertEquals(LiveFps.F30, fresh.fps)
        assertEquals(LiveBitrate.Smooth, fresh.bitrate)
    }
}