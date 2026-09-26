package com.rovecamlink.app.core.net

/**
 * iOS keeps credentials in memory only. Joining the hotspot needs the
 * `NEHotspotConfiguration` entitlement (docs/analysis/ble-and-vpn §3.5), which is not in the shell
 * yet, so there is nothing for a persisted passphrase to unlock.
 */
actual fun createWifiCredentialStore(): WifiCredentialStore = MemoryWifiCredentialStore()
