package com.rovecamlink.app.brand.tuwin

import com.rovecamlink.app.core.model.DeviceInfo
import com.rovecamlink.app.core.model.DeviceStatus
import com.rovecamlink.app.core.model.SdCardState
import com.rovecamlink.app.core.model.WorkMode
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonObject

/**
 * The status half of the TUWIN REST family: what its replies are judged by
 * ([looksLike]) and what they mean ([parse]).
 *
 * Both live here on purpose. The probe decides which plugin drives a camera, and the
 * registry is asked in order, so a probe that is too generous takes a camera away from the
 * family that can actually drive it. The rule this replaced
 * (`body.contains("status", true) || body.trim().startsWith("{")`) had exactly that hole:
 * iCatch's Qz profile answers `/app/getdeviceattr` with `{"result":0,"info":{"ssid":…}}`,
 * which is a JSON object, so a TUWIN probe that merely wanted a `{` claimed a dash cam and
 * then drove it with `/api/...` requests it never answers. Keeping the key vocabulary in
 * one file is what stops the parser and the fingerprint from drifting apart.
 *
 * Two independent facts bound what [parse] may claim:
 *
 *  - **The envelope is not evidence.** `result` + `info` is the shape *both* families use
 *    for every reply, so neither name may decide anything.
 *  - **Case is not evidence either.** Keys are matched case-insensitively — a camera that
 *    upper-cases them is still this family's camera, and refusing it would report "no
 *    camera found" for a device sitting right there.
 *
 * `info` and the top level are both searched, in that order, because the archive's field
 * list and this plugin's original reads disagree about which holds the data (`docs/08
 * 01-TUWIN-档案.md` §2.1 row 4 vs. the flat names the first implementation used). The
 * disagreement is recorded here rather than guessed at.
 */
internal object TuwinStatus {

    // ---- what a reply's keys are judged by (the probe) ----------------------

    /** Field names `Ride3ProDeviceStatusInfo` declares for `/api/device/status`. */
    private val statusKeys = setOf(
        "adapter_status",
        "battery_percent",
        "battery_level",
        "current_mode",
        "mode_active",
        "recording_time",
        "exception_flags",
        "hdr_chk_cnt",
    )

    /** The flat names the first implementation read. */
    private val flatKeys = setOf(
        "battery",
        "batterylevel",
        "record",
        "recording",
        "mode",
        "recordtime",
        "videotime",
    )

    private val json = Json { ignoreUnknownKeys = true; isLenient = true }

    /**
     * True when [body] reads as this family's status answer.
     *
     * Deliberately absent from the vocabulary: `status`, `value`, `result`, `info`. iCatch's
     * `/app/getsdinfo` answers `{"result":0,"info":{"status":"0",…}}`, so accepting either of
     * those names — at any depth — puts the two families back in conflict.
     */
    fun looksLike(body: String?): Boolean {
        val trimmed = body?.trim() ?: return false
        if (!trimmed.startsWith("{")) return false
        val obj = runCatching { json.parseToJsonElement(trimmed).jsonObject }.getOrNull()
            ?: return false
        if (obj.hasFingerprint()) return true
        val envelope = obj.entries.firstOrNull { it.key.equals("info", ignoreCase = true) }?.value
            ?: return false
        return runCatching { envelope.jsonObject }.getOrNull()?.hasFingerprint() ?: false
    }

    private fun JsonObject.hasFingerprint(): Boolean =
        keys.any { it.lowercase() in statusKeys || it.lowercase() in flatKeys }

    // ---- what a reply means (the parser) ------------------------------------

