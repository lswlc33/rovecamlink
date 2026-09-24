package com.rovecamlink.app.core.net

import android.content.Context
import com.rovecamlink.app.androidContext
import com.rovecamlink.app.core.security.SecretCodec

/**
 * Passphrases live in app-private shared preferences, so a re-pair after an app
 * update or a reboot is still one tap. They are never written to external storage:
 * `logs/` is world-readable through the file manager, and the diagnostics TXT a
 * user sends us is built from it.
 *
 * They are also **encrypted at rest** ([SecretCodec], an AES/GCM key held by the
 * platform Keystore) rather than stored in the clear, because the value grants
 * access to the camera's own network — the same reason the BLE log masks it. A
 * value the keystore refuses to encrypt falls back to plaintext so the feature
 * still works; [SecretCodec.decrypt] reads both forms.
 *
 * Keyed by SSID, not BSSID — these cameras hand out a new BSSID per boot while the
 * network name stays put.
 */
private class SharedPrefsCredentialStore : WifiCredentialStore {
    private val prefs by lazy {
        androidContext.applicationContext.getSharedPreferences(FILE, Context.MODE_PRIVATE)
    }

    override fun passwordFor(ssid: String): String? =
        prefs.getString(KEY_PREFIX + ssid, null)?.let { SecretCodec.decrypt(it) }?.takeIf { it.isNotEmpty() }

    override fun remember(ssid: String, password: String) {
        val stored = SecretCodec.encrypt(password) ?: password
        prefs.edit().putString(KEY_PREFIX + ssid, stored).apply()
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
