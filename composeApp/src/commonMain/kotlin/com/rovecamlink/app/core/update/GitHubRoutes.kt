package com.rovecamlink.app.core.update

import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogFormat
import com.rovecamlink.app.core.log.LogTag

/**
 * How the updater reaches GitHub, and what happens when the direct route does not.
 *
 * GitHub is unreachable from some networks without help (TLS handshake to
 * `api.github.com`/`github.com` just times out — the 2026-09-30 session measured it from
 * the dev machine itself). The classic accelerator mirrors are *download* proxies: they
 * happily front `github.com/.../releases/download/...` but refuse `api.github.com`
 * outright (403 on ghfast.top / ghproxy.net, measured). Only one shape does both, the
 * `gh-proxy.com` path-prefix proxy, and it is run by a third party — so it is a *fallback*,
 * never the primary route, and every attempt is logged with which route answered.
 *
 * The client is deliberately dumb: it tries the list in order and takes the first non-error
 * answer. It does not probe, cache reachability, or fail over mid-download — the OS's
 * browser owns downloads, so failover only ever concerns the one JSON check (and the
 * mirror URL the page offers for the browser).
 */
object GitHubRoutes {

    /** Direct GitHub — tried first, works on most networks. */
    const val DIRECT = ""

    /**
     * Path-prefix proxies: `<mirror><original-url>`. Verified 2026-09-30 for both the
     * Releases API and release-asset downloads against this repository. The list is
     * ordered and first-match wins; entries are plain strings so a dead one can be
     * dropped by editing this line.
     */
    val DOWNLOAD_MIRRORS: List<String> = listOf(
        "https://gh-proxy.com/",
        "https://ghfast.top/",
        "https://ghproxy.net/",
    )

    /** Which mirror fronts [url], for the log line and the page's 镜像 label. */
    fun describe(mirror: String): String = when (mirror) {
        DIRECT -> "github.com"
        else -> mirror.removePrefix("https://").removeSuffix("/")
    }

    /**
     * Apply [mirror] to a GitHub URL. The mirrors take the absolute URL verbatim after
     * their prefix (path-prefix form), which is why every entry ends with `/`.
     */
    fun apply(mirror: String, url: String): String = "$mirror$url"
}

/**
 * The update check's network half: run [fetch] against each route until one answers
 * something parseable, remembering which route won.
 *
 * [fetch] returns the response body as text, or null when that route failed (timeout,
 * TLS, proxy 403 — the transport collapses all of them to null, which is exactly the
 * shape the caller wants here). "The latest release does not exist" (the stable 404)
 * is *not* a route failure — it is a real answer from GitHub, and the parse step
 * distinguishes it from "no answer at all".
 */
class UpdateFetcher(private val fetch: suspend (String) -> String?) {

    /** The route that answered the last check, for the page's 镜像 label. */
    var lastRoute: String = GitHubRoutes.DIRECT
        private set

    /**
     * Fetch [path] (an absolute GitHub URL) trying direct first, then each mirror.
     * Null only when *every* route failed — one non-null body, even an error body,
     * ends the walk.
     */
    suspend fun get(path: String): String? {
        val routes = buildList {
            add(GitHubRoutes.DIRECT)
            addAll(GitHubRoutes.DOWNLOAD_MIRRORS)
        }
        for (mirror in routes) {
            val url = GitHubRoutes.apply(mirror, path)
            val body = runCatching { fetch(url) }.getOrNull()
            if (body != null) {
                lastRoute = mirror
                Diag.i(LogTag.UPDATE) { "route ${GitHubRoutes.describe(mirror)} answered for ${LogFormat.endpointKey(path)}" }
                return body
            }
            Diag.w(LogTag.UPDATE) { "route ${GitHubRoutes.describe(mirror)} failed for ${LogFormat.endpointKey(path)}" }
        }
        lastRoute = GitHubRoutes.DIRECT
        return null
    }
}

/** Rewrites a GitHub release-asset download URL to go through [mirror]. Mirrors only
 * front `github.com` — an `api.github.com` URL handed to a download mirror gets a 403
 * or an HTML error page, so this refuses to transform anything else rather than
 * producing a URL that will not work.
 */
fun mirrorAssetUrl(mirror: String, url: String): String? {
    if (mirror == GitHubRoutes.DIRECT) return url
    if (!url.startsWith("https://github.com/")) return null
    return GitHubRoutes.apply(mirror, url)
}
