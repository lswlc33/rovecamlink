package com.rovecamlink.app.brand.xtu

/**
 * Parser for the Hisilicon Hi35xx CGI "var" response format. Most hi3510
 * commands do NOT return JSON; they return JavaScript-style assignments:
 *
 *     var key="value";\r\n
 *     var key2="value2";\r\n
 *
 * (recovered verbatim from the official XTU app's net/StringParser.java).
 *
 * **Statements are not always one per line.** `getprimarymenuitem.cgi` answers
 * both of its variables on a single line —
 * `var item="A,B";var cur="1,2";` — which a line-based reader merges into one
 * mangled value. Verified on an XTU S7PRO (firmware 20.8.6.1.20260710) from the
 * 2026-09-21 field log, where the line-based reader produced 39 "menu items"
 * from a 20-item menu because the item list swallowed the current-value list.
 * So this scans `var k="v"` assignments wherever they start, and never assumes
 * a line boundary or a trailing `;`.
 *
 * **A key can also appear twice, and the repeat can be damaged.** That is what
 * [putKeepingRicher] is for; read it there before "simplifying" the map write back
 * to `out[key] = value`.
 */
object HiVarParser {

    /** Parse every `[var ]k="v"` (or bare `k=v`) assignment found in [body]. */
    fun parse(body: String?): Map<String, String> {
        if (body.isNullOrBlank()) return emptyMap()
        val out = LinkedHashMap<String, String>()
        val n = body.length
        var i = 0
        while (i < n) {
            // Separators between statements: whitespace, newlines, ';', and the
            // '{'/',' an embedded JSON-ish payload may put around us.
            while (i < n && (body[i].isWhitespace() || body[i] == ';' || body[i] == ',' || body[i] == '{' || body[i] == '}')) i++
            if (i >= n) break
            if (body.startsWith("var", i) && (i + 3 >= n || body[i + 3].isWhitespace())) {
                i += 3
                while (i < n && body[i].isWhitespace()) i++
            }
            val eq = body.indexOf('=', i)
            if (eq < 0) break
            val key = body.substring(i, eq).trim().trim('"').trim()
            var j = eq + 1
            while (j < n && body[j].isWhitespace()) j++
            if (j >= n) break
            val value: String
            if (body[j] == '"') {
                val close = body.indexOf('"', j + 1)
                if (close < 0) {
                    value = body.substring(j + 1)
                    i = n
                } else {
                    value = body.substring(j + 1, close)
                    i = close + 1
                }
            } else {
                var end = j
                while (end < n && body[end] != ';' && body[end] != '\n' && body[end] != '\r') end++
                value = body.substring(j, end).trim()
                i = end
            }
            if (key.isNotEmpty()) putKeepingRicher(out, key, value)
        }
        return out
    }

    /**
     * Store one statement, but never let a truncated repeat erase a complete one.
     *
     * `getallworkmode.cgi` on the XTU S7PRO (firmware 20.8.6.1.20260710) answers
     * 235 characters and then repeats itself with its own buffer exhausted:
     *
     *     var photo="Normal Photo,…,Raw Photo";var video="Normal Video,Car Looping,…,Night Scene";var video="Normal Video,
     *
     * The last statement has no closing quote, so it swallows the rest of the body as
     * a one-item list. A plain `map[key] = value` therefore let that fragment replace
     * the eight video modes above it, which is the 2026-09-22 field report of "拍照模式是完
     * 整的，录像模式全没了" — `modes from getallworkmode: n=7`.
     *
     * So a repeated key keeps whichever statement lists more values, and everything
     * else is unchanged: equal-standing values still take the later statement, which
     * is what a firmware that genuinely re-assigns a scalar expects.
     */
    private fun putKeepingRicher(out: LinkedHashMap<String, String>, key: String, value: String) {
        val previous = out[key]
        if (previous == null || value.valueCount() >= previous.valueCount()) out[key] = value
    }

    /** How many comma-separated values this statement carries (blank counts as none). */
    private fun String.valueCount(): Int = if (isBlank()) 0 else count { it == ',' } + 1

    fun Map<String, String>.int(key: String): Int? = get(key)?.trim()?.toIntOrNull()
    fun Map<String, String>.long(key: String): Long? = get(key)?.trim()?.toLongOrNull()
    fun Map<String, String>.bool(key: String): Boolean? = get(key)?.trim()?.let { it == "1" || it.equals("true", true) }

    /**
     * A capacity the firmware spells with its unit attached — `getsdstate.cgi`
     * answers `var total="59882 MB"` on the XTU S7PRO, which a bare `int()` reads
     * as null and the UI then reports as "no card". Only MB/GB/TB are understood;
     * anything else yields null rather than a wrong number.
     */
    fun Map<String, String>.mb(key: String): Long? {
        val raw = get(key)?.trim() ?: return null
        // Drop exactly the characters the number consumed; re-deriving its width from
        // a Double's `toString` turns "59882" into "59882.0" and misreads the unit.
        val digits = raw.takeWhile { it.isDigit() || it == '-' || it == '.' }
        val number = digits.toDoubleOrNull() ?: return null
        val unit = raw.drop(digits.length).trim().uppercase()
        return when (unit) {
            "", "MB", "M" -> round(number)
            "GB", "G" -> round(number * 1024)
            "TB", "T" -> round(number * 1024 * 1024)
            "KB", "K" -> round(number / 1024)
            "BYTES", "B" -> round(number / 1024 / 1024)
            else -> null
        }
    }

    /** Common-stdlib rounding; `Math.round` is JVM-only and breaks the iOS target. */
    private fun round(value: Double): Long = kotlin.math.round(value).toLong()
}