    /**
     * `/api/device/status` + `/api/sd/info`, as far as this family's firmware documents
     * them. Either body may be null (the request failed) — every field then falls back to
     * its own "not known", never to an invented value.
     *
     * `recording` is always false here and that is not a claim: this family's status reply
     * has **no** recording field at all — the official app tracks recording as a local
     * event (`docs/08 01-TUWIN-档案.md` §5.3, "不用 `recording_time` 字段") — which is why
     * the plugin declares `reportsRecordingState = false` so this `false` never overwrites
     * what the record button actually established.
     */
    fun parse(statusBody: String?, sdBody: String?): DeviceStatus {
        val status = Reply.of(statusBody)
        val sd = Reply.of(sdBody)
        return DeviceStatus(
            battery = status?.int("battery_percent", "battery_level", "battery", "batterylevel"),
            recording = false,
            mode = status?.int("current_mode")?.let(::workModeOf),
            // `total` / `free` only: those are what §2.1 row 12 documents for this endpoint.
            // The legacy Ride5 line spells them `sdtotalspace` / `sdfreespace` — a different
            // platform with its own plugin — and the bare `totalspace` / `freespace` pair is
            // iCatch's, so neither belongs in this family's vocabulary.
            sdTotalMb = sd?.int("total")?.toLong(),
            sdFreeMb = sd?.int("free")?.toLong(),
            sdState = sd?.sdState(),
            videoTimeSec = status?.int("recording_time", "recordtime", "videotime"),
            photoCount = sd?.int("photocount"),
            videoCount = sd?.int("videocount"),
            raw = status?.fields() ?: emptyMap(),
        )
    }

    /**
     * `/api/device/info` — the facts the About page and the diagnostics header show.
     *
     * Found by the same mistake [parse] was: this endpoint's fields live in `info` too
     * (`docs/08 01-TUWIN-档案.md` §2.1 row 3), so reading them off the top level left the
     * model, firmware version, serial, MAC, SSID and SoC all blank on a camera that was
     * answering perfectly well.
     *
     * Null when the body does not decode or carries no fields at all — "the camera said
     * nothing" has to stay distinguishable from "the camera said it has no model".
     */
    fun deviceInfo(body: String?): DeviceInfo? {
        val reply = Reply.of(body) ?: return null
        // An answer carrying none of the facts this endpoint exists for is not device info —
        // and `{"result":0}` must land here rather than turn into a row of blanks, because
        // "the camera said nothing" and "the camera reported no model" are different things
        // to the About page.
        if (identityKeys.none { reply.string(it) != null }) return null
        return DeviceInfo(
            model = reply.string("model")?.ifEmpty { null },
            softVersion = reply.string("swver")?.ifEmpty { null },
            hardVersion = reply.string("hwver")?.ifEmpty { null },
            serialNumber = reply.string("uuid")?.ifEmpty { null },
            mac = reply.string("mac")?.ifEmpty { null },
            ssid = reply.string("ssid")?.ifEmpty { null },
            soc = reply.string("soc")?.ifEmpty { null },
            raw = redact(reply.fields()),
        )
    }

    /** The fields `/api/device/info` is asked for; one of them present means it answered. */
    private val identityKeys =
        listOf("model", "uuid", "swver", "hwver", "mac", "ssid", "soc", "region")

    /**
     * Drop secrets from a raw echo before it reaches the diagnostics log.
     *
     * `DeviceInfo.raw` travels into exported logs, and this family's `/api/device/info`
     * answers a `pwd` beside the SSID (`docs/08 01-TUWIN-档案.md` §2.1 row 3) — the camera's
     * own hotspot passphrase. `core.model.CameraWifi` exists for exactly this reason ("a
     * secret must not travel in a bag like that"), so the key is removed here rather than
     * masked: a reader of the log has no use for the length of a password either.
     */
    private val secretKeys = setOf("pwd", "passwd", "password", "passphrase", "psk", "wpa", "secret")

    private fun redact(fields: Map<String, String>): Map<String, String> =
        fields.filterKeys { it.lowercase() !in secretKeys }

