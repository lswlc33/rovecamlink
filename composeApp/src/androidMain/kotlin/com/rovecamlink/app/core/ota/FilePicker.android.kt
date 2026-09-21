package com.rovecamlink.app.core.ota

// Android firmware upload uses a content-URI picker bridged to the Activity; that
// bridge is not wired in this pass, so return null (flow still testable on desktop).
actual suspend fun pickCameraFirmwarePackage(): OtaPackage? = null