package com.rovecamlink.app.core.media

import android.content.Context
import android.content.res.Configuration
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventCallback
import android.hardware.SensorManager
import android.view.Surface
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalView
import com.rovecamlink.app.androidContext
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogTag

/**
 * ~50 Hz, faster than SENSOR_DELAY_UI's 60 ms. The extra samples are cheap because
 * [updatedWith] is the only door to Compose: in the default mode they buy flip latency
 * (~20 ms rather than the hand getting there ~80 ms early), not extra frames.
 */
private const val SAMPLE_RATE_US = SensorManager.SENSOR_DELAY_GAME

/** The picture follows the phone and nothing else moves: see [rememberDeviceOrientation]. */
@Composable
actual fun rememberDeviceOrientation(
    mode: OrientationMode,
    enabled: Boolean,
): DeviceOrientation {
    // Re-seeded on a mode change, since a Free-mode angle is not a valid cardinal to
    // start hysteresising from and mixing the two would strand the picture mid-tilt.
    val state = remember(mode) { mutableStateOf(DeviceOrientation(0f, mode)) }
    val view = LocalView.current

    DisposableEffect(enabled, mode) {
        if (!enabled) {
            // Unsubscribed and re-seeded, not held: a screen that is composed but not on
            // screen has no business costing battery, and the angle it would have held is
            // one the user did not look at. The re-seed is also what makes `enabled` a
            // reset control — off and on again re-derives the picture from the next
            // sample, which is the escape hatch for a grip the snapper read wrong.
            state.value = DeviceOrientation(0f, mode)
            return@DisposableEffect onDispose { }
        }
        // runCatching: a Compose preview has no Application, and RoveCamApp fills its
        // lateinit context in onCreate.
        val manager = runCatching {
            androidContext.getSystemService(Context.SENSOR_SERVICE) as? SensorManager
        }.getOrNull()
        // Rotation vector first: gyro + magnetometer fusion gives a much steadier up
        // vector than raw gravity while someone walks. Neither sensor needs a runtime
        // permission, so unlike the QR scanner there is nothing to ask the user for.
        val sensor = manager?.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)
            ?: manager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        if (manager == null || sensor == null) {
            Diag.info(LogTag.PREV, "orientation: no usable sensor, picture stays at 0deg")
            return@DisposableEffect onDispose { }
        }

        val matrix = FloatArray(9)
        // SensorEventCallback, not SensorEventListener: it is delivered without the
        // shared-handler hop, which is the difference between the flip landing in the
        // hand movement that caused it and landing a frame or two later.
        val listener = object : SensorEventCallback() {
            override fun onSensorChanged(event: SensorEvent) {
                // Read once per sample: the canvas only turns when the system rotates the
                // activity, and asking the display twice is two chances to disagree.
                val canvas = view.canvasRollDegrees()
                val raw = when (event.sensor.type) {
                    Sensor.TYPE_ROTATION_VECTOR -> {
                        SensorManager.getRotationMatrixFromVector(matrix, event.values)
                        // Row 3 of R is world-up in device coordinates — R maps device to
                        // East-North-Up, so gravity (0, 0, -g) collapses onto that row and
                        // the g factor drops out in the normalisation.
                        rollDegreesFromUpVector(matrix[6], matrix[7], matrix[8], canvas)
                    }
                    // The accelerometer already reports the up direction (it reads the
                    // reaction to gravity), so both sensors feed one formula.
                    else -> rollDegreesFromUpVector(
                        event.values[0], event.values[1], event.values[2], canvas,
                    )
                }
                if (raw == null) return // near flat: hold whatever is on screen
                val published = state.value.updatedWith(raw) ?: return
                state.value = published
                Diag.info(
                    LogTag.PREV,
                    "picture -> ${published.degrees.toInt()}deg raw=${raw.toInt()}deg " +
                        "canvas=${canvas.toInt()}deg sensor=${sensor.name}",
                )
            }
        }
        manager.registerListener(listener, sensor, SAMPLE_RATE_US)
        onDispose { manager.unregisterListener(listener, sensor) }
    }

    return state.value
}

/**
 * How far the canvas has already turned along with the phone, in the same degrees
 * [rollDegreesFromUpVector] speaks: 0 when the UI is upright for the viewer, 90 when it
 * has been turned counter-clockwise, and so on.
 *
 * It is 0 for the build this feature is meant for — the request is a portrait-locked app
 * with only the picture rotating — but MainActivity does not lock `screenOrientation`
 * today, so with the system's auto-rotate on the canvas turns with the hand and the
 * picture would land upside down without subtracting this.
 *
 * [Configuration] decides whether the canvas is sideways at all — the same configuration
 * Compose's `LocalConfiguration` hands the layout. The display is only consulted for
 * *which* of the two sideways it is, and `Context.getDisplay()` is @Nullable — null in a
 * Compose preview and while a window tears down — so every unreadable case answers 0,
 * which is the one value that cannot be wrong in both directions at once.
 *
 * Field check for whoever reads the log: if the picture is exactly upside down in ONE of
 * the two landscape grips, this table is inverted — swap the two landscape rows.
 */
private fun View?.canvasRollDegrees(): Float {
    val context = this?.context ?: return 0f
    val configuration = context.resources?.configuration ?: return 0f
    if (configuration.orientation != Configuration.ORIENTATION_LANDSCAPE) return 0f
    val rotation = runCatching { context.display?.rotation }.getOrNull() ?: return 0f
    return when (rotation) {
        Surface.ROTATION_90 -> 270f
        Surface.ROTATION_180 -> 180f
        Surface.ROTATION_270 -> 90f
        else -> 0f
    }
}
