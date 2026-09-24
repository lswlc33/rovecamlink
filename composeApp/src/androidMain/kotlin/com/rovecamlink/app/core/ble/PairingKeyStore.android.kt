package com.rovecamlink.app.core.ble

import android.content.Context
import com.rovecamlink.app.androidContext
import com.rovecamlink.app.core.security.SecretCodec

/**
 * Pairs survive app restarts: the camera keeps the code it accepted, so a stored
 * code is what turns "type the 4 digits again" into a silent reconnect.
 *
 * The code is **encrypted at rest** ([SecretCodec]) like the Wi-Fi passphrase — it
 * is the other secret that grants access to the camera's network, and it was the
 * value the diagnostics log shipped in the clear before the mask covered `Pin=`.
 *
 * Keyed by advertisement name (`XTU_S7Pro_f9e5e2`) rather than MAC, because some
 * firmwares advertise a rotating address while the name stays put.
 */
private class SharedPrefsPairingKeyStore : PairingKeyStore {
    private val prefs by lazy {
        androidContext.applicationContext.getSharedPreferences(FILE, Context.MODE_PRIVATE)
    }

    override fun keyFor(cameraName: String): String? =
        prefs.getString(KEY_PREFIX + cameraName, null)?.let { SecretCodec.decrypt(it) }?.takeIf { it.isNotEmpty() }

    override fun remember(cameraName: String, key: String) {
        val stored = SecretCodec.encrypt(key) ?: key
        prefs.edit().putString(KEY_PREFIX + cameraName, stored).apply()
    }

    override fun forget(cameraName: String) {
        prefs.edit().remove(KEY_PREFIX + cameraName).apply()
    }

    companion object {
        private const val FILE = "rovlink_pairing"
        private const val KEY_PREFIX = "pin_"
    }
}

actual fun createPairingKeyStore(): PairingKeyStore = SharedPrefsPairingKeyStore()
