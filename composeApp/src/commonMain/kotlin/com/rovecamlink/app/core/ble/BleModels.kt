package com.rovecamlink.app.core.ble

/**
 * A camera seen in Bluetooth LE advertising — before any Wi-Fi exists between us.
 *
 * This is the entry point of the "tap and it connects" flow: the ad name tells us
 * which brand profile to use, and the profile's handshake then hands back the
 * hotspot credentials ([BleWifiOffer]) instead of making the user dig through
 * system Settings.
 */
data class BleCamera(
    /** Android MAC address, or the platform's stable peer identifier. */
    val address: String,
    /** Advertised / GATT device name, e.g. `XTU_S7Pro_f9e5e2`. */
    val name: String,
    /** Signal strength in dBm, for sorting the list the user reads. */
    val rssi: Int,
    /** Which [BleCameraProfile] matched this name. */
    val profileId: String,
)

/** What the camera told us over Bluetooth about the hotspot it just opened. */
data class BleWifiOffer(
    val ssid: String,
    val password: String?,
    val camera: BleCamera,
    /** Gateway the brand always uses, when known — lets discovery skip probing. */
    val expectedGateway: String? = null,
)

/** Why a handshake stopped, so the caller can pick the right next move. */
enum class BleFailure {
    /** The camera said no to the pairing code → generate a new one and re-prompt. */
    PairingRejected,

    /** Nothing answered over Bluetooth → tell the user to move closer / check BLE. */
    NoAnswer,

    /** Anything else; show the message and fall back to Wi-Fi connect. */
    Other,
}

/** Outcome of one wake-and-fetch attempt. */
sealed interface BleOutcome {
    data class WifiOffered(val offer: BleWifiOffer) : BleOutcome

    /** Platform has no Bluetooth at all (desktop) or it is not implemented yet (iOS shell). */
    data object Unsupported : BleOutcome
    data object PermissionsDenied : BleOutcome
    data object BluetoothOff : BleOutcome
    data class Failed(val message: String, val kind: BleFailure = BleFailure.Other) : BleOutcome
}

/** One frame to write to the camera's GATT characteristic. */
class BleFrame(val bytes: ByteArray, val reason: String) {
    override fun toString(): String = "$reason(${bytes.size}B)"
}

/**
 * Progress reported by a [BleHandshake] after it consumes one notification chunk.
 * Deliberately free of platform types so the whole protocol can be unit-tested.
 */
sealed interface BleProgress {
    /** More frames to write (retries included). */
    data class Send(val frames: List<BleFrame>) : BleProgress
    /** Nothing to do; keep waiting for notifications. */
    data object Waiting : BleProgress
    /** The camera opened its AP and gave us the credentials. */
    data class Offered(val ssid: String, val password: String?) : BleProgress
    /** Terminal failure — the caller should fall back to another route. */
    data class Failed(
        val message: String,
        val kind: BleFailure = BleFailure.Other,
    ) : BleProgress
}

/**
 * A brand's Bluetooth side: how to recognise it in an advertisement, and how to
 * drive the wake-the-hotspot handshake. Pure logic lives in [newSession]; only
 * the bytes on the wire differ per brand, which is what keeps this plugin-friendly.
 */
interface BleCameraProfile {
    val id: String

    /** Case-insensitive advertisement-name prefixes that identify this brand. */
    val namePrefixes: List<String>

    fun matches(name: String): Boolean =
        namePrefixes.any { name.startsWith(it, ignoreCase = true) }

    /**
     * Fresh handshake for one connection attempt.
     *
     * [pairingKey] is the short code the camera shows on its own screen (XTU: 4
     * digits). Brands that need none simply ignore it.
     */
    fun newSession(camera: BleCamera, pairingKey: String?): BleHandshake

    /** Fixed AP gateway for this brand, when the firmware guarantees one. */
    val expectedGateway: String? get() = null
}

/**
 * Platform-independent handshake state machine. The caller feeds it notification
 * chunks and periodic ticks; it says what to write and when it is done.
 *
 * Implementations must never block and must never touch platform APIs — that is
 * what makes the framing/retry/timeout rules testable on the desktop JVM.
 */
interface BleHandshake {
    /** Frames to write as soon as notifications are enabled. */
    fun start(): List<BleFrame>

    /** Consume one notification chunk (may be a fragment of a logical frame). */
    fun onNotify(chunk: ByteArray): BleProgress

    /**
     * Called periodically so the machine can retry and eventually give up.
     * [nowMs] is a monotonic clock reading, injectable for tests.
     */
    fun onTick(nowMs: Long): List<BleFrame>

    /** Human-readable stage for the UI ("pairing", "opening hotspot", ...). */
    fun stage(): String
}

/**
 * Bluetooth LE client. On Android this wraps `BluetoothLeScanner` + GATT; other
 * platforms report [isAvailable] = false so the app degrades to Wi-Fi scanning
 * instead of pretending it can provision over Bluetooth.
 */
interface BleCentral {
    val isAvailable: Boolean

    /** Ask for BLUETOOTH_SCAN / BLUETOOTH_CONNECT (or legacy + location below 31). */
    suspend fun ensurePermissions(): Boolean

    /** Whether the phone's adapter is on. False means "tell the user", not "retry". */
    fun isAdapterEnabled(): Boolean

    /**
     * Start a background scan that keeps accumulating advertisements until
     * [stopScan]. The connection screen's 2-second refresh cycle is a *reader* of
     * the result, not a series of scans: an Android LE scan torn down and restarted
     * every two seconds misses the advertisement packets it was not listening for in
     * the gap, which is how a camera that is plainly in range stops appearing.
     *
     * Returns false when nothing could start (no adapter, permission denied, adapter
     * switched off) — the caller reports that as a reason, never as an empty list.
     */
    fun startScan(profiles: List<BleCameraProfile>): Boolean

    /** The cameras heard from lately, strongest signal first. Thread-safe to poll. */
    fun scannedCameras(): List<BleCamera>

    /** Stop the background scan and keep what was seen (a later scan adds to it). */
    fun stopScan()

    /** Forget every advertisement, so a manual refresh cannot show a gone camera. */
    fun clearScanResults()

    /**
     * Connect, run the profile's handshake, and return the hotspot the camera
     * opened. Never throws: every failure arrives as a [BleOutcome].
     *
     * [pairingKey] is the code to use when the user has just typed one; pass null
     * to let the profile reuse what it remembered for this camera (or generate a
     * fresh code for the user to enter on the camera's screen).
     */
    suspend fun wakeAndFetch(
        camera: BleCamera,
        profile: BleCameraProfile,
        pairingKey: String? = null,
        timeoutMs: Long = DEFAULT_HANDSHAKE_MS,
    ): BleOutcome

    /** Abandon an in-flight [wakeAndFetch] (user cancelled, or we lost the peer). */
    fun abort()

    companion object {
        /** A camera not heard from for this long is dropped from the list. */
        const val STALE_AFTER_MS = 12_000L
        const val DEFAULT_HANDSHAKE_MS = 25_000L
    }
}

/** expect factory; each platform supplies its own implementation. */
expect fun createBleCentral(): BleCentral
