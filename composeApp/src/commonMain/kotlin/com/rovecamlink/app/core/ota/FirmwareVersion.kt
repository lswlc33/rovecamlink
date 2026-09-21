package com.rovecamlink.app.core.ota

/**
 * `String.format("%04d…")` is a JVM-only API, but these date stamps are what the
 * cameras' own version strings are made of, so pad by hand to keep commonMain
 * compilable for Kotlin/Native (iOS) as well.
 */
internal fun zeroPad(value: Int, width: Int): String = value.toString().padStart(width, '0')

/**
 * Normalizes a firmware version string to a comparable `yyyyMMdd` date stamp.
 *
 * Doc 04 §4 conclusion 2: TUWIN M3, XTU (all three cloud APIs) and idGoLive all use a
 * `yyyyMMdd` date stamp as their version truth, so one normalization covers all three
 * families (unlike semver, none of them use it). Rules, in order:
 *  - trim surrounding whitespace; if nothing remains → null.
 *  - if the string is a "Mon DD YYYY" build stamp → convert to `yyyyMMdd` (TUWIN M3).
 *  - otherwise extract the first 8-digit `yyyyMMdd`; if absent → null (not a version we
 *    can compare, so treat as "no usable version").
 *
 * Comparison is lexicographic on the returned 8-digit string, which is equivalent to
 * numeric/date comparison.
 */
object FirmwareVersion {

    private val months = mapOf(
        "jan" to 1, "feb" to 2, "mar" to 3, "apr" to 4, "may" to 5, "jun" to 6,
        "jul" to 7, "aug" to 8, "sep" to 9, "oct" to 10, "nov" to 11, "dec" to 12,
    )

    /** "Mon DD YYYY" (e.g. "Jun 15 2025") → yyyyMMdd. */
    private val monDdYyyy = Regex("""([A-Za-z]{3})\s+(\d{1,2})\s+(\d{4})""")
    private val digits8 = Regex("""\d{8}""")

    fun from(raw: String?): String? {
        val s = raw?.trim() ?: return null
        if (s.isEmpty()) return null

        // "Jun 15 2025" build stamps (TUWIN M3) → 20250615.
        monDdYyyy.matchEntire(s)?.let { m ->
            val mon = months[m.groupValues[1].take(3).lowercase()] ?: return@let
            val day = m.groupValues[2].toInt()
            val year = m.groupValues[3].toInt()
            val maxDay = daysInMonth(mon, year)
            if (day in 1..maxDay) {
                return zeroPad(year, 4) + zeroPad(mon, 2) + zeroPad(day, 2)
            }
        }

        // First 8-digit date stamp anywhere in the string (XTU `\d{8}`, idGoLive `_YYYYMMDD_`).
        return digits8.find(s)?.value
    }

    /** Alias so callers that don't care about the parse rule read clearly. */
    fun normalize(raw: String?): String? = from(raw)

    /** True when [newer] strictly supersedes [older]; null versions are never newer. */
    fun isNewer(newer: String?, older: String?): Boolean {
        if (newer == null || older == null) return false
        return newer > older
    }

    private fun daysInMonth(mon: Int, year: Int): Int = when (mon) {
        2 -> if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) 29 else 28
        4, 6, 9, 11 -> 30
        else -> 31
    }
}