package com.rovecamlink.app.core.ble

/**
 * Remembers the pairing code accepted for each camera, keyed by its advertisement
 * name (`XTU_S7Pro_f9e5e2`).
 *
 * The phone invents the code and writes it into the camera, which shows it on its own
 * screen for someone to confirm — once. After that both sides hold the same code and
 * [com.rovecamlink.app.core.ble.XtuBleHandshake] uses it to open the hotspot directly,
 * with no offer and no confirmation. That is the difference between "pair once" and
 * "ask for a code every single time".
 */
interface PairingKeyStore {
    fun keyFor(cameraName: String): String?
    fun remember(cameraName: String, key: String)
    fun forget(cameraName: String)
}

/** expect factory; Android persists to SharedPreferences, others keep memory only. */
expect fun createPairingKeyStore(): PairingKeyStore

/** In-memory store, used by platforms without a persistence backend wired up yet. */
class MemoryPairingKeyStore : PairingKeyStore {
    private val keys = mutableMapOf<String, String>()
    override fun keyFor(cameraName: String): String? = keys[cameraName]
    override fun remember(cameraName: String, key: String) {
        keys[cameraName] = key
    }

    override fun forget(cameraName: String) {
        keys.remove(cameraName)
    }
}
