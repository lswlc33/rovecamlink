package com.rovecamlink.app.core.net

import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogFormat
import com.rovecamlink.app.core.log.LogTag
import io.ktor.network.selector.SelectorManager
import io.ktor.network.sockets.Datagram
import io.ktor.network.sockets.InetSocketAddress
import io.ktor.network.sockets.aSocket
import io.ktor.utils.io.core.ByteReadPacket
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Wake-on-LAN, the only way to bring a sleeping hi3510 camera back.
 *
 * There is no wake CGI in that firmware family — the official client builds a magic
 * packet by hand instead (`Setting.wakeupDevice`, `Setting.java:483-511`): 102 bytes of
 * `0xFF` six times followed by the MAC sixteen times, sent over UDP to port 9 at the
 * subnet broadcast address derived from the camera's IP (`<first three octets>.255`),
 * **five times in a row**, fire-and-forget.
 *
 * Two properties of the original are load-bearing and are kept verbatim:
 *  - the MAC must be exactly 17 characters and contain `:` (`macAddres2ByteArray`
 *    returns null otherwise and the official client aborts without sending anything);
 *  - nothing is read back. A camera whose Wi-Fi chip does not implement WoL receives
 *    this packet and ignores it, so a "sent" result means "sent", never "awake".
 *
 * The MAC is not queried from the camera: it is the **BSSID of the hotspot the phone is
 * joined to** (`TelevisionActivity.java:170` hands `connectionInfo.getBSSID()` to
 * `DV.setMacAddress`). The camera is asleep, so nothing on it can answer.
 */
internal object WakeOnLan {

    /** How many packets the official client sends back-to-back. */
    const val BURSTS = 5

    /** WoL's assigned port. */
    const val PORT = 9

    /**
     * The 102-byte magic packet for [mac], or null when [mac] is not a `:`-separated
     * 6-octet address — the same shape check the official client makes, and for the same
     * reason: a packet built from a malformed address cannot work, and sending one only
     * makes a failure harder to read.
     */
    fun magicPacket(mac: String?): ByteArray? {
        val text = mac?.trim().orEmpty()
        if (text.length != 17 || !text.contains(":")) return null
        val octets = text.split(":").map { it.toIntOrNull(16) ?: return null }
        if (octets.size != 6 || octets.any { it !in 0..0xFF }) return null
        val packet = ByteArray(6 + 6 * 16)
        for (i in 0 until 6) packet[i] = 0xFF.toByte()
        for (repeat in 0 until 16) {
            for (i in 0 until 6) packet[6 + repeat * 6 + i] = octets[i].toByte()
        }
        return packet
    }

    /**
     * The broadcast address the packet goes to: the camera's IP with its last octet
     * replaced by `255` (`Setting.java:498` — `ip.substring(0, ip.lastIndexOf(46)) + ".255"`).
     *
     * Deliberately the subnet broadcast and not a global one: a camera on an isolated
     * hotspot has no route to `255.255.255.255`, and a global broadcast from the phone
     * would also wake unrelated machines on a normal network.
     */
    fun broadcastAddress(host: String): String? {
        val cut = host.lastIndexOf('.')
        if (cut <= 0) return null
        return host.substring(0, cut) + ".255"
    }

    /**
     * Build and send the packet [BURSTS] times.
     *
     * Returns a failure with the reason when the MAC is malformed or the address cannot
     * be derived, and a failure carrying the socket error when the send itself throws —
     * a phone that is not on the camera's network in the first place is the common case,
     * and it must not look like a camera that ignored the wake.
     */
    suspend fun send(host: String, mac: String?): Result<Unit> {
        val packet = magicPacket(mac) ?: return Result.failure(
            IllegalArgumentException("no usable MAC for Wake-on-LAN (need a 17-character `aa:bb:cc:dd:ee:ff`; the camera's hotspot BSSID is not available)"),
        )
        val target = broadcastAddress(host) ?: return Result.failure(
            IllegalArgumentException("cannot derive a broadcast address from \"$host\""),
        )
        // `Dispatchers.Default`, not `IO`: this file is commonMain, and `Dispatchers.IO` is
        // internal in the common coroutines metadata — it only resolves in the android and
        // desktop source sets (which is why `CameraTcp` has an actual per platform). Five
        // 102-byte datagrams do not need an I/O-sized pool. Getting this wrong is not a
        // warning: the iOS target fails to compile (2026-09-24).
        return withContext(Dispatchers.Default) {
            runCatching {
                val selector = SelectorManager(Dispatchers.Default)
                try {
                    val socket = aSocket(selector).udp().bind()
                    try {
                        val address = InetSocketAddress(target, PORT)
                        repeat(BURSTS) { socket.send(Datagram(ByteReadPacket(packet), address)) }
                    } finally {
                        socket.close()
                    }
                } finally {
                    selector.close()
                }
                Diag.info(
                    LogTag.PROTO,
                    "wake-on-lan -> $target:$PORT ${BURSTS}x mac=${LogFormat.safe(mac)} bytes=${packet.size} (no answer is expected)",
                )
            }
        }
    }
}