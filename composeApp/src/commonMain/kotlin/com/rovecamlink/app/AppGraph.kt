package com.rovecamlink.app

import com.rovecamlink.app.brand.tuwin.TuwinRestProtocol
import com.rovecamlink.app.brand.xtu.HisiliconProtocol
import com.rovecamlink.app.core.net.DeviceDiscovery
import com.rovecamlink.app.core.protocol.CameraProtocolRegistry
import com.rovecamlink.app.core.storage.createFileSaver
import com.rovecamlink.app.core.storage.createPermissionController
import com.rovecamlink.app.core.transport.CameraHttp
import com.rovecamlink.app.core.wifi.createWifiController
import com.rovecamlink.app.core.wifi.createWifiScanner

/**
 * Hand-rolled composition root (no DI framework — keeps the dependency graph
 * tiny and the build robust). To support a new camera family, add its protocol
 * plugin to [protocolList] and nothing else changes.
 */
class AppGraph {
    val http: CameraHttp = CameraHttp()

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
}
