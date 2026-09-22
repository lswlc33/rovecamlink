package com.rovecamlink.app.core.wifi

import com.rovecamlink.app.core.wifi.WifiResult

/**
 * iOS WiFi-direct scaffold. Apple does not expose a public API to join an
 * arbitrary hotspot programmatically without the NEHotspotConfiguration +
 * Access WiFi entitlement, so this is a placeholder that keeps the shared code
 * compiling. Real iOS support requires the "Access WiFi Information" capability
 * and NEHotspotConfigurationManager.
 */
private class IosWifiController : WifiController {
    override val isConnectedToCamera: Boolean get() = false
    override fun currentCameraSsid(): String? = null
    override fun gateway(): String? = null
    override suspend fun connect(ssid: String, password: String?): WifiResult =
        WifiResult.Failed("iOS WiFi-direct not implemented (needs NEHotspotConfiguration entitlement). Join the camera network in Settings, then use Manual connect.")
    override suspend fun disconnect() {}
    override fun watchWifiChanges(listener: ((ssid: String?) -> Unit)?) {}
    override suspend fun adoptCurrentNetwork(force: Boolean): WifiResult =
        WifiResult.Failed("iOS cannot rebind sockets to an already-joined network yet (needs NEHotspotConfiguration + per-flow routing).")
    override fun isVpnActive(): Boolean = false
    override fun openVpnSettings(): Boolean = false
}

private class IosWifiScanner : WifiScanner {
    override suspend fun scan(prefixes: List<String>, force: Boolean): List<CameraNetwork> = emptyList()
}

actual fun createWifiController(): WifiController = IosWifiController()
actual fun createWifiScanner(): WifiScanner = IosWifiScanner()
