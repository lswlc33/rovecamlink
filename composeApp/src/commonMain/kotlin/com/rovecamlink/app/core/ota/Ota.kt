package com.rovecamlink.app.core.ota

import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CmdResult
import okio.Path

/**
 * Firmware-OTA state. Mirrors the 14-state machine TUWIN actually ships
 * (doc 04 §2.2) collapsed to the states that are meaningful and observable
 * without a native OS (install/reconnect/version-confirm), plus terminal states.
 *
 * The first five states are the two halves that happen **on the phone** — asking the
 * vendor, fetching the package — and are driven by [FirmwareUpdater]; the rest is the
 * transfer to the camera, driven by [OtaCoordinator]. They share one sealed type
 * because the screen that shows them is one list of rows and the user does not care
 * which machine produced the line.
 */
sealed interface OtaState {
    data object Idle : OtaState

    // ---- the phone side: check the vendor index, then fetch what it points at ----

    /** A `getNewestVersion` request is in flight on the internet route. */
    data object Checking : OtaState

    /** The index knows this model and the camera already has its newest build. */
    data class UpToDate(val installed: String?) : OtaState

    /** The index answered with nothing for this model — no published firmware at all. */
    data class NoEntry(val installed: String?) : OtaState

    /** There is a newer build. The user has not agreed to fetch it yet. */
    data class Available(val installed: String?, val offer: FirmwareOffer) : OtaState

    /** Bytes are flowing from the vendor to the phone. */
    data class Downloading(val fraction: Float, val done: Long, val total: Long) : OtaState

    /** The package is on disk and verified; installing still needs a tap. */
    data class ReadyToInstall(val offer: FirmwareOffer, val path: Path, val bytes: Long) : OtaState

    // ---- the camera side ----

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

    /**
     * True when no transfer is in flight — the machine has stopped and is either
     * waiting for the user to act on the result or has already been dismissed.
     *
     * This is deliberately *not* "nothing is happening": [Downloading] is a running
     * state whose cancel button must work, and [Available] is a stopped state whose
     * only button is 下载. Getting that wrong is how a download becomes
     * uncancellable, or a finished check turns into a phantom 取消.
     */
    val isTerminal: Boolean
        get() = this is Completed || this is Cancelled || this is Failed ||
            this is UpToDate || this is NoEntry || this is Available || this is ReadyToInstall
}

/**
 * A firmware package sitting on the phone's disk.
 *
 * A path and a length rather than a `ByteArray`, because the smallest real package
 * measured in this project is 16 MB and the S7PRO's current build is 54,490,165 bytes
 * (`docs/04 §5`), against a phone whose Java heap the 2026-09-22 field log puts around
 * 200 MB. A transport that receives bytes would have to hold the whole image in memory
 * while also building the multipart body around it — the exact shape of the thumbnail
 * OOM this app has already been bitten by once.
 */
data class FirmwarePackage(
    val path: Path,
    val sizeBytes: Long,
    /** What the camera should be told the file is called. */
    val fileName: String = path.name,
    /**
     * The build this package is, as it can be read from the file name or the vendor's
     * index. Null means "we do not know", and the only thing that is lost is the
     * post-reboot version confirmation — [OtaCoordinator] reports 已更新 without
     * claiming it checked, rather than failing a transfer that probably worked.
     */
    val version: String? = null,
)

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
     * Push the package at [pkg]'s path to the camera and trigger install. Returns when
     * the camera has accepted the image — it may reboot afterwards. Progress 0f..1f.
     *
     * Implementations must read [pkg] incrementally, never whole; see [FirmwarePackage]
     * for the sizes that make that a requirement rather than a preference.
     */
    suspend fun install(
        session: CameraSession,
        pkg: FirmwarePackage,
        onProgress: (Float) -> Unit,
    ): CmdResult
}

