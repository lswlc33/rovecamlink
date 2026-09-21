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

    /**
     * Take over the Wi-Fi network the phone is **already** on, without asking the
     * system for a new connection.
     *
     * This exists because a hotspot the user joined from Settings never passes
     * through [connect], so nothing ever pinned our sockets to it — and a running
     * VPN owns the default route with `0.0.0.0/0`, which then swallows every
     * request to the camera. Adopting binds the process to the real Wi-Fi network
     * (the tunnel is a different network, so it stops intercepting) and gives us
     * the link properties needed for [gateway].
     *
     * Best-effort: a failure here must not abort a connection attempt, because on
     * many devices the default network already *is* the camera's Wi-Fi.
     *
     * [force] adopts even when the SSID does not look like a camera network and
     * the network claims internet — used by the manual-IP flow, where the user
     * told us the host so we do not need the hotspot to identify itself.
     */
    suspend fun adoptCurrentNetwork(force: Boolean = false): WifiResult

    /**
     * True when the phone's default network is a VPN tunnel. Camera traffic then
     * depends on [adoptCurrentNetwork] having worked, so the UI can warn the user
     * instead of reporting a mysterious "no camera found".
     */
    fun isVpnActive(): Boolean
}

/**
 * Scans for nearby camera hotspots. XTU/TUWIN cameras broadcast SSIDs that
 * usually start with a brand prefix (e.g. "XTU", "X7", "RIDE", "M3").
 */
interface WifiScanner {
    /**
     * Camera-like networks in range, strongest signal first.
     *
     * [force] asks the operating system for a genuinely fresh scan. Android
     * rate-limits `WifiManager.startScan()` — the 2026-09-21 field log has two
     * calls three seconds apart both answered `false` — so a 2-second UI refresh
     * cycle reads the cached results and lets the platform throttle decide when a
     * real scan is worth requesting. Without that split the list looks frozen and
     * every manual tap on 刷新 is a no-op.
     */
    suspend fun scan(
        prefixes: List<String> = DEFAULT_PREFIXES,
        force: Boolean = false,
    ): List<CameraNetwork>
}

data class CameraNetwork(val ssid: String, val secured: Boolean, val rssi: Int)

val DEFAULT_PREFIXES = listOf("XTU", "X7", "X5", "GO", "RIDE", "R3", "R6", "R5", "M3", "SJ", "AKASO")

/** expect factory; each platform supplies its own implementation. */
expect fun createWifiController(): WifiController
expect fun createWifiScanner(): WifiScanner
