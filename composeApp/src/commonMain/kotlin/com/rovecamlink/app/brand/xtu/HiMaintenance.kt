package com.rovecamlink.app.brand.xtu

import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CameraWifi
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogFormat
import com.rovecamlink.app.core.log.LogLevel
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.ota.zeroPad
import com.rovecamlink.app.core.transport.CameraHttp
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

/**
 * The maintenance endpoints of the hi3510 CGI family, where HTTP 200 means
 * nothing on its own.
 *
 * Split out of [HisiliconProtocol] because all four share one property the app had
 * already been caught out by: these commands answer `200 OK` with a *refusal* in the
 * body (`Cgi.verdict`), and two of them answer 200 with a plain `Success` while
 * still telling you nothing happened — the verdict for those is a second variable in
 * the same body, so the caller has to look.
 */
internal class HiMaintenance(private val http: CameraHttp, private val cgi: (CameraSession) -> String) {

    /**
     * Format the card.
     *
     * `sdcommand.cgi?-format&-partition=1` is the request the official app makes
     * (`HaisiCommandUtil.java:150`, `RemoteFileManager.formatSdCard`), but what the
     * official app *trusts* is not the HTTP status nor the `Success` sentinel — it
     * parses the reply into a map and formats only if `sdstatus` came back as `1`
     * (`DV.java:634-641`, whose states `SSResponseParse.java:281-292` maps as
     * 1=normal, 3=full, 2/4=no card, anything else = error). Answering 200 without
     * that variable is how a camera with no card inserted reports "formatted".
     */
    suspend fun formatSd(session: CameraSession): CmdResult {
        val r = http.getText("${cgi(session)}/sdcommand.cgi?-format&-partition=1")
        val verdict = Cgi.verdict(r)
        if (verdict is CgiReply.Rejected) return refused("format", verdict)
        if (verdict is CgiReply.NoAnswer) return CmdResult.Failure("format SD failed (sdcommand.cgi did not answer)")
        val status = HiVarParser.parse(r)["sdstatus"]?.trim()
        return when (status) {
            SD_READY -> CmdResult.Ok
            SD_FULL -> refusedWith("format", "SD card is full — remove it or clear it before formatting")
            SD_MISSING_2, SD_MISSING_4 -> refusedWith("format", "No SD card in the camera — insert one and try again")
            null -> refusedWith("format", "camera did not report the card state (no sdstatus in the reply)")
            else -> refusedWith("format", "camera reported sdstatus=\"$status\" — the card did not accept the format")
        }
    }

    /**
     * Set the clock to the phone's local wall time.
     *
     * `setsystime.cgi?-time=yyyyMMddHHmmss` — the stamp is built the same way and
     * sent with **no timezone parameter**, byte-compatible with the official path
     * (`HaisiCommandUtil.java:156-158` builds the URL,
     * `HaisiPreviewModel.java:221` feeds it the local clock). There is no
     * read-back endpoint for the clock in this protocol — nothing answers "what time
     * do you have?" — so the body verdict is the only evidence of success this app
     * will ever get, and a camera that rebooted into a different zone cannot be
     * detected, only re-synced.
     */
    suspend fun syncTime(session: CameraSession): CmdResult {
        val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        val stamp = zeroPad(now.year, 4) + zeroPad(now.monthNumber, 2) + zeroPad(now.dayOfMonth, 2) +
            zeroPad(now.hour, 2) + zeroPad(now.minute, 2) + zeroPad(now.second, 2)
        Diag.i(LogTag.PROTO) { "setsystime cgi stamp=$stamp (device clock is the phone's local time)" }
        val r = http.getText("${cgi(session)}/setsystime.cgi?-time=$stamp")
        return when (val verdict = Cgi.verdict(r)) {
            is CgiReply.Accepted -> CmdResult.Ok
            is CgiReply.Rejected -> refused("setsystime", verdict)
            CgiReply.NoAnswer -> CmdResult.Failure("time sync failed (setsystime.cgi did not answer)")
        }
    }

