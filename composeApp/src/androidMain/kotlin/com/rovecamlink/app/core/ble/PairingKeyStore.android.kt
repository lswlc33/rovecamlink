package com.rovecamlink.app.core.ble

import android.content.Context
import com.rovecamlink.app.androidContext

/**
 * Pairs survive app restarts: the camera keeps the code it accepted, so a stored
 * code is what turns "type the 4 digits again" into a silent reconnect.
 *
 * Keyed by advertisement name (`XTU_S7Pro_f9e5e2`) rather than MAC, because some
 * firmwares advertise a rotating address while the name stays put.
 */
private class SharedPrefsPairingKeyStore : PairingKeyStore {
    private val prefs by lazy {
        androidContext.applicationContext.getSharedPreferences(FILE, Context.MODE_PRIVATE)
    }

    override fun keyFor(cameraName: String): String? =
        prefs.getString(KEY_PREFIX + cameraName, null)?.takeIf { it.isNotEmpty() }

    override fun remember(cameraName: String, key: String) {
        prefs.edit().putString(KEY_PREFIX + cameraName, key).apply()
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
