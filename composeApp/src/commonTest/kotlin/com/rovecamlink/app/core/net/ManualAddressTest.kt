package com.rovecamlink.app.core.net

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

/**
 * Guard for what a typed camera address means.
 *
 * The manual-connect page and `AppState.connectBlocking` both call this, and the shape it
 * has to get right is `host:port` — the desktop simulator's `127.0.0.1:8080`, an emulator's
 * view of its host `10.0.2.2:8080`, an SSH forward's `localhost:9000`. A camera's own AP
 * address (`192.168.1.254`) carries no port and must keep working, because that is what the
 * brand sections tell a user to type.
 */
class ManualAddressTest {

    @Test
    fun `a bare host defaults to port 80`() {
        assertEquals("192.168.1.254" to 80, parseManualAddress("192.168.1.254"))
        assertEquals("cam.local" to 80, parseManualAddress("  cam.local  "))
    }

    @Test
    fun `an explicit port is honoured`() {
        assertEquals("127.0.0.1" to 8080, parseManualAddress("127.0.0.1:8080"))
        assertEquals("10.0.2.2" to 8080, parseManualAddress("10.0.2.2:8080"))
        assertEquals("host" to 1, parseManualAddress("host:1"))
        assertEquals("host" to 65535, parseManualAddress("host:65535"))
    }

    @Test
    fun `nothing typed or a broken port is not an address`() {
        assertNull(parseManualAddress(null))
        assertNull(parseManualAddress(""))
        assertNull(parseManualAddress("   "))
        assertNull(parseManualAddress(":8080"))
        assertNull(parseManualAddress("host:0"))
        assertNull(parseManualAddress("host:70000"))
    }

    @Test
    fun `a non-numeric tail is part of the host rather than a port`() {
        // `host:abc` is not a port; the connection layer will fail to resolve it, which is
        // the honest outcome — dropping the tail silently would dial the wrong machine.
        assertEquals("host:abc" to 80, parseManualAddress("host:abc"))
    }
}
