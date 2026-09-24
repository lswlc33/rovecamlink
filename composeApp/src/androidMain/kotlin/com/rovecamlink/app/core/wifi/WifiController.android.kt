package com.rovecamlink.app.core.wifi

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.LinkProperties
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.net.wifi.ScanResult
import android.net.wifi.SupplicantState
import android.net.wifi.WifiConfiguration
import android.net.wifi.WifiManager
import android.provider.Settings
import android.net.wifi.WifiNetworkSpecifier
import android.os.Build
import android.os.SystemClock
import com.rovecamlink.app.androidContext
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogTag
import kotlinx.coroutines.delay
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.coroutines.resume

@Suppress("DEPRECATION", "MissingPermission")
private class AndroidWifiController : WifiController {

    private val cm by lazy { androidContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
    private val wm by lazy { androidContext.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager }

    @Volatile private var boundNetwork: Network? = null
    @Volatile private var linkProps: LinkProperties? = null
    @Volatile private var callback: ConnectivityManager.NetworkCallback? = null
    @Volatile private var legacyNetId: Int = -1

    /** Holds off a second [withInternetRoute] while one is already open. */
    private val internetRouteMutex = Mutex()

    /**
     * Whether we still have a live camera network to send sockets through.
     *
     * This validates rather than recalls. The second attempt of the 2026-09-22 field
     * test logged `CONNECT begin ... already_bound=true` after the hotspot had already
     * gone: a remembered `Network` handle says "we once bound", not "traffic still
     * reaches the camera", and acting on that skipped both the join and the adopt —
     * leaving every socket on the default network, which is exactly the failure the
     * adopt path exists to prevent. A stale handle is dropped by [clearStaleCameraBinding]
     * so the next caller takes the honest path; this getter itself only reports, so a
     * diagnostics read can never unbind the process out from under a caller.
     */
    override val isConnectedToCamera: Boolean
        get() {
            if (legacyNetId != -1) return true
            val n = boundNetwork ?: return false
            return isLiveWifiNetwork(n)
        }

    /**
     * Drops a [boundNetwork] handle that no longer points at a live Wi-Fi network.
     *
     * Split out of [isConnectedToCamera] on purpose: that is a property getter any
     * thread may read any number of times, and a getter must not have side effects. The
     * read never needed this mutation to answer honestly, so callers that are about to
     * (re)bind the route — [adoptCurrentNetwork] — ask for the cleanup explicitly.
     */
    private fun clearStaleCameraBinding() {
        if (legacyNetId != -1) return
        val n = boundNetwork ?: return
        if (isLiveWifiNetwork(n)) return
        Diag.warn(LogTag.WIFI, "bound network handle is stale (was adopted=${adoptedNetwork != null}) — clearing and reporting not connected")
        boundNetwork = null
        adoptedNetwork = null
        linkProps = null
        runCatching { cm.bindProcessToNetwork(null) }
    }

    private fun isLiveWifiNetwork(n: Network): Boolean = runCatching {
        val caps = cm.getNetworkCapabilities(n) ?: return@runCatching false
        caps.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) &&
            !caps.hasTransport(NetworkCapabilities.TRANSPORT_VPN) &&
            (cm.allNetworks?.contains(n) == true)
    }.getOrDefault(false)

    /**
     * The network we adopted (as opposed to one we requested via specifier). Kept
     * separate so [disconnect] only tears down the watch we registered, never a
     * request the modern join path owns.
     */
    @Volatile private var adoptedNetwork: Network? = null
    @Volatile private var adoptWatch: ConnectivityManager.NetworkCallback? = null

    override fun currentCameraSsid(): String? {
        return runCatching {
            val info = wm.connectionInfo ?: return null
            info.ssid?.trim('"')?.takeIf { it.isNotEmpty() && it != "<unknown ssid>" }
        }.getOrNull()
    }

    override fun gateway(): String? {
        val g = gatewayInternal()
        Diag.debug(LogTag.WIFI, "gateway() -> ${g ?: "(none)"} bound=${boundNetwork != null} linkProps=${linkProps?.summary()}")
        return g
    }

    /**
     * The hotspot's own MAC, used only as the Wake-on-LAN target (B10).
     *
     * `02:00:00:00:00:00` is what Android answers when the SSID/BSSID is not readable
     * (no location permission, or the system redacting it) — it is not a real address and
     * a magic packet aimed at it wakes nothing, so it is reported as "unavailable" rather
     * than passed on.
     */
    override fun currentCameraBssid(): String? {
        return runCatching {
            val info = wm.connectionInfo ?: return null
            val bssid = info.bssid?.takeIf { it.isNotEmpty() }
            Diag.debug(LogTag.WIFI, "bssid read ssid=${info.ssid} bssid=${bssid ?: "(none)"}")
            bssid?.takeIf { it != REDACTED_BSSID }
        }.getOrNull()
    }

    private fun gatewayInternal(): String? {
        // 1. Link properties captured when we joined the camera network ourselves.
        linkProps?.let { lp ->
            defaultGatewayOf(lp)?.let { return it }
            lp.linkAddresses?.firstOrNull()?.address?.hostAddress?.let { addr ->
                return addr.substringBeforeLast('.') + ".1"
            }
        }
        // 2. Fallback for manually-joined networks: read the active network's
        //    link properties directly (works without our own requestNetwork).
        val active = boundNetwork ?: cm.activeNetwork ?: return null
        return runCatching {
            cm.getLinkProperties(active)?.let { defaultGatewayOf(it) }
        }.getOrNull()
    }

    /**
     * The camera's address on [lp]: the IPv4 default-route gateway.
     *
     * The 2026-09-22 log shows why the family matters — that AP publishes three
     * default routes, `::`, `0.0.0.0` and `192.168.0.1`, and taking "the first one"
     * returned the IPv6 `::`. XTU survives that only because its plugin hard-codes
     * 192.168.0.1; a brand without a fixed host would fall through to the eight-address
     * probe walk and read as "camera not found".
     */
    private fun defaultGatewayOf(lp: LinkProperties): String? =
        lp.routes
            ?.mapNotNull { if (it.isDefaultRoute) it.gateway?.hostAddress else null }
            ?.firstOrNull { !it.contains(':') }
            ?: lp.routes?.firstOrNull { it.isDefaultRoute }?.gateway?.hostAddress

