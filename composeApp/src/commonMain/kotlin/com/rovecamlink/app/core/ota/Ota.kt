package com.rovecamlink.app.core.ota

import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CmdResult

/**
 * Firmware-OTA state. Mirrors the 14-state machine TUWIN actually ships
 * (doc 04 §2.2) collapsed to the states that are meaningful and observable
 * without a native OS (install/reconnect/version-confirm), plus terminal states.
 */
sealed interface OtaState {
    data object Idle : OtaState
    /** Package is ready; camera must be connected before transfer starts. */
    data object WaitingForDevice : OtaState
    /** Bytes are flowing to the camera. */
    data object Uploading : OtaState
    /** Transfer accepted; camera is applying the image (may reboot). */
    data object Installing : OtaState
    /** Camera went away after install; waiting for it to come back. */
    data object WaitingForReboot : OtaState
    /** Camera is back; negotiating a fresh session. */
    data object Reconnecting : OtaState
    /** Re-read the installed version and compare against what we pushed. */
    data class ConfirmingVersion(val expected: String) : OtaState
    data object Completed : OtaState
    data object Cancelled : OtaState
    data class Failed(val message: String) : OtaState

    val isTerminal: Boolean
        get() = this is Completed || this is Cancelled || this is Failed
}

/**
 * Per-brand the bytes reach the camera differently (doc 04 §4: a unified
 * check/plan layer wraps a per-profile transport). TUWIN uploads whole-file REST,
 * XTU/Hisilicon use fileupload.cgi, idGoLive drops it into native PTP. One
 * implementation per profile keeps that variance off the coordinator.
 */
interface OtaTransport {
    /** Normalized (or raw) currently-installed firmware version, or null if unavailable. */
    suspend fun readVersion(session: CameraSession): String?

    /**
     * Push [fileBytes] to the camera and trigger install. Returns when the camera
     * has accepted the image — it may reboot afterwards. Progress 0f..1f.
     */
    suspend fun install(
        session: CameraSession,
        fileName: String,
        fileBytes: ByteArray,
        onProgress: (Float) -> Unit,
    ): CmdResult
}

/** A resolved update to apply: normalized target version plus the candidate bytes. */
data class OtaPackage(
    val version: String,
    val fileName: String,
    val bytes: ByteArray,
)

/**
 * Drives the OTA state machine around a single [OtaTransport].
 *
 * A String key so state.time both identifies the transfer and lets the caller
 * cancel it from the UI between steps.
 */
class OtaCoordinator(
    private val transport: OtaTransport,
    private val connect: suspend () -> CameraSession,
) {
    private var _state: OtaState = OtaState.Idle
    var state: OtaState
        get() = _state
        private set(value) {
            _state = value
            onState?.invoke(value)
        }
    var onState: ((OtaState) -> Unit)? = null

    fun cancel() {
        if (!state.isTerminal) state = OtaState.Cancelled
    }

    /**
     * Run an install. Expected to be launched directly on the UI scope (it is
     * cancelled by the caller swapping its coroutine away). Returns the terminal state.
     */
    suspend fun run(pkg: OtaPackage, reconnectBefore: Boolean = true): OtaState {
        state = OtaState.Idle
        var session: CameraSession
        if (reconnectBefore) {
            state = OtaState.WaitingForDevice
            session = runCatching { connect() }.getOrElse {
                state = OtaState.Failed("Camera unreachable: ${it.message}")
                return state
            }
        } else {
            session = runCatching { connect() }.getOrElse { state = OtaState.Cancelled; return state }
        }

        state = OtaState.Uploading
        val install = runCatching {
            transport.install(session, pkg.fileName.takeLast(120), pkg.bytes) { }
        }.getOrElse { CmdResult.Failure(it.message ?: "Transfer failed") }

        if (state.isTerminal) return state
        if (install !is CmdResult.Ok) {
            val msg = (install as? CmdResult.Failure)?.message ?: "Upload failed"
            state = OtaState.Failed(msg)
            return state
        }

        // Camera restarts and/or the Wi-Fi session drops: wait for it to come back.
        state = OtaState.Installing
        val back = waitForReboot(pkg.version)
        if (state.isTerminal) return state
        if (!back) {
            state = OtaState.Failed("Camera did not come back after the update")
            return state
        }

        state = OtaState.Reconnecting
        val s2 = runCatching { connect() }.getOrElse {
            state = OtaState.Failed("Reconnect failed: ${it.message}")
            return state
        }

        state = OtaState.ConfirmingVersion(pkg.version)
        val installed = runCatching { transport.readVersion(s2) }.getOrNull()
        if (installed == null) {
            state = OtaState.Failed("OTA version confirmation returned no version")
            return state
        }
        if (FirmwareVersion.normalize(installed) != FirmwareVersion.normalize(pkg.version)) {
            state = OtaState.Failed("OTA version mismatch: expected=${pkg.version}, got=$installed")
            return state
        }

        state = OtaState.Completed
        return state
    }

    /**
     * Poll [readVersion] until the camera either confirms [target] or stays silent
     * beyond [timeoutMs]. Returning true means the camera answered with the target
     * version (i.e. it rebooted onto the new firmware).
     */
    private suspend fun waitForReboot(target: String, timeoutMs: Long = 60_000): Boolean {
        state = OtaState.WaitingForReboot
        val deadline = kotlinx.datetime.Clock.System.now().toEpochMilliseconds() + timeoutMs
        val want = FirmwareVersion.normalize(target)
        while (!state.isTerminal) {
            kotlinx.coroutines.delay(2_000)
            if (kotlinx.datetime.Clock.System.now().toEpochMilliseconds() > deadline) return false
            val v = runCatching { transport.readVersion(connect()) }.getOrNull()
            if (v == null) continue
            if (want == null) return true      // no usable target — any answer is a reboot ack
            if (FirmwareVersion.normalize(v) == want) return true
        }
        return false
    }
}