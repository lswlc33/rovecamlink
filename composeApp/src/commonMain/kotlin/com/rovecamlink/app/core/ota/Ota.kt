package com.rovecamlink.app.core.ota

import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogLevel
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.storage.sanitizeFileName
import kotlin.coroutines.cancellation.CancellationException
import okio.FileSystem
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
 * (`docs/analysis/ota-and-gaps §5`), against a phone whose Java heap the 2026-09-22 field log puts around
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
 * screen was never wired into the vendor's own manifest (`docs/analysis/ota-and-gaps §1.2(b)`), so it has no
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
    private val fileSystem: FileSystem = FileSystem.SYSTEM,
    /**
     * Whether a package whose header cannot be read may still be sent.
     *
     * True only for the hand-picked local-file route (`docs/analysis/ota-and-gaps §6.1` R9): a user choosing
     * an arbitrary file off their own disk is the one case where "we do not recognise
     * this" is not the same as "this is wrong" — it may be a rescue image the vendor never
     * published. The index route has no such excuse: we know what that endpoint serves, so
     * an unrecognised header there means the download is not what it claims.
     */
    private val allowUnverifiedPackage: Boolean = false,
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
            session = runCatching { connect() }.getOrElse { e ->
                if (e is CancellationException) throw e
                state = OtaState.Failed("连不上相机：${e.message ?: "没有应答"}")
                return state
            }
        } else {
            session = runCatching { connect() }.getOrElse { e ->
                if (e is CancellationException) throw e
                state = OtaState.Cancelled
                return state
            }
        }

        // R1/R2 of `docs/analysis/ota-and-gaps §6.1`, and the last moment they can be applied: the image is
        // read here, on the phone, *before* the camera is told anything. Refusing a package
        // that is for another model or is short a few megabytes costs one 256-byte read;
        // discovering it afterwards is the bricking scenario the whole section is about.
        val refusal = verifyImage(pkg, session.model)
        if (refusal != null) {
            state = OtaState.Failed(refusal)
            return state
        }

        state = OtaState.Uploading
        // The file name is server- or user-supplied and lands verbatim in the multipart
        // `filename="..."` of the transports, so it is sanitised here, on the last hop
        // before it becomes a protocol string: control characters, quotes and separators
        // are neutralised and the length is capped (the previous `takeLast` kept the tail
        // and could drop the extension instead of a prefix).
        val install = runCatching {
            transport.install(session, pkg.copy(fileName = sanitizeFileName(pkg.fileName))) { }
        }.getOrElse { e ->
            if (e is CancellationException) throw e
            CmdResult.Failure(e.message ?: "transfer failed")
        }

        if (state.isTerminal) return state
        if (install !is CmdResult.Ok) {
            val msg = (install as? CmdResult.Failure)?.message ?: "上传失败"
            state = OtaState.Failed(msg)
            return state
        }

        // Camera restarts and/or the Wi-Fi session drops: wait for it to come back.
        state = OtaState.Installing
        val back = waitForReboot(pkg.version)
        if (state.isTerminal) return state
        if (!back) {
            state = OtaState.Failed("相机在更新后没有回来（等待 60 秒无应答）")
            return state
        }

        state = OtaState.Reconnecting
        val s2 = runCatching { connect() }.getOrElse { e ->
            if (e is CancellationException) throw e
            state = OtaState.Failed("重连失败：${e.message ?: "没有应答"}")
            return state
        }

        // A hand-picked file with no date stamp in its name cannot be confirmed, and
        // "no confirmation available" must not become "the update failed" — the camera
        // is already running whatever we sent it by this point. `docs/analysis/ota-and-gaps §0` conclusion 2
        // is the other half of the reason this is a warning rather than a wall: none of
        // the three official apps reads the version back at all, so a package whose
        // version we cannot name is still further than they go.
        val want = pkg.version
        if (want == null) {
            Diag.warn(LogTag.OTA, "package ${pkg.fileName} carries no identifiable version; skipping confirmation")
            state = OtaState.Completed
            return state
        }
        // A non-null `want` is not by itself comparable: if neither side normalises to a
        // date stamp, comparing them would be `null == null` and a failed update would pass
        // silently. Only a usable stamp counts as evidence, so a package whose version
        // cannot be normalised takes the same "cannot confirm" branch as a null version.
        val w = FirmwareVersion.normalize(want)
        if (w == null) {
            Diag.warn(LogTag.OTA, "package ${pkg.fileName} version $want has no comparable date stamp; skipping confirmation")
            state = OtaState.Completed
            return state
        }

        state = OtaState.ConfirmingVersion(want)
        val installed = runCatching { transport.readVersion(s2) }.getOrElse { e ->
            if (e is CancellationException) throw e
            null
        }
        if (installed == null) {
            state = OtaState.Failed("回读版本时相机没有给出固件版本，无法确认是否更新成功")
            return state
        }
        if (FirmwareVersion.normalize(installed) != w) {
            state = OtaState.Failed("版本核对不符：期望 $want，相机自报 $installed")
            return state
        }

        state = OtaState.Completed
        return state
    }

    /**
     * Read the package's own header and judge it against the camera it would be sent to.
     *
     * Returns the reason to refuse, or null when the package may go. The messages are
     * Chinese because [OtaState.Failed] is rendered verbatim on the settings page — the
     * diagnostic detail (model found vs model expected, declared vs actual bytes) goes to
     * the log as well, in English, where the rest of the OTA trail lives.
     */
    private fun verifyImage(pkg: FirmwarePackage, cameraModel: String): String? {
        val read = FirmwareImage.read(fileSystem, pkg.path)
        if (read == null) {
            return if (allowUnverifiedPackage) {
                Diag.warn(LogTag.OTA, "image header unreadable for ${pkg.fileName}; sending anyway (hand-picked file)")
                null
            } else {
                "读不到固件包的头部，无法确认它是不是给这台相机的；已拒绝送包"
            }
        }
        val (bytes, actualBytes) = read
        val expected = GkuFirmwareIndex.firmwareModelOf(cameraModel)
        return when (val check = FirmwareImage.judge(FirmwareImage.parse(bytes), actualBytes, expected)) {
            is FirmwareImage.Check.Ok -> {
                Diag.info(
                    LogTag.OTA,
                    "image header ok model=${check.model} version=${check.version ?: "-"} bytes=$actualBytes",
                )
                null
            }

            is FirmwareImage.Check.WrongModel -> {
                Diag.at(
                    LogLevel.ERROR, LogTag.OTA,
                    "image header model=${check.found} but camera is ${check.expected ?: "unknown"}; refusing to send ${pkg.fileName}",
                )
                "这个固件包是给 ${check.found} 的，相机自报 ${check.expected ?: "未知型号"}。" +
                    "型号不符的镜像刷进去可能再也开不了机，已拒绝送包。"
            }

            is FirmwareImage.Check.Truncated -> {
                Diag.at(
                    LogLevel.ERROR, LogTag.OTA,
                    "image header declares ${check.declaredBytes}B but the file is ${check.actualBytes}B",
                )
                "固件包不完整：头部声明 ${check.declaredBytes} 字节，实际 ${check.actualBytes} 字节；已拒绝送包。"
            }

            is FirmwareImage.Check.Unrecognised -> {
                if (allowUnverifiedPackage) {
                    Diag.warn(LogTag.OTA, "${check.reason}; sending anyway (hand-picked file)")
                    null
                } else {
                    Diag.at(LogLevel.ERROR, LogTag.OTA, "refusing ${pkg.fileName}: ${check.reason}")
                    "${check.reason}；已拒绝送包。"
                }
            }
        }
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
            // A fresh [connect] per poll is deliberate, not a leak: the camera is rebooting,
            // so a session captured before the reboot would be stale, and [connect] only
            // performs the attribute read into an immutable [CameraSession] — there is no
            // session handle to close (the shared HTTP machinery lives in the graph, not in
            // the session). The one thing that *is* wrong here is swallowing cancellation,
            // which would turn a user's 取消 into one more probe and a bogus result.
            val v = runCatching { transport.readVersion(connect()) }.getOrElse { e ->
                if (e is CancellationException) throw e
                null
            }
            if (v == null) continue
            if (want == null) return true      // no usable target — any answer is a reboot ack
            if (FirmwareVersion.normalize(v) == want) return true
        }
        return false
    }
}