    override suspend fun connect(ssid: String, password: String?): WifiResult {
        Diag.info(LogTag.WIFI, "join request ssid=$ssid pass=${password?.length ?: 0}ch api=${Build.VERSION.SDK_INT} modern=${Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q}")
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            connectModern(ssid, password)
        } else {
            connectLegacy(ssid, password)
        }
    }

    private suspend fun connectModern(ssid: String, password: String?): WifiResult {
        val t0 = Diag.uptimeMillis()
        var attempt = 0
        var unavailable = false
        while (true) {
            attempt++
            val left = JOIN_BUDGET_MS - (Diag.uptimeMillis() - t0)
            if (left <= 0) break
            when (val join = requestJoin(ssid, password, t0, attempt, left)) {
                Join.Connected -> return WifiResult.Connected(ssid)
                is Join.Error -> return WifiResult.Failed(join.message)
                Join.Expired -> break
                Join.Unavailable -> {
                    unavailable = true
                    val remaining = JOIN_BUDGET_MS - (Diag.uptimeMillis() - t0)
                    if (attempt >= JOIN_MAX_ATTEMPTS || remaining < JOIN_MIN_RETRY_MS) break
                    // `onUnavailable` on a hotspot Bluetooth just woke is a *not yet*,
                    // not a never. The 2026-09-22 field log is explicit about the
                    // ordering: the camera offered `XTUCam_f9e5e2` at +51.9s, the
                    // phone's scan list still held 0 camera APs at +54s, the request
                    // came back UNAVAILABLE at +57.9s — and the same hotspot joined in
                    // 8.7s once it was actually broadcast. Nudge a fresh scan so the AP
                    // can surface, then re-request inside the same budget.
                    runCatching { wm.startScan() }
                    val visible = runCatching { wm.scanResults.orEmpty().count { it.SSID == ssid } }
                        .getOrDefault(-1)
                    Diag.warn(
                        LogTag.WIFI,
                        "join attempt $attempt for $ssid came back unavailable " +
                            "(scan sees $visible of that name, ${remaining}ms of budget left); " +
                            "retrying in ${JOIN_RETRY_DELAY_MS}ms",
                    )
                    delay(JOIN_RETRY_DELAY_MS)
                }
            }
        }
        val joined = currentCameraSsid()
        if (joined == ssid) {
            Diag.warn(LogTag.WIFI, "join budget ran out but the phone is on $joined — adopting instead of failing")
            // Drop the specifier request first: leaving it registered would let a
            // late system dialog bind sockets we are about to bind ourselves.
            runCatching { callback?.let { cm.unregisterNetworkCallback(it) } }
            callback = null
            return adoptCurrentNetwork(force = true)
        }
        val spent = Diag.uptimeMillis() - t0
        return if (unavailable) {
            // The OS said no, $JOIN_MAX_ATTEMPTS times: a password the camera will not
            // accept, or an access point that never actually started broadcasting.
            Diag.error(LogTag.WIFI, "join $ssid refused after $attempt attempt(s) in ${spent}ms (still on ${joined ?: "no Wi-Fi"})")
            disconnect()
            WifiResult.Failed("Camera network unavailable")
        } else {
            Diag.error(LogTag.WIFI, "join $ssid timed out after ${spent}ms (still on ${joined ?: "no Wi-Fi"})")
            disconnect()
            WifiResult.Failed("Timed out joining $ssid")
        }
    }

    /** What one specifier request amounts to: joined, refused, still waiting, or threw. */
    private sealed interface Join {
        object Connected : Join
        object Unavailable : Join
        object Expired : Join
        class Error(val message: String) : Join
    }

    /**
     * One `requestNetwork` round for [ssid], ending at the first of
     * onAvailable / onUnavailable / [budgetMs].
     *
     * [attempt] exists only in the log line: a join that needed three rounds has to be
     * readable as that from the exported TXT, because the alternative diagnosis —
     * wrong passphrase — looks identical in the frames alone.
     */
    @Suppress("DEPRECATION")
    private suspend fun requestJoin(
        ssid: String,
        password: String?,
        startedAt: Long,
        attempt: Int,
        budgetMs: Long,
    ): Join {
        val specBuilder = WifiNetworkSpecifier.Builder().setSsid(ssid)
        if (!password.isNullOrBlank()) specBuilder.setWpa2Passphrase(password)
        val request = NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .removeCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .setNetworkSpecifier(specBuilder.build())
            .build()

        val t0 = Diag.uptimeMillis()
        return withTimeoutOrNull(budgetMs) {
            suspendCancellableCoroutine { cont ->
                val cb = object : ConnectivityManager.NetworkCallback() {
                    override fun onAvailable(network: Network) {
                        boundNetwork = network
                        // Route ALL of this process's sockets (Ktor CIO + Media3) via the camera.
                        runCatching { cm.bindProcessToNetwork(network) }
                            .onFailure { Diag.error(LogTag.WIFI, "bindProcessToNetwork threw ${Diag.causeChain(it)}") }
                        Diag.info(LogTag.WIFI, "network AVAILABLE after ${Diag.uptimeMillis() - t0}ms, process bound=${boundNetwork != null}")
                        if (cont.isActive) cont.resume(Join.Connected)
                    }
                    override fun onLinkPropertiesChanged(network: Network, lp: LinkProperties) {
                        if (network == boundNetwork) {
                            linkProps = lp
                            Diag.debug(LogTag.WIFI, "link properties: ${lp.summary()}")
                        }
                    }
                    override fun onCapabilitiesChanged(network: Network, caps: NetworkCapabilities) {
                        val lp = cm.getLinkProperties(network)
                        if (lp != null) linkProps = lp
                    }
                    override fun onLost(network: Network) {
                        if (network == boundNetwork) {
                            Diag.warn(LogTag.WIFI, "network LOST after ${Diag.uptimeMillis() - t0}ms — unbinding process")
                            boundNetwork = null
                            linkProps = null
                            // Stop routing process sockets through the dead network, and
                            // unregister so the specifier request doesn't linger/reprompt.
                            runCatching { cm.bindProcessToNetwork(null) }
                            runCatching { cm.unregisterNetworkCallback(this) }
                        }
                    }
                    override fun onUnavailable() {
                        Diag.warn(LogTag.WIFI, "requestNetwork #$attempt reported UNAVAILABLE after ${Diag.uptimeMillis() - t0}ms (wrong password, the AP vanished, or the user dismissed the system prompt)")
                        runCatching { cm.unregisterNetworkCallback(this) }
                        if (cont.isActive) cont.resume(Join.Unavailable)
                    }
                    // There is deliberately no `onRejected` hook here: Android 16 (API 36)
                    // is where `NetworkCallback.onRejected()` exists — verified against
                    // android-35's `android.jar`, which has only onAvailable/onLost/
                    // onUnavailable/onCapabilities… — and this module compiles against 36
                    // would break CI's android job. A dismissed prompt therefore surfaces
                    // as the join budget expiring, which [JOIN_BUDGET_MS] + the adopt
                    // fallback below handle honestly.
                }
                callback?.let { runCatching { cm.unregisterNetworkCallback(it) } }
                callback = cb
                try {
                    Diag.debug(LogTag.WIFI, "requestNetwork #$attempt(TRANSPORT_WIFI, specifier for $ssid, no INTERNET capability)")
                    cm.requestNetwork(request, cb)
                } catch (t: Throwable) {
                    Diag.error(LogTag.WIFI, "requestNetwork threw ${Diag.causeChain(t)}")
                    if (cont.isActive) cont.resume(Join.Error(t.message ?: "requestNetwork failed"))
                }
                cont.invokeOnCancellation {
                    runCatching { cm.unregisterNetworkCallback(cb) }
                }
            }
        } ?: run {
            Diag.debug(LogTag.WIFI, "join attempt $attempt still pending at ${Diag.uptimeMillis() - startedAt}ms (budget spent)")
            Join.Expired
        }
    }

    private fun LinkProperties?.summary(): String = this?.let { lp ->
        "addrs=" + (lp.linkAddresses?.joinToString(",") { a -> a.address?.hostAddress ?: "?" } ?: "-") +
            " gateways=" + (lp.routes?.joinToString(",") { r -> r.gateway?.hostAddress ?: "-" } ?: "-")
    } ?: "null"

    private suspend fun connectLegacy(ssid: String, password: String?): WifiResult {
        return try {
            val config = WifiConfiguration().apply {
                SSID = "\"$ssid\""
                if (password.isNullOrBlank()) {
                    allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE)
                } else {
                    preSharedKey = "\"$password\""
                    allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK)
                }
            }
            val netId = wm.addNetwork(config)
            Diag.debug(LogTag.WIFI, "legacy addNetwork -> netId=$netId")
            if (netId == -1) return WifiResult.Failed("addNetwork failed")
            wm.disconnect()
            val ok = wm.enableNetwork(netId, true)
            wm.reconnect()
            if (!ok) return WifiResult.Failed("enableNetwork failed")
            legacyNetId = netId
            // Association is asynchronous; without a real COMPLETED state we have no
            // gateway and no route, so report failure instead of pretending.
            val t0 = Diag.uptimeMillis()
            val associated = withTimeoutOrNull(8_000) {
                while (true) {
                    val info = wm.connectionInfo
                    if (info != null && info.supplicantState == SupplicantState.COMPLETED && info.networkId == netId) {
                        break
                    }
                    kotlinx.coroutines.delay(300)
                }
                true
            } ?: false
            if (!associated) {
                Diag.error(LogTag.WIFI, "legacy association never reached COMPLETED in ${Diag.uptimeMillis() - t0}ms")
                runCatching { wm.removeNetwork(netId) }
                legacyNetId = -1
                return WifiResult.Failed("Timed out joining $ssid")
            }
            Diag.info(LogTag.WIFI, "legacy association completed in ${Diag.uptimeMillis() - t0}ms")
            // Pick up link properties for gateway() even though we didn't bind a socket.
            runCatching {
                cm.getLinkProperties(cm.activeNetwork)?.let { linkProps = it }
            }
            WifiResult.Connected(ssid)
        } catch (t: Throwable) {
            Diag.error(LogTag.WIFI, "legacy join threw ${Diag.causeChain(t)}")
            WifiResult.Failed(t.message ?: "legacy connect failed")
        }
    }

    /**
     * A Wi-Fi network we can actually talk to the camera through. The *default*
     * network is often a VPN tunnel while the camera's hotspot is still attached,
     * so this deliberately looks past the default and rejects TRANSPORT_VPN.
     */
    private fun findWifiNetwork(): Network? {
        fun isPlainWifi(n: Network?): Boolean = runCatching {
            val caps = n?.let { cm.getNetworkCapabilities(it) } ?: return false
            caps.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) &&
                !caps.hasTransport(NetworkCapabilities.TRANSPORT_VPN)
        }.getOrDefault(false)
        if (isPlainWifi(cm.activeNetwork)) return cm.activeNetwork
        return runCatching { cm.allNetworks?.firstOrNull { isPlainWifi(it) } }.getOrNull()
    }

    override suspend fun adoptCurrentNetwork(force: Boolean): WifiResult {
        // We are about to take over the route: drop a handle that is no longer live
        // first, so it cannot be reported back as "still bound" afterwards.
        clearStaleCameraBinding()
        val target = findWifiNetwork()
            ?: return WifiResult.Failed("phone is not on a Wi-Fi network").also {
                Diag.warn(LogTag.WIFI, "adopt refused: no plain Wi-Fi network (cellular only, or Wi-Fi off)")
            }
        val ssid = currentCameraSsid()
        val cameraLike = ssid != null && DEFAULT_PREFIXES.any { ssid.startsWith(it, ignoreCase = true) }
        val isolatedAp = runCatching {
            val caps = cm.getNetworkCapabilities(target)
            caps != null && !caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        }.getOrDefault(false)
        if (!cameraLike && !isolatedAp && !force) {
            Diag.debug(LogTag.WIFI, "adopt skipped: $ssid looks like a normal network (camera_like=false internet=true), pass force for manual-IP flows")
            return WifiResult.Failed("Current Wi-Fi (${"${ssid ?: "unknown"}"}) is not a camera network")
        }
        adoptedNetwork = target
        boundNetwork = target
        runCatching { cm.bindProcessToNetwork(target) }
            .onFailure { Diag.error(LogTag.WIFI, "adopt bindProcessToNetwork threw ${Diag.causeChain(it)}") }
        linkProps = runCatching { cm.getLinkProperties(target) }.getOrNull()
        // One watch at a time: adopting twice used to leave two callbacks alive, and
        // disconnect() only unregistered the last one — the orphan later fired
        // `bindProcessToNetwork(null)` over a session that had since re-bound.
        adoptWatch?.let { stale ->
            runCatching { cm.unregisterNetworkCallback(stale) }
            Diag.debug(LogTag.WIFI, "adopt replaced a previous watch")
        }
        adoptWatch = null
        // If the user walks off this network we must stop routing through it,
        // otherwise every socket dies with the tunnel that replaced it. The target is
        // captured below rather than read back from `adoptedNetwork`, which
        // disconnect() clears — a guard on that field made the unbind unreachable.
        runCatching {
            val cb = object : ConnectivityManager.NetworkCallback() {
                override fun onLost(network: Network) {
                    if (network != target) return
                    Diag.warn(LogTag.WIFI, "adopted Wi-Fi network LOST — unbinding process")
                    if (adoptedNetwork === target) adoptedNetwork = null
                    if (boundNetwork === target) boundNetwork = null
                    linkProps = null
                    runCatching { cm.bindProcessToNetwork(null) }
                    runCatching { cm.unregisterNetworkCallback(this) }
                    if (adoptWatch === this) adoptWatch = null
                }

                override fun onCapabilitiesChanged(network: Network, caps: NetworkCapabilities) {
                    if (network != target) return
                    // DHCP can hand out a new address long after we joined; gateway()
                    // and the fixed-host fallback are the only ways we find the camera,
                    // so keep the properties current instead of serving the join-time
                    // snapshot until the network is lost.
                    cm.getLinkProperties(network)?.let { linkProps = it }
                }

                override fun onLinkPropertiesChanged(network: Network, lp: LinkProperties) {
                    if (network == target) linkProps = lp
                }
            }
            cm.registerNetworkCallback(
                NetworkRequest.Builder()
                    .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                    .removeCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                    .build(),
                cb,
            )
            adoptWatch = cb
        }.onFailure { Diag.error(LogTag.WIFI, "adopt watch registration threw ${Diag.causeChain(it)}") }
        Diag.info(LogTag.WIFI, "adopted current Wi-Fi ssid=${ssid ?: "-"} camera_like=$cameraLike isolated_ap=$isolatedAp gateway=${linkProps?.summary()}")
        return WifiResult.Connected(ssid ?: "")
    }

    override fun isVpnActive(): Boolean = runCatching {
        val n = cm.activeNetwork ?: return false
        cm.getNetworkCapabilities(n)?.hasTransport(NetworkCapabilities.TRANSPORT_VPN) == true
    }.getOrDefault(false)

    override fun openVpnSettings(): Boolean {
        // The VPN panel is the screen the user was sent to, but OEM ROMs own that
        // decision — the OnePlus this was first field-tested on ships a settings app
        // that answers some `android.settings.*` actions by throwing. Fall through to
        // the top-level page rather than reporting failure for a screen that exists.
        for (action in listOf(Settings.ACTION_VPN_SETTINGS, Settings.ACTION_SETTINGS)) {
            val intent = Intent(action).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            val opened = runCatching { androidContext.startActivity(intent); true }.getOrDefault(false)
            if (opened) {
                Diag.info(LogTag.NET, "opened $action so the proxy can be switched off")
                return true
            }
        }
        Diag.warn(LogTag.NET, "no settings screen would open; the user has to leave the app to stop the proxy")
        return false
    }

    /**
     * Step the process off the camera's hotspot for the duration of [block].
     *
     * `bindProcessToNetwork(null)` means "use the system default network", which is
     * deliberately chosen over hunting for a network that advertises
     * `NET_CAPABILITY_INTERNET`: on this phone the default *is* the user's proxy or
     * cellular connection, and picking the default keeps that decision with the
     * operating system instead of second-guessing it from an app.
     *
     * Serialized by [internetRouteMutex] because two overlapping windows would have
     * the second one restore the binding while the first still expects to be off it.
     */
    override suspend fun <T> withInternetRoute(label: String, block: suspend () -> T): T =
        internetRouteMutex.withLock {
            if (boundNetwork == null) return@withLock block()
            val t0 = Diag.uptimeMillis()
            runCatching { cm.bindProcessToNetwork(null) }
            Diag.info(
                LogTag.WIFI,
                "internet route taken for $label after ${Diag.uptimeMillis() - t0}ms " +
                    "(camera sockets parked; bound=${boundNetwork != null})",
            )
            try {
                block()
            } finally {
                // Re-bind only if that same network is still alive; if the hotspot went
                // away mid-download the onLost callback already cleared it, and binding a
                // dead Network would strand every subsequent camera request.
                val stillThere = boundNetwork?.let { isLiveWifiNetwork(it) } == true
                runCatching { cm.bindProcessToNetwork(if (stillThere) boundNetwork else null) }
                    .onFailure { Diag.error(LogTag.WIFI, "internet route restore threw ${Diag.causeChain(it)}") }
                Diag.info(
                    LogTag.WIFI,
                    "internet route released after ${Diag.uptimeMillis() - t0}ms, camera route ${if (stillThere) "restored" else "not restored (no live camera network)"}",
                )
            }
        }

    override suspend fun disconnect() {
        Diag.debug(LogTag.WIFI, "disconnect (bound=${boundNetwork != null} adopted=${adoptedNetwork != null} legacyNetId=$legacyNetId)")
        runCatching { callback?.let { cm.unregisterNetworkCallback(it) } }
        callback = null
        runCatching { adoptWatch?.let { cm.unregisterNetworkCallback(it) } }
        adoptWatch = null
        adoptedNetwork = null
        runCatching { cm.bindProcessToNetwork(null) }
        boundNetwork = null
        linkProps = null
        if (legacyNetId != -1) {
            runCatching { wm.disableNetwork(legacyNetId) }
            // disableNetwork alone leaves the saved configuration behind forever.
            runCatching { wm.removeNetwork(legacyNetId) }
            runCatching { wm.disconnect() }
            legacyNetId = -1
        }
    }

    @Volatile private var wifiWatchCallback: ConnectivityManager.NetworkCallback? = null

    override fun watchWifiChanges(listener: ((ssid: String?) -> Unit)?) {
        val previous = wifiWatchCallback
        if (previous != null) {
            runCatching { cm.unregisterNetworkCallback(previous) }
            wifiWatchCallback = null
        }
        if (listener == null) return

        val cb = object : ConnectivityManager.NetworkCallback() {
            private var lastSsid: String? = null
            override fun onCapabilitiesChanged(network: Network, caps: NetworkCapabilities) {
                if (!caps.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) return
                val ssid = wm.connectionInfo?.ssid?.trim('"')
                    ?.takeIf { it.isNotEmpty() && it != "<unknown ssid>" }
                if (ssid != null && ssid != lastSsid) {
                    lastSsid = ssid
                    Diag.info(LogTag.WIFI, "watch: active wifi ssid is now $ssid")
                    listener(ssid)
                }
            }
            override fun onLost(network: Network) {
                Diag.info(LogTag.WIFI, "watch: default network lost")
                listener(null)
            }
        }
        wifiWatchCallback = cb
        runCatching { cm.registerDefaultNetworkCallback(cb) }
            .onFailure { Diag.error(LogTag.WIFI, "registerDefaultNetworkCallback threw ${Diag.causeChain(it)}") }
    }
}

