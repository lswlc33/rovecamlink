package com.rovecamlink.app.core.prefs

import android.content.Context
import com.rovecamlink.app.androidContext

/**
 * App-private SharedPreferences, in its own file rather than sharing the credential
 * store's: these keys are bookkeeping, and keeping them apart means clearing one never
 * risks the other.
 */
private class SharedPrefsAppPrefs : AppPrefs {
    private val prefs by lazy {
        androidContext.applicationContext.getSharedPreferences(FILE, Context.MODE_PRIVATE)
    }

    override fun getString(key: String): String? = prefs.getString(key, null)

    override fun putString(key: String, value: String?) {
        prefs.edit().apply { if (value == null) remove(key) else putString(key, value) }.apply()
    }

    // `contains` first: getLong would otherwise answer 0 for a key that was never set,
    // and 0 is a meaningful timestamp-free value to the caller.
    override fun getLong(key: String): Long? = if (prefs.contains(key)) prefs.getLong(key, 0L) else null

    override fun putLong(key: String, value: Long?) {
        prefs.edit().apply { if (value == null) remove(key) else putLong(key, value) }.apply()
    }

    companion object {
        private const val FILE = "rovlink_prefs"
    }
}

actual fun createAppPrefs(): AppPrefs = SharedPrefsAppPrefs()
