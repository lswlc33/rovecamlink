package com.rovecamlink.app.core.ota

/**
 * Platform hook to let the user choose a firmware package from local storage.
 *
 * The second, manual entry into the same install flow the vendor cloud drives: the
 * card-update path every supported camera has and none of the official apps expose
 * (`docs/04 §6.1` R9) means a downloaded file should always be installable, and it is
 * the only route left when the index has nothing for the model.
 *
 * Desktop opens a file dialog; Android and iOS return null, because the cloud check
 * (`GkuFirmwareIndex` + `FirmwareUpdater`) already puts the package on disk for those
 * and a SAF content-URI bridge would be a second way to do one job.
 *
 * Implementations hand back a [FirmwarePackage] — a path and a length — and must not
 * read the file; see [FirmwarePackage] for why.
 */
expect suspend fun pickCameraFirmwarePackage(): FirmwarePackage?

/**
 * Whether this platform can be offered a "choose a file" button at all.
 *
 * The row exists so the install path can be exercised without the vendor cloud (and
 * stays the only route for a model the index has nothing for), but on Android and iOS
 * [pickCameraFirmwarePackage] answers null by design — so the button would be a dead
 * control, and a dead control in this app has to say why it is dead. Better to not
 * show it.
 */
expect val firmwareLocalPickerAvailable: Boolean
