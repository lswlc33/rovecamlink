package com.rovecamlink.app

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
import com.rovecamlink.app.core.wifi.createWifiController
import com.rovecamlink.app.core.wifi.createWifiScanner

/**
 * Hand-rolled composition root (no DI framework — keeps the dependency graph
 * tiny and the build robust). To support a new camera family, add its protocol
 * plugin to [protocolList] and nothing else changes.
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
        HisiliconProtocol(http),   // XTU X7 Pro + most Hi35xx cams (primary target)
        TuwinRestProtocol(http),   // TUWIN Ride3Pro / Ride6
    )

    val registry = CameraProtocolRegistry(protocolList)
    val discovery = DeviceDiscovery(registry, http)

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
     * Loose bookkeeping that outlives a launch — the last SD format, the starred clips.
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
