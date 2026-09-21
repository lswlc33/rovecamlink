package com.rovecamlink.app.core.ota

/**
 * Platform hook to let the user choose a firmware package from local storage.
 * Desktop opens a file dialog; Android/iOS return null (not wired yet in this
 * pass — the flow is still fully testable on desktop against the simulator).
 */
expect suspend fun pickCameraFirmwarePackage(): OtaPackage?