private class AndroidWifiScanner : WifiScanner {
    private val wm by lazy { androidContext.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager }

    @Volatile private var lastRequestAt = 0L

    @Suppress("DEPRECATION", "MissingPermission")
    override suspend fun scan(prefixes: List<String>, force: Boolean): List<CameraNetwork> {
        return try {
            val now = SystemClock.elapsedRealtime()
            val due = force || now - lastRequestAt >= MIN_SCAN_REQUEST_INTERVAL_MS
            if (due) {
                lastRequestAt = now
                val started = runCatching { wm.startScan() }.getOrDefault(false)
                Diag.debug(LogTag.WIFI, "startScan requested (forced=$force) -> $started")
            }
            val results: List<ScanResult> = wm.scanResults ?: emptyList()
            results
                .filter { r -> prefixes.any { p -> (r.SSID ?: "").startsWith(p, ignoreCase = true) } }
                .distinctBy { it.SSID }
                .map { r ->
                    val secured = !(r.capabilities ?: "").contains("OPEN", true)
                    CameraNetwork(r.SSID ?: "", secured, r.level)
                }
                .sortedByDescending { it.rssi }
                .also {
                    Diag.debug(
                        LogTag.WIFI,
                        "scan results: ${it.size} camera-like (${results.size} total in range" +
                            if (due) ")" else ", cached — request not due yet)",
                    )
                }
        } catch (t: Throwable) {
            Diag.error(LogTag.WIFI, "scan threw ${Diag.causeChain(t)}")
            emptyList()
        }
    }

