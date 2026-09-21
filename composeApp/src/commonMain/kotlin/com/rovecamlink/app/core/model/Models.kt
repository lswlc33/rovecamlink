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
    /** Opaque auth token / seed where the protocol requires one (TUWIN REST). */
    val authToken: String? = null,
    val baseUrl: String = "http://$host:$port",
    /** Protocol-specific carried state (e.g. Hisilicon string work-mode, NewAPP flag). */
    val extras: Map<String, String> = emptyMap(),
)

/** SD-card health as reported by the camera (TUWIN's 9-state model collapsed to 4). */
enum class SdCardState { OK, MISSING, ERROR, UNKNOWN;

    companion object {
        /** Maps a firmware-reported state string (e.g. `SDOK`, `NOSD`) to the enum. */
        fun fromRaw(raw: String?): SdCardState = when {
            raw == null -> UNKNOWN
            raw.contains("OK", ignoreCase = true) -> OK
            raw.contains("NO", ignoreCase = true) || raw.contains("NONE", ignoreCase = true) ||
                raw.contains("ABSENT", ignoreCase = true) || raw.contains("无", ignoreCase = true) -> MISSING
            raw.isBlank() -> UNKNOWN
            else -> ERROR
        }
    }
}

/** Live device state polled from the camera. */
data class DeviceStatus(
    val battery: Int? = null,
    val charging: Boolean? = null,
    val recording: Boolean = false,
    val mode: WorkMode? = null,
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

/** A setting the user can change (resolution, bitrate, exposure, ...). */
data class CameraSetting(
    val id: String,
    val title: String,
    val value: String,
    val options: List<Option> = emptyList(),
) {
    data class Option(val value: String, val label: String)
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