    /**
     * Read the hotspot's name and passphrase back off the camera.
     *
     * `GET /cgi-bin/hi3510/getwifi.cgi` answers two variables, `wifissid` and
     * `wifikey` — the same pair `setwifi.cgi` takes. Field evidence that this is the
     * right endpoint and not one of the Wi-Fi neighbours: the official rename dialog is
     * populated from it (`SetDataUtils.getWifiInfor` at
     * `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:319-332`,
     * whose `BaseUrl` is set to `http://<ip>/cgi-bin/hi3510/` in `HomeActivity.java:1708`),
     * and it consumes exactly those two keys —
     * `if (tempMap.containsKey("wifissid") && tempMap.containsKey("wifikey"))`
     * (`SetDataUIUtils.java:306-312`), as does the SigmaStar-side parser
     * (`SSResponseParse.parseGetWiFi`, `:467-485`, `new SSWiFiInfo(map.get("wifissid"), map.get("wifikey"))`).
     *
     * Both the name and the key come back in the clear, which is the camera's design
     * rather than an accident: the endpoint sits on an unauthenticated HTTP server that
     * every client inside the hotspot can reach. `wifikey` is therefore only ever
     * written to the log when `Diag.config.captureSecrets` is on.
     *
     * A missing `wifissid` is reported as "this camera will not say", not as an empty
     * name — the difference decides whether the UI offers to overwrite the hotspot with
     * a blank one.
     */
    suspend fun getWifi(session: CameraSession): CameraWifi? {
        val url = "${cgi(session)}/getwifi.cgi"
        val body = http.getText(url)
        val vars = HiVarParser.parse(body)
        val ssid = vars["wifissid"]?.trim()?.ifEmpty { null }
        if (ssid == null) {
            Diag.at(
                LogLevel.WARN, LogTag.PROTO,
                "getwifi: no wifissid in reply (body=${LogFormat.bodyField(body, Diag.config.captureSecrets)} chars=${body?.length ?: "null"})",
            )
            return null
        }
        val key = vars["wifikey"]?.trim()?.ifEmpty { null }
        Diag.info(
            LogTag.PROTO,
            "getwifi ssid=${LogFormat.safe(ssid)} keylen=${key?.length ?: 0} " +
                "key=${if (Diag.config.captureSecrets) LogFormat.safe(key) else "<redacted>"}",
        )
        return CameraWifi(ssid = ssid, password = key)
    }

    /**
     * Rename the camera's own hotspot.
     *
     * The official rename rule the camera enforces: the SSID keeps its **exact
     * length**. `SetDataUIUtils.java:383-401` refuses the dialog unless the typed
     * name is exactly `SSID_TITLE_Length` characters, and then builds the new network
     * name by substituting the editable prefix inside the *current* SSID
     * (`SSID.replace(SSID_title, string)`) — the trailing device suffix stays, so
     * only a same-width name can round-trip. Send a shorter or longer one and the
     * camera either refuses it or produces a name whose suffix is clipped, and the
     * phone can no longer recognise its own access point.
     */
    suspend fun setWifi(session: CameraSession, ssid: String, password: String): CmdResult {
        val url = "${cgi(session)}/setwifi.cgi?&-wifissid=${Cgi.param(ssid)}&-wifikey=${Cgi.param(password)}"
        Diag.i(LogTag.PROTO) {
            "setwifi ssid=${LogFormat.safe(ssid)} len=${ssid.length} keylen=${password.length} " +
                "(value redacted unless secrets capture is on; the camera expects an unchanged SSID length)"
        }
        val r = http.getText(url)
        return when (val verdict = Cgi.verdict(r)) {
            is CgiReply.Accepted -> CmdResult.Ok
            is CgiReply.Rejected -> refused("setwifi", verdict)
            CgiReply.NoAnswer -> CmdResult.Failure("setwifi failed (setwifi.cgi did not answer)")
        }
    }

    /**
     * The hotspot's channel — `getwifichannel.cgi`, key `wifichannel`, read with
     * `doForIntByKey` (`Setting.java:522`). Null when the firmware does not answer, so a
     * camera without the endpoint shows nothing rather than a fabricated 0.
     */
    suspend fun getWifiChannel(session: CameraSession): Int? {
        val body = http.getText("${cgi(session)}/getwifichannel.cgi?")
        return HiVarParser.parse(body)["wifichannel"]?.toIntOrNull()
    }

    /**
     * Move the hotspot to [channel] — `setwifichannel.cgi?&-wifichannel=%d`
     * (`Setting.java:526`). The archive records the parameter and its type but not the
     * value set the firmware accepts, so the UI offers the standard channel numbers and
     * lets the camera refuse what it will not take.
     */
    suspend fun setWifiChannel(session: CameraSession, channel: Int): CmdResult {
        val url = "${cgi(session)}/setwifichannel.cgi?&-wifichannel=$channel"
        Diag.i(LogTag.PROTO) { "setwifichannel -> $channel" }
        val r = http.getText(url)
        return when (val verdict = Cgi.verdict(r)) {
            is CgiReply.Accepted -> CmdResult.Ok
            is CgiReply.Rejected -> refused("setwifichannel", verdict)
            CgiReply.NoAnswer -> CmdResult.Failure("setwifichannel failed (setwifichannel.cgi did not answer)")
        }
    }

    /**
     * Raise the camera's hotspot again, without Bluetooth.
     *
     * `GET http://<ip>/cgi-bin/setwifista.cgi?` — bare, and **not** under
     * `/cgi-bin/hi3510/` (`Common.ICGI_PATH`, `Common.java:61`). The official client
     * calls it the moment the Wi-Fi drops (`Setting.setWifiToAp`, `Setting.java:325-327`
     * via `HiWifiScrollView.java:147`) to pull the camera out of STA mode and back into
     * being an access point.
     *
     * It cannot help a camera that is switched off or not on the network at all — that
     * is what Bluetooth is for, since the radio has to answer before any IP exists.
     * But "the camera was reachable and stopped broadcasting" is the other half of the
     * field complaint, and this is the one command that fixes it.
     */
    suspend fun raiseAccessPoint(session: CameraSession): CmdResult {
        val base = cgi(session).removeSuffix("/hi3510").substringBeforeLast("/cgi-bin")
        val url = "$base/cgi-bin/setwifista.cgi?"
        Diag.info(LogTag.PROTO, "setwifista (raise AP, no args) -> $url")
        val r = http.getText(url)
        return when (val verdict = Cgi.verdict(r)) {
            is CgiReply.Accepted -> CmdResult.Ok
            is CgiReply.Rejected -> refused("setwifista", verdict)
            CgiReply.NoAnswer -> CmdResult.Failure("相机没有回应热点命令（setwifista.cgi）")
        }
    }

