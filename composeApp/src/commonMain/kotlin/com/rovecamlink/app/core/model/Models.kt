package com.rovecamlink.app.core.model

import com.rovecamlink.app.Res
import com.rovecamlink.app.workmode_photo
import com.rovecamlink.app.workmode_playback
import com.rovecamlink.app.workmode_video
import org.jetbrains.compose.resources.StringResource

/**
 * Camera SoC / firmware platform families discovered while reverse-engineering
 * the official XTU GO and TUWIN apps. Each platform speaks a different wire
 * protocol, so the protocol layer is keyed on this enum. New platforms are added
 * here and paired with a [com.rovecamlink.app.core.protocol.CameraProtocol]
 * implementation + registration in the protocol registry.
 *
 * [displayName] 是技术/品牌标识(如 "Hisilicon CGI"),不随 UI 语言变化;
 * 它会作为参数注入到本地化的状态消息(如 "Connected · %1$s")。
 */
enum class DevicePlatform(val displayName: String) {
    /** Hisilicon Hi35xx – HTTP CGI at /cgi-bin/hi3510/<cmd>.cgi (XTU Hi-based cams, XTU S7/MINU2 are Ambarella). */
    HISILICON("Hisilicon CGI"),

    /** Ambarella – JSON-over-TCP/HTTP with {msg_id, rval} envelope. */
    AMBARELLA("Ambarella"),

    /** SigmaStar – proprietary socket protocol + BT heartbeat. */
    SIGMASTAR("SigmaStar"),

    /** TUWIN REST – `/api/...` JSON endpoints (Ride3Pro / Ride6). */
    TUWIN_REST("TUWIN REST"),

    /** TUWIN M3 – `/app/...` HTTP + read-chunk-as-frame TCP push (NOT delimiter-framed; that decoder is dead code upstream). */
    TUWIN_M3("TUWIN M3"),

    /** iCatch PTP-over-IP + HTTP `/app/...` records (idGoLive / XTU Mini1). Property-table + object-table model. */
    ICATCH("iCatch PTP"),

    UNKNOWN("Unknown"),
}

enum class Brand(val displayName: String) {
    XTU("XTU"),
    TUWIN("TUWIN"),
    ICATCH("iCatch"),
    GENERIC("Generic"),
}

/**
 * Work / capture mode. Hisilicon cams expose this via getcurworkmode / setworkmode.
 *
 * [displayNameRes] 指向本地化字符串资源(Video / 视频、Photo / 照片 等),
 * 在 Composable 中通过 `stringResource(mode.displayNameRes)` 解析。
 */
enum class WorkMode(val code: Int, val displayNameRes: StringResource) {
    VIDEO(0, Res.string.workmode_video),
    PHOTO(1, Res.string.workmode_photo),
    PLAYBACK(2, Res.string.workmode_playback),
    ;

    companion object {
        fun fromCode(code: Int): WorkMode? = entries.firstOrNull { it.code == code }
    }
}

/**
 * Which side of the shutter a firmware mode belongs to. [OTHER] covers a camera that
 * reports a mode the app has no family for; it is still selectable, because the
 * firmware's own list is the authority on what the camera can do.
 */
enum class ModeFamily { VIDEO, PHOTO, OTHER }

/**
 * What the capture button has to do in a given mode.
 *
 * [SINGLE] is one press, one result. [TOGGLE] modes run until they are told to stop
 * — the XTU/SigmaStar 延时拍照 and 定时拍照 families are started with
 * `photo.cgi?&-type=phototimelapse&-cmd=start` and only ended by the matching
 * `-cmd=stop`, so a button that always sends "start" leaves the camera taking frames
 * for minutes after the user thinks it stopped.
 */
enum class ModeTrigger { SINGLE, TOGGLE }

/**
 * One shooting mode, as the firmware names it. [name] is the exact wire value of
 * `-workmode=` (spacing included — `Normal Video` and `NormalVideo` are different
 * answers to a camera that rejects the wrong one with `SvrFuncResult="-2222"`), so
 * it is what must be sent back, never a re-derived spelling.
 */
