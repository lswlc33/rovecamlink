package com.rovecamlink.app.core.ble

/**
 * Desktop has no Bluetooth LE stack we can reach from shared Kotlin, so every
 * provisioning attempt reports [BleOutcome.Unsupported] and the app falls back to
 * Wi-Fi scanning / manual IP (which is also how the local simulator is used).
 */
private class UnsupportedBleCentral : BleCentral {
    override val isAvailable: Boolean get() = false
    override suspend fun ensurePermissions(): Boolean = false
    override fun isAdapterEnabled(): Boolean = false
    override suspend fun scan(
        profiles: List<BleCameraProfile>,
        timeoutMs: Long,
        onFound: (List<BleCamera>) -> Unit,
    ): List<BleCamera> = emptyList()

    override suspend fun wakeAndFetch(
        camera: BleCamera,
        profile: BleCameraProfile,
        pairingKey: String?,
        timeoutMs: Long,
    ): BleOutcome = BleOutcome.Unsupported

    override fun abort() {}
}

actual fun createBleCentral(): BleCentral = UnsupportedBleCentral()
