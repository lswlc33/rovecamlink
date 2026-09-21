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
            if (key.isNotEmpty()) out[key] = value
        }
        return out
    }

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
