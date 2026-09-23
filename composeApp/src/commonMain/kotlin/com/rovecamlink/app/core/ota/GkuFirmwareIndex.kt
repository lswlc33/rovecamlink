package com.rovecamlink.app.core.ota

import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogFormat
import com.rovecamlink.app.core.log.LogLevel
import com.rovecamlink.app.core.log.LogTag
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

/**
 * The vendor's public firmware index, and the decisions we make from it.
 *
 * Checked against the live endpoint on 2026-09-23 (one read-only GET, the method
 * boundary `docs/05 §0` allows): `GET https://server4.gkuvision.com/v1/push/api/getNewestVersion`
 * answers **200 with no authentication and no custom headers at all** — this repo
 * previously recorded the official client's header set (`os: android`, `appVersionCode`,
 * a bare `Bearer`), and it turns out none of it is required; a plain GET returns the
 * same 2,475-byte body. So we send none of it: impersonating another app's version
 * string to buy nothing is exactly the kind of debt this project exists to avoid.
 *
 * The three query parameters are what the official device-management UI sends
 * (`_work/xtu_src/sources/com/gku/loginmodule/manage/DeviceVersionManager.java:150-211`),
 * where each is a comma-joined list because that screen checks every paired camera in
 * one call. One camera, one request is what `docs/05 §7` asks of us, so all three stay
 * single-valued here.
 *
 * Only the model is read from the camera. `getdeviceattr.cgi` on the 2026-09-21/22
 * field logs answers with exactly these keys — `name, serialnum, type, networkstatus,
 * softversion, bluetoothrxversion, hardversion, startdate, runtimes, model, timeout` —
 * and **no `region`, no hardware/PCB revision and no SSID**, so [DEFAULT_REGION] and
 * [DEFAULT_HARDWARE_VERSION] carry the values the official client itself falls back to
 * when those fields are empty (`DeviceVersionManager.java:184-196`).
 */
object GkuFirmwareIndex {

    /** Vendor firmware index. HTTPS only; there is no HTTP fallback on purpose. */
    const val ENDPOINT = "https://server4.gkuvision.com/v1/push/api/getNewestVersion"

    /** What `DeviceVersionManager` substitutes when the camera reports no region. */
    const val DEFAULT_REGION = "G"

