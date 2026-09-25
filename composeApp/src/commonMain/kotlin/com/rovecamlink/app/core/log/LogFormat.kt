package com.rovecamlink.app.core.log

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

/**
 * Text rendering for the `rovdiag/1` log grammar, plus the sanitising and
 * redaction rules that keep a submitted file safe to share.
 *
 * Grammar (one entry per line; `docs/06-诊断日志系统.md` is the prose version):
 *
 * ```
 * 000451 2026-09-21T18:32:11.482+08:00 +12.345s I HTTP  op=7:capture REQ #231 GET http://…
 * |  var name="XTU X7 Pro";
 * |  var softversion="20250101.0";
 * ```
 *
 * Columns are fixed-width-or-prefixed so the file can be split with whitespace:
 * `seq`, wall time (local, ISO-8601 with UTC offset), `+elapsed since process
 * start`, level letter, tag, `op=<id>:<name>` (or `-` outside an operation),
 * then the free-form message. A line that starts with `|  ` belongs to the
 * entry above it — bodies and stack traces are always on continuation lines.
 */
object LogFormat {

    /** Prefix of every continuation line; also what makes one "not a record". */
    const val CONT: String = "|  "

    /** Mask marker for anything redacted; the `#N` after it is the original length. */
    private const val MASK = "***#"

    /** Query/body keys whose value must never leave the phone by default. */
    private val secretKeys = listOf(
        "wifikey", "wifipass", "wifipasswd", "wifi_passwd", "passphrase", "password", "passwd",
        "passkey", "psk", "pwd", "secret", "token", "seed", "credential", "auth", "key",
    )

    /** Parameter names that only say *which* setting follows, so the secret is in `value=`. */
    private val indirectionNames = listOf("id", "name", "param", "item")

    private val secretInBody = Regex(
        // `wifikey="letmein"`, `wifikey=letmein`, `"password": "letmein"` — the value may
        // be quoted (the quote is consumed with the separator, so spaces inside survive masked).
        // Everything inside the key alternation is non-capturing: a stray group there would
        // shift the group indices the redactor below reads back.
        """(?i)\b(wifi_?key|wifi_?pass(?:word)?|wifi_passwd|passphrase|passwd|password|passkey|psk|pwd|token|secret|seed|credential|auth|key)\b""" +
            """(\s*=\s*"?|"\s*:\s*")([^"&;\r\n]+)""",
    )

    /** Render one record (its own line plus any `|  ` continuation lines). */
    fun line(r: LogRecord, tz: TimeZone): String = buildString {
        append(r.seq.toString().padStart(6, '0'))
        append(' ')
        append(wall(r.epochMillis, tz))
        append(' ')
        append('+').append(seconds(r.elapsedMillis)).append('s')
        append(' ')
        append(r.level.letter)
        append(' ')
        // Tags are padded to a fixed column so the file stays aligned; split on runs
        // of spaces (`line.split(Regex(" +"))`) rather than on a single space.
        append(r.tag.id.padEnd(5))
        append(' ')
        append("op=").append(r.op ?: "-")
        append(' ')
        // The annotation belongs on the record's own line even when the message
        // carries a multi-line body, so it is inserted after that first line.
        val note = r.annotation
        val breakAt = r.text.indexOf('\n')
        if (note == null || breakAt < 0) {
            append(r.text)
            if (note != null) append("   ").append(note)
        } else {
            append(r.text, 0, breakAt)
            append("   ").append(note)
            append(r.text, breakAt, r.text.length)
        }
    }

