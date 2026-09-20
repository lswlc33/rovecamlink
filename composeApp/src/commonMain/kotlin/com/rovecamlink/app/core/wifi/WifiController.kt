package com.rovecamlink.app.core.wifi

/** Result of an attempt to join a camera's WiFi network. */
sealed interface WifiResult {
    data class Connected(val ssid: String) : WifiResult
    data class Failed(val message: String) : WifiResult
    data object Cancelled : WifiResult
}

/**
 * Platform WiFi-direct controller. On Android (API 29+) this uses
 * WifiNetworkSpecifier + ConnectivityManager.requestNetwork and binds the
 * process to the camera network while removing NET_CAPABILITY_INTERNET so the
 * phone keeps its cellular data. Older devices fall back to WifiManager.
 */
interface WifiController {
    val isConnectedToCamera: Boolean
    fun currentCameraSsid(): String?
    /** Gateway IP of the connected camera network (usually the camera itself). */
    fun gateway(): String?
    suspend fun connect(ssid: String, password: String?): WifiResult
    suspend fun disconnect()

    /**
     * Observe WiFi networks the phone joins. Called with the SSID whenever the
     * active WiFi network changes (including networks the user joined manually
     * in system settings), so the app can auto-discover a camera on it.
     * Passing null unregisters the previous listener.
     */
    fun watchWifiChanges(listener: ((ssid: String?) -> Unit)?)
}

/**
 * Scans for nearby camera hotspots. XTU/TUWIN cameras broadcast SSIDs that
 * usually start with a brand prefix (e.g. "XTU", "X7", "RIDE", "M3").
 */
interface WifiScanner {
    suspend fun scan(prefixes: List<String> = DEFAULT_PREFIXES): List<CameraNetwork>
}

data class CameraNetwork(val ssid: String, val secured: Boolean, val rssi: Int)

val DEFAULT_PREFIXES = listOf("XTU", "X7", "X5", "GO", "RIDE", "R3", "R6", "R5", "M3", "SJ", "AKASO")

/** expect factory; each platform supplies its own implementation. */
expect fun createWifiController(): WifiController
expect fun createWifiScanner(): WifiScanner
