package com.rovecamlink.app.core.net

/**
 * Remembers the passphrase that worked for each camera hotspot, keyed by SSID.
 *
 * This is what turns "tap the camera in the Wi-Fi list" into a one-tap connect on
 * every later visit. A camera hotspot is a WPA2 network whose passphrase the
 * official app reads over Bluetooth — and when Bluetooth is unavailable the user
 * types it once, which is exactly the step this cache removes the second time.
 *
 * The BLE-reported password and the brand's factory default go through the same
 * store, so the resolution order stays one list rather than three code paths.
 */
interface WifiCredentialStore {
    fun passwordFor(ssid: String): String?
    fun remember(ssid: String, password: String)
    fun forget(ssid: String)
}

/** expect factory; Android persists, the others keep memory only. */
expect fun createWifiCredentialStore(): WifiCredentialStore

/** Used where there is no persistence backend, and as the common fallback. */
class MemoryWifiCredentialStore : WifiCredentialStore {
    private val passwords = mutableMapOf<String, String>()

    override fun passwordFor(ssid: String): String? = passwords[ssid]?.takeIf { it.isNotEmpty() }

    override fun remember(ssid: String, password: String) {
        passwords[ssid] = password
    }

    override fun forget(ssid: String) {
        passwords.remove(ssid)
    }
}
