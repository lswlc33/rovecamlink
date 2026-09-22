package com.rovecamlink.app.core.ble

import com.rovecamlink.app.core.log.monotonicMillis
import kotlin.random.Random

/**
 * XTU (SigmaStar / Hi35xx firmware) Bluetooth provisioning profile.
 *
 * The camera keeps BLE alive while its hotspot is off, which is what makes
 * "tap and it connects" possible at all. The sequence, verified against the
 * official client's `BLEConnectUtils`:
 *
 * 1. `R003_<code>` — offer a 4-digit code **the phone invented** (`currentTimeMillis`
 *    style, as the official client does). The camera answers `KEY=1` / `Status=1,
 *    Pin=<code>` when it takes it, and `KEY=0` when it does not.
 * 2. `R001_<code>` — open the AP; the camera answers `SSID=..,PWD=..`.
 * 3. `R002_<code>` — confirm; the camera answers `WiFi_Status=1` once the AP is up.
 *
 * Step 1 is the one a person confirms **on the camera**: it shows the code on its own
 * screen and waits. The official client says so in its own UI — `DeviceAddSetKeyFragment`
 * renders the four digits under 「请在设备上核对验证码」 (`res-strings-zh.md:1312`) and is
 * dismissed only when the camera answers. What makes the official app look
 * confirmation-free is what happens on the *second* visit to a camera it already knows:
 * `BLEConnectUtils.java:859-878` skips step 1 entirely and writes `R001_<stored code>`
 * as its first command. [resumeWithStoredKey] is that same fast path — pair once, with
 * a confirmation, then never again.
 *
 * Nobody is asked for a code on the phone: it is written *into* the camera. What the
 * 2026-09-22 field logs settled is that a code is good for **one offer**: the camera
 * answers a fresh one (with `Status=0` until it decides to pair, then `Status=1`), and
 * answers a code it has already seen with **nothing at all**. So every retry carries a
 * new code, and a stored code is spent on the fast path above rather than replayed as
 * if it were a password — which is what made this camera stop answering Bluetooth.
 */
class XtuBleProfile(
    private val pairingKeys: PairingKeyStore,
    private val clock: () -> Long = { monotonicMillis() },
) : BleCameraProfile {

    override val id: String get() = ID

    /**
     * `XTU` is the official discovery filter (`BLEScanActivity.java:46` tests
     * `name.startsWith("XTU")`, `HomeActivity.java:2648` uses `contains`). The real
     * S7Pro advertises `XTU_S7Pro_f9e5e2`, so the narrower `XTU_` would work on this
     * one camera and silently miss the ones that name themselves differently.
     */
    override val namePrefixes: List<String> = listOf("XTU")

    /** XTU's AP always hands out itself as the gateway (SSConstant.SS_IP). */
    override val expectedGateway: String? get() = "192.168.0.1"

    override fun newSession(camera: BleCamera, pairingKey: String?): BleHandshake {
        // A code we already hold for this camera is the official client's signal to skip
        // the pairing offer and open the hotspot with it directly.
        val remembered = pairingKey?.takeIf { it.isNotBlank() } ?: pairingKeys.keyFor(camera.name)
        val key = remembered ?: newPairingKey()
        return XtuBleHandshake(
            camera = camera,
            pairingKey = key,
            clock = clock,
            resumeWithStoredKey = remembered != null,
            onPairingAccepted = { accepted -> pairingKeys.remember(camera.name, accepted) },
        )
    }

    companion object {
        const val ID = "xtu"

        /** 4 decimal digits, leading zeros kept — same shape the official app uses. */
        fun newPairingKey(random: Random = Random.Default): String =
            random.nextInt(10_000).toString().padStart(4, '0')
    }
}

/**
 * Pure handshake state machine for one GATT connection. Everything that makes the
 * real cameras work lives here — the command order, the retry cadence, and the
 * tolerance for a firmware that answers the same question twice.
 *
 * Deliberately free of Android types so the framing rules are unit-testable: the
 * caller feeds notifications and clock ticks, and writes whatever comes back.
 */
internal class XtuBleHandshake(
    private val camera: BleCamera,
    private var pairingKey: String,
    private val clock: () -> Long,
    /** Open the hotspot with [pairingKey] straight away: the camera agreed to it before. */
    private val resumeWithStoredKey: Boolean = false,
    private val onPairingAccepted: (String) -> Unit,
) : BleHandshake {

    private enum class Stage { Pairing, OpeningAp, ConfirmingAp, Done, Failed }

    private var stage = if (resumeWithStoredKey) Stage.OpeningAp else Stage.Pairing
    private var lastSentAt = clock()
    private var sendsForStage = 0
    private var rotations = 0
    private var ssid: String? = null
    private var password: String? = null
    /** Still betting on a stored code the camera may have forgotten? */
    private var resuming = resumeWithStoredKey
    /** Any notification at all since the link came up — silence is what ends the bet. */
    private var heardFromCamera = false

    override fun start(): List<BleFrame> = send(
        if (stage == Stage.OpeningAp) command(OPEN_AP, pairingKey) else command(PAIR, pairingKey),
        if (stage == Stage.OpeningAp) "open-ap" else "pair",
    ).frames()

    override fun stage(): String = when (stage) {
        Stage.Pairing -> "pairing"
        Stage.OpeningAp -> "opening-hotspot"
        Stage.ConfirmingAp -> "waiting-for-ap"
        Stage.Done -> "ready"
        Stage.Failed -> "failed"
    }

    override fun onNotify(chunk: ByteArray): BleProgress {
        if (stage == Stage.Done || stage == Stage.Failed) return BleProgress.Waiting
        val reply = parseBleReply(decodeBlePayload(chunk))
        if (reply.isEmpty()) return BleProgress.Waiting
        heardFromCamera = true

        return when (stage) {
            Stage.Pairing -> onPairingReply(reply)
            Stage.OpeningAp -> onOpeningReply(reply)
            Stage.ConfirmingAp -> onConfirmReply(reply)
            else -> BleProgress.Waiting
        }
    }

    /**
     * `Status=1,Pin=1234` is the accept — the official client additionally demands a
     * non-empty `Pin` (`BLEConnectUtils.java:644-660`), which we treat as optional
     * because a firmware that only answers `Status=1` is still saying yes. `KEY=0` /
     * `Status=0` means it did not take this code — and the official client's answer
     * is to invent a new one and resend, not to bother the user. We do the same, a
     * few times, then give up.
     */
    private fun onPairingReply(reply: Map<String, String>): BleProgress {
        val status = reply[BleKeys.STATUS]
        val key = reply[BleKeys.KEY]
        val rejected = key == BleKeys.REJECTED || status == BleKeys.REJECTED
        if (rejected) {
            if (rotations >= MAX_ROTATIONS) {
                return fail(
                    "相机没有接受配对请求，请把相机靠近手机后重试",
                    BleFailure.PairingRejected,
                )
            }
            return send(command(PAIR, nextPairingCode()), "pair-retry")
        }
        if (status != BleKeys.OK && key != BleKeys.OK) return BleProgress.Waiting
        // Store what the camera echoed, the way `saveDeviceWithPin(name, Pin)` does
        // (`BLEConnectUtils.java:648-649`): that is the value the next visit's `R001_`
        // has to carry. On this firmware it is the code we just wrote — the 2026-09-22
        // 21:48 log has `R003_8310` answered by `Status=1,Pin=8310` — so the two only
        // disagree on a firmware that invents its own, and then the camera's is right.
        onPairingAccepted(reply[BleKeys.PIN]?.takeIf { it.length == 4 } ?: pairingKey)
        // This session keeps the code the camera agreed to *from us*, which is also what
        // the official client sends next (`startConnect()` → `R001_ + getCode()`).
        stage = Stage.OpeningAp
        return send(command(OPEN_AP, pairingKey), "open-ap")
    }

    /** The camera reports its own hotspot here — this is the credential we never ask for. */
    private fun onOpeningReply(reply: Map<String, String>): BleProgress {
        val reported = reply[BleKeys.SSID]
        if (reported.isNullOrEmpty()) {
            // A camera that was factory-reset, or that kept a different code, answers the
            // bet on a stored code with a refusal — or with nothing at all, which `onTick`
            // handles. Both end the bet and fall back to the pairing offer.
            val refused = reply[BleKeys.STATUS] == BleKeys.REJECTED || reply[BleKeys.KEY] == BleKeys.REJECTED
            return if (resuming && refused) fallBackToPairing() else BleProgress.Waiting
        }
        resuming = false
        ssid = reported
        password = reply[BleKeys.PASSWORD]
        stage = Stage.ConfirmingAp
        return send(command(CONFIRM, pairingKey), "confirm-ap")
    }

    /**
     * `WiFi_Status=1` means the AP is really broadcasting. Anything else is not a
     * refusal but a camera that is still bringing the AP up: the official client
     * re-sends `R002_<code>` **every second, without a cap**
     * (`BLEConnectUtils.java:750-758`) and only the caller's own timeout ends it, so
     * we keep asking too and let [com.rovecamlink.app.core.ble.BleCentral.wakeAndFetch]
     * decide when the attempt is over.
     */
    private fun onConfirmReply(reply: Map<String, String>): BleProgress {
        reply[BleKeys.SSID]?.takeIf { it.isNotEmpty() }?.let {
            ssid = it
            password = reply[BleKeys.PASSWORD]?.takeIf { p -> p.isNotEmpty() } ?: password
        }
        if (reply[BleKeys.WIFI_STATUS] != BleKeys.OK) return BleProgress.Waiting
        // Firmware that announces "AP up" without ever reporting its SSID is served by
        // the advertisement name: on XTU the two share the same `_<6 hex>` suffix.
        val network = ssid?.takeIf { it.isNotEmpty() } ?: camera.name
        stage = Stage.Done
        return BleProgress.Offered(ssid = network, password = password?.takeIf { it.isNotEmpty() })
    }

    override fun onTick(nowMs: Long): List<BleFrame> {
        if (stage == Stage.Done || stage == Stage.Failed) return emptyList()
        val interval = if (stage == Stage.ConfirmingAp) AP_POLL_INTERVAL_MS else RETRY_INTERVAL_MS
        if (nowMs - lastSentAt < interval) return emptyList()
        // Silence is the other way a stored code fails: a camera that does not know the
        // code does not argue, it just stops answering.
        if (resuming && !heardFromCamera && sendsForStage >= RESUME_PROBE_SENDS) {
            return fallBackToPairing().frames()
        }
        // Pairing and AP-open are bounded so a dead camera becomes an error instead of
        // an infinite write loop; the AP-up poll is not, because a slow camera is the
        // normal case rather than a failure.
        if (stage != Stage.ConfirmingAp && sendsForStage >= MAX_SENDS) return emptyList()
        return send(pendingCommand(), "retry").frames()
    }

    private fun pendingCommand(): String = when (stage) {
        // A retry of the pairing offer is a **new** offer, not a repeat: the camera
        // ignores a code it has already seen, which is how the 2026-09-22 20:46 run
        // spent 12 writes of `R003_6874` and 45 seconds without a single notification.
        Stage.Pairing -> command(PAIR, nextPairingCode())
        Stage.OpeningAp -> command(OPEN_AP, pairingKey)
        Stage.ConfirmingAp -> command(CONFIRM, pairingKey)
        else -> ""
    }

    /**
     * The code for the next `R003_` **retry**: always a fresh one, up to
     * [MAX_ROTATIONS] of them per attempt.
     *
     * Only retries come through here. A remembered code is no longer spent on a pairing
     * offer at all — [resumeWithStoredKey] spends it on `R001_` instead, and a first-ever
     * pairing starts from a fresh random code.
     */
    private fun nextPairingCode(): String {
        if (rotations >= MAX_ROTATIONS) return pairingKey
        rotations++
        pairingKey = XtuBleProfile.newPairingKey()
        return pairingKey
    }

    /**
     * Give up on the stored code and pair the slow way.
     *
     * This is the recovery for a camera that was reset, paired with another phone, or
     * simply keeps a different code from the one [PairingKeyStore] remembered. It costs
     * one on-screen confirmation on the camera — the thing the fast path exists to avoid
     * — and it is what keeps a stale memory from turning into a dead connect.
     */
    private fun fallBackToPairing(): BleProgress {
        resuming = false
        stage = Stage.Pairing
        return send(command(PAIR, nextPairingCode()), "pair-after-stale-key")
    }

    private fun send(text: String, reason: String): BleProgress {
        if (text != lastCommand) {
            lastCommand = text
            sendsForStage = 0
        }
        lastSentAt = clock()
        sendsForStage++
        return BleProgress.Send(listOf(BleFrame(text.encodeToByteArray(), reason)))
    }

    private fun fail(message: String, kind: BleFailure = BleFailure.Other): BleProgress {
        stage = Stage.Failed
        return BleProgress.Failed(message, kind)
    }

    private fun command(prefix: String, key: String): String = prefix + key

    private var lastCommand: String = ""

    companion object {
        const val PAIR = "R003_"
        const val OPEN_AP = "R001_"
        const val CONFIRM = "R002_"

        /** Resend the pending command this often; the camera answers within ~1s. */
        const val RETRY_INTERVAL_MS = 1_500L

        /**
         * While waiting for the AP to come up, the official client polls once a
         * second (`BLEConnectUtils.java:750-758`); a hotspot takes longer than our
         * old 8 x 1.5 s budget to start on a cold camera.
         */
        const val AP_POLL_INTERVAL_MS = 1_000L

        /**
         * How many unanswered `R001_` writes a resumed session tolerates before it stops
         * betting on the stored code and offers a pairing code instead.
         *
         * Four, at [RETRY_INTERVAL_MS], is ~6 s: past the point where a camera that knows
         * the code has usually answered, and early enough that a reset camera still has
         * most of [com.rovecamlink.app.core.ble.BleCentral.wakeAndFetch]'s budget left to
         * pair the slow way.
         */
        const val RESUME_PROBE_SENDS = 4

        /**
         * Cap on repeating **the same** command, so a dead camera becomes an error
         * instead of an infinite write loop.
         *
         * It used to be 8, measured against the wrong clock: the 2026-09-22 log has the
         * camera taking 7 to 17 seconds to answer the first `R003_`, so eight writes at
         * [RETRY_INTERVAL_MS] went quiet at ~12 s — before the camera decided to answer.
         *
         * For the pairing stage this cap barely applies any more, because
         * [nextPairingCode] changes the command text on every retry and the counter
         * resets with it; [MAX_ROTATIONS] and the caller's handshake budget are what
         * bound pairing now. This one still ends a silent `R001_`/`R002_` wait.
         */
        const val MAX_SENDS = 16

        /**
         * How many *distinct* pairing codes one attempt may offer, counting a retry
         * after a refusal and a retry after silence alike — see [nextPairingCode].
         *
         * This was 3, and 3 is not enough on the XTU S7PRO: one attempt was answered
         * `Status=0,Pin=…` four times in a row and ended as 「相机没有接受配对请求」, while
         * another seconds later was accepted on the **third** reply. The camera's
         * pairing state settles somewhere inside that window, so a cap of four races
         * with it. Twelve codes at the camera's ~1 s answer time stay well inside
         * [com.rovecamlink.app.core.ble.BleCentral.wakeAndFetch]'s budget, and that
         * timeout — not this number — is what ends a camera that is genuinely off.
         */
        const val MAX_ROTATIONS = 12
    }
}

private fun BleProgress.frames(): List<BleFrame> =
    (this as? BleProgress.Send)?.frames ?: emptyList()
