package com.rovecamlink.app.core.wifi

import com.rovecamlink.app.core.wifi.WifiResult

/** Desktop has no WiFi-direct API; connect manually by IP (e.g. the simulator on 127.0.0.1). */
private class DesktopWifiController : WifiController {
    override val isConnectedToCamera: Boolean get() = false
    override fun currentCameraSsid(): String? = null
    override fun gateway(): String? = null
    override suspend fun connect(ssid: String, password: String?): WifiResult =
        WifiResult.Failed("WiFi-direct is not available on desktop. Use Manual connect (e.g. 127.0.0.1).")
    override suspend fun disconnect() {}
    override fun watchWifiChanges(listener: ((ssid: String?) -> Unit)?) {}
    override suspend fun adoptCurrentNetwork(force: Boolean): WifiResult =
        WifiResult.Failed("Desktop has no per-network socket binding; the OS routing table decides.")
    override fun isVpnActive(): Boolean = false
}

private class DesktopWifiScanner : WifiScanner {
    override suspend fun scan(prefixes: List<String>, force: Boolean): List<CameraNetwork> = emptyList()
}

actual fun createWifiController(): WifiController = DesktopWifiController()
actual fun createWifiScanner(): WifiScanner = DesktopWifiScanner()
