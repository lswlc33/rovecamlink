package com.rovecamlink.app.core.ble

/**
 * iOS Bluetooth LE scaffold. The real implementation needs CoreBluetooth
 * (`CBCentralManager` + a GATT write per command) and, to actually join the
 * hotspot the camera reports, the `NEHotspotConfiguration` entitlement — see
 * docs/analysis/ble-and-vpn §3.5. Until then this keeps shared code compiling and the UI honest:
 * [BleOutcome.Unsupported] makes the app fall back to "join in Settings, then
 * we adopt that network".
 */
private class UnimplementedBleCentral : BleCentral {
    override val isAvailable: Boolean get() = false
    override suspend fun ensurePermissions(): Boolean = false
    override fun isAdapterEnabled(): Boolean = false
    override fun startScan(profiles: List<BleCameraProfile>): Boolean = false
    override fun scannedCameras(): List<BleCamera> = emptyList()
    override fun stopScan() {}
    override fun clearScanResults() {}

    override suspend fun wakeAndFetch(
        camera: BleCamera,
        profile: BleCameraProfile,
        pairingKey: String?,
        timeoutMs: Long,
    ): BleOutcome = BleOutcome.Unsupported

    override fun abort() {}
}

actual fun createBleCentral(): BleCentral = UnimplementedBleCentral()
