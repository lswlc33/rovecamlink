package com.rovecamlink.app.core.net

import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.model.DevicePlatform
import com.rovecamlink.app.core.protocol.CameraProtocolRegistry
import com.rovecamlink.app.core.transport.CameraHttp
import kotlinx.coroutines.CancellationException
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
                // Each probe gets a budget of its own. Without one, a single slow endpoint
                // eats the host's whole slice — 12s for the first candidate — and the plugin
                // that would have answered never runs at all, so a camera that is right there
                // is reported absent.
                //
                // A probe that runs out means "not this family", not "this host is gone": the
                // caller's budget in [discover] still owns that verdict, and because
                // `withTimeoutOrNull` only swallows its own timeout, an outer cancellation
                // passes straight through here.
                val outcome: Result<Boolean?> = runCatching {
                    withTimeoutOrNull(PROBE_TIMEOUT_MS) { protocol.probe(host, port) }
                }.onFailure { if (it is CancellationException) throw it }
                val ms = Diag.uptimeMillis() - t0
                Diag.d(LogTag.NET) {
                    "probe ${protocol.platform.displayName} $host:$port -> " +
                        outcome.fold(
                            { verdict ->
                                when (verdict) {
                                    true -> "MATCH"
                                    false -> "no"
                                    null -> "TIMEOUT (over ${PROBE_TIMEOUT_MS}ms)"
                                }
                            },
                            { "ERROR ${Diag.causeChain(it)}" },
                        ) + " ${ms}ms"
                }
                if (outcome.getOrNull() == true) {
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
    suspend fun discover(
        gatewayHint: String?,
        preferredHost: String? = null,
        alreadyTried: List<String> = emptyList(),
    ): Pair<String, DevicePlatform>? {
        val hosts = buildList {
            preferredHost?.takeIf { isRoutableIpv4(it) }?.let { add(it) }
            gatewayHint?.takeIf { isRoutableIpv4(it) }?.let { add(it) }
            addAll(candidateHosts)
        }
            .distinct()
            // A host the caller already probed must not be probed again: the XTU fixed
            // address is also `candidateHosts[0]`, so a failed first guess would
            // otherwise spend its timeout budget twice before the walk even started.
            .filterNot { alreadyTried.contains(it) }
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
            // 169.254.x is link-local, which no camera CGI answers on. Loopback and the
            // all-ones broadcast address are never a camera either.
            if (octets[0] == 0) return false
            if (octets[0] == 127) return false
            if (octets[0] == 169 && octets[1] == 254) return false
            return !octets.all { it == 255 }
        }

        private const val FIRST_HOST_BUDGET_MS = 12_000L
        private const val LATER_HOST_BUDGET_MS = 2_500L

        /**
         * How long one plugin's `probe` may take before it is called "not this family".
         *
         * Sized against [FIRST_HOST_BUDGET_MS] and the plugin count, not against a camera:
         * the point is that three plugins each get a fair share of the first, generous slice
         * instead of the first one consuming it. A CGI answer takes ~200ms (2026-09-22 field
         * log), an unanswered connect costs the HTTP client's 8s — so 4s separates "slow but
         * real" from "this host is not that family" with room to spare.
         *
         * Hosts after the first run on [LATER_HOST_BUDGET_MS], which is shorter than this, so
         * there the caller's budget remains the effective limit — which is the intent: only
         * the first guess is worth waiting on.
         */
        private const val PROBE_TIMEOUT_MS = 4_000L
    }
}
