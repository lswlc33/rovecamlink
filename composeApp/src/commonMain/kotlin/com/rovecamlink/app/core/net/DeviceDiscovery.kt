package com.rovecamlink.app.core.net

import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.model.DevicePlatform
import com.rovecamlink.app.core.protocol.CameraProtocolRegistry
import com.rovecamlink.app.core.transport.CameraHttp

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

    /** Try the gateway hint first, then well-known camera IPs. */
    suspend fun discover(gatewayHint: String?): Pair<String, DevicePlatform>? {
        val hosts = (listOfNotNull(gatewayHint) + candidateHosts).distinct()
        Diag.i(LogTag.NET) { "discover gateway_hint=${gatewayHint ?: "none"} candidates=${hosts.joinToString(",")}" }
        for (host in hosts) {
            val platform = identify(host) ?: continue
            Diag.i(LogTag.NET) { "camera found at $host as ${platform.displayName}" }
            return host to platform
        }
        Diag.w(LogTag.NET) { "discover failed: no camera answered on ${hosts.size} candidate hosts" }
        return null
    }
}
