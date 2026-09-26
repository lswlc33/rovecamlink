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

    /**
     * The BSSID — the access point's own MAC — of the network the phone is joined to, or
     * null when it cannot be read (not on Wi-Fi, no permission, or a platform that has no
     * such concept).
     *
     * Its one consumer is Wake-on-LAN (B10): a sleeping camera has no address to be asked
     * for a MAC, so the magic packet has to be addressed from the phone's side of the link.
     * The official client takes exactly this value for the same purpose
     * (`TelevisionActivity.java:170` hands `connectionInfo.getBSSID()` to `DV.setMacAddress`).
     */
    fun currentCameraBssid(): String? = null

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
     *
     * [prefixes] is what "looks like a camera network" means to the caller, so the
     * brand vocabulary stays where the plugins are: pass
     * [com.rovecamlink.app.AppGraph.cameraSsidPrefixes]. The default is the generic
     * hint list, which is what an unscoped call (a platform's own retry) should use.
     */
    suspend fun adoptCurrentNetwork(
        force: Boolean = false,
        prefixes: List<String> = DEFAULT_PREFIXES,
    ): WifiResult

    /**
     * True when the phone's default network is a VPN tunnel. Camera traffic then
     * depends on [adoptCurrentNetwork] having worked, so the connect flow asks the
     * user what to do about it before spending a minute on a doomed join.
     */
    fun isVpnActive(): Boolean

    /**
     * Run [block] with this process's sockets on the internet instead of on the
     * camera's hotspot, then put them back.
     *
     * This exists because reaching a camera and reaching the internet are mutually
     * exclusive here on purpose: [connect] and [adoptCurrentNetwork] call
     * `bindProcessToNetwork` so the camera's isolated, internet-less hotspot cannot
     * be shadowed by a VPN (`docs/analysis/ble-and-vpn` P0), and that same binding sends every other
     * socket into a network with no route off it. A vendor firmware index is
     * therefore unreachable while a camera is connected unless somebody steps aside.
     *
     * Callers must treat this as an **exclusive** window: nothing else may talk to
     * the camera while it is open, because its traffic would silently go to the wrong
     * network and fail. That is why the OTA flow takes the route once for the whole
     * check-and-download and pauses camera polling around it, rather than per request.
     *
     * The default implementation just runs [block] — desktop and iOS have no process
     * binding to lift. [label] is for the log line only.
     */
    suspend fun <T> withInternetRoute(label: String, block: suspend () -> T): T = block()

    /**
     * Hand the user to the system screen where the running VPN can be switched off.
     *
     * Only ever called from the one button in the connect-time VPN dialog, so a
     * platform with no such screen says so with `false` instead of inventing a
     * gesture the user would have to complete by memory.
     */
    fun openVpnSettings(): Boolean
    fun openWifiSettings(): Boolean
}

/**
 * Scans for nearby camera hotspots, matching whatever prefixes the caller passes —
 * the merged camera-like list, in practice
 * ([com.rovecamlink.app.AppGraph.cameraSsidPrefixes]).
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

/**
 * Hotspot prefixes that mean "camera-like" but that **no plugin claims**.
 *
 * Two different questions live here, and conflating them is how a new brand breaks an
 * old one:
 *
 *  - *Which plugin drives this hotspot* — [CameraProtocol.wifiSsidPrefixes], owned by
 *    the plugin, answering with a fixed host and a factory passphrase.
 *  - *Is this SSID worth showing and auto-connecting* — this list, which is deliberately
 *    wider. XTU is the case that proves they differ: the camera family's own hotspots
 *    begin `XTU…`, while the Hisilicon plugin claims only `XTUCam_` because XTU's
 *    Ambarella models share the naming and do not answer CGI on port 80.
 *
 * These entries predate the plugin registry and none of them is a documented hotspot
 * prefix — `X7`, `RIDE`, `M3`, `R3`, `R6` are *model* names, and `GO` is the official
 * XTU app's name (`docs/analysis/protocol-matrix §1.1`, `§2.1`). They are kept verbatim because removing a
 * matcher can only lose cameras, and they cost one `startsWith` each.
 *
 * **A new brand must not add anything here.** Declare `wifiSsidPrefixes` on its plugin;
 * [cameraLikePrefixes] merges that in automatically.
 */
val DEFAULT_PREFIXES = listOf("XTU", "X7", "X5", "GO", "RIDE", "R3", "R6", "R5", "M3", "SJ", "AKASO")

/**
 * What the Wi-Fi layer treats as a camera hotspot: the prefixes the registered plugins
 * claim, plus the generic hints above.
 *
 * A union, so this is purely additive — a new plugin can only make more SSIDs match, and
 * can never take a match away from a camera that already worked. That property is the
 * point: it is what lets a brand be added by registering a plugin instead of editing a
 * name list every other brand shares.
 *
 * Order is irrelevant to matching (the caller tests every prefix), but claimed prefixes
 * come first so a log line reads brand-first.
 */
fun cameraLikePrefixes(claimed: List<String>): List<String> =
    (claimed + DEFAULT_PREFIXES).distinct()

/**
 * True when [ssid] is one of [prefixes] — the single matching rule behind "this hotspot
 * looks like a camera".
 *
 * One function rather than the same `startsWith(…, ignoreCase = true)` spelled out at
 * each site (the scan filter, the auto-connect trigger, the adopt gate), because the
 * answer to "is this our kind of network" has to agree everywhere: a hotspot the scan
 * lists but the adopt gate refuses leaves the phone talking to the camera over the
 * default route, which is the VPN failure this whole path exists to avoid.
 *
 * Null and blank are never a camera — there are no empty prefixes to match against.
 */
fun anyPrefixMatches(prefixes: List<String>, ssid: String?): Boolean =
    !ssid.isNullOrBlank() && prefixes.any { ssid.startsWith(it, ignoreCase = true) }

/** expect factory; each platform supplies its own implementation. */
expect fun createWifiController(): WifiController
expect fun createWifiScanner(): WifiScanner
