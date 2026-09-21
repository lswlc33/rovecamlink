package com.rovecamlink.app.brand.xtu

import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogFormat
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
