package com.rovecamlink.app.brand.sjcam

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

/**
 * Guard for the Ambarella channel's JSON envelope and its media-path translation.
 *
 * The envelope facts come from `docs/evidence/sjcam` §4.3: single values ride in `param`
 * (`AmbaCamera.java:164,364`), and the session id is read from `param` by the vendor client
 * (`AmbProtocol.java:524`) while the same protocol under XTU's app uses `token` — the reason
 * [SjcamAmbaChannel.tokenOf] accepts both. The `/tmp/SD0` → `/SD` mapping is the difference
 * between a download URL that works and one that 404s (`AmbaCamera.java:42,62`).
 */
class SjcamAmbaJsonTest {

    private fun obj(text: String) = Json.parseToJsonElement(text).jsonObject

    @Test
    fun `the session token is read from token or from param`() {
        assertEquals(123, SjcamAmbaChannel.tokenOf(obj("""{"msg_id":257,"rval":0,"token":123}""")))
        // The vendor client's own field (AmbProtocol.java:524).
        assertEquals(7, SjcamAmbaChannel.tokenOf(obj("""{"msg_id":257,"rval":0,"param":7}""")))
        assertNull(SjcamAmbaChannel.tokenOf(obj("""{"msg_id":257,"rval":-5}""")))
    }

    @Test
    fun `single values come from param`() {
        assertEquals(87, SjcamAmbaChannel.intParam(obj("""{"msg_id":13,"rval":0,"param":87}""")))
        assertEquals(0, SjcamAmbaChannel.intParam(obj("""{"msg_id":515,"rval":0,"param":0}""")))
        assertNull(SjcamAmbaChannel.intParam(obj("""{"msg_id":13,"rval":-1}""")))
        assertNull(SjcamAmbaChannel.intParam(null))
    }

    @Test
    fun `the device model is read out of param`() {
        val reply = obj("""{"msg_id":11,"rval":0,"param":{"model":"SJCAMSJ8PRO","sw_version":"1.2.9"}}""")
        assertEquals("SJCAMSJ8PRO", SjcamAmbaChannel.modelOf(reply))
        // A device-info reply without the key claims nothing.
        assertNull(SjcamAmbaChannel.modelOf(obj("""{"msg_id":11,"rval":0,"param":{"foo":1}}""")))
    }

    @Test
    fun `rval says whether the camera accepted a command`() {
        assertEquals(0, SjcamAmbaChannel.rval(obj("""{"msg_id":513,"rval":0}""")))
        assertEquals(-4, SjcamAmbaChannel.rval(obj("""{"msg_id":513,"rval":-4}""")))
    }

    @Test
    fun `media paths are translated to the camera's HTTP mirror`() {
        assertEquals(
            "http://192.168.42.1/SD/DCIM/100MEDIA/20260101120000.MP4",
            SjcamAmbaChannel.httpUrl("192.168.42.1", "/tmp/SD0/DCIM/100MEDIA/20260101120000.MP4"),
        )
        // A path that is already in mirror form must not be mangled.
        assertEquals(
            "http://192.168.42.1/SD/DCIM/100MEDIA/A.JPG",
            SjcamAmbaChannel.httpUrl("192.168.42.1", "SD/DCIM/100MEDIA/A.JPG"),
        )
    }
}