    companion object {
        /**
         * Android answers `startScan()` with `false` while it is rate-limiting us
         * (measured on the 2026-09-21 OnePlus run: two calls three seconds apart,
         * both refused), so a 2-second refresh cycle asks for a real scan at most
         * this often and reads cached results in between.
         */
        private const val MIN_SCAN_REQUEST_INTERVAL_MS = 15_000L
    }
}

/** What Android returns for a BSSID it will not disclose — never a real address. */
private const val REDACTED_BSSID = "02:00:00:00:00:00"

/**
 * How long a specifier join may take. Android shows its own picker for this and
 * never tells us the user is still looking at it, so the budget has to outlast a
 * slow tap — the field test that prompted this timed out at 25 s while the hotspot
 * was already joined, and reported a failure for a connection that had succeeded.
 */
private const val JOIN_BUDGET_MS = 60_000L

/**
 * How many specifier requests one join may spend, and how it waits between them.
 *
 * A Bluetooth-woken hotspot needs a few seconds before the phone can see it at all
 * (see `AndroidWifiController.connectModern`), so the first `onUnavailable` says
 * nothing about the passphrase. Retrying covers the ~9 s gap the 2026-09-22 field log
 * measured between "the camera says the AP is up" and "the AP is in the scan list",
 * while a genuinely wrong password still ends inside [JOIN_BUDGET_MS] rather than
 * dragging the connection screen on for a minute.
 */
private const val JOIN_MAX_ATTEMPTS = 4

/** Pause between attempts, long enough for a forced scan to land. */
private const val JOIN_RETRY_DELAY_MS = 2_500L

/** Never start an attempt that cannot finish inside [JOIN_BUDGET_MS]. */
private const val JOIN_MIN_RETRY_MS = 6_000L

actual fun createWifiController(): WifiController = AndroidWifiController()
actual fun createWifiScanner(): WifiScanner = AndroidWifiScanner()
