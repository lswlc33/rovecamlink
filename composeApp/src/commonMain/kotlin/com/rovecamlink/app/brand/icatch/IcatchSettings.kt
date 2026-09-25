package com.rovecamlink.app.brand.icatch

/**
 * The LyIC (Novatek) settings vocabulary — the `cmd=NNNN&par=K` value tables the
 * official app hardcodes, verbatim from the archive (03-idGoLive-档案.md §8) and
 * cross-checked against `_work/idgo_live_src/sources/com/icatch/golive/net/LyIC.java`
 * (`handleList3030`, LyIC.java:41-42) and `LdeviceSettingActivity.java:59-75`.
 *
 * A firmware may redefine the choice set for `2003/2011/8010/8011` through
 * `cmd=3031&str=all` (the official app overwrites its own tables with that answer);
 * the plugin consults [IcatchSettings.menuOptions] first and falls back to these
 * static tables. `2002` (recording resolution) has no static fallback here on
 * purpose: its options come from `cmd=3030` capability indices intersected with
 * the §8.1 table, which is exactly what `handleList3030` does.
 */
object IcatchSettings {

    /**
     * The §8.1 recording-resolution table: label ↔ firmware index for
     * `cmd=2002&par=<index>`. Order matters — it is the display order of the official
     * settings page.
     */
    val VIDEO_RESOLUTIONS = listOf(
        Option(value = "1", label = "2160p@30fps"),
        Option(value = "6", label = "1440p@30fps"),
        Option(value = "10", label = "1080p@60fps"),
        Option(value = "11", label = "1080p@30fps"),
        Option(value = "14", label = "720p@60fps"),
        Option(value = "15", label = "720p@30fps"),
    )

    /** §8.2 photo size: `cmd=1002&par=<K>` — note `par` is *inversely* related to pixels. */
    val PHOTO_SIZES = listOf(
        Option(value = "0", label = "12M"),
        Option(value = "1", label = "10M"),
        Option(value = "2", label = "8M"),
        Option(value = "3", label = "5M"),
    )

    /** §8.3 loop-clip length: `cmd=2003&par=<index>` (firmware may override via 3031). */
    val LOOP_LENGTHS = listOf(
        Option(value = "0", label = "OFF"),
        Option(value = "1", label = "1 MIN"),
        Option(value = "2", label = "3 MIN"),
        Option(value = "3", label = "5 MIN"),
    )

    /** §8.4 G-Sensor: `cmd=2011&par=0..4` (firmware may override via 3031). */
    val G_SENSOR = listOf(
        Option(value = "0", label = "Off"),
        Option(value = "1", label = "Low"),
        Option(value = "2", label = "Med"),
        Option(value = "3", label = "High"),
        Option(value = "4", label = "Max"),
    )

    /** §8.4 mic source: `cmd=8010&par=0|1` (firmware may override via 3031). */
    val MIC_SOURCE = listOf(
        Option(value = "0", label = "机身麦克风"),
        Option(value = "1", label = "耳机麦克风"),
    )

    /** §8.4 audio record: `cmd=8011&par=1|0` (firmware may override via 3031). */
    val AUDIO_RECORD = listOf(
        Option(value = "1", label = "ON"),
        Option(value = "0", label = "OFF"),
    )

    /** §8.4 WDR: `cmd=2004&par=1|0`. */
    val WDR = listOf(Option(value = "1", label = "ON"), Option(value = "0", label = "OFF"))

    /** §8.4 date watermark: `cmd=2008&par=1|0`. */
    val TIME_IMPRINT = listOf(Option(value = "1", label = "ON"), Option(value = "0", label = "OFF"))

    /** §8.4 lens rotation: `cmd=3044&par=1|0`. */
    val LENS_ROTATION = listOf(Option(value = "1", label = "ON"), Option(value = "0", label = "OFF"))

    /**
     * The fixed rows this plugin exposes for a LyIC device, in settings-page order.
     * `id` is the wire `cmd` number (what `setSetting` receives); current values are
     * filled in later from `cmd=3014`'s `Cmd/Status` pairs.
     */
    val LY_ITEMS: List<LyItem> = listOf(
        LyItem(cmd = "2002", title = "录像分辨率", options = { VIDEO_RESOLUTIONS }),
        LyItem(cmd = "2003", title = "循环录像", options = { LOOP_LENGTHS }),
        LyItem(cmd = "2004", title = "宽动态", options = { WDR }),
        LyItem(cmd = "2008", title = "日期水印", options = { TIME_IMPRINT }),
        LyItem(cmd = "2011", title = "碰撞感应", options = { G_SENSOR }),
        LyItem(cmd = "3044", title = "镜头旋转", options = { LENS_ROTATION }),
        LyItem(cmd = "8010", title = "录音来源", options = { MIC_SOURCE }),
        LyItem(cmd = "8011", title = "录音", options = { AUDIO_RECORD }),
    )

    /**
     * Which of the fixed rows a `cmd=3031&str=all` answer may redefine, mapped to the
     * static table used when the firmware did not speak up (XmlParseUtil keeps exactly
     * these four Cmds — `KNOWN_MENU_CMDS` minus `2002`, whose options come from 3030).
     */
    val MENU_OVERRIDABLE = setOf("2003", "2011", "8010", "8011")

    class LyItem(
        val cmd: String,
        val title: String,
        val options: () -> List<Option>,
    )

    data class Option(val value: String, val label: String)

    /**
     * Human label for one option value, or null when unknown (shown as the raw value).
     * [options] is the firmware-overridden table when present.
     */
    fun labelFor(options: List<Option>?, value: String): String? =
        options?.firstOrNull { it.value == value }?.label
}
