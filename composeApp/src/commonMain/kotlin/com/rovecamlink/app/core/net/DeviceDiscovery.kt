package com.rovecamlink.app.core.net

import com.rovecamlink.app.core.model.DevicePlatform
import com.rovecamlink.app.core.protocol.CameraProtocolRegistry
import com.rovecamlink.app.core.transport.CameraHttp

/**
 * Runtime device identification. Because the X7 Pro and other cams are not all
 * listed by model string in firmware, we do not hardcode a model table — we
 * probe the live device with each registered protocol and pick the first that
 * answers. This is what makes new cameras "just work" once a protocol plugin is
 * registered.
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

    suspend fun identify(host: String, port: Int = 80): DevicePlatform? {
        for (protocol in registry.all()) {
            if (protocol.probe(host, port)) return protocol.platform
        }
        return null
    }

    /** Try the gateway hint first, then well-known camera IPs. */
    suspend fun discover(gatewayHint: String?): Pair<String, DevicePlatform>? {
        val hosts = (listOfNotNull(gatewayHint) + candidateHosts).distinct()
        for (host in hosts) {
            val platform = identify(host) ?: continue
            return host to platform
        }
        return null
    }
}
