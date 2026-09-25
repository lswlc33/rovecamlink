package com.rovecamlink.app.core.model

import com.rovecamlink.app.Res
import com.rovecamlink.app.live_bitrate_high
import com.rovecamlink.app.live_bitrate_smooth
import com.rovecamlink.app.live_blocker_no_network
import com.rovecamlink.app.live_blocker_no_url
import com.rovecamlink.app.live_blocker_not_rtmp
import com.rovecamlink.app.live_fps_25
import com.rovecamlink.app.live_fps_30
import com.rovecamlink.app.live_res_1080
import com.rovecamlink.app.live_res_720
import org.jetbrains.compose.resources.StringResource

/**
 * Everything a camera needs before it can push an RTMP stream **by itself**.
 *
 * The camera is the RTMP client, not this app: the official client hands it a Wi-Fi
 * network to join and an RTMP URL to push to, then shows a timer while the camera does
 * the work (`docs/08-官方APK全量逆向档案/02-XTUGO-档案.md` §10.4-10.5, and
 * `BroadcastDouyinFragment3.java:247-302` for the whole hand-off). So a config is
 * exactly the set of fields that travel in the one payload the firmware takes:
 *
 * ```
 * ssid:<ssid>;pwd:<pwd>;live_type:<type>;res:<res>;fps:<fps>;rtmp_url:<url>;
 * ```
 *
 * (`TCPClient.format`, `_work/xtu_src/sources/com/gku/actioncam/amba/ui/stream/TCPClient.java:26-28`;
 * the BLE variant carries the same four parameters under `live_type:...` — see
 * `BLEConnectUtils.java:285`.)
 *
 * The option sets are the vendor's own, all four of them read off the custom-RTMP screen
 * the vendor app ships (`BroadcastRTMPFragment2.java:318-348`): 720/1080, 25/30, and a
 * bitrate that is only ever "0 = 流畅优先 / 1 = 画质优先" — a flag, not a number of kbps,
 * which is why the firmware call sites use `%d` where every other parameter is `%s`.
 *
 * [password] may be empty: the vendor UI demands one (`SelectLiveWifiActivity` answers
 * 请选择可用的Wi-Fi密码), but an open network is a real case the payload's `pwd:;`
 * expresses fine, and refusing it here would block that case for no reason.
 */
data class LiveConfig(
    /** The Wi-Fi the camera should join before it pushes — not the phone's own hotspot. */
    val ssid: String = "",
    val password: String = "",
    /** The full RTMP URL, credentials and stream key included, as the platform gave it. */
    val rtmpUrl: String = "",
    val resolution: LiveResolution = LiveResolution.R1080,
    val fps: LiveFps = LiveFps.F30,
    val bitrate: LiveBitrate = LiveBitrate.Smooth,
    /**
     * `live_type` on the wire. The vendor app always sends `tiktokCN` here, including on
     * its "custom RTMP / any platform" screen (`BroadcastRTMPFragment2.java:354`), so it
     * is a protocol slot rather than a platform name.
     */
    val liveType: String = DEFAULT_LIVE_TYPE,
) {
    /** What is missing before this can be handed to a camera, or null when nothing is. */
    val blocker: LiveBlocker?
        get() = when {
            ssid.isBlank() -> LiveBlocker.NoNetwork
            // The vendor's own gate is `url.startsWith("rtmp")` on a non-null check
            // (`CustomLiveActivity.isLivePrepared`, `:105-121`); the blank case is folded
            // in so an empty field reads as 未填写 rather than as a malformed URL
            // (`not_set_rtmp` = 未填写RTMP地址).
            rtmpUrl.isBlank() -> LiveBlocker.NoUrl
            !rtmpUrl.startsWith("rtmp", ignoreCase = true) -> LiveBlocker.NotRtmp
            else -> null
        }

    val isSendable: Boolean get() = blocker == null

    companion object {
        const val DEFAULT_LIVE_TYPE = "tiktokCN"
    }
}

/** Why a [LiveConfig] cannot be sent yet, as a message the UI can show in place. */
enum class LiveBlocker(val reasonRes: StringResource) {
    NoNetwork(Res.string.live_blocker_no_network),
    NoUrl(Res.string.live_blocker_no_url),
    NotRtmp(Res.string.live_blocker_not_rtmp),
}

/** 720P / 1080P — the `res` field, which travels as a **string** in the payload. */
enum class LiveResolution(val wire: String, val displayNameRes: StringResource) {
    R720("720", Res.string.live_res_720),
    R1080("1080", Res.string.live_res_1080),
    ;

    companion object {
        fun fromWire(raw: String?): LiveResolution? = entries.firstOrNull { it.wire == raw?.trim() }
    }
}

/** 25 / 30 — the `fps` field, also a string on the wire. */
enum class LiveFps(val wire: String, val displayNameRes: StringResource) {
    F25("25", Res.string.live_fps_25),
    F30("30", Res.string.live_fps_30),
    ;

    companion object {
        fun fromWire(raw: String?): LiveFps? = entries.firstOrNull { it.wire == raw?.trim() }
    }
}

/**
 * 流畅优先 / 画质优先 — the `bitrate` field, and the one parameter the payload formats with
 * `%d`: the vendor app sends `0` or `1`, never a kbps figure
 * (`BroadcastRTMPFragment2.java:348,355`).
 */
enum class LiveBitrate(val wire: Int, val displayNameRes: StringResource) {
    Smooth(0, Res.string.live_bitrate_smooth),
    High(1, Res.string.live_bitrate_high),
    ;

    companion object {
        fun fromWire(raw: Int?): LiveBitrate? = entries.firstOrNull { it.wire == raw }
    }
}
