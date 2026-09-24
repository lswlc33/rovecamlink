package com.rovecamlink.app.core.model

import kotlin.time.Instant

/**
 * A canned device, for the UI test mode.
 *
 * The point is that every page has something real-shaped to draw without a camera on the
 * other end: the menu, the file list and the status line here are what an XTU S7PRO
 * answered in the 2026-09-21/22 field sessions, so a layout change can be looked at rather
 * than fielded. Item names are the firmware's own spelling — they are the keys
 * `MenuCatalog` labels by, and `UiTestDeviceTest` fails if one drifts.
 *
 * Nothing here is sent anywhere: with the mode on, the writes land in memory and in the
 * log, and the camera is never touched.
 */
object UiTestDevice {

    const val MODEL: String = "S7PRO (UI test)"

    fun session(): CameraSession = CameraSession(
        host = "ui.test",
        port = 80,
        platform = DevicePlatform.HISILICON,
        brand = Brand.XTU,
        model = MODEL,
        extras = mapOf("newapp" to "1", "softversion" to "20.8.6.1.20260710"),
    )

    /** [recording] and [seconds] move the status line so the shutter's states can be seen. */
    fun status(recording: Boolean = false, seconds: Int = 0): DeviceStatus = DeviceStatus(
        battery = 82,
        charging = false,
        recording = recording,
        busy = recording,
        mode = WorkMode.VIDEO,
        modeName = "Normal Video",
        workState = if (recording) 20 else 0,
        sdTotalMb = 122_064,
        sdFreeMb = 18_432,
        sdState = SdCardState.OK,
        videoTimeSec = if (recording) seconds else 0,
        photoCount = 4,
        videoCount = 3,
    )

    /** The shooting menu of the current mode, in the order the camera answers it. */
    fun settings(): List<CameraSetting> = listOf(
        setting("Resolution", "1080P60", "720P100", "1080P60", "2.7K30", "4K30"),
        setting("VideoEncode", "H265", "H264", "H265"),
        setting("Image Quality", "Normal", "Super", "Normal"),
        setting("Gyro EIS", "High", "OFF", "Low", "Middle", "High", "Super"),
        setting("LDC", "ON", "ON", "OFF"),
        setting("EIS Anti-Blur", "OFF", "ON", "OFF"),
        setting("Segment", "3Min", "1Min", "3Min", "5Min"),
        setting("Audio", "ON", "ON", "OFF"),
        setting("Pre-Recording", "OFF", "OFF", "30Sec", "60Sec"),
        setting("Meter Mode", "Average", "Average", "Center", "Spot"),
        // Descending, like the firmware's own list: the slider exists to turn this around.
        setting("Exposure", "-1", "+2", "+1.5", "+1", "+0.5", "0", "-0.5", "-1", "-1.5", "-2"),
        setting("Shutter", "Auto", "Auto", "1/60", "1/120", "1/240"),
        setting("ISO", "Auto", "Auto", "100", "200", "400", "800"),
        setting("AWB", "Auto", "Auto", "Daylight", "Cloudy", "Incandescent", "Fluorescent", "Shade"),
        setting("Scene Mode", "Auto", "Auto", "Landscape", "Portrait", "Night"),
        setting("Sharpness", "Normal", "Low", "Normal", "High"),
        setting("Filter", "Off", "Off", "BlackWhite", "Sepia", "Vivid"),
        setting("brightness", "0", "-2", "-1", "0", "1", "2"),
        setting("Contrast", "Normal", "Low", "Normal", "High"),
        setting("Saturation", "Normal", "Low", "Normal", "High"),
    )

