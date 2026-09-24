package com.rovecamlink.app.core.qr

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

/** Wi-Fi credentials decoded from a camera's QR code. */
data class QrWifiCredentials(val ssid: String, val password: String?)

/**
 * Parses the QR payloads action cameras actually emit. There is no standard, so
 * accept the Android `WIFI:` scheme, JSON objects, bare `key=value` pairs, and
 * a plain `ssid,password` payload. Returns null when nothing usable is found.
 */
fun parseWifiQr(raw: String): QrWifiCredentials? {
    val text = raw.trim()
    if (text.isEmpty()) return null

    // Android standard: WIFI:T:WPA;S:XTUCam_f9e5e2;P:12345678;;
    if (text.startsWith("WIFI:", ignoreCase = true)) {
        val fields = splitUnescaped(text.substringAfter(':'), ';')
            .mapNotNull { part ->
                val idx = part.indexOf(':')
                if (idx <= 0) {
                    null
                } else {
                    part.substring(0, idx).trim().uppercase() to
                        unescapeWifiField(part.substring(idx + 1)).trim()
                }
            }
            .toMap()
        val ssid = fields["S"]?.takeIf { it.isNotEmpty() } ?: return null
        return QrWifiCredentials(ssid, fields["P"]?.takeIf { it.isNotEmpty() })
    }

    // JSON: {"ssid":"...","pwd":"..."} / {"SSID":...,"password":...}
    if (text.startsWith("{")) {
        val obj = runCatching { Json.parseToJsonElement(text) as? JsonObject }.getOrNull() ?: return null
        val ssid = obj.string("ssid", "SSID", "wifiSsid", "WIFI_SSID", "name") ?: return null
        val pwd = obj.string("pwd", "password", "PWD", "PASSWORD", "key")
        return QrWifiCredentials(ssid, pwd?.takeIf { it.isNotEmpty() })
    }

    // Key/value pairs: ssid=XTUCam_f9e5e2&pwd=12345678  /  SSID:...,PASSWORD:...
    if (text.contains('=') || (text.contains(':') && text.contains(','))) {
        val pairs = text.split('&', ';', ',')
            .mapNotNull { part ->
                val idx = part.indexOfFirst { it == '=' || it == ':' }
                if (idx <= 0) null else part.substring(0, idx).trim().lowercase() to part.substring(idx + 1).trim()
            }
            .toMap()
        val ssid = pairs["ssid"] ?: pairs["wifissid"] ?: pairs["wifi_ssid"] ?: pairs["name"]
        if (ssid != null) {
            val pwd = pairs["pwd"] ?: pairs["password"] ?: pairs["pass"] ?: pairs["key"]
            return QrWifiCredentials(ssid, pwd?.takeIf { it.isNotEmpty() })
        }
    }

    // Last resort: exactly two bare tokens, "XTUCam_f9e5e2 12345678".
    val tokens = text.split(Regex("[\\s,]+")).filter { it.isNotBlank() }
    if (tokens.size == 2) return QrWifiCredentials(tokens[0], tokens[1])
    return null
}

private fun JsonObject.string(vararg keys: String): String? {
    for (key in keys) {
        val element = this[key]
        if (element is JsonPrimitive && element.isString) return element.content
    }
    return null
}

/**
 * Splits on [delimiter] only where it is not escaped, leaving the escape sequences in
 * place. The Android `WIFI:` scheme escapes `\`, `;`, `,`, `:` and `"` inside a value, so
 * `S:My\;Cam` is one field and not two; decoding first would lose the difference between a
 * literal `;` and the field separator, which is why [unescapeWifiField] runs afterwards.
 */
private fun splitUnescaped(text: String, delimiter: Char): List<String> {
    val parts = mutableListOf<String>()
    val current = StringBuilder()
    var i = 0
    while (i < text.length) {
        val c = text[i]
        when {
            c == '\\' && i + 1 < text.length -> {
                current.append(c).append(text[i + 1])
                i += 2
            }
            c == delimiter -> {
                parts += current.toString()
                current.clear()
                i++
            }
            else -> {
                current.append(c)
                i++
            }
        }
    }
    parts += current.toString()
    return parts
}

/** Decodes the `WIFI:` escapes: `\;` `\,` `\:` `\"` `\\` become the literal character. */
private fun unescapeWifiField(value: String): String {
    if ('\\' !in value) return value
    val out = StringBuilder(value.length)
    var i = 0
    while (i < value.length) {
        val c = value[i]
        if (c == '\\' && i + 1 < value.length) {
            out.append(value[i + 1])
            i += 2
        } else {
            out.append(c)
            i++
        }
    }
    return out.toString()
}