data class CameraMode(
    val name: String,
    val family: ModeFamily,
    val trigger: ModeTrigger = ModeTrigger.SINGLE,
)

/**
 * The coarse family a [CameraMode] belongs to, for the code paths that still speak
 * [WorkMode] (a plugin with no mode table, or a status field that only says
 * "video-ish"). [OTHER] maps to photo so a control guarded on "photo mode" stays
 * conservative rather than firing a capture the camera would refuse.
 */
fun ModeFamily.workMode(): WorkMode = when (this) {
    ModeFamily.VIDEO -> WorkMode.VIDEO
    else -> WorkMode.PHOTO
}

enum class FileType { VIDEO, PHOTO, UNKNOWN }

/**
 * An established connection to a camera. Produced by
 * [com.rovecamlink.app.core.protocol.CameraProtocol.connect].
 */
data class CameraSession(
    val host: String,
    val port: Int,
    val platform: DevicePlatform,
    val brand: Brand,
    val model: String,
    val baseUrl: String = "http://$host:$port",
    /** Protocol-specific carried state (e.g. Hisilicon string work-mode, NewAPP flag). */
    val extras: Map<String, String> = emptyMap(),
)

/** SD-card health as reported by the camera (TUWIN's 9-state model collapsed to 4). */
enum class SdCardState { OK, MISSING, ERROR, UNKNOWN;

    companion object {
        /** Words that mean a healthy card, matched whole before any loose `contains` test. */
        private val OK_WORDS = setOf("OK", "SDOK", "SD_OK", "NORMAL", "SUCCESS")

        /** Words that mean no card is inserted. */
        private val MISSING_WORDS =
            setOf("NO", "NONE", "NOSD", "NO_SD", "SDNO", "ABSENT", "SD_ABSENT", "无", "无卡")

        /** Words that mean "not known yet"; whole-word, so `UNKNOWN` is not read as `NO` + … */
        private val UNKNOWN_WORDS = setOf("UNKNOWN", "UNKNOW", "NA", "N/A", "INVALID")

        /** Maps a firmware-reported state string (e.g. `SDOK`, `NOSD`) to the enum. */
        fun fromRaw(raw: String?): SdCardState {
            if (raw == null) return UNKNOWN
            val token = raw.trim().uppercase()
            if (token.isEmpty()) return UNKNOWN
            // Whole-word matches first: a loose `contains("NO")` reads `UNKNOWN` as MISSING.
            if (token in OK_WORDS) return OK
            if (token in MISSING_WORDS) return MISSING
            if (token in UNKNOWN_WORDS) return UNKNOWN
            // Loose fallback for compound answers like `SdState:SDOK` or `无存储卡`.
            return when {
                token.contains("OK") -> OK
                token.contains("NO") || token.contains("ABSENT") || raw.contains("无") -> MISSING
                else -> ERROR
            }
        }
    }
}

/** Live device state polled from the camera. */
data class DeviceStatus(
    val battery: Int? = null,
    val charging: Boolean? = null,
    val recording: Boolean = false,
    /**
     * The camera is working (state 20) but not recording — mid-capture, mode change
     * or startup. Controls must not fire, and saying "busy" is truer than saying
     * "idle" or falsely claiming "recording".
     */
    val busy: Boolean = false,
    val mode: WorkMode? = null,
    /** The firmware's own work-mode name, e.g. "Normal Video" / "Timelapse Photo". */
    val modeName: String? = null,
    /** Raw `getcurallinfo` work state (20 working / 21 standby) for diagnostics. */
    val workState: Int? = null,
    val sdTotalMb: Long? = null,
    val sdFreeMb: Long? = null,
    val sdState: SdCardState? = null,
    val videoTimeSec: Int? = null,
    val photoCount: Int? = null,
    val videoCount: Int? = null,
    /** Raw key/value pairs straight from the firmware for forward-compat. */
    val raw: Map<String, String> = emptyMap(),
)

