package com.rovecamlink.app.core.update

import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogLevel
import com.rovecamlink.app.core.log.LogTag
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

/**
 * The GitHub Releases API, as the in-app updater's one data source.
 *
 * Everything the two channels need is already published by CI — the alpha workflow
 * creates one prerelease per push (`alpha-<timestamp>`, historically `nightly-`),
 * the release workflow creates the tagged stable (`vX.Y.Z`) — so the updater reads the
 * same surface the user browses, with no second place to publish and no server of our
 * own. One unauthenticated GET per check is the whole cost.
 *
 * The endpoints, verified against this repository on 2026-09-29:
 *  - `releases/latest` answers **404 while the only releases are prereleases** — that
 *    is what "no stable exists yet" looks like, and the channel page must say so
 *    rather than read it as an outage;
 *  - `releases?per_page=N` lists every release, newest first, prereleases included.
 */
object AppUpdateIndex {

    const val LATEST_ENDPOINT = "https://api.github.com/repos/lswlc33/rovecamlink/releases/latest"
    const val LIST_ENDPOINT = "https://api.github.com/repos/lswlc33/rovecamlink/releases?per_page=15"

    /**
     * Tags the alpha channel reads: today's `alpha-…` plus the `nightly-…` history the
     * rename left behind. One alternation so a stored check (or a test) can match the
     * same set this object's queries return.
     */
    val alphaTagPattern = Regex("^(alpha|nightly)-([0-9]{8}-[0-9]{6})$")

    /**
     * The timestamp half of an alpha tag — the part that makes two tags orderable.
     *
     * Comparing the *whole* tag string would put every `nightly-…` above every
     * `alpha-…` (`"n" > "a"`), which is exactly the wrong order the day after the
     * rename. Only the stamp compares; the prefix is the same channel under two names.
     */
    fun alphaStampOf(tag: String): String = alphaTagPattern.matchEntire(tag)?.groupValues?.get(2) ?: ""

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        explicitNulls = false
    }

    /** Stable channel: what `/releases/latest` describes, or that nothing is published. */
    fun parseStable(body: String?): AppRelease? {
        if (body.isNullOrBlank()) {
            Diag.warn(LogTag.UPDATE, "update index: empty body from releases/latest")
            return null
        }
        val release = runCatching { json.decodeFromString(GhRelease.serializer(), body) }.getOrElse {
            Diag.at(
                LogLevel.ERROR, LogTag.UPDATE,
                "update index: unparseable /latest body (${body.length} chars) ${Diag.causeChain(it)}",
            )
            return null
        }
        // A body that parses but names no tag is the API's error shape
        // (`{"message":"Not Found"}` — the 404 a stable-less repository answers), not a
        // release. Reporting it as one would put an empty row on the page.
        if (release.tagName.isBlank()) {
            Diag.info(LogTag.UPDATE, "update index: /latest carries no tag (no stable published, or an API error)")
            return null
        }
        return release.toAppRelease().also { r ->
            Diag.info(LogTag.UPDATE, "update index: stable is ${r.tagName} prerelease=${r.prerelease}")
        }
    }

    /**
     * Alpha channel: the newest `alpha-*` / `nightly-*` release in [body], or null when
     * the page carries none. The list is *newest first by created date*, not by tag, so
     * a re-run of an older workflow cannot put itself at the top on the strength of its
     * timestamp alone — but tags are `UTC timestamps to the second`, which makes the
     * string order the time order, and sorting on it is what keeps "newest" honest even
     * when the API's ordering and reality disagree (backfills, deleted-and-recreated
     * tags). A stable `v…` release in the page is simply not an alpha and is skipped.
     */
    fun parseAlpha(body: String?): AppRelease? {
        if (body.isNullOrBlank()) {
            Diag.warn(LogTag.UPDATE, "update index: empty body from releases list")
            return null
        }
        val releases = runCatching {
            json.decodeFromString(kotlinx.serialization.builtins.ListSerializer(GhRelease.serializer()), body)
        }.getOrElse {
            Diag.at(
                LogLevel.ERROR, LogTag.UPDATE,
                "update index: unparseable list body (${body.length} chars) ${Diag.causeChain(it)}",
            )
            return null
        }
        val newest = releases
            .filter { alphaTagPattern.matches(it.tagName) }
            .maxByOrNull { alphaStampOf(it.tagName) }
        if (newest == null) {
            Diag.info(LogTag.UPDATE, "update index: no alpha-tagged release among ${releases.size}")
            return null
        }
        return newest.toAppRelease().also { r ->
            Diag.info(LogTag.UPDATE, "update index: alpha head is ${r.tagName} (${r.assetCount} asset(s))")
        }
    }
}

