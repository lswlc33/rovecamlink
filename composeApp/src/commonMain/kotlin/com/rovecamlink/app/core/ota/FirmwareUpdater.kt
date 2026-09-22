package com.rovecamlink.app.core.ota

import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogFormat
import com.rovecamlink.app.core.log.LogLevel
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.transport.CameraHttp
import com.rovecamlink.app.core.wifi.WifiController
import okio.FileSystem
import okio.Path

/**
 * The first two of the four halves of "firmware update" (`docs/04 §0`): ask the
 * vendor which build is current, then get its bytes onto the phone. Sending them to
 * the camera and reading the version back are the other two, and live in
 * [OtaCoordinator] and the per-brand [OtaTransport].
 *
 * Everything here runs on the phone's **internet** route, which is a real constraint
 * rather than a footnote: [WifiController] binds the process to the camera's hotspot so
 * an isolated AP cannot be shadowed by a VPN, and while that binding is up the vendor's
 * server is unreachable. [WifiController.withInternetRoute] is the window this class
 * opens, and it is why [check] and [download] take the whole flow rather than one
 * request — a second concurrent caller would put camera traffic on the internet route
 * and get nothing but timeouts.
 *
 * The HTTP itself rides [CameraHttp] rather than a second client: no new dependency
 * (CI cannot resolve one), and its logging, timeouts and streaming-to-disk are already
 * what this needs. The camera-lane machinery keyed by `host:port` simply gives the
 * vendor's host its own lane.
 */
