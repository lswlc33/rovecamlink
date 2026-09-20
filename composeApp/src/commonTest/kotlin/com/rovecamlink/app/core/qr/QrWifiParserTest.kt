package com.rovecamlink.app.core.qr

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class QrWifiParserTest {

    @Test
    fun androidWifiScheme() {
        val c = parseWifiQr("WIFI:T:WPA;S:XTUCam_f9e5e2;P:12345678;;")
        assertEquals("XTUCam_f9e5e2", c?.ssid)
        assertEquals("12345678", c?.password)
    }

    @Test
    fun androidWifiSchemeWithoutPassword() {
        val c = parseWifiQr("WIFI:S:RoveCam;;")
        assertEquals("RoveCam", c?.ssid)
        assertNull(c?.password)
    }

    @Test
    fun jsonPayload() {
        val c = parseWifiQr("""{"ssid":"XTUCam_f9e5e2","password":"12345678"}""")
        assertEquals("XTUCam_f9e5e2", c?.ssid)
        assertEquals("12345678", c?.password)
    }

    @Test
    fun queryStylePairs() {
        val c = parseWifiQr("ssid=XTUCam_f9e5e2&pwd=12345678")
        assertEquals("XTUCam_f9e5e2", c?.ssid)
        assertEquals("12345678", c?.password)
    }

    @Test
    fun colonCommaPairs() {
        val c = parseWifiQr("SSID:XTUCam_abc,PASSWORD:12345678")
        assertEquals("XTUCam_abc", c?.ssid)
        assertEquals("12345678", c?.password)
    }

    @Test
    fun bareSsidAndKey() {
        val c = parseWifiQr("XTUCam_f9e5e2 12345678")
        assertEquals("XTUCam_f9e5e2", c?.ssid)
        assertEquals("12345678", c?.password)
    }

    @Test
    fun ssidContainingColonSurvives() {
        val c = parseWifiQr("SSID:XTU:Cam_01,PASSWORD:12345678")
        assertEquals("XTU:Cam_01", c?.ssid)
    }

    @Test
    fun unrelatedTextIsRejected() {
        assertNull(parseWifiQr("https://example.com/some/long/path/here"))
        assertNull(parseWifiQr("one two three four"))
        assertNull(parseWifiQr("   "))
    }

    @Test
    fun malformedJsonIsRejected() {
        assertNull(parseWifiQr("{not json at all"))
    }
}
