package com.rovecamlink.app.core.net

import kotlin.concurrent.atomics.AtomicReference
import kotlin.concurrent.atomics.ExperimentalAtomicApi

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

/**
 * Used where there is no persistence backend, and as the common fallback.
 *
 * Sessions read and write this from whichever thread happens to be running them, so the
 * collections are held as immutable snapshots swapped by compare-and-set rather than as a
 * mutable [HashMap] / [ArrayList] that two threads could corrupt mid-resize.
 */
@OptIn(ExperimentalAtomicApi::class)
class MemoryWifiCredentialStore : WifiCredentialStore {
    private val passwords = AtomicReference<Map<String, String>>(emptyMap())
    private val known = AtomicReference<List<String>>(emptyList())
    private val aliases = AtomicReference<Map<String, String>>(emptyMap())

    override fun passwordFor(ssid: String): String? = passwords.load()[ssid]?.takeIf { it.isNotEmpty() }

    /** An empty [password] is not a credential: it clears the entry, like [passwordFor] reads it. */
    override fun remember(ssid: String, password: String) {
        if (password.isEmpty()) {
            update(passwords) { it - ssid }
        } else {
            update(passwords) { it + (ssid to password) }
        }
    }

    override fun forget(ssid: String) {
        update(passwords) { it - ssid }
        update(known) { it - ssid }
        update(aliases) { it - ssid }
    }

    override fun knownCameras(): List<String> = known.load()

    override fun noteConnected(ssid: String) {
        update(known) { (listOf(ssid) + it.filterNot { name -> name == ssid }).take(MAX_KNOWN_CAMERAS) }
    }

    override fun aliasFor(ssid: String): String? = aliases.load()[ssid]?.takeIf { it.isNotBlank() }

    override fun setAlias(ssid: String, alias: String?) {
        if (alias.isNullOrBlank()) {
            update(aliases) { it - ssid }
        } else {
            update(aliases) { it + (ssid to alias.trim()) }
        }
    }

    /** Swap in a new snapshot, retrying when another thread got there first. */
    private fun <T : Any> update(ref: AtomicReference<T>, transform: (T) -> T) {
        while (true) {
            val current = ref.load()
            if (ref.compareAndSet(current, transform(current))) return
        }
    }
}

/**
 * How many previously-used cameras are kept. Enough to cover a shelf of them without the
 * list growing without bound — and, on Android, without the prefs value growing past what
 * is comfortable to read in one line.
 */
internal const val MAX_KNOWN_CAMERAS: Int = 12