    /** `yyyy-MM-ddTHH:mm:ss.SSS±HH:MM` in [tz]. */
    fun wall(epochMillis: Long, tz: TimeZone): String {
        val inst = Instant.fromEpochMilliseconds(epochMillis)
        val local = inst.toLocalDateTime(tz)
        val offsetMin = utcOffsetMinutes(epochMillis, tz)
        return buildString {
            append(local.year.toString().padStart(4, '0')).append('-')
            append(local.monthNumber.toString().padStart(2, '0')).append('-')
            append(local.dayOfMonth.toString().padStart(2, '0')).append('T')
            append(local.hour.toString().padStart(2, '0')).append(':')
            append(local.minute.toString().padStart(2, '0')).append(':')
            append(local.second.toString().padStart(2, '0')).append('.')
            append(epochMillis.floorMod(1000L).toString().padStart(3, '0'))
            append(offsetText(offsetMin))
        }
    }

    /** Minutes ahead of UTC for [tz] at [epochMillis] (DCT-aware, no JVM APIs). */
    fun utcOffsetMinutes(epochMillis: Long, tz: TimeZone): Int {
        val utc = Instant.fromEpochMilliseconds(epochMillis).toLocalDateTime(TimeZone.UTC)
        val local = Instant.fromEpochMilliseconds(epochMillis).toLocalDateTime(tz)
        val dayDiff = (local.date.toEpochDays() - utc.date.toEpochDays()).toInt()
        return dayDiff * 24 * 60 + (local.hour * 60 + local.minute) - (utc.hour * 60 + utc.minute)
    }

    private fun offsetText(minutes: Int): String {
        val sign = if (minutes < 0) '-' else '+'
        val abs = kotlin.math.abs(minutes)
        return "$sign${(abs / 60).toString().padStart(2, '0')}:${(abs % 60).toString().padStart(2, '0')}"
    }

    /** `12.345` — seconds with millisecond resolution. */
    fun seconds(millis: Long): String {
        val sign = if (millis < 0) "-" else ""
        val abs = if (millis < 0) -millis else millis
        return "$sign${abs / 1000}.${(abs % 1000).toString().padStart(3, '0')}"
    }

    /** Force a value onto one line: escapes newlines/tabs, drops other control chars. */
    fun safe(value: String?): String {
        if (value == null) return ""
        return buildString(value.length + 8) {
            for (c in value) {
                when {
                    c == '\n' -> append("\\n")
                    c == '\r' -> append("\\r")
                    c == '\t' -> append("\\t")
                    c == '"' -> append("'")
                    c.code < 0x20 || c.code == 0x7F -> append('?')
                    else -> append(c)
                }
            }
        }
    }

    /**
     * Sanitize a whole body for a `key=value` field: keeps printable ASCII plus
     * everything above 0x7F (camera strings are often GBK-decoded Chinese), and
     * redacts secret-looking assignments because bodies echo Wi-Fi credentials.
     */
    fun bodyField(body: String?, keepSecrets: Boolean): String {
        if (body.isNullOrEmpty()) return "<empty>"
        val clipped = if (body.length > 4096) body.substring(0, 4096) else body
        val scrubbed = if (keepSecrets) clipped else redactText(clipped)
        return safe(scrubbed)
    }

    /**
     * A body as continuation lines — the readable form for a camera response.
     * Returns "" when bodies are switched off so callers can skip the field.
     */
    fun bodyBlock(body: String?, maxChars: Int, keepSecrets: Boolean): String {
        if (body == null) return ""
        if (!keepSecrets) {
            return blocksOf(redactText(body).trimEnd(), maxChars)
        }
        return blocksOf(body.trimEnd(), maxChars)
    }

    private fun blocksOf(text: String, maxChars: Int): String {
        if (text.isEmpty()) return ""
        // Clip *before* redacting: a 100 KB file listing would otherwise run every
        // regex over all of it on the caller's thread, once per poll.
        val cut = if (text.length > maxChars) text.substring(0, maxChars) else text
        val out = cut.lineSequence().joinToString("\n") { CONT + it }
        return if (text.length > maxChars) {
            out + "\n" + CONT + "...truncated ${text.length - maxChars} chars of ${text.length}"
        } else {
            out
        }
    }

