package com.rovecamlink.app.brand.xtu

/**
 * Parser for the Hisilicon Hi35xx CGI "var" response format. Most hi3510
 * commands do NOT return JSON; they return JavaScript-style assignments:
 *
 *     var key="value";\r\n
 *     var key2="value2";\r\n
 *
 * (recovered verbatim from the official XTU app's net/StringParser.java).
 * A few commands terminate on `";` without CRLF, so we are lenient.
 */
object HiVarParser {

    /** Parse `var k="v";` lines into a map. Tolerates missing CRLF and extra whitespace. */
    fun parse(body: String?): Map<String, String> {
        if (body.isNullOrBlank()) return emptyMap()
        val out = LinkedHashMap<String, String>()
        // Normalize line endings, then split on ';' or newline boundaries.
        val normalized = body.replace("\r\n", "\n").replace("\r", "\n")
        for (rawLine in normalized.split("\n")) {
            val line = rawLine.trim().removeSuffix(";").trim()
            if (line.isEmpty()) continue
            val withoutVar = if (line.startsWith("var ")) line.substring(4) else line
            val eq = withoutVar.indexOf("=\"")
            if (eq > 0) {
                val key = withoutVar.substring(0, eq).trim()
                var value = withoutVar.substring(eq + 2)
                if (value.endsWith("\"")) value = value.dropLast(1)
                out[key] = value
            } else {
                val eq2 = withoutVar.indexOf('=')
                if (eq2 > 0) {
                    val key = withoutVar.substring(0, eq2).trim()
                    val value = withoutVar.substring(eq2 + 1).trim().trim('"')
                    out[key] = value
                }
            }
        }
        return out
    }

    fun Map<String, String>.int(key: String): Int? = get(key)?.trim()?.toIntOrNull()
    fun Map<String, String>.long(key: String): Long? = get(key)?.trim()?.toLongOrNull()
    fun Map<String, String>.bool(key: String): Boolean? = get(key)?.trim()?.let { it == "1" || it.equals("true", true) }
}
