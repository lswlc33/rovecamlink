package com.rovecamlink.app.core.ble

/**
 * iOS pairing-code persistence is not wired up yet (it needs a real Keychain or
 * `NSUserDefaults` actual, and iOS cannot provision without the hotspot
 * entitlement anyway — see docs/07 §3.5). Memory-only keeps the shell honest.
 */
actual fun createPairingKeyStore(): PairingKeyStore = MemoryPairingKeyStore()