    /** Ditto for the PCB/hardware revision (`pcbrevision` in the official code). */
    const val DEFAULT_HARDWARE_VERSION = "V1.0"

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        explicitNulls = false
    }

    /**
     * Turns the camera's own `name` into the `firm_ware_model` the index expects.
     *
     * The official client's only transformation is "remove every run of whitespace"
     * (`DeviceVersionManager.java:175` and `:242`, both `Regex("\\s+").replace(model, "")`),
     * which is what makes `XTU S7PRO` — one of only two model names in the whole XTU
     * table that contains a space — come out as `XTUS7PRO`, the string the index knows.
     *
     * Cutting at the first `-` is our addition and the one place this file deliberately
     * diverges from the vendor: the app keeps the device name as `"<model>-<suffix>"`
     * elsewhere (`HomeActivity.java:1765` does the same split for its own preference
     * key), and an index lookup with a suffix in it can only ever come back empty.
     */
    fun firmwareModelOf(cameraName: String?): String? {
        val base = cameraName?.trim()?.substringBefore('-')?.trim() ?: return null
        val model = base.replace(Regex("\\s+"), "")
        return model.ifEmpty { null }
    }

    /**
     * Build the request URL. Percent-encoding is hand-rolled rather than pulled from
     * ktor so this file stays usable from `commonTest` without a transport on the
     * classpath; the alphabet it emits is restricted to `[A-Za-z0-9._~-]` by [unescape]-safe
     * construction, and everything else — including the `,` the vendor uses to join
     * multiple devices — is escaped, so a hostile camera-supplied name cannot add a
     * parameter or a second list entry.
     */
    fun requestUrl(model: String, region: String, hardwareVersion: String): String =
        "$ENDPOINT?firm_ware_model=${encode(model)}&region=${encode(region)}&hardware_version=${encode(hardwareVersion)}"

    /**
     * Parse the index reply. Returns null when the body is not the shape we expect —
     * the caller turns that into "the update server did not answer", never into
     * "you are up to date", because those two feel identical on the screen and are not.
     */
    fun parse(body: String?, wantModel: String): List<FirmwareOffer> {
        if (body.isNullOrBlank()) {
            Diag.warn(LogTag.OTA, "firmware index: empty body")
            return emptyList()
        }
        val reply = runCatching { json.decodeFromString(GkuIndexReply.serializer(), body) }
            .getOrElse {
                Diag.at(
                    LogLevel.ERROR, LogTag.OTA,
                    "firmware index: unparseable body (${body.length} chars, " +
                        "starts=${LogFormat.safe(body.take(60))}) ${Diag.causeChain(it)}",
                )
                return emptyList()
            }
        if (reply.code != 0) {
            Diag.at(LogLevel.WARN, LogTag.OTA, "firmware index: code=${reply.code} msg=${reply.msg}")
            return emptyList()
        }
        val entries = reply.data?.list.orEmpty()
        if (entries.isEmpty()) {
            // Not an error. `XTUS7` and `XTUMAX3` are real models with no OTA at all
            // (docs/04 §5.1), so an empty list is the honest answer for them.
            Diag.info(LogTag.OTA, "firmware index: no entries for $wantModel")
            return emptyList()
        }
        // The request can list several models; match ours back, ignoring spaces the same
        // way the lookup key was built, so a server that answers `XTU S7PRO` still fits.
        val wanted = wantModel.replace(Regex("\\s+"), "").uppercase()
        val mine = entries.filter {
            it.firmWareModel?.replace(Regex("\\s+"), "")?.uppercase() == wanted
        }
        return (if (mine.isEmpty()) entries else mine).mapNotNull { entry ->
            val url = secureDownloadUrl(entry.fileUrl)
            if (entry.version.isNullOrBlank() || url == null) {
                Diag.at(
                    LogLevel.WARN, LogTag.OTA,
                    "firmware index: entry ${entry.version ?: "<no version>"} has no usable url",
                )
                return@mapNotNull null
            }
            FirmwareOffer(
                version = entry.version,
                downloadUrl = url,
                sizeBytes = entry.size.coerceAtLeast(0L),
                forced = entry.force,
                releasedAtEpochSeconds = entry.createTime,
                notes = entry.releaseNotes.orEmpty()
                    .mapNotNull { note ->
                        val text = note.content?.let(::plainText)?.ifEmpty { null } ?: return@mapNotNull null
                        ReleaseNote(note.lang?.trim()?.lowercase().orEmpty(), text)
                    },
                bareNote = entry.releaseNote?.let(::plainText)?.ifEmpty { null },
                model = entry.firmWareModel ?: wantModel,
                region = entry.region ?: DEFAULT_REGION,
                hardwareVersion = entry.hardwareVersion ?: DEFAULT_HARDWARE_VERSION,
            )
        }.sortedWith(compareBy(FirmwareOffer::normalized, FirmwareOffer::version))
    }

    /**
     * Force the package onto HTTPS.
     *
     * The live answer for S7PRO is `http://vidvault-asia.oss-cn-hangzhou.aliyuncs.com/system/…zip`
     * — the vendor ships a cleartext download URL for a binary that is about to become
     * the camera's operating system, which `docs/05` logs as defect C-2 on their side.
     * The same object is served over TLS (verified 2026-09-23: `HEAD https://…` returns
     * 200, `Content-Length: 54490165`, `Accept-Ranges: bytes`), so rewriting the scheme
     * costs nothing and removes the only step in the chain where the image could be
     * swapped on the way to the phone.
     *
     * Anything that is not an `http(s)` URL is refused rather than fetched: a
     * server-controlled path component becoming a client-side URL is the shape of the
     * bug we are fixing here, so the scheme is checked, not guessed.
     */
    fun secureDownloadUrl(raw: String?): String? {
        val url = raw?.trim()?.ifEmpty { null } ?: return null
        return when {
            url.startsWith("https://") -> url
            url.startsWith("http://") -> "https://" + url.removePrefix("http://")
            else -> {
                Diag.at(LogLevel.WARN, LogTag.OTA, "firmware index: refused non-http url ${LogFormat.safe(url.take(60))}")
                null
            }
        }
    }

    /**
     * HTML fragment → the lines the user actually reads. `<p>` becomes a line break and
     * every other tag is dropped, because the settings rows have no rich text to put them
     * in. Entities are left alone: `docs/08` shows the vendor's notes use plain prose,
     * and inventing an entity table is a guess at content we have not seen.
     */
    fun plainText(html: String): String = html
        .replace(Regex("(?i)</p>|<br\\s*/?>"), "\n")
        .replace(Regex("<[^>]*>"), "")
        .replace(Regex("[ \t]+"), " ")
        .split("\n")
        .map { it.trim() }
        .filter { it.isNotEmpty() }
        .joinToString("\n")

    /**
     * Decide what to tell the user.
     *
     * Comparison is on the normalized `yyyyMMdd` stamp, which `docs/04 §4` established as
     * the version truth for all three supported brands (`20.8.6.1.20260910` and
     * `XTUS7PRO_20.8.6.1.20260910.G` both yield `20260910`). Lexicographic on the
     * 8-digit string is the same as date order, which is why [FirmwareVersion] can be
     * this small.
     *
     * The vendor's own OTA path compares nothing (`docs/04 §0` conclusion 7: TUWIN will
     * happily install an equal or older build, and XTU leaves the decision to the cloud),
     * so both of those cases are decided explicitly here instead.
     */
    fun plan(installedRaw: String?, offers: List<FirmwareOffer>): UpdatePlan {
        val installed = FirmwareVersion.normalize(installedRaw)
        if (offers.isEmpty()) {
            return UpdatePlan.NoEntry(installedRaw?.trim()?.ifEmpty { null })
        }
        val newest = offers.last()
        if (installed == null) {
            return UpdatePlan.CannotCompare(installedRaw, newest)
        }
        val target = newest.normalized
        if (target == null) return UpdatePlan.CannotCompare(installedRaw, newest)
        return when {
            target > installed -> UpdatePlan.Available(installedRaw, newest)
            target == installed -> UpdatePlan.UpToDate(installedRaw)
            else -> UpdatePlan.NewerInstalled(installedRaw, newest)
        }
    }

    /** Minimal percent-encoding; see [requestUrl] for why it is hand-rolled. */
    private fun encode(value: String): String {
        val sb = StringBuilder(value.length)
        for (ch in value) {
            if (ch.isLetterOrDigit() || ch in ".-_" || ch == '~') sb.append(ch) else {
                for (byte in ch.toString().encodeToByteArray()) {
                    val v = byte.toInt() and 0xFF
                    sb.append('%').append(HEX[v shr 4]).append(HEX[v and 0x0F])
                }
            }
        }
        return sb.toString()
    }

    private const val HEX = "0123456789ABCDEF"
}