    /** The `workmode=System` menu: network, power, sound, display, maintenance. */
    fun deviceSettings(): List<CameraSetting> = listOf(
        setting("WiFi Frequency", "2.4GHz", "2.4GHz", "5GHz"),
        setting("Wi-Fi", "ON", "ON", "OFF"),
        setting("Auto Dormant", "3Min", "OFF", "1Min", "3Min", "5Min"),
        setting("Auto Power Off", "5Min", "OFF", "1Min", "3Min", "5Min"),
        setting("Voice Volume", "Middle", "Low", "Middle", "High"),
        setting("Power Tone", "ON", "ON", "OFF"),
        setting("Key Tone", "OFF", "ON", "OFF"),
        setting("Cap Tone", "ON", "ON", "OFF"),
        setting("Voice Control", "ON", "ON", "OFF"),
        setting("SubScreen Display", "ON", "ON", "OFF"),
        setting("LEDs", "ON", "ON", "OFF"),
        setting("Date Stamp", "OFF", "ON", "OFF"),
        setting("Stamp", "ON", "ON", "OFF"),
        setting("Grid", "OFF", "ON", "OFF"),
        setting("Language", "zh", "zh", "en", "ja", "es"),
        setting("Video Format", "PAL", "NTSC", "PAL"),
        setting("Frequency", "50Hz", "50Hz", "60Hz"),
        setting("Quick-Start Switch", "ON", "ON", "OFF"),
        // The three action rows: the firmware pads `cur` with `-` for "nothing to show".
        CameraSetting("SD Format", "SD Format", "-"),
        CameraSetting("Factory Reset", "Factory Reset", "-"),
        CameraSetting("Information", "Information", "-"),
    )

    fun modes(): List<CameraMode> = listOf(
        CameraMode("Normal Video", ModeFamily.VIDEO),
        CameraMode("Car Looping", ModeFamily.VIDEO),
        CameraMode("Timelapse Video", ModeFamily.VIDEO),
        CameraMode("Slow Motion", ModeFamily.VIDEO),
        CameraMode("Normal Photo", ModeFamily.PHOTO, ModeTrigger.SINGLE),
        CameraMode("Timing Photo", ModeFamily.PHOTO, ModeTrigger.TOGGLE),
        CameraMode("Burst Photo", ModeFamily.PHOTO),
    )

    /**
     * Two days of captures, so the file page's date grouping has something to group.
     *
     * The URLs point at a canned tree served over HTTP rather than at the fake
     * `ui.test` host: `loadThumbnail` does not ride [runOp], so nothing upstream of
     * the transport stops it, and a `.THM` fetch against an unresolvable name just
     * fails. Pointing at a real server is what lets the gallery's grid cells draw
     * actual pictures in this mode. `10.0.2.2` is the emulator's view of the host;
     * `tools/fakecam/README.md` has the server that fills those paths.
     */
    fun files(): List<RemoteFile> {
        val root = "http://10.0.2.2:18080/DCIM"
        fun file(name: String, type: FileType, size: Long, stamp: String) = RemoteFile(
            name = name,
            type = type,
            sizeBytes = size,
            downloadUrl = "$root/$stamp/$name",
            thumbnailUrl = "$root/$stamp/${name.substringBeforeLast('.')}.THM",
            dateMillis = Instant.parse(isoUtc(stamp)).toEpochMilliseconds(),
        )
        return listOf(
            file("2026092114302200.MP4", FileType.VIDEO, 148_236_544, "20260921143022"),
            file("2026092114315500.JPG", FileType.PHOTO, 3_812_448, "20260921143155"),
            file("2026092118041100.MP4", FileType.VIDEO, 1_207_959_552, "20260921180411"),
            file("2026092209120300.JPG", FileType.PHOTO, 2_457_600, "20260922091203"),
            file("2026092209121900.JPG", FileType.PHOTO, 4_194_304, "20260922091219"),
            file("2026092219384700.MP4", FileType.VIDEO, 524_288_000, "20260922193847"),
        )
    }

    private fun setting(id: String, value: String, vararg options: String): CameraSetting =
        CameraSetting(
            id = id,
            title = id,
            value = value,
            options = options.map { CameraSetting.Option(it, it) },
        )

    /** `yyyyMMddHHmmss`, the shape the firmware's own file names carry, as a UTC instant. */
    private fun isoUtc(stamp: String): String =
        "${stamp.substring(0, 4)}-${stamp.substring(4, 6)}-${stamp.substring(6, 8)}" +
            "T${stamp.substring(8, 10)}:${stamp.substring(10, 12)}:${stamp.substring(12, 14)}Z"
}