    /**
     * Redact secret-looking values in arbitrary text (bodies, headers, traces).
     *
     * One structural pass, no per-key loops: [Regex.replace] scans the input and never
     * re-reads what it emitted, so a masked value cannot be masked again — the earlier
     * second loop over [secretKeys] did exactly that and produced `wifikey=***#6`
     * style nonsense from an already-masked `***#10`.
     */
    fun redactText(text: String): String = secretInBody.replace(text) { m ->
        val key = m.groupValues[1]
        val sep = m.groupValues[2]
        val value = m.groupValues[3]
        "$key$sep$MASK${value.length}"
    }

    /**
     * Escape AND redact a value that goes into a `key=value` field. Anything that can
     * carry attacker- or firmware-controlled text should go through this rather than
     * [safe] alone: headers, exception messages, environment snapshots.
     */
    fun field(value: String?, keepSecrets: Boolean = false): String {
        if (value.isNullOrEmpty()) return ""
        return safe(if (keepSecrets) value else redactText(value))
    }

    /**
     * A setting value whose *name* is the only thing marking it as a credential
     * (`setSetting("wifi_passwd", "letmein")`). The generic body/URL redactors cannot
     * see that, so the caller has to: print the length, never the value.
     */
    fun settingValue(id: String, value: String, keepSecrets: Boolean = false): String {
        if (keepSecrets) return safe(value)
        val secret = id.containsAny(secretKeys) || value.containsAny(secretKeys)
        return if (secret) "$MASK${value.length}" else safe(value)
    }

    /**
     * A URL with secret-looking query values masked, so it can be logged as-is.
     * Parameter names, order and the cameras' leading `-` all survive — that is
     * exactly what protocol debugging needs to keep reading.
     *
     * Two shapes have to be handled: the value names itself (`-wifikey=…`) and the
     * menu indirection the cameras actually use for a passphrase
     * (`/api/menu/setparameter?id=wifi_passwd&value=<pw>` and
     * `setcurparameter.cgi?-name=Wifi+Key&-value=<pw>`), where the secret sits in a
     * generically named `value=` and only its sibling parameter says what it is.
     */
    fun redactUrl(url: String, keepSecrets: Boolean = false): String {
        if (keepSecrets) return url
        val withUserinfo = maskUserInfo(url)
        val q = withUserinfo.indexOf('?')
        if (q < 0) return withUserinfo
        val head = withUserinfo.substring(0, q)
        val pairs = withUserinfo.substring(q + 1).split('&')
        // Does any parameter declare that this query carries a credential? Either by
        // naming it (`-wifikey=`) or by pointing at it (`id=wifi_passwd`, `-name=Wifi Key`).
        val secretNamed = pairs.any { pair ->
            if (!pair.contains('=')) return@any false
            val rawName = pair.substringBefore('=').removePrefix("-").removePrefix("&")
            val value = pair.substringAfter('=', "")
            when {
                indirectionNames.any { rawName.equals(it, true) } -> value.containsAny(secretKeys)
                else -> rawName.containsAny(secretKeys) && value.isNotBlank()
            }
        }
        val query = pairs.joinToString("&") { pair ->
            if (!pair.contains('=')) return@joinToString pair
            val rawName = pair.substringBefore('=')
            val name = rawName.removePrefix("-").removePrefix("&")
            val value = pair.substringAfter('=', "")
            val indirect = indirectionNames.any { name.equals(it, true) }
            val isSecret = !indirect && (name.containsAny(secretKeys) || (secretNamed && name.equals("value", true)))
            if (!isSecret) pair else rawName + "=" + MASK + value.length
        }
        return "$head?$query"
    }

    /** `http://user:pass@host/…` — the credential is in the URL even without a query. */
    private fun maskUserInfo(url: String): String {
        val scheme = url.indexOf("://")
        if (scheme < 0) return url
        val authorityStart = scheme + 3
        val authorityEnd = url.indexOf('/', authorityStart).takeIf { it >= 0 } ?: url.length
        val authority = url.substring(authorityStart, authorityEnd)
        val at = authority.lastIndexOf('@')
        if (at < 0) return url
        val credentials = authority.substring(0, at)
        return url.substring(0, authorityStart) + MASK + credentials.length +
            authority.substring(at)
    }