/**
 * Try several transports in order, and fall through **only** while the camera has not
 * started receiving.
 *
 * This exists because the two XTU channels have opposite evidence: port 8080 with the
 * 72-byte `RECV_FILE` frame is the one the official app actually ships for this camera
 * class, while `fileupload.cgi` + `upgrade.cgi` is real firmware-facing code whose host
 * screen was never wired into the vendor's own manifest (`docs/04 §1.2(b)`), so it has no
 * field evidence either way. Trying both costs nothing on the happy path and turns an
 * "unreachable" verdict into a usable update without asking anyone to know what a port
 * number is.
 *
 * The gate is what makes it safe. A channel that failed *after* the camera agreed to
 * receive bytes must not be followed by a second push, because the camera may already be
 * half-way through an image; [preHandshakeFailures] carries exactly the codes that mean
 * "nothing of the package reached the camera".
 */
class ChainedOtaTransport(
    private val channels: List<OtaTransport>,
    private val preHandshakeFailures: Set<Int>,
) : OtaTransport {

    override suspend fun readVersion(session: CameraSession): String? {
        for (channel in channels) {
            val v = runCatching { channel.readVersion(session) }.getOrNull()
            if (v != null) return v
        }
        return null
    }

    override suspend fun install(
        session: CameraSession,
        pkg: FirmwarePackage,
        onProgress: (Float) -> Unit,
    ): CmdResult {
        var last: CmdResult = CmdResult.Failure("没有可用的固件送包通道")
        for ((index, channel) in channels.withIndex()) {
            val result = runCatching { channel.install(session, pkg, onProgress) }
                .getOrElse { CmdResult.Failure(it.message ?: "transfer failed") }
            if (result is CmdResult.Ok) {
                if (index > 0) Diag.info(LogTag.OTA, "${channel::class.simpleName} carried the package after a previous channel refused")
                return result
            }
            last = result
            val code = (result as? CmdResult.Failure)?.code
            if (code == null || code !in preHandshakeFailures) {
                Diag.error(
                    LogTag.OTA,
                    "${channel::class.simpleName} failed with code=${code ?: "none"}; not trying ${channels.size - index - 1} further channel(s) — the camera may already hold part of the image",
                )
                return result
            }
            if (index < channels.lastIndex) {
                Diag.warn(
                    LogTag.OTA,
                    "${channel::class.simpleName} refused before any bytes moved (code=$code); falling through to ${channels[index + 1]::class.simpleName}",
                )
            }
        }
        return last
    }
}

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
    suspend fun run(pkg: FirmwarePackage, reconnectBefore: Boolean = true): OtaState {
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
            transport.install(session, pkg.copy(fileName = pkg.fileName.takeLast(120))) { }
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

        // A hand-picked file with no date stamp in its name cannot be confirmed, and
        // "no confirmation available" must not become "the update failed" — the camera
        // is already running whatever we sent it by this point. `docs/04 §0` conclusion 2
        // is the other half of the reason this is a warning rather than a wall: none of
        // the three official apps reads the version back at all, so a package whose
        // version we cannot name is still further than they go.
        val want = pkg.version
        if (want == null) {
            Diag.warn(LogTag.OTA, "package ${pkg.fileName} carries no identifiable version; skipping confirmation")
            state = OtaState.Completed
            return state
        }

        state = OtaState.ConfirmingVersion(want)
        val installed = runCatching { transport.readVersion(s2) }.getOrNull()
        if (installed == null) {
            state = OtaState.Failed("OTA version confirmation returned no version")
            return state
        }
        if (FirmwareVersion.normalize(installed) != FirmwareVersion.normalize(want)) {
            state = OtaState.Failed("OTA version mismatch: expected=$want, got=$installed")
            return state
        }

        state = OtaState.Completed
        return state
    }

    /**
     * Poll [readVersion] until the camera either confirms [target] or stays silent
     * beyond [timeoutMs]. Returning true means the camera answered with the target
     * version (i.e. it rebooted onto the new firmware). A null [target] accepts any
     * answer, which is the honest best-effort for a hand-picked package whose version
     * the file name does not state.
     */
    private suspend fun waitForReboot(target: String?, timeoutMs: Long = 60_000): Boolean {
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