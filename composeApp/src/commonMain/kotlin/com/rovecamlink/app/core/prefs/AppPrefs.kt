package com.rovecamlink.app.core.prefs

import kotlin.concurrent.atomics.AtomicReference
import kotlin.concurrent.atomics.ExperimentalAtomicApi

/**
 * Flat key-value store for the app's own bookkeeping — facts that must survive a restart
 * but are neither the user's content nor a credential: when the SD card was last
 * formatted, and similar one-liners.
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

/**
 * Used where there is no persistence backend, and as the common fallback.
 *
 * Callers may arrive from the UI thread and a background worker at the same time, so the
 * entries live in an immutable snapshot swapped by compare-and-set rather than in a bare
 * mutableMapOf two threads could corrupt mid-resize. commonMain has neither
 * java.util.concurrent nor `kotlin.synchronized` (both JVM-only) to guard it with.
 */
@OptIn(ExperimentalAtomicApi::class)
class MemoryAppPrefs : AppPrefs {
    private val values = AtomicReference<Map<String, Any>>(emptyMap())

    override fun getString(key: String): String? = values.load()[key] as? String

    override fun putString(key: String, value: String?) {
        put(key, value)
    }

    override fun getLong(key: String): Long? = values.load()[key] as? Long

    override fun putLong(key: String, value: Long?) {
        put(key, value)
    }

    private fun put(key: String, value: Any?) {
        update { if (value == null) it - key else it + (key to value) }
    }

    /** Swap in a new snapshot, retrying when another thread got there first. */
    private fun update(transform: (Map<String, Any>) -> Map<String, Any>) {
        while (true) {
            val current = values.load()
            if (values.compareAndSet(current, transform(current))) return
        }
    }
}
