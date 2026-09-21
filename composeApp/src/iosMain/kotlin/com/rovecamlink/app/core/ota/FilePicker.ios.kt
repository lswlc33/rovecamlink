package com.rovecamlink.app.core.ota

// iOS firmware upload is not wired in this pass.
actual suspend fun pickCameraFirmwarePackage(): OtaPackage? = null