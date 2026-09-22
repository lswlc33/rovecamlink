package com.rovecamlink.app.core.ota

// iOS is a compile-along shell in this project (no device, no test path); the cloud
// update flow is Android-only for now.
actual suspend fun pickCameraFirmwarePackage(): FirmwarePackage? = null