    /**
     * What the firmware says it can do — `getdevcapabilities.cgi?`, key
     * `devcapabilities` (`Setting.java:529-531`).
     *
     * One comma-separated string. The official client reads exactly one token out of
     * it — `DV.supportWakeSleep()` looks for `standby` (`DV.java:736-743`) — but the
     * whole set comes back here, because "which tokens does this firmware actually
     * emit" is not something this app can answer from the archive alone. An empty set
     * is "no answer" (older firmware, or the read failed), never "nothing supported".
     */
    suspend fun devCapabilities(session: CameraSession): Set<String> {
        val body = http.getText("${cgi(session)}/getdevcapabilities.cgi?")
        val raw = HiVarParser.parse(body)["devcapabilities"]
        val tokens = splitTokens(raw)
        Diag.info(
            LogTag.PROTO,
            "getdevcapabilities -> ${if (raw == null) "no key" else "${tokens.size} token(s)"}" +
                if (tokens.isEmpty()) "" else " [${tokens.joinToString(",")}]",
        )
        return tokens
    }

    /**
     * The accepted values for one setting, as the camera itself reports them —
     * `getcapability.cgi?&-workmode=%d&-type=%d`, key `capability`
     * (`Setting.java:541-543`).
     *
     * The reply is one comma-separated string, which the official client splits on `,`
     * before comparing it against the current parameter (`DV.java:200`). Empty means
     * the camera declined, the endpoint is absent, or the firmware is NewAPP — the
     * official client skips this call entirely there (`DV.getCapability` returns null)
     * because the self-describing menu already carries the values.
     */
    suspend fun capabilities(session: CameraSession, workMode: Int, configType: Int): List<String> {
        val url = "${cgi(session)}/getcapability.cgi?&-workmode=$workMode&-type=$configType"
        val body = http.getText(url)
        val raw = HiVarParser.parse(body)["capability"]
        val values = splitTokens(raw).toList()
        Diag.debug(
            LogTag.PROTO,
            "getcapability workmode=$workMode type=$configType -> " +
                if (values.isEmpty()) "no values" else "${values.size} value(s) [${values.joinToString(",")}]",
        )
        return values
    }

    /**
     * Standby — `wifisleep.cgi?` with no arguments (`Setting.java:463-465`).
     *
     * The camera is expected to drop off the network rather than answer, so the reply
     * is best-effort: a refusal is reported, but a missing answer is not treated as a
     * failure (the official client's `doForSuccess` cannot tell the two apart either,
     * since the socket usually dies mid-exchange). The caller must gate this on the
     * `standby` capability — a camera without it ignores the command, and this call
     * cannot detect that on its own.
     */
    suspend fun sleep(session: CameraSession): CmdResult {
        Diag.info(LogTag.PROTO, "wifisleep (standby) — the camera is expected to leave the network")
        val r = http.getText("${cgi(session)}/wifisleep.cgi?")
        return when (val verdict = Cgi.verdict(r)) {
            is CgiReply.Accepted -> CmdResult.Ok
            is CgiReply.Rejected -> refused("wifisleep", verdict)
            CgiReply.NoAnswer -> CmdResult.Ok
        }
    }

    /** One comma-separated firmware string into tokens, dropping blanks. */
    private fun splitTokens(raw: String?): Set<String> =
        raw?.split(',')?.map { it.trim() }?.filter { it.isNotEmpty() }?.toSet().orEmpty()

    private suspend fun refused(endpoint: String, verdict: CgiReply.Rejected): CmdResult.Failure {
        val detail = Cgi.explain(verdict.code)
        Diag.w(LogTag.PROTO) { "$endpoint refused: code=${verdict.code} — $detail (body=${LogFormat.bodyField(verdict.body, Diag.config.captureSecrets)})" }
        return CmdResult.Failure("$endpoint: $detail")
    }

    private fun refusedWith(endpoint: String, detail: String): CmdResult.Failure {
        Diag.warn(LogTag.PROTO, "$endpoint refused: $detail")
        return CmdResult.Failure("$endpoint: $detail")
    }

    private companion object {
        /** `sdstatus` values, per `SSResponseParse.parseGetSdCardInfo`. */
        const val SD_READY = "1"
        const val SD_FULL = "3"
        const val SD_MISSING_2 = "2"
        const val SD_MISSING_4 = "4"
    }
}
