package com.rovecamlink.app.core.ble

import kotlin.test.Test
import kotlin.test.assertEquals

/** The wire format these firmwares use is not JSON and not `key:value`; pin it. */
class BleReplyTest {

    @Test
    fun parsesTheEqualsSeparatedReply() {
        val reply = parseBleReply("SSID=XTU_S7Pro_f9e5e2,PWD=abcdefgh,WiFi_Status=1")
        assertEquals("XTU_S7Pro_f9e5e2", reply["SSID"])
        assertEquals("abcdefgh", reply["PWD"])
        assertEquals("1", reply["WiFi_Status"])
    }

    @Test
    fun stripsThePaddingSomeFirmwaresPutAroundEveryField() {
        assertEquals(mapOf("Status" to "1", "Pin" to "0042"), parseBleReply(" Status = 1 , Pin = 0042 "))
    }

    @Test
    fun keepsGoingPastAMalformedPairInsteadOfLosingTheRest() {
        val reply = parseBleReply("Status=1,garbage,SSID=XTU_X,PWD=secret")
        assertEquals("1", reply["Status"])
        assertEquals("XTU_X", reply["SSID"])
        assertEquals("secret", reply["PWD"])
    }

    @Test
    fun splitsOnlyOnTheFirstEqualsSoAValueMayContainOne() {
        assertEquals("a=b", parseBleReply("PWD=a=b")["PWD"])
    }

    @Test
    fun ignoresNoiseThatIsNotAReplyAtAll() {
        assertEquals(emptyMap(), parseBleReply(""))
        assertEquals(emptyMap(), parseBleReply("R009_cap:0x02;"))
    }
}
