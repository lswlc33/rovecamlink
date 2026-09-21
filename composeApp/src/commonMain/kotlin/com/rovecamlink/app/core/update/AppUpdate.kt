package com.rovecamlink.app.core.update

import com.rovecamlink.app.core.transport.CameraHttp
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.contentOrNull

/** A newer app release found by [checkForAppUpdate]. */
data class AppUpdateInfo(
    /** Version of the latest release, e.g. "0.2.0" (tag "v0.2.0"). */
    val version: String,
    /** Direct APK download URL on this release (Android), or null. */
    val apkUrl: String?,
    /** Release page URL (desktop opens this in a browser). */
    val releaseUrl: String,
    val releaseNotes: String? = null,
)

/**
 * Single source of truth for the locally installed app version. Must stay in sync
 * with `versionName` in composeApp/build.gradle.kts (the release pipeline enforces
 * that the release tag matches versionName, so this is the one constant to bump).
 */
object AppVersion {
    const val current = "0.1.0"

    /** Version strings like "0.1.0" → comparable triple. */
    fun parse(v: String): Triple<Int, Int, Int>? {
        val p = v.trim().removePrefix("v").split("-").first().split(".")
        if (p.size < 3) return null
        val a = p[0].toIntOrNull() ?: return null
        val b = p[1].toIntOrNull() ?: return null
        val c = p[2].toIntOrNull() ?: return null
        return Triple(a, b, c)
    }

    fun isNewer(candidate: String?, installed: String = current): Boolean {
        val x = candidate?.let { parse(it) } ?: return false
        val y = parse(installed) ?: return false
        return when {
            x.first != y.first -> x.first > y.first
            x.second != y.second -> x.second > y.second
            else -> x.third > y.third
        }
    }
}

private const val RELEASES_LATEST =
    "https://api.github.com/repos/lswlc33/rovecamlink/releases/latest"

private val json = Json { ignoreUnknownKeys = true; isLenient = true }

/**
 * Queries GitHub for the latest release and returns an [AppUpdateInfo] if it is
 * newer than [AppVersion.current], or null if there is no newer release / the
 * network is unavailable. Intended to run on normal Internet, not the camera Wi-Fi.
 */
suspend fun checkForAppUpdate(http: CameraHttp): AppUpdateInfo? {
    val body = http.getText(RELEASES_LATEST) ?: return null
    val root = runCatching { json.parseToJsonElement(body) }.getOrNull()?.jsonObject ?: return null
    val tag = root["tag_name"]?.jsonPrimitive?.contentOrNull ?: return null
    val version = tag.removePrefix("v")
    if (!AppVersion.isNewer(version)) return null
    val releaseUrl = root["html_url"]?.jsonPrimitive?.contentOrNull ?: ""
    val apkUrl = (root["assets"] as? kotlinx.serialization.json.JsonArray)
        ?.mapNotNull { it.jsonObject["browser_download_url"]?.jsonPrimitive?.contentOrNull }
        ?.filterNotNull()
        ?.firstOrNull { it.endsWith(".apk", ignoreCase = true) }
    val notes = root["body"]?.jsonPrimitive?.contentOrNull
    return AppUpdateInfo(version, apkUrl, releaseUrl, notes)
}

/**
 * Platform-specific action to actually apply an update. Android downloads and installs
 * the APK via a FileProvider intent; desktop opens the release page in a browser;
 * iOS has no self-update path (returns a short message instead).
 */
expect suspend fun applyAppUpdate(info: AppUpdateInfo, http: CameraHttp): String?