/**
 * The Wi-Fi network the camera is itself broadcasting, read back from the camera.
 *
 * Its own type rather than two more [DeviceInfo] fields because one of them is a
 * passphrase: [DeviceInfo.raw] holds whatever the firmware answered and is echoed into
 * the diagnostics log, and a secret must not travel in a bag like that. Keeping it here
 * means there is exactly one place in the app that can print it, and `Diag`'s
 * `captureSecrets` switch is what decides whether it does.
 *
 * [password] is the clear-text key. That is not this app being careless — the camera
 * serves it over unauthenticated HTTP on its own hotspot, so anyone inside the network
 * can already read it; showing it to the person holding the camera is the strictly
 * smaller exposure, and it is the thing they asked for ("回读一下 WiFi 名称和 WiFi 密码
 * 进行展示"), because the alternative today is reading it off the camera's LCD menu.
 */
data class CameraWifi(
    val ssid: String,
    val password: String?,
    /** True when the camera reports this as a client network (STA) rather than its own AP. */
    val stationMode: Boolean = false,
)

/**
 * Static device identity for the About screen. Field names mirror what each
 * firmware reports (`softversion`/`swver`, `serialnum`/`uuid`, ...).
 */
data class DeviceInfo(
    val name: String? = null,
    val model: String? = null,
    val serialNumber: String? = null,
    val softVersion: String? = null,
    val hardVersion: String? = null,
    val region: String? = null,
    val mac: String? = null,
    val ssid: String? = null,
    val soc: String? = null,
    /** Raw key/value pairs straight from the firmware for forward-compat. */
    val raw: Map<String, String> = emptyMap(),
)

/**
 * A setting the user can change (resolution, bitrate, exposure, ...).
 *
 * [id] is the name the firmware knows (the `-name=` of `setcurparameter.cgi`), so
 * it must survive a UI relabel untouched. [title] is the firmware's own label; the
 * UI maps [id] through a catalog to get a translated title, an explanation and a
 * group, and falls back to [title] for items no catalog knows.
 */
data class CameraSetting(
    val id: String,
    val title: String,
    val value: String,
    val options: List<Option> = emptyList(),
) {
    data class Option(val value: String, val label: String)

    /** True when the firmware offers exactly two ON/OFF-ish choices: render as a switch. */
    val isToggle: Boolean
        get() {
            if (options.size != 2) return false
            val values = options.map { it.value.trim().uppercase() }.toSet()
            return TOGGLE_VALUE_PAIRS.any { it == values }
        }

    /** The value to send for switch position [on] on an [isToggle] setting. */
    fun toggleValue(on: Boolean): String {
        fun meansOn(v: String) = v.trim() == "1" || v.trim().equals("ON", ignoreCase = true)
        return (if (on) options.firstOrNull { meansOn(it.value) } else options.firstOrNull { !meansOn(it.value) })
            ?.value ?: options.getOrNull(if (on) 1 else 0)?.value ?: value
    }

    companion object {
        /** Value pairs that mean a switch: firmware `0`/`1` and firmware `ON`/`OFF`. */
        private val TOGGLE_VALUE_PAIRS = listOf(setOf("0", "1"), setOf("ON", "OFF"))
    }
}

data class RemoteFile(
    val name: String,
    val type: FileType,
    val sizeBytes: Long,
    val downloadUrl: String,
    val thumbnailUrl: String? = null,
    val dateMillis: Long? = null,
)

sealed interface CmdResult {
    data object Ok : CmdResult
    data class Failure(val message: String, val code: Int? = null) : CmdResult

    val isOk: Boolean get() = this is Ok
}

/** Push-style events from the device (recording started, file created, disconnected...). */
sealed interface DeviceEvent {
    data class RecordingChanged(val recording: Boolean) : DeviceEvent
    data class Disconnected(val reason: String) : DeviceEvent
    data class BatteryChanged(val percent: Int) : DeviceEvent
}

/** Page request for file listing. */
data class FilePage(val start: Int, val end: Int)
