package com.rovecamlink.app.core.ble

import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogTag

/**
 * Decoder for the `KEY=VALUE,KEY=VALUE` replies these cameras push over a BLE
 * notification. Two rules come from the official client and are kept because they
 * are what a real device sends: `=` separates key from value
 * (`sigmastar/bluetooth/utils/ByteUtils.divideString2` resolves
 * `ContainerUtils.KEY_VALUE_DELIMITER` to `"="`, confirmed in the 2026-09-21
 * re-read — an earlier note here claimed `:`, which is wrong for this family), and
 * a malformed pair is skipped instead of abandoning the rest of the reply, so one
 * truncated field cannot cost us credentials arriving after it.
 *
 * The official parser strips **every** space (`replaceAll(" ","")`) and `break`s on
 * the first segment without a delimiter, so an SSID containing a space is unjoinable
 * there and one truncated field loses the credentials after it. We keep spaces inside
 * a value and skip only the segment we cannot read. The cost of that choice is a
 * value that contains a literal comma: it is dropped, not merged into the field
 * before it, because a reply like `Status=1,garbage,Pin=42` is what the field corpus
 * actually contains and merging would corrupt the value we do need.
 *
 * A `:` separated dialect is tolerated for keys we recognise, because the Ambarella
 * branch of these firmwares answers `Status:1,Pin:1234`. Accepting it costs nothing on
 * a camera that only ever uses `=`, and the alternative is a phone holding valid
 * credentials it cannot read.
 */
internal fun parseBleReply(text: String): Map<String, String> {
    if (text.isBlank()) return emptyMap()
    val out = LinkedHashMap<String, String>(4)
    for (pair in text.split(',')) {
        if (pair.isEmpty()) continue
        val delimiter = pair.indexOf('=').takeIf { it > 0 } ?: colonDelimiter(pair) ?: continue
        val key = pair.substring(0, delimiter).trim()
        if (key.isEmpty()) continue
        // An empty value is meaningful: `PWD=` is how an open AP answers. Padding is
        // stripped because `Status: 1, Pin: 0042` is how these firmwares pad a reply,
        // and a comparison against "1" is what decides whether we may go on.
        val value = pair.substring(delimiter + 1).trim()
        if (out.put(key, value) != null) {
            Diag.warn(LogTag.NET, "BLE reply repeats key $key — keeping the later value")
        }
    }
    return out
}

/**
 * `:` as a key/value delimiter, but only for a key we already recognise.
 *
 * The Ambarella and dashcam branches of this family answer `Status:1,Pin:1234`, and
 * accepting that costs nothing here. It has to stay restricted to the known keys
 * though, or the capability advertisement `R009_cap:0x02;` — which is not a reply to
 * anything — would be parsed as one, and the log would claim a handshake answer the
 * camera never gave.
 */
private fun colonDelimiter(pair: String): Int? {
    val colon = pair.indexOf(':')
    if (colon <= 0) return null
    return if (pair.substring(0, colon).trim() in BleKeys.KNOWN) colon else null
}

/**
 * Notification keys exactly as the firmware spells them (they are case-sensitive).
 * [BleKeys.KNOWN] is also what decides whether a `:` is a delimiter at all.
 */
internal object BleKeys {
    const val STATUS = "Status"
    const val PIN = "Pin"
    const val KEY = "KEY"
    const val SSID = "SSID"
    const val PASSWORD = "PWD"
    const val WIFI_STATUS = "WiFi_Status"
    const val OK = "1"
    const val REJECTED = "0"

    val KNOWN = setOf(STATUS, PIN, KEY, SSID, PASSWORD, WIFI_STATUS)
}

/**
 * Decode one notification. Payloads are UTF-8; some firmwares pad the value with a
 * NUL byte and trailing CR/LF, which would otherwise poison every key comparison.
 */
internal fun decodeBlePayload(chunk: ByteArray): String =
    chunk.decodeToString().trim { it.isWhitespace() || it.code == 0 }
