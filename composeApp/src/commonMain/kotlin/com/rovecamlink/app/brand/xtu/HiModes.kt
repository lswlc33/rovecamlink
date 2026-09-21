package com.rovecamlink.app.brand.xtu

import com.rovecamlink.app.core.model.CameraMode
import com.rovecamlink.app.core.model.ModeFamily
import com.rovecamlink.app.core.model.ModeTrigger

/**
 * The shutter one firmware mode drives: which CGI under `/cgi-bin/hi3510/`, with
 * which query, and whether a second press is needed to end it.
 *
 * [stopQuery] is the whole difference between [ModeTrigger.SINGLE] and
 * [ModeTrigger.TOGGLE] — a mode is only ever labelled TOGGLE because this row
 * carries the request that stops it, which is what keeps
 * [com.rovecamlink.app.core.protocol.CameraProtocol.stopCapture] from being
 * called on a shutter that has no stop.
 */
data class CaptureShape(
    val endpoint: String,
    val startQuery: String,
    val stopQuery: String? = null,
) {
    val trigger: ModeTrigger get() = if (stopQuery == null) ModeTrigger.SINGLE else ModeTrigger.TOGGLE

    fun startUrl(base: String) = "$base/$endpoint$startQuery"

    /** The URL that ends this sequence, or null when one press is the whole capture. */
    fun stopUrl(base: String): String? = stopQuery?.let { "$base/$endpoint$it" }
}

/**
 * One shooting mode as the XTU/Hisilicon firmware names it, and what its shutter
 * does. [name] is the **verbatim** `-workmode=` value, spaces included: the
 * firmware compares strings and answers `SvrFuncResult="-2222"` to anything it
 * does not recognise, so `NormalPhoto` and `Normal Video` (no space, from the
 * legacy int-mode table) are rejected on a NewAPP camera that has both modes.
 *
 * This object is the single source of truth for three things that must never
 * disagree: which side of the shutter a mode is on (its
 * [com.rovecamlink.app.core.protocol.CameraProtocol.capture] CGI), whether it
 * needs a stop ([CaptureShape.trigger], hence [CameraMode.trigger]), and the
 * candidate list probed when `getallworkmode.cgi` does not answer.
 *
 * The rows and their spellings come from the official app's command table
 * (`hisilicon/dv/biz/Command.java:9-31` with the mode→index map of
 * `sigmastar/OldUi/preview/model/HaisiPreviewModel.java:340-394`), and the name
 * set is the union of `sigmastar/util/SSExchangeWorkMode.java:11-25` and
 * `hisilicon/dv/ui/config/CameraParameters.java:46-74`.
 */
object HiModes {

    /**
     * The pseudo work mode whose menu is the **device's** own settings — watermarks,
     * tones, grid, clock, SD format (`SSDeviceSettingActivity.java:48` and
     * `hisilicon/dv/ui/data/SetDataUtils.java:93` both send the literal `System`).
     */
    const val SYSTEM_WORKMODE = "System"

    /** The two names the firmware answers when nothing else is known about it. */
    const val NORMAL_VIDEO = "Normal Video"
    const val NORMAL_PHOTO = "Normal Photo"

    /** The firmware's answer to a name it does not have — see [Cgi.explain]. */
    const val UNKNOWN_NAME = "-2222"

    /**
     * Every video-family mode fires plain `record.cgi` on NewAPP firmware. The
     * official app does have per-video-type endpoints
     * (`record2.cgi?&-type=timelapse&-cmd=start`, …) but rewrites them all to the
     * plain pair as soon as the camera reports `hardversion=NewAPP`
     * (`HaisiCommandUtil.java:53-58`: `cmd % 2 == 0 ? 1 : 0`), so this app does the
     * same and [com.rovecamlink.app.brand.xtu.HisiliconProtocol.record] keeps being
     * the only place that talks to the video shutter. No `stopQuery` here on purpose:
     * the stop belongs to `record(start=false)`, not to [CaptureShape.trigger], which
     * describes the *capture* button.
     */
    val VIDEO_SHAPE = CaptureShape("record.cgi", "?&-cmd=start")

    /**
     * FIELD-TEST CONFLICT — resolve it against the camera, not from here.
     *
     * Two spellings of "take one picture" were recovered from the official app and
     * they are not the same request:
     *  - `?&-type=photo` — the legacy Hisilicon action table
     *    (`Command.java:31` index 2, sent by `HaisiPreviewModel.commandOperation`),
     *    and what this app sends on non-NewAPP firmware.
     *  - `?-type=photo&-cmd=start` — what `HaisiCommandUtil.java:168`
     *    (`startPhoto(type)`) builds for the NewAPP branch, **and the only spelling
     *    a 2026-09-21 field note recorded as actually producing a file on the
     *    XTU S7PRO** (firmware 20.8.6.1.20260710).
     *
     * Normal Photo keeps the field-proven second spelling because silently switching
     * it would cost a working shutter on the next build. The other single-shot photo
     * rows below carry the official first spelling ([PHOTO_SINGLE_OFFICIAL]), for
     * which this camera has never been tested. If the next field test says the
     * `?-type=…&-cmd=start` shape is the NewAPP rule generally, edit
     * [PHOTO_SINGLE_OFFICIAL] — every row built from it moves with it.
     */
    val PHOTO_SINGLE_NEWAPP = CaptureShape("photo.cgi", "?-type=photo&-cmd=start")
    val PHOTO_SINGLE_LEGACY = CaptureShape("photo.cgi", "?&-type=photo")

    /** `photoburst` takes the whole burst on one press, so it has no stop. */
    val BURST_PHOTO = CaptureShape("photo.cgi", "?&-type=photoburst")

