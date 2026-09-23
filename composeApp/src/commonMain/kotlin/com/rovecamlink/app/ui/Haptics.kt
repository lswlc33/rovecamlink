package com.rovecamlink.app.ui

import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.hapticfeedback.HapticFeedbackType

/**
 * The app's vibration vocabulary — four verbs, because a phone that buzzes the same way for
 * everything stops telling you anything.
 *
 * Compose's own [HapticFeedback] is the right layer for this rather than Android's
 * `Vibrator`: it needs no permission, the platform maps each type onto the user's own haptic
 * settings and intensity, and it is already a no-op on desktop and iOS — one call site, no
 * `expect`/`actual` and no platform branch. What it lacks is names that say *when* to use
 * them: `SegmentTick` describes the feel, not the moment. These do.
 *
 * Call sites read `LocalHapticFeedback.current.tap()` next to the click they belong to. A
 * haptic is for something the user did — never for something the app noticed on its own
 * (a poll failing, a camera going away), which is what the error banner is for.
 */

/** An ordinary press: a button, a tappable row, a dismissed notice. */
fun HapticFeedback.tap() = performHapticFeedback(HapticFeedbackType.ContextClick)

/** A selection moved between siblings: a tab, a filter, a chip in a row of chips. */
fun HapticFeedback.tick() = performHapticFeedback(HapticFeedbackType.SegmentTick)

/** A two-state control flipped: a switch, a favourite star. */
fun HapticFeedback.toggle() = performHapticFeedback(HapticFeedbackType.ToggleOn)

/** The affirmative half of a confirmation — the one that does the thing. */
fun HapticFeedback.confirm() = performHapticFeedback(HapticFeedbackType.Confirm)

/**
 * A press that is being held or that starts something with weight behind it: the shutter,
 * a long press.
 */
fun HapticFeedback.longPress() = performHapticFeedback(HapticFeedbackType.LongPress)