    /**
     * `current_mode` → [WorkMode], for the one value that is unambiguous.
     *
     * `2` is playback and is named as such in three places in the official app; `0` is
     * "preview/record" — the point of the *stream*, not the shooting mode, since photo vs.
     * video is a menu item on this family and not a mode — so it is deliberately not mapped
     * to [WorkMode.VIDEO]. `1` has no constant or use site anywhere in the decompiled app
     * (`docs/08 01-TUWIN-档案.md` §2.1 row 11).
     */
    private fun workModeOf(currentMode: Int): WorkMode? = when (currentMode) {
        2 -> WorkMode.PLAYBACK
        else -> null
    }

    /**
     * The SD code, which on this family is **not** the hi3510 family's vocabulary: here `0`
     * means a healthy card and `2` means no card (`docs/08 01-TUWIN-档案.md` §5.2.2, the
     * three-set table). Feeding `0` to [SdCardState.fromRaw] — which reads the XTU family's
     * `SDOK` / `NOSD` words — reports a perfectly good card as an error, and that is what
     * this plugin used to do.
     *
     * A missing `status` is not "unknown" to the official app: it falls back to the capacity
     * (`total > 0` → no card, else format required), and that rule is reproduced here rather
     * than replaced with a null, so the card row keeps saying something true.
     */
    private fun Reply.sdState(): SdCardState {
        val status = primitive("status")
        val code = status?.intOrNull ?: status?.contentOrNull?.toIntOrNull()
        if (code != null) {
            return when (code) {
                0 -> SdCardState.OK
                2 -> SdCardState.MISSING
                else -> SdCardState.ERROR // what the official app renders as 「点击去格式化」
            }
        }
        // Not a number: either the field is absent (null) or a spelling from another
        // firmware line, which the shared vocabulary still understands.
        if (status == null) {
            return if ((int("total") ?: 0) > 0) SdCardState.MISSING else SdCardState.ERROR
        }
        return SdCardState.fromRaw(status.contentOrNull)
    }

    /**
     * One reply, read through to whichever object actually holds the fields.
     *
     * The scope list is ordered `info` first, then the outer object, and every lookup walks
     * that order — so the documented shape wins when both are present, while a firmware that
     * answers flat still reads correctly.
     */
    private class Reply(private val scopes: List<JsonObject>) {

        fun int(vararg keys: String): Int? {
            for (key in keys) {
                for (scope in scopes) {
                    val hit = scope.entry(key) ?: continue
                    val value = hit.intOrNull ?: hit.contentOrNull?.toIntOrNull()
                    if (value != null) return value
                }
            }
            return null
        }

        fun primitive(key: String): JsonPrimitive? =
            scopes.firstNotNullOfOrNull { it.entry(key) }

        fun string(key: String): String? = primitive(key)?.contentOrNull

        /**
         * The innermost object's own fields, for the diagnostics echo — with the envelope's
         * own keys (`result`, `info`) left out. They describe the reply, not the camera, and
         * `result=0` in an exported log reads like a camera fact to whoever is reading it.
         */
        fun fields(): Map<String, String> =
            scopes.first().entries
                .filterNot { it.key.lowercase() in envelopeKeys }
                .associate { (k, v) ->
                    k to ((v as? JsonPrimitive)?.contentOrNull ?: v.toString())
                }

        private fun JsonObject.entry(key: String): JsonPrimitive? =
            entries.firstOrNull { it.key.equals(key, ignoreCase = true) }?.value as? JsonPrimitive

        companion object {
            /** The envelope's own keys — see [Reply.fields]. */
            private val envelopeKeys = setOf("result", "info")

            fun of(body: String?): Reply? {
                val trimmed = body?.trim() ?: return null
                val outer = runCatching { json.parseToJsonElement(trimmed).jsonObject }.getOrNull()
                    ?: return null
                val inner = outer.entries.firstOrNull { it.key.equals("info", ignoreCase = true) }
                    ?.value
                    ?.let { runCatching { it.jsonObject }.getOrNull() }
                return Reply(listOfNotNull(inner, outer))
            }
        }
    }
}