    /** 定时拍照: runs until `-cmd=stop`. */
    val TIMING_PHOTO = CaptureShape("photo.cgi", "?&-type=phototimer&-cmd=start", "?&-type=phototimer&-cmd=stop")

    /** 延时拍照 (and the night-scene variant of it): runs until `-cmd=stop`. */
    val TIMELAPSE_PHOTO = CaptureShape(
        "photo.cgi",
        "?&-type=phototimelapse&-cmd=start",
        "?&-type=phototimelapse&-cmd=stop",
    )

    /** The single-shot `photo` type as the legacy table spells it. */
    private val PHOTO_SINGLE_OFFICIAL = CaptureShape("photo.cgi", "?&-type=photo")

    /**
     * The table. Order is the probe order of [videoCandidates] /
     * [photoCandidates], which is the order the official app lists them.
     */
    val specs: List<ModeSpec> = listOf(
        // ---- video family: the record button, never photo.cgi ----
        ModeSpec(NORMAL_VIDEO, ModeFamily.VIDEO, VIDEO_SHAPE),
        ModeSpec("Slow Motion", ModeFamily.VIDEO, VIDEO_SHAPE),
        ModeSpec("Timelapse Video", ModeFamily.VIDEO, VIDEO_SHAPE),
        ModeSpec("Car Looping", ModeFamily.VIDEO, VIDEO_SHAPE),
        ModeSpec("Quick Stories", ModeFamily.VIDEO, VIDEO_SHAPE),
        ModeSpec("Quick Video", ModeFamily.VIDEO, VIDEO_SHAPE),
        ModeSpec("Under Water", ModeFamily.VIDEO, VIDEO_SHAPE),
        ModeSpec("Video and Photo", ModeFamily.VIDEO, VIDEO_SHAPE),
        ModeSpec("Time Stretch", ModeFamily.VIDEO, VIDEO_SHAPE),
        ModeSpec("Manual Recsnap", ModeFamily.VIDEO, VIDEO_SHAPE),
        ModeSpec("Loop Video", ModeFamily.VIDEO, VIDEO_SHAPE),
        // ---- photo family, in the order the official app lists them ----
        ModeSpec(NORMAL_PHOTO, ModeFamily.PHOTO, PHOTO_SINGLE_NEWAPP),
        ModeSpec("Raw Photo", ModeFamily.PHOTO, PHOTO_SINGLE_OFFICIAL),
        ModeSpec("Burst Photo", ModeFamily.PHOTO, BURST_PHOTO),
        ModeSpec("Timing Photo", ModeFamily.PHOTO, TIMING_PHOTO),
        ModeSpec("Timelapse Photo", ModeFamily.PHOTO, TIMELAPSE_PHOTO),
        ModeSpec("Lapse Photo", ModeFamily.PHOTO, TIMELAPSE_PHOTO),
        ModeSpec("Long Exposure", ModeFamily.PHOTO, PHOTO_SINGLE_OFFICIAL),
        ModeSpec("Night Timelapse Photo", ModeFamily.PHOTO, TIMELAPSE_PHOTO),
        ModeSpec("Night Photo", ModeFamily.PHOTO, PHOTO_SINGLE_OFFICIAL),
        ModeSpec("Night Scene", ModeFamily.PHOTO, TIMELAPSE_PHOTO),
        ModeSpec("Lapse Burst", ModeFamily.PHOTO, PHOTO_SINGLE_OFFICIAL),
    )

    private val byName: Map<String, ModeSpec> = specs.associateBy { it.name }

    /** Video names probed when `getallworkmode.cgi` is silent, in official order. */
    val videoCandidates: List<String> = specs.filter { it.family == ModeFamily.VIDEO }.map { it.name }

    /** Photo names probed when `getallworkmode.cgi` is silent, in official order. */
    val photoCandidates: List<String> = specs.filter { it.family == ModeFamily.PHOTO }.map { it.name }

    /** Every candidate, family-tagged, video first: the exact probe order. */
    val candidates: List<Pair<ModeFamily, String>> =
        videoCandidates.map { ModeFamily.VIDEO to it } + photoCandidates.map { ModeFamily.PHOTO to it }

    /** The row for one firmware name, verbatim match only — a spelling is not close enough. */
    fun spec(name: String?): ModeSpec? = name?.let { byName[it] }

    /** The family a known name belongs to, null when this table has never seen it. */
    fun familyOf(name: String?): ModeFamily? = spec(name)?.family

    /**
     * The shutter for [name]. A VIDEO-family name always gets the video shutter,
     * whatever the table says, so no mode the firmware lists under `video` can ever
     * route to `photo.cgi`. An unknown photo name gets the plain single-shot form for
     * the firmware generation in use — one picture per press is the safe default for a
     * mode this app has not met.
     */
    fun shapeFor(name: String?, family: ModeFamily, newApp: Boolean): CaptureShape = when {
        family == ModeFamily.VIDEO -> VIDEO_SHAPE
        else -> spec(name)?.shape ?: if (newApp) PHOTO_SINGLE_NEWAPP else PHOTO_SINGLE_LEGACY
    }

    /**
     * A [CameraMode] whose `trigger` is read from the same row as its capture shape,
     * so a TOGGLE label and a single-shot shutter cannot coexist.
     *
     * [family] comes from the firmware's own list (`getallworkmode`'s `video` /
     * `photo` keys, or which candidate list a probe answered), because that list, not
     * this table, is the authority on what the camera can do.
     */
    fun modeFor(name: String, family: ModeFamily, newApp: Boolean = true): CameraMode =
        CameraMode(
            name = name,
            family = family,
            trigger = shapeFor(name, family, newApp).trigger,
        )

    /** A row of [specs]. */
    data class ModeSpec(val name: String, val family: ModeFamily, val shape: CaptureShape)
}
