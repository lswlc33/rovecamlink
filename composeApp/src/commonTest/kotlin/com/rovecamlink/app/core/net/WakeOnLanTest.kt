package com.rovecamlink.app.core.net

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

/**
 * The Wake-on-LAN packet, pinned to the official client's own construction
 * (`Setting.wakeupDevice`, `Setting.java:483-511`): 102 bytes, six `0xFF` then the MAC
 * sixteen times, aimed at `<first three octets>.255:9`, sent five times.
 *
 * Worth pinning because every one of those numbers is invisible when it is wrong — the
 * camera simply does not wake, and there is nothing on the wire to read back.
 */
class WakeOnLanTest {

    private val mac = "aa:bb:cc:dd:ee:ff"

    @Test
    fun `packet is six ff bytes followed by the mac sixteen times`() {
        val packet = WakeOnLan.magicPacket(mac)!!
        assertEquals(102, packet.size, "the official packet is 102 bytes, not the 6+6*16 minimum")
        assertEquals(List(6) { 0xFF.toByte() }, packet.take(6).toList())
        (0 until 16).forEach { repeat ->
            assertEquals(
                listOf(0xAA, 0xBB, 0xCC, 0xDD, 0xEE, 0xFF).map { it.toByte() },
                packet.toList().subList(6 + repeat * 6, 6 + repeat * 6 + 6),
                "mac copy #$repeat",
            )
        }
    }

    @Test
    fun `case and surrounding space do not change the packet`() {
        assertEquals(WakeOnLan.magicPacket(mac)!!.toList(), WakeOnLan.magicPacket("AA:BB:CC:DD:EE:FF")!!.toList())
        assertEquals(WakeOnLan.magicPacket(mac)!!.toList(), WakeOnLan.magicPacket("  $mac  ")!!.toList())
    }

    @Test
    fun `a mac that is not six hex octets produces no packet at all`() {
        // The official client aborts on exactly the same shape check rather than sending
        // a packet built from a malformed address: an unusable packet looks identical to
        // a camera that ignored a good one.
        assertNull(WakeOnLan.magicPacket(null))
        assertNull(WakeOnLan.magicPacket(""))
        assertNull(WakeOnLan.magicPacket("aa:bb:cc:dd:ee"))
        assertNull(WakeOnLan.magicPacket("aabbccddeeff"))
        assertNull(WakeOnLan.magicPacket("aa:bb:cc:dd:ee:gg"))
        assertNull(WakeOnLan.magicPacket("aa:bb:cc:dd:ee:100"))
    }

    @Test
    fun `the target is the camera's own subnet broadcast`() {
        assertEquals("192.168.0.255", WakeOnLan.broadcastAddress("192.168.0.1"))
        assertEquals("10.0.0.255", WakeOnLan.broadcastAddress("10.0.0.7"))
        assertNull(WakeOnLan.broadcastAddress("localhost"))
        assertNull(WakeOnLan.broadcastAddress(""))
    }
}