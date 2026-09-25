package com.rovecamlink.app

import com.rovecamlink.app.brand.icatch.IcatchHttpProtocol
import com.rovecamlink.app.brand.tuwin.TuwinRestProtocol
import com.rovecamlink.app.brand.xtu.HisiliconProtocol
import com.rovecamlink.app.core.ble.BleCameraProfile
import com.rovecamlink.app.core.ble.XtuBleProfile
import com.rovecamlink.app.core.ble.createBleCentral
import com.rovecamlink.app.core.ble.createPairingKeyStore
import com.rovecamlink.app.core.net.createWifiCredentialStore
import com.rovecamlink.app.core.net.DeviceDiscovery
import com.rovecamlink.app.core.prefs.createAppPrefs
import com.rovecamlink.app.core.protocol.CameraProtocolRegistry
import com.rovecamlink.app.core.storage.createFileSaver
import com.rovecamlink.app.core.storage.createPermissionController
import com.rovecamlink.app.core.transport.CameraHttp
import com.rovecamlink.app.core.transport.CameraTcp
import com.rovecamlink.app.core.transport.createCameraTcp
import com.rovecamlink.app.core.wifi.anyPrefixMatches
import com.rovecamlink.app.core.wifi.cameraLikePrefixes
import com.rovecamlink.app.core.wifi.createWifiController
import com.rovecamlink.app.core.wifi.createWifiScanner

/**
 * Hand-rolled composition root (no DI framework — keeps the dependency graph
 * tiny and the build robust).
 *
 * To support a new camera family: implement [com.rovecamlink.app.core.protocol.CameraProtocol]
 * in a `brand/<name>` package, add it to [protocolList], and give it a
 * [DevicePlatform] / [Brand] value. Nothing else changes — [cameraSsidPrefixes], the
 * capability gates, the OTA channel and the device-menu rendering all read from the
 * plugin, so none of them names a brand.
 */
class AppGraph {
    val http: CameraHttp = CameraHttp()

    /**
     * Raw TCP, for the camera endpoints that are not HTTP. Today that is exactly one:
     * port 8080 on the XTU hi3510 family, which takes the 72-byte `RECV_FILE` frame the
     * firmware update is pushed through. It lives here rather than inside the plugin so a
     * protocol stays constructible without reaching for a platform factory itself.
     */
    val tcp: CameraTcp = createCameraTcp()

    private val protocolList = listOf(
        HisiliconProtocol(http, tcp),  // XTU X7 Pro + most Hi35xx cams (primary target)
        TuwinRestProtocol(http),       // TUWIN Ride3Pro / Ride6
        IcatchHttpProtocol(http),      // idGoLive family: Novatek `.254` + Qz `.169.1` (dash cams)
    )

    val registry = CameraProtocolRegistry(protocolList)
    val discovery = DeviceDiscovery(registry, http)

    /**
     * What the Wi-Fi layer treats as a camera hotspot: every prefix the registered
     * plugins claim, plus the generic hints that predate the registry.
     *
     * Read by the scan filter, the auto-connect trigger and `adoptCurrentNetwork`, so a
     * brand reaches all three by declaring `wifiSsidPrefixes` on its plugin — no edit to
     * a list of names shared by every other brand. It is a union with [DEFAULT_PREFIXES],
     * so adding a plugin can only ever recognise *more* hotspots.
     */
    val cameraSsidPrefixes: List<String> = cameraLikePrefixes(registry.claimedSsidPrefixes)

    /** True when [ssid] looks like a camera hotspot — the predicate behind the above. */
    fun isCameraLikeSsid(ssid: String?): Boolean = anyPrefixMatches(cameraSsidPrefixes, ssid)

    val wifi = createWifiController()
    val scanner = createWifiScanner()
    val fileSaver = createFileSaver()
    val permissions = createPermissionController()

    /**
     * Passphrases that worked, per hotspot name. What Bluetooth reports and what the
     * user types once both land here, so a camera seen in the Wi-Fi list is a one-tap
     * connect instead of a memory test.
     */
    val wifiCredentials = createWifiCredentialStore()

    /**
     * Loose bookkeeping that outlives a launch — currently just the last SD format.
     * Separate from [wifiCredentials] because these are not secrets and clearing one must
     * never touch the other.
     */
    val prefs = createAppPrefs()

    /**
     * Bluetooth side of connecting: find the camera before any Wi-Fi exists, wake
     * its hotspot and get the credentials back. A brand joins by adding a
     * [BleCameraProfile] here — the UI and the connection flow do not change.
     */
    val pairingKeys = createPairingKeyStore()
    val ble = createBleCentral()
    val bleProfiles: List<BleCameraProfile> = listOf(XtuBleProfile(pairingKeys))

    fun bleProfileFor(profileId: String): BleCameraProfile? =
        bleProfiles.firstOrNull { it.id == profileId }
}