    /**
     * An RTMP push URL with its stream key masked, for log lines.
     *
     * The last `/`-separated segment of an RTMP URL is almost always the stream key —
     * the secret a platform issues that lets anyone holding it push into the channel
     * (`rtmp://host/live/<key>`; some hosts shape it as `rtmp://host/<app>/<key>`, which
     * this masks too, since the app name is recoverable from context and the key is the
     * one thing that must not travel). Diagnostic exports are designed to be attached to
     * a public issue, so a push URL may only appear in one with its tail masked. Everything
     * before the tail stays readable: host and app are what a "which server was it" follow-up
     * needs, and [maskUserInfo] has already handled credentials ahead of the host.
     */
    fun redactStreamUrl(url: String, keepSecrets: Boolean = false): String {
        val safe = redactUrl(url, keepSecrets)
        if (keepSecrets || safe.startsWith("rtmp", ignoreCase = true).not()) return safe
        val tailStart = safe.lastIndexOf('/')
        // No path segment to split (rtmp://host or a bare host:port): there is no key,
        // and masking the authority would erase the address the whole line exists for.
        if (tailStart < safe.indexOf("://") + 3) return safe
        val key = safe.substring(tailStart + 1)
        if (key.isEmpty()) return safe
        return safe.substring(0, tailStart + 1) + MASK + key.length
    }

    private fun String.containsAny(needles: List<String>): Boolean =
        needles.any { contains(it, ignoreCase = true) }

    /**
     * Bounded, comparable bucket for a URL: what the summary table groups by.
     * Cardinality has to stay small (media file names would otherwise fill the map).
     */
    fun endpointKey(url: String): String {
        val path = url.substringAfter("://", url).substringAfter('/', "").substringBefore('?')
        val file = path.substringAfterLast('/')
        val ext = file.substringAfterLast('.', "").lowercase()
        return when {
            path.contains("cgi-bin") -> "cgi:" + file.removeSuffix(".cgi")
            path.startsWith("api/") -> "api:" + path.removePrefix("api/")
            ext in MEDIA_EXT -> "media:.$ext"
            ext == "thm" -> "media:.thm"
            file.isEmpty() -> "root:" + url.substringAfter("://").substringBefore('/')
            else -> "other:$file"
        }
    }

    /** First [max] bytes as hex + ASCII, for responses that are not text. */
    fun hexPreview(bytes: ByteArray, max: Int): String {
        if (bytes.isEmpty()) return "<0 bytes>"
        val n = minOf(max, bytes.size)
        val hex = StringBuilder(n * 3)
        for (i in 0 until n) {
            hex.append((bytes[i].toInt() and 0xFF).toString(16).padStart(2, '0')).append(' ')
        }
        val ascii = bytes.take(n).joinToString("") { b ->
            val c = b.toInt() and 0xFF
            if (c in 0x20..0x7E) c.toChar().toString() else "."
        }
        return "$hex| $ascii" + if (bytes.size > n) " ...(+${bytes.size - n} of ${bytes.size}B)" else ""
    }

    /** `1.2 MB` / `340 KB` / `812 B` for byte counts in messages. */
    fun size(bytes: Long): String = when {
        bytes < 0 -> "?"
        bytes < 1024 -> "$bytes B"
        bytes < 1024 * 1024 -> "${bytes / 1024} KB"
        bytes < 1024L * 1024 * 1024 -> "${(bytes * 10 / (1024 * 1024)) / 10.0} MB"
        else -> "${(bytes * 10 / (1024L * 1024 * 1024)) / 10.0} GB"
    }

    private val MEDIA_EXT = setOf("mp4", "mov", "lrv", "jpg", "jpeg", "png", "dng", "thm")
}

private fun Long.floorMod(other: Long): Long {
    val r = this % other
    return if (r < 0) r + other else r
}
