package com.rovecamlink.app.core.prefs

/**
 * Flat key-value store for the app's own bookkeeping — facts that must survive a restart
 * but are neither the user's content nor a credential: when the SD card was last
 * formatted, which clips are starred.
 *
 * Deliberately narrow (strings and longs, one namespace, no schema) so every platform
 * actual is a few lines and nothing here can quietly grow into a database. Anything that
 * needs structure gets its own store, the way [com.rovecamlink.app.core.net.WifiCredentialStore]
 * did.
 */
interface AppPrefs {
    fun getString(key: String): String?
    fun putString(key: String, value: String?)
    fun getLong(key: String): Long?
    fun putLong(key: String, value: Long?)
}

/** expect factory; Android persists to SharedPreferences, the others keep memory only. */
expect fun createAppPrefs(): AppPrefs

/** Used where there is no persistence backend, and as the common fallback. */
class MemoryAppPrefs : AppPrefs {
    private val values = mutableMapOf<String, Any>()

    override fun getString(key: String): String? = values[key] as? String

    override fun putString(key: String, value: String?) {
        if (value == null) values.remove(key) else values[key] = value
    }

    override fun getLong(key: String): Long? = values[key] as? Long

    override fun putLong(key: String, value: Long?) {
        if (value == null) values.remove(key) else values[key] = value
    }
}
