package com.rovecamlink.app.core.ota

// Android installs the package the vendor index supplied (FirmwareUpdater writes it to the app cache
// and the settings page offers it), so there is no SAF content-URI bridge here yet; the
// manual route remains desktop-only, see the expect doc for why.
actual suspend fun pickCameraFirmwarePackage(): FirmwarePackage? = null
