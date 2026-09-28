package com.rovecamlink.app.core.net

/**
 * Parse what a user types into the manual-connect field: `host` or `host:port`.
 *
 * Exists as a function of its own because the page and the connection state machine must
 * agree on what a typed address means, and "camera at 127.0.0.1:8080" is the shape every
 * no-camera test — and every port-forwarded setup — depends on. The parsing used to live
 * inline in `AppState.connectBlocking`, where the only inputs were whichever strings the
 * UI happened to produce; a typed address deserves the same treatment as a scanned one.
 *
 * Null means "not an address": blank input, a bare `:8080`, or a port outside 1..65535.
 * A missing port is 80, the port every camera's HTTP face answers on.
 */
fun parseManualAddress(raw: String?): Pair<String, Int>? {
    val text = raw?.trim().orEmpty()
    if (text.isEmpty()) return null
    val colon = text.lastIndexOf(':')
    if (colon < 0) return text to 80
    val host = text.substring(0, colon).trim()
    val portText = text.substring(colon + 1).trim()
    if (host.isEmpty()) return null
    // IPv4 only, like the rest of this app (`DeviceDiscovery.isRoutableIpv4`): if what is left
    // of the host still contains a colon, the tail was not a port and the text stays whole.
    if (host.contains(':')) return text to 80
    // A non-numeric tail is not a port: keep the whole string as the host so the dial fails
    // with "cannot resolve" instead of quietly connecting to a different machine on :80.
    if (portText.isEmpty()) return host to 80
    val port = portText.toIntOrNull() ?: return text to 80
    if (port !in 1..65535) return null
    return host to port
}
