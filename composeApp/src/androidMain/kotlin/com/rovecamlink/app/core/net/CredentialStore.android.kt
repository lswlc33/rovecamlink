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
        prefs.edit()
            .remove(KEY_PREFIX + ssid)
            .remove(ALIAS_PREFIX + ssid)
            .putString(KEY_KNOWN, knownCameras().filterNot { it == ssid }.joinToString(SEP))
            .apply()
    }

    override fun knownCameras(): List<String> =
        prefs.getString(KEY_KNOWN, null)
            ?.split(SEP)
            ?.filter { it.isNotBlank() }
            ?.take(MAX_KNOWN_CAMERAS)
            ?: emptyList()

    override fun noteConnected(ssid: String) {
        val next = (listOf(ssid) + knownCameras().filterNot { it == ssid }).take(MAX_KNOWN_CAMERAS)
        prefs.edit().putString(KEY_KNOWN, next.joinToString(SEP)).apply()
    }

    override fun aliasFor(ssid: String): String? =
        prefs.getString(ALIAS_PREFIX + ssid, null)?.takeIf { it.isNotBlank() }

    override fun setAlias(ssid: String, alias: String?) {
        val e = prefs.edit()
        if (alias.isNullOrBlank()) e.remove(ALIAS_PREFIX + ssid)
        else e.putString(ALIAS_PREFIX + ssid, alias.trim())
        e.apply()
    }

    companion object {
        private const val FILE = "rovlink_wifi"
        private const val KEY_PREFIX = "pwd_"
        private const val ALIAS_PREFIX = "alias_"
        private const val KEY_KNOWN = "known_cameras"
        /** A newline cannot appear in an SSID, so it is a safe separator inside one pref. */
        private const val SEP = "\n"
    }
}

actual fun createWifiCredentialStore(): WifiCredentialStore = SharedPrefsCredentialStore()