/** One firmware build, as the vendor's index describes it, reduced to what we act on. */
data class FirmwareOffer(
    val version: String,
    val downloadUrl: String,
    val sizeBytes: Long,
    val forced: Boolean,
    val releasedAtEpochSeconds: Long,
    /** Per-language release notes already stripped of HTML, as the index sent them. */
    val notes: List<ReleaseNote> = emptyList(),
    /** The index's single `release_note`; the S7PRO entries send it empty. */
    val bareNote: String? = null,
    val model: String,
    val region: String,
    val hardwareVersion: String,
) {
    /** The `yyyyMMdd` stamp this build really is, or null if it carries none. */
    val normalized: String? get() = FirmwareVersion.normalize(version)

    /** `<file name>` from the download URL — the name the camera sees in its header. */
    val fileName: String get() = downloadUrl.substringAfterLast('/').substringBefore('?').ifEmpty { "firmware.zip" }

    /**
     * The note to show for the UI's current [lang].
     *
     * Language is passed in rather than read here: the app resolves its own text through
     * Compose resources, and the core layer that fetched this offer cannot see which
     * locale the screen ended up rendering in.
     *
     * Exact match, then language-only prefix (`zh` answers `zh-cn`), then English, then
     * whatever arrived first, then the bare note — a note in the wrong language still
     * beats an empty row, and no note at all is a legitimate answer (`release_notes`
     * itself is optional in the vendor's own DTO).
     */
    fun releaseNoteFor(lang: String?): String? {
        val wanted = lang?.trim()?.lowercase().orEmpty()
        if (wanted.isNotEmpty()) {
            notes.firstOrNull { it.lang == wanted }?.let { return it.text }
            val base = wanted.substringBefore('-')
            notes.firstOrNull { it.lang.substringBefore('-') == base }?.let { return it.text }
        }
        return notes.firstOrNull { it.lang == "en" }?.text ?: notes.firstOrNull()?.text ?: bareNote
    }
}

