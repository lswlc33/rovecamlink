package com.rovecamlink.app.core.ble

/**
 * Decoder for the `KEY=VALUE,KEY=VALUE` replies these cameras push over a BLE
 * notification. Two rules come from the official client and are kept because they
 * are what a real device sends: `=` (not `:`) separates key from value, and
 * whitespace is stripped before splitting — so an SSID containing a literal space
 * cannot survive this format, and we match the camera rather than invent a stricter
 * parser of our own.
 *
 * Unlike the official parser, a malformed pair is skipped instead of abandoning the
 * rest of the reply: one truncated field must not cost us credentials arriving after
 * it.
 */
internal fun parseBleReply(text: String): Map<String, String> {
    if (text.isBlank()) return emptyMap()
    val out = LinkedHashMap<String, String>(4)
    for (pair in text.replace(" ", "").split(',')) {
        if (pair.isEmpty()) continue
        val equals = pair.indexOf('=')
        if (equals == NOT_FOUND) continue
        val key = pair.substring(0, equals)
        if (key.isEmpty()) continue
        // An empty value is meaningful: `PWD=` is how an open AP answers.
        out[key] = pair.substring(equals + 1)
    }
    return out
}

private const val NOT_FOUND = -1

/** Notification keys exactly as the firmware spells them (they are case-sensitive). */
internal object BleKeys {
    const val STATUS = "Status"
    const val PIN = "Pin"
    const val KEY = "KEY"
    const val SSID = "SSID"
    const val PASSWORD = "PWD"
    const val WIFI_STATUS = "WiFi_Status"
    const val OK = "1"
    const val REJECTED = "0"
}

/**
 * Decode one notification. Payloads are UTF-8; some firmwares pad the value with a
 * NUL byte and trailing CR/LF, which would otherwise poison every key comparison.
 */
internal fun decodeBlePayload(chunk: ByteArray): String =
    chunk.decodeToString().trim { it.isWhitespace() || it.code == 0 }