/** One release, reduced to what the update page shows and acts on. */
data class AppRelease(
    val tagName: String,
    val name: String?,
    val prerelease: Boolean,
    val publishedAt: String?,
    val body: String?,
    /** The APK asset's browser URL, when the release carries exactly one. */
    val apkUrl: String?,
    val apkSizeBytes: Long,
) {
    /** The page's own link when there is nothing to hand the browser directly. */
    val openUrl: String get() = apkUrl ?: "https://github.com/lswlc33/rovecamlink/releases/tag/$tagName"
    val assetCount: Int get() = if (apkUrl == null) 0 else 1
}

@Serializable
private data class GhRelease(
    @SerialName("tag_name") val tagName: String = "",
    val name: String? = null,
    val prerelease: Boolean = false,
    @SerialName("published_at") val publishedAt: String? = null,
    val body: String? = null,
    val assets: List<GhAsset> = emptyList(),
    val message: String? = null,
) {
    fun toAppRelease(): AppRelease {
        val apk = assets.filter { it.name.endsWith(".apk") }
        // The workflows each publish exactly one APK; two would mean the release page is
        // hand-edited or a future workflow changed shape, and opening the page is the
        // honest move there — picking one of two blind is not.
        val chosen = apk.singleOrNull()
        return AppRelease(
            tagName = tagName,
            name = name,
            prerelease = prerelease,
            publishedAt = publishedAt,
            body = body,
            apkUrl = chosen?.browserDownloadUrl,
            apkSizeBytes = chosen?.size ?: 0L,
        )
    }
}

@Serializable
private data class GhAsset(
    val name: String = "",
    @SerialName("browser_download_url") val browserDownloadUrl: String = "",
    val size: Long = 0,
)

/**
 * The app's own semver (`0.1.3`), parsed just far enough to order two of them.
 *
 * A triple of ints rather than a string compare: `0.1.10` sorts after `0.1.9` numerically
 * and *before* it lexicographically, which is exactly the wrong answer on the one screen
 * whose whole job is to say "there is a newer one". Anything unparseable — a prerelease
 * suffix this repo does not use yet, a tag with no numbers at all — comes back null and
 * the caller shows the release rather than a verdict.
 */
data class AppVersion(val major: Int, val minor: Int, val patch: Int) : Comparable<AppVersion> {
    override fun compareTo(other: AppVersion): Int = compareValuesBy(
        this, other,
        { it.major }, { it.minor }, { it.patch },
    )

    companion object {
        fun parse(raw: String?): AppVersion? {
            val s = raw?.trim()?.ifEmpty { null } ?: return null
            val m = SEMVER.matchEntire(s) ?: return null
            return AppVersion(
                m.groupValues[1].toInt(),
                m.groupValues[2].toInt(),
                m.groupValues[3].toInt(),
            )
        }

        /** `X.Y.Z` with an optional `-suffix` kept out of the comparison. */
        private val SEMVER = Regex("""(\d+)\.(\d+)\.(\d+)(?:-[0-9A-Za-z.-]+)?""")
    }
}
