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
 * Nothing here asks the user for anything: the code is written *into* the camera,
 * which is why the official app connects without a single prompt. When the camera
 * refuses a code the client simply offers a new one — [XtuBleHandshake] does that
 * too, then remembers the accepted code per advertisement name so later connects
 * replay it silently.
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
        val key = pairingKey?.takeIf { it.isNotBlank() }
            ?: pairingKeys.keyFor(camera.name)
            ?: newPairingKey()
        return XtuBleHandshake(camera, key, clock) { accepted ->
            pairingKeys.remember(camera.name, accepted)
        }
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
    private val onPairingAccepted: (String) -> Unit,
) : BleHandshake {

    private enum class Stage { Pairing, OpeningAp, ConfirmingAp, Done, Failed }

    private var stage = Stage.Pairing
    private var lastSentAt = clock()
    private var sendsForStage = 0
    private var rotations = 0
    private var ssid: String? = null
    private var password: String? = null

    override fun start(): List<BleFrame> = send(command(PAIR, pairingKey), "pair").frames()

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
            rotations++
            pairingKey = XtuBleProfile.newPairingKey()
            return send(command(PAIR, pairingKey), "pair-retry")
        }
        if (status != BleKeys.OK && key != BleKeys.OK) return BleProgress.Waiting
        onPairingAccepted(reply[BleKeys.PIN]?.takeIf { it.isNotEmpty() } ?: pairingKey)
        stage = Stage.OpeningAp
        return send(command(OPEN_AP, pairingKey), "open-ap")
    }

    /** The camera reports its own hotspot here — this is the credential we never ask for. */
    private fun onOpeningReply(reply: Map<String, String>): BleProgress {
        val reported = reply[BleKeys.SSID]
        if (reported.isNullOrEmpty()) return BleProgress.Waiting
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
        // Pairing and AP-open are bounded so a dead camera becomes an error instead of
        // an infinite write loop; the AP-up poll is not, because a slow camera is the
        // normal case rather than a failure.
        if (stage != Stage.ConfirmingAp && sendsForStage >= MAX_SENDS) return emptyList()
        return send(pendingCommand(), "retry").frames()
    }

    private fun pendingCommand(): String = when (stage) {
        Stage.Pairing -> command(PAIR, pairingKey)
        Stage.OpeningAp -> command(OPEN_AP, pairingKey)
        Stage.ConfirmingAp -> command(CONFIRM, pairingKey)
        else -> ""
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

        /** Cap so a dead camera becomes an error instead of an infinite write loop. */
        const val MAX_SENDS = 8

        /** Times we invent a fresh code and re-offer it before telling the user. */
        const val MAX_ROTATIONS = 3
    }
}

private fun BleProgress.frames(): List<BleFrame> =
    (this as? BleProgress.Send)?.frames ?: emptyList()