/** One language of one build's release notes. */
data class ReleaseNote(val lang: String, val text: String)

/** What a check against the index concluded. */
sealed interface UpdatePlan {
    /** The camera's build, as the camera reported it (not normalized). */
    val installed: String?

    /** Nothing newer for this model, and the index does have entries for it. */
    data class UpToDate(override val installed: String?) : UpdatePlan

    /** The index knows a newer build. */
    data class Available(override val installed: String?, val offer: FirmwareOffer) : UpdatePlan

    /**
     * The index has no entry for this model at all. `XTUS7` and `XTUMAX3` are in that
     * group, so the UI must say "this camera has no published firmware", not
     * "you are up to date" — the first is a fact about the vendor, the second is a
     * promise we cannot keep.
     */
    data class NoEntry(override val installed: String?) : UpdatePlan

    /** The installed build is newer than anything published (a down-grade, or a beta). */
    data class NewerInstalled(override val installed: String?, val newest: FirmwareOffer) : UpdatePlan

    /** Either side lacks a comparable date stamp, so no ordering claim is honest. */
    data class CannotCompare(override val installed: String?, val offer: FirmwareOffer?) : UpdatePlan
}

// ---- the wire shape, verbatim from the vendor's field names ----
//
// `docs/04 §1.1` records that XTU's three generations of firmware API have mutually
// incompatible field names; this is the current generation
// (`loginmodule/model/GetDeviceNewestVersionResponse.java:8-143`). The vendor's own DTO
// declares eight fields and drops `size` and `create_time` even though they are in the
// body — we keep both, because `size` is the download integrity check the official
// client never performs.

@Serializable
internal data class GkuIndexReply(
    val code: Int = -1,
    val msg: String? = null,
    val data: GkuIndexData? = null,
)

@Serializable
internal data class GkuIndexData(
    val list: List<GkuFirmwareEntryDto>? = null,
)

@Serializable
internal data class GkuFirmwareEntryDto(
    @SerialName("firm_ware_model") val firmWareModel: String? = null,
    val version: String? = null,
    val region: String? = null,
    @SerialName("hardware_version") val hardwareVersion: String? = null,
    @SerialName("file_url") val fileUrl: String? = null,
    val force: Boolean = false,
    val size: Long = 0L,
    @SerialName("create_time") val createTime: Long = 0L,
    @SerialName("release_note") val releaseNote: String? = null,
    @SerialName("release_notes") val releaseNotes: List<GkuReleaseNoteDto>? = null,
)

@Serializable
data class GkuReleaseNoteDto(
    val lang: String? = null,
    val content: String? = null,
)
