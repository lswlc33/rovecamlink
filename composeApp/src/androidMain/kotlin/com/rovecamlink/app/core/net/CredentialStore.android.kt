package com.rovecamlink.app.core.net

import android.content.Context
import com.rovecamlink.app.androidContext

/**
 * Passphrases live in app-private shared preferences, so a re-pair after an app
 * update or a reboot is still one tap. They are never written to external storage:
 * `logs/` is world-readable through the file manager, and the diagnostics TXT a
 * user sends us is built from it.
 *
 * Keyed by SSID, not BSSID — these cameras hand out a new BSSID per boot while the
 * network name stays put.
 */
private class SharedPrefsCredentialStore : WifiCredentialStore {
    private val prefs by lazy {
        androidContext.applicationContext.getSharedPreferences(FILE, Context.MODE_PRIVATE)
    }

    override fun passwordFor(ssid: String): String? =
        prefs.getString(KEY_PREFIX + ssid, null)?.takeIf { it.isNotEmpty() }

    override fun remember(ssid: String, password: String) {
        prefs.edit().putString(KEY_PREFIX + ssid, password).apply()
    }

    override fun forget(ssid: String) {
        prefs.edit().remove(KEY_PREFIX + ssid).apply()
    }

    companion object {
        private const val FILE = "rovlink_wifi"
        private const val KEY_PREFIX = "pwd_"
    }
}

actual fun createWifiCredentialStore(): WifiCredentialStore = SharedPrefsCredentialStore()
