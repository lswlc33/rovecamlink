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
        val lp = linkProps ?: return null
        // Prefer the default route's gateway; fall back to the link subnet's .1
        lp.routes?.firstOrNull { it.isDefaultRoute }?.gateway?.hostAddress?.let { return it }
        val addr = lp.linkAddresses?.firstOrNull()?.address?.hostAddress ?: return null
        return addr.substringBeforeLast('.') + ".1"
    }

    override suspend fun connect(ssid: String, password: String?): WifiResult {
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

        val result = withTimeoutOrNull(25_000) {
            suspendCancellableCoroutine { cont ->
                val cb = object : ConnectivityManager.NetworkCallback() {
                    override fun onAvailable(network: Network) {
                        boundNetwork = network
                        // Route ALL of this process's sockets (Ktor CIO + Media3) via the camera.
                        cm.bindProcessToNetwork(network)
                        if (cont.isActive) cont.resume(WifiResult.Connected(ssid))
                    }
                    override fun onLinkPropertiesChanged(network: Network, lp: LinkProperties) {
                        if (network == boundNetwork) linkProps = lp
                    }
                    override fun onCapabilitiesChanged(network: Network, caps: NetworkCapabilities) {
                        val lp = cm.getLinkProperties(network)
                        if (lp != null) linkProps = lp
                    }
                    override fun onLost(network: Network) {
                        if (network == boundNetwork) { boundNetwork = null; linkProps = null }
                    }
                    override fun onUnavailable() {
                        if (cont.isActive) cont.resume(WifiResult.Failed("Camera network unavailable"))
                    }
                }
                callback = cb
                try {
                    cm.requestNetwork(request, cb)
                } catch (t: Throwable) {
                    if (cont.isActive) cont.resume(WifiResult.Failed(t.message ?: "requestNetwork failed"))
                }
                cont.invokeOnCancellation {
                    runCatching { cm.unregisterNetworkCallback(cb) }
                }
            }
        }
        return result ?: run {
            disconnect()
            WifiResult.Failed("Timed out joining $ssid")
        }
    }

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
            if (netId == -1) return WifiResult.Failed("addNetwork failed")
            wm.disconnect()
            val ok = wm.enableNetwork(netId, true)
            wm.reconnect()
            if (!ok) return WifiResult.Failed("enableNetwork failed")
            legacyNetId = netId
            // Give association a moment, then read link properties for the gateway.
            withTimeoutOrNull(8_000) {
                while (true) {
                    val info = wm.connectionInfo
                    if (info != null && info.supplicantState == SupplicantState.COMPLETED && info.networkId == netId) {
                        break
                    }
                    kotlinx.coroutines.delay(300)
                }
            }
            WifiResult.Connected(ssid)
        } catch (t: Throwable) {
            WifiResult.Failed(t.message ?: "legacy connect failed")
        }
    }

    override suspend fun disconnect() {
        runCatching { callback?.let { cm.unregisterNetworkCallback(it) } }
        callback = null
        runCatching { cm.bindProcessToNetwork(null) }
        boundNetwork = null
        linkProps = null
        if (legacyNetId != -1) {
            runCatching { wm.disableNetwork(legacyNetId) }
            runCatching { wm.disconnect() }
            legacyNetId = -1
        }
    }
}

private class AndroidWifiScanner : WifiScanner {
    private val wm by lazy { androidContext.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager }

    @Suppress("DEPRECATION", "MissingPermission")
    override suspend fun scan(prefixes: List<String>): List<CameraNetwork> {
        return try {
            runCatching { wm.startScan() }
            val results: List<ScanResult> = wm.scanResults ?: emptyList()
            results
                .filter { r -> prefixes.any { p -> (r.SSID ?: "").startsWith(p, ignoreCase = true) } }
                .distinctBy { it.SSID }
                .map { r ->
                    val secured = !(r.capabilities ?: "").contains("OPEN", true)
                    CameraNetwork(r.SSID ?: "", secured, r.level)
                }
                .sortedByDescending { it.rssi }
        } catch (t: Throwable) {
            emptyList()
        }
    }
}

actual fun createWifiController(): WifiController = AndroidWifiController()
actual fun createWifiScanner(): WifiScanner = AndroidWifiScanner()
