package com.rovecamlink.app.core.prefs

/**
 * iOS keeps the values in memory only, matching the other stores in the shell (see
 * `CredentialStore.ios.kt`): the platform cannot reach a camera yet — joining the hotspot
 * needs the `NEHotspotConfiguration` entitlement (docs/analysis/ble-and-vpn §3.5) — so there is no
 * bookkeeping worth persisting until that lands.
 */
actual fun createAppPrefs(): AppPrefs = MemoryAppPrefs()
