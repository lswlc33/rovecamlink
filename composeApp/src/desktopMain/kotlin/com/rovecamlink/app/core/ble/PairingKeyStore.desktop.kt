package com.rovecamlink.app.core.ble

/** Desktop has no persisted pairing codes; a restart means pairing again. */
actual fun createPairingKeyStore(): PairingKeyStore = MemoryPairingKeyStore()
