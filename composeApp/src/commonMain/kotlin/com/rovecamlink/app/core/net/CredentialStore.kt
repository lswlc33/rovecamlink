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

    /**
     * The cameras this phone has joined before, most recent first.
     *
     * Cameras, not networks: only an SSID a session was actually completed on is worth
     * offering again, and the order is the order they were used, so the one that was in
     * the bag last sits at the top. Blank by default so a platform with no persistence
     * still compiles and simply remembers nothing across launches.
     */
    fun knownCameras(): List<String> = emptyList()

    /** Note a completed connection, moving [ssid] to the front of [knownCameras]. */
    fun noteConnected(ssid: String) {}

    /** A name the user gave this camera; null means show the SSID. */
    fun aliasFor(ssid: String): String? = null

    /** Set or clear the alias. Null or blank clears it. */
    fun setAlias(ssid: String, alias: String?) {}
}

/** expect factory; Android persists, the others keep memory only. */
expect fun createWifiCredentialStore(): WifiCredentialStore

/** Used where there is no persistence backend, and as the common fallback. */
class MemoryWifiCredentialStore : WifiCredentialStore {
    private val passwords = mutableMapOf<String, String>()
    private val known = mutableListOf<String>()
    private val aliases = mutableMapOf<String, String>()

    override fun passwordFor(ssid: String): String? = passwords[ssid]?.takeIf { it.isNotEmpty() }

    override fun remember(ssid: String, password: String) {
        passwords[ssid] = password
    }

    override fun forget(ssid: String) {
        passwords.remove(ssid)
        known.remove(ssid)
        aliases.remove(ssid)
    }

    override fun knownCameras(): List<String> = known.toList()

    override fun noteConnected(ssid: String) {
        known.remove(ssid)
        known.add(0, ssid)
        while (known.size > MAX_KNOWN_CAMERAS) known.removeAt(known.lastIndex)
    }

    override fun aliasFor(ssid: String): String? = aliases[ssid]?.takeIf { it.isNotBlank() }

    override fun setAlias(ssid: String, alias: String?) {
        if (alias.isNullOrBlank()) aliases.remove(ssid) else aliases[ssid] = alias.trim()
    }
}

/**
 * How many previously-used cameras are kept. Enough to cover a shelf of them without the
 * list growing without bound — and, on Android, without the prefs value growing past what
 * is comfortable to read in one line.
 */
internal const val MAX_KNOWN_CAMERAS: Int = 12
