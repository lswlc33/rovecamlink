package com.rovecamlink.app.core.wifi

import android.content.Context
import android.net.ConnectivityManager
import android.net.LinkProperties
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.net.wifi.ScanResult
import android.net.wifi.SupplicantState
import android.net.wifi.WifiConfiguration
import android.net.wifi.WifiManager
import android.net.wifi.WifiNetworkSpecifier
import android.os.Build
import com.rovecamlink.app.androidContext
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogTag
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.coroutines.resume

@Suppress("DEPRECATION")
private class AndroidWifiController : WifiController {

    private val cm by lazy { androidContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
    private val wm by lazy { androidContext.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager }

    @Volatile private var boundNetwork: Network? = null
    @Volatile private var linkProps: LinkProperties? = null
    @Volatile private var callback: ConnectivityManager.NetworkCallback? = null
    @Volatile private var legacyNetId: Int = -1

    override val isConnectedToCamera: Boolean get() = boundNetwork != null || legacyNetId != -1

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

    private fun gatewayInternal(): String? {
        // 1. Link properties captured when we joined the camera network ourselves.
        linkProps?.let { lp ->
            lp.routes?.firstOrNull { it.isDefaultRoute }?.gateway?.hostAddress?.let { return it }
            lp.linkAddresses?.firstOrNull()?.address?.hostAddress?.let { addr ->
                return addr.substringBeforeLast('.') + ".1"
            }
        }
        // 2. Fallback for manually-joined networks: read the active network's
        //    link properties directly (works without our own requestNetwork).
        val active = boundNetwork ?: cm.activeNetwork ?: return null
        return runCatching {
            val lp = cm.getLinkProperties(active) ?: return null
            lp.routes?.firstOrNull { it.isDefaultRoute }?.gateway?.hostAddress
                ?: lp.linkAddresses?.firstOrNull()?.address?.hostAddress
                    ?.substringBeforeLast('.')?.plus(".1")
        }.getOrNull()
    }

    override suspend fun connect(ssid: String, password: String?): WifiResult {
        Diag.info(LogTag.WIFI, "join request ssid=$ssid pass=${password?.length ?: 0}ch api=${Build.VERSION.SDK_INT} modern=${Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q}")
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            connectModern(ssid, password)
        } else {
            connectLegacy(ssid, password)
        }
    }

    private suspend fun connectModern(ssid: String, password: String?): WifiResult {
        val specBuilder = WifiNetworkSpecifier.Builder().setSsid(ssid)
        if (!password.isNullOrBlank()) specBuilder.setWpa2Passphrase(password)
        val request = NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .removeCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .setNetworkSpecifier(specBuilder.build())
            .build()

        val t0 = Diag.uptimeMillis()
        val result = withTimeoutOrNull(25_000) {
            suspendCancellableCoroutine { cont ->
                val cb = object : ConnectivityManager.NetworkCallback() {
                    override fun onAvailable(network: Network) {
                        boundNetwork = network
                        // Route ALL of this process's sockets (Ktor CIO + Media3) via the camera.
                        runCatching { cm.bindProcessToNetwork(network) }
                            .onFailure { Diag.error(LogTag.WIFI, "bindProcessToNetwork threw ${Diag.causeChain(it)}") }
                        Diag.info(LogTag.WIFI, "network AVAILABLE after ${Diag.uptimeMillis() - t0}ms, process bound=${boundNetwork != null}")
                        if (cont.isActive) cont.resume(WifiResult.Connected(ssid))
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
                        Diag.error(LogTag.WIFI, "requestNetwork reported UNAVAILABLE after ${Diag.uptimeMillis() - t0}ms (wrong password, or the AP vanished)")
                        runCatching { cm.unregisterNetworkCallback(this) }
                        if (cont.isActive) cont.resume(WifiResult.Failed("Camera network unavailable"))
                    }
                }
                callback = cb
                try {
                    Diag.debug(LogTag.WIFI, "requestNetwork(TRANSPORT_WIFI, specifier for $ssid, no INTERNET capability)")
                    cm.requestNetwork(request, cb)
                } catch (t: Throwable) {
                    Diag.error(LogTag.WIFI, "requestNetwork threw ${Diag.causeChain(t)}")
                    if (cont.isActive) cont.resume(WifiResult.Failed(t.message ?: "requestNetwork failed"))
                }
                cont.invokeOnCancellation {
                    runCatching { cm.unregisterNetworkCallback(cb) }
                }
            }
        }
        return result ?: run {
            Diag.error(LogTag.WIFI, "join $ssid timed out after ${Diag.uptimeMillis() - t0}ms")
            disconnect()
            WifiResult.Failed("Timed out joining $ssid")
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

    override suspend fun disconnect() {
        Diag.debug(LogTag.WIFI, "disconnect (bound=${boundNetwork != null} legacyNetId=$legacyNetId)")
        runCatching { callback?.let { cm.unregisterNetworkCallback(it) } }
        callback = null
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

    @Suppress("DEPRECATION", "MissingPermission")
    override suspend fun scan(prefixes: List<String>): List<CameraNetwork> {
        return try {
            val started = runCatching { wm.startScan() }.getOrDefault(false)
            Diag.debug(LogTag.WIFI, "startScan requested -> $started")
            val results: List<ScanResult> = wm.scanResults ?: emptyList()
            results
                .filter { r -> prefixes.any { p -> (r.SSID ?: "").startsWith(p, ignoreCase = true) } }
                .distinctBy { it.SSID }
                .map { r ->
                    val secured = !(r.capabilities ?: "").contains("OPEN", true)
                    CameraNetwork(r.SSID ?: "", secured, r.level)
                }
                .sortedByDescending { it.rssi }
                .also { Diag.info(LogTag.WIFI, "scan results: ${it.size} camera-like (${results.size} total in range)") }
        } catch (t: Throwable) {
            Diag.error(LogTag.WIFI, "scan threw ${Diag.causeChain(t)}")
            emptyList()
        }
    }
}

actual fun createWifiController(): WifiController = AndroidWifiController()
actual fun createWifiScanner(): WifiScanner = AndroidWifiScanner()
