package com.rovecamlink.app.core.media

import androidx.compose.runtime.Composable

/**
 * iOS reports 0°: the picture never turns, exactly as it does on desktop.
 *
 * Everything except the samples is already in place — the snapping, the deadband and the
 * flat-device freeze live in `DeviceOrientation.kt` and are unit-tested — so an iOS
 * implementation is only "hand [rollDegreesFromUpVector] an up vector in device
 * coordinates at a sane rate", which `CMMotionManager.deviceMotion`'s `gravity` gives
 * directly (CoreMotion needs no permission prompt for it, unlike the camera).
 *
 * TODO(ios): drive CMMotionManager.deviceMotionUpdatesToQueue with an NSOperationQueue,
 * read `gravity.x/y/z`, and feed them in. Deliberately not written here: this repo has
 * twice shipped iOS `actual`s whose cinterop calls only resolved on the macOS nightly
 * (`0f9be5e` is the last fixup), there is no iOS device in the project to check axis
 * order or sign against, and the owner does not test iOS. An identity value is honest;
 * a wrong-axis guess would spin the preview.
 */
@Composable
actual fun rememberDeviceOrientation(
    mode: OrientationMode,
    enabled: Boolean,
): DeviceOrientation = DeviceOrientation(0f, mode)
