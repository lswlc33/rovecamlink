package com.rovecamlink.app.core.net

/** Desktop has no persisted Wi-Fi credentials; a restart means typing it again. */
actual fun createWifiCredentialStore(): WifiCredentialStore = MemoryWifiCredentialStore()