class FirmwareUpdater(
    private val http: CameraHttp,
    private val wifi: WifiController,
    private val cacheDir: Path,
) {

    /**
     * Ask the index for [cameraName]'s model and compare it against [softVersion].
     *
     * One user action, one request — the shape `docs/05 §7` asks for. Enumerating
     * models against this endpoint is trivially easy (it is unauthenticated and the
     * model is whitespace-stripped device name), and doing it here would turn a
     * feature into a scanner.
     */
    suspend fun check(cameraName: String?, softVersion: String?): UpdatePlan {
        val model = GkuFirmwareIndex.firmwareModelOf(cameraName)
        if (model == null) {
            Diag.at(LogLevel.WARN, LogTag.OTA, "cannot look up firmware: the camera reported no model name")
            return UpdatePlan.CannotCompare(softVersion, null)
        }
        val url = GkuFirmwareIndex.requestUrl(
            model = model,
            region = GkuFirmwareIndex.DEFAULT_REGION,
            hardwareVersion = GkuFirmwareIndex.DEFAULT_HARDWARE_VERSION,
        )
        val body = wifi.withInternetRoute("firmware-check $model") { http.getText(url) }
        if (body == null) {
            // getText() swallows the reason; the counted HTTP line Diag already wrote
            // for this URL is the only place `DNS failure` and `403` differ, so say
            // which route we tried here instead of guessing at it later.
            Diag.at(
                LogLevel.ERROR, LogTag.OTA,
                "firmware index unreachable for $model — the phone had no internet route while the camera held the process binding",
            )
            return UpdatePlan.CannotCompare(softVersion, null)
        }
        val offers = GkuFirmwareIndex.parse(body, wantModel = model)
        val plan = GkuFirmwareIndex.plan(softVersion, offers)
        Diag.info(
            LogTag.OTA,
            "check $model installed=${softVersion ?: "-"} (${FirmwareVersion.normalize(softVersion) ?: "uncomparable"}) " +
                "published=${offers.size} -> ${plan::class.simpleName}",
        )
        return plan
    }

    /**
     * Fetch [offer] into the cache directory.
     *
     * Two things the vendor's own client never does, and both are free here: the URL is
     * forced onto HTTPS (`GkuFirmwareIndex.secureDownloadUrl`), and the byte count is
     * compared with the `size` the index already sent (`GetDeviceNewestVersionResponse`
     * has no such field, so the official app cannot — `docs/04 §5.2`). A truncated
     * package pushed to a camera is the bricking scenario, so a short body is reported
     * as a failure even though the transport calls it a completed transfer.
     *
     * A partial file left on disk is resumed with a `Range` request rather than
     * restarted: the object is 50 MB on a phone that may be on cellular, and the OSS
     * bucket was verified to answer `Accept-Ranges: bytes`.
     */
    suspend fun download(
        offer: FirmwareOffer,
        onProgress: (fraction: Float, done: Long, total: Long) -> Unit,
    ): PackageResult = wifi.withInternetRoute("firmware-download ${offer.fileName}") {
        val dest = cacheDir / safePackageName(offer.fileName)
        val fs = FileSystem.SYSTEM
        val already = runCatching { fs.metadata(dest).size }.getOrNull() ?: 0L
        // Only resume into something that is genuinely a prefix of this package. A
        // leftover from another build, or one that is already complete, restarts at 0.
        val resumable = already > 0L && (offer.sizeBytes <= 0L || already < offer.sizeBytes)
        if (already > 0L && !resumable) {
            Diag.info(LogTag.OTA, "${dest.name} already holds $already bytes; restarting from zero")
            runCatching { fs.delete(dest) }
        }
        val from = if (resumable) already else 0L
        Diag.info(
            LogTag.OTA,
            "downloading ${LogFormat.redactUrl(offer.downloadUrl)} size=${offer.sizeBytes}B resume_from=$from to=${dest.name}",
        )
        if (from > 0L) onProgress(fraction(from, offer.sizeBytes), from, offer.sizeBytes)
        val written = http.download(offer.downloadUrl, dest, from) { f ->
            onProgress(f.coerceIn(0f, 1f), (from + f * (offer.sizeBytes - from)).toLong(), offer.sizeBytes)
        }
        when {
            written < 0L -> PackageResult.Failed("下载中断，相机固件包没有完整取回（已保留 ${LogFormat.size(from)} 可续传）")
            offer.sizeBytes > 0L && written != offer.sizeBytes -> PackageResult.Failed(
                "固件包大小不符：收到 ${LogFormat.size(written)}，云端声明 ${LogFormat.size(offer.sizeBytes)}",
            )
            else -> {
                Diag.info(LogTag.OTA, "package ready ${dest.name} bytes=$written")
                PackageResult.Ready(dest, written)
            }
        }
    }

    /** Drop the cached package once it has been sent, or before re-fetching it. */
    fun discard(name: String) {
        val dest = cacheDir / safePackageName(name)
        val removed = runCatching {
            if (FileSystem.SYSTEM.exists(dest)) FileSystem.SYSTEM.delete(dest)
        }.isSuccess
        Diag.info(LogTag.OTA, "cached package ${dest.name} ${if (removed) "deleted" else "delete failed"}")
    }

    private fun fraction(done: Long, total: Long): Float =
        if (total <= 0L) 0f else (done.toFloat() / total.toFloat()).coerceIn(0f, 1f)

    companion object {
        /**
         * Keep a server-supplied file name inside the cache directory.
         *
         * The name is the last path segment of a URL the vendor controls, so it is
         * treated as untrusted input (`docs/05` C-3 is the vendor making exactly this
         * mistake on their side). Separators and traversal are removed, but **dots that
         * are part of a real name survive**: the extension is load-bearing here — the
         * camera is handed `XTUS7PRO_20.8.6.1.20260910.G.zip` verbatim by the official
         * client, and this app sends that same string in the 8080 header, so stripping
         * the `.zip` would be a change of protocol, not a hardening step.
         */
        fun safePackageName(raw: String): String {
            val base = raw.replace('\\', '/').substringAfterLast('/').trim()
            val allowed = base.filter { !it.isISOControl() && it != '/' && it != ':' }
            // Collapse every dot run to a single dot so ".." cannot survive as traversal,
            // then drop leading/trailing dots left over from that collapse.
            val collapsed = allowed.replace(Regex("\\.{2,}"), ".").trim('.')
            val name = if (collapsed.isBlank()) "firmware" else collapsed
            return name.take(80)
        }
    }
}

/** Outcome of fetching a package onto the phone. */
sealed interface PackageResult {
    data class Ready(val path: Path, val bytes: Long) : PackageResult
    data class Failed(val message: String) : PackageResult
}
