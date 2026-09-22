package com.rovecamlink.app.core.transport

/**
 * iOS has no raw-TCP implementation. This project treats iOS as a compile-along shell —
 * CI builds the framework to keep the shared code Native-clean, and no iOS device has
 * been used — so the honest answer is a loud failure rather than a Darwin cinterop that
 * nobody has run against a camera.
 *
 * A real implementation needs Network.framework (`NWConnection`) or a sockets cinterop;
 * the [CameraTcp] seam exists so that work lands in one file here instead of leaking into
 * the transport, which is written against the interface.
 */
actual fun createCameraTcp(): CameraTcp = object : CameraTcp {
    override suspend fun open(host: String, port: Int, timeoutMs: Int): CameraTcpConnection =
        throw NotImplementedError(
            "Raw TCP to $host:$port is not implemented on iOS — firmware push over the " +
                "camera's port 8080 socket needs an NWConnection-based CameraTcp actual.",
        )
}
