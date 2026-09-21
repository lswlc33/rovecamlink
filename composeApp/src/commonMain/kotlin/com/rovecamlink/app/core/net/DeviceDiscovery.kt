package com.rovecamlink.app.core.net

import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.model.DevicePlatform
import com.rovecamlink.app.core.protocol.CameraProtocolRegistry
import com.rovecamlink.app.core.transport.CameraHttp
import kotlinx.coroutines.withTimeoutOrNull

/**
 * Runtime device identification. Because the X7 Pro and other cams are not all
 * listed by model string in firmware, we do not hardcode a model table — we
 * probe the live device with each registered protocol and pick the first that
 * answers. This is what makes new cameras "just work" once a protocol plugin is
 * registered.
 *
 * Every candidate host and every probe verdict is logged: "which IP answered and
 * which plugin claimed it" is the first question a connection report has to
 * answer, and it is unanswerable from the HTTP lines alone.
 */
class DeviceDiscovery(
    private val registry: CameraProtocolRegistry,
    private val http: CameraHttp,
) {
    /** Common gateway IPs used by action-camera hotspots, tried in order. */
    val candidateHosts: List<String> = listOf(
        "192.168.0.1",
        "192.168.1.1",
        "192.168.42.1",
        "192.168.16.1",
        "192.168.169.1", // TUWIN M3 + idGoLive Qz
        "192.168.1.254", // idGoLive Ly/Yz
        "192.168.25.1",
        "10.0.0.1",
    )

    suspend fun identify(host: String, port: Int = 80): DevicePlatform? =
        Diag.inOp("identify", "target=$host:$port plugins=${registry.platforms().joinToString(",")}") {
            for (protocol in registry.all()) {
                val t0 = Diag.uptimeMillis()
                val verdict = runCatching { protocol.probe(host, port) }
                val ms = Diag.uptimeMillis() - t0
                Diag.d(LogTag.NET) {
                    "probe ${protocol.platform.displayName} $host:$port -> " +
                        verdict.fold(
                            { if (it) "MATCH" else "no" },
                            { "ERROR ${Diag.causeChain(it)}" },
                        ) + " ${ms}ms"
                }
                if (verdict.getOrDefault(false)) {
                    Diag.i(LogTag.NET) { "identified $host:$port as ${protocol.platform.displayName}" }
                    return@inOp protocol.platform
                }
            }
            Diag.w(LogTag.NET) { "no plugin claimed $host:$port after ${registry.all().size} probes" }
            null
        }

    /**
     * Find the camera, cheapest clue first: the address the hotspot's brand always
     * uses, then the gateway the platform reported, then the well-known list.
     *
     * The order is load-bearing. In the 2026-09-21 S7PRO session the platform
     * gateway resolved to `0.0.0.0` and then to a VPN address, so discovery walked
     * nine hosts at two 8-second connect timeouts each — 15 `ConnectTimeoutException`s
     * fired while the live view was trying to deliver frames, and the walk outlived
     * the camera it was looking for. A brand that fixes its AP address now gets there
     * in one probe, and everything after that first guess runs on a short budget.
     */
    suspend fun discover(gatewayHint: String?, preferredHost: String? = null): Pair<String, DevicePlatform>? {
        val hosts = buildList {
            preferredHost?.takeIf { isRoutableIpv4(it) }?.let { add(it) }
            gatewayHint?.takeIf { isRoutableIpv4(it) }?.let { add(it) }
            addAll(candidateHosts)
        }.distinct()
        Diag.i(LogTag.NET) {
            "discover preferred=${preferredHost ?: "-"} gateway_hint=${gatewayHint ?: "-"} " +
                "candidates=${hosts.joinToString(",")}"
        }
        for (index in hosts.indices) {
            val host = hosts[index]
            // Only the first guess is worth a full 8-second connect timeout; after
            // that a host either answers quickly or is not the camera.
            val budget = if (index == 0) FIRST_HOST_BUDGET_MS else LATER_HOST_BUDGET_MS
            val platform = withTimeoutOrNull(budget) { identify(host) } ?: continue
            Diag.i(LogTag.NET) { "camera found at $host as ${platform.displayName}" }
            return host to platform
        }
        Diag.w(LogTag.NET) { "discover failed: no camera answered on ${hosts.size} candidate hosts" }
        return null
    }

    companion object {
        /** A usable dotted-quad, not the `0.0.0.0` / `fe80::…` the platform hands back. */
        fun isRoutableIpv4(host: String): Boolean {
            val parts = host.split('.')
            if (parts.size != 4) return false
            val octets = parts.map { it.toIntOrNull() ?: return false }
            if (octets.any { it !in 0..255 }) return false
            // 0.0.0.0 is what ConnectivityManager reports when it has no route;
            // 169.254.x is link-local, which no camera CGI answers on.
            return octets[0] != 0 && !(octets[0] == 169 && octets[1] == 254)
        }

        private const val FIRST_HOST_BUDGET_MS = 12_000L
        private const val LATER_HOST_BUDGET_MS = 2_500L
    }
}
