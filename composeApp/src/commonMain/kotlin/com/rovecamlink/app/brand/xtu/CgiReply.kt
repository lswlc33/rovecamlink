package com.rovecamlink.app.brand.xtu

/**
 * Verdict on one hi3510 CGI *command* reply (`record.cgi`, `photo.cgi`,
 * `setcurworkmode.cgi`, `setcurparameter.cgi`, ...).
 *
 * HTTP status is worthless on this protocol: the camera's thttpd answers `200 OK`
 * even when the firmware refused the command. The real verdict is in the body —
 * the sentinel `Success` when it accepted, and a `SvrFuncResult="<code>"` when it
 * did not. That is the rule the official app uses (`hisilicon/dv/biz/Command.java`),
 * and the 2026-09-21 XTU S7PRO field log shows why it matters: a
 * `setcurworkmode.cgi` that came back `SvrFuncResult="0xFFFFF752"` was reported to
 * the user as a success, so the UI retried it 23 times.
 */
sealed interface CgiReply {
    /** Body said `Success`, or carried no rejection and the transport answered. */
    data object Accepted : CgiReply

    /** Firmware refused: [code] is the normalised (signed decimal) result code. */
    data class Rejected(val code: String, val body: String) : CgiReply

    /** No answer at all — the socket/HTTP layer failed, so nothing was applied. */
    data object NoAnswer : CgiReply

    val isOk: Boolean get() = this is Accepted
}

object Cgi {
    /** Body sentinel that means "the firmware took the command". */
    const val SUCCESS = "Success"

    /** Marker the firmware uses for every refusal, whatever the reason. */
    const val RESULT_KEY = "SvrFuncResult"

    /** Classify a command reply. [body] is the raw response text, or null if it never came. */
    fun verdict(body: String?): CgiReply {
        if (body == null) return CgiReply.NoAnswer
        val trimmed = body.trim()
        if (trimmed.isEmpty()) return CgiReply.NoAnswer
        val rejected = HiVarParser.parse(trimmed)[RESULT_KEY]
        if (rejected != null) return CgiReply.Rejected(normaliseCode(rejected), trimmed)
        if (trimmed.contains("sd is not ready", true) || trimmed.contains("sd is full", true)) {
            return CgiReply.Rejected(normaliseCode(rejectedLiteral(trimmed) ?: trimmed), trimmed)
        }
        return CgiReply.Accepted
    }

    private fun rejectedLiteral(body: String): String? =
        listOf("sd is not ready", "sd is full").firstOrNull { body.contains(it, ignoreCase = true) }

    /**
     * `0xFFFFF752` and `-2222` are the same firmware code — some endpoints send
     * signed decimals, others the raw two's-complement hex. Normalising both to
     * decimal is what lets one message table cover them.
     */
    fun normaliseCode(raw: String): String {
        val text = raw.trim()
        if (!text.startsWith("0x", ignoreCase = true)) return text
        val asLong = text.substring(2).toLongOrNull(16) ?: return text
        val signed = if (asLong > 0x7FFFFFFFL) asLong - 0x1_0000_0000L else asLong
        return signed.toString()
    }

    /**
     * Percent-encode one CGI query value. This protocol prefixes every parameter
     * with `-` and space-separates its words (`-name=Gyro EIS`, `-workmode=Normal
     * Video`), and menu values can carry non-ASCII (`360° Horizon Correction`), so
     * a plain `replace(" ", "%20")` is not enough for the value to survive the
     * camera's thttpd. Unreserved characters stay literal, everything else becomes
     * UTF-8 `%XX`.
     */
    fun param(value: String): String = buildString(value.length) {
        for (byte in value.encodeToByteArray()) {
            val b = byte.toInt() and 0xFF
            val isUnreserved = b in 'a'.code..'z'.code || b in 'A'.code..'Z'.code ||
                b in '0'.code..'9'.code || b == '-'.code || b == '.'.code || b == '_'.code || b == '~'.code
            if (isUnreserved) append(b.toChar()) else append("%").append(HEX[b shr 4]).append(HEX[b and 0x0F])
        }
    }

    private val HEX = "0123456789ABCDEF".toCharArray()

    /** A one-line explanation for the user, from the codes this camera family is
     * known to produce. `-2222` is the generic "this parameter/name is not valid
     * right now" — it is what the firmware answers for an unknown work-mode string
     * and for a menu item name it does not have.
     */
    fun explain(code: String): String = when (code.lowercase()) {
        "sd is not ready" -> "SD card not ready — insert or format a card"
        "sd is full" -> "SD card full"
        "-2222" -> "Camera rejected the parameter (code -2222): unknown name/value, or not allowed in the current mode"
        else -> OPERATION_CODES[code] ?: "Camera refused the command (code $code)"
    }

    /**
     * The firmware's own operation-result codes, which arrive in the same
     * `SvrFuncResult` field as `-2222` but mean something far more specific.
     *
     * These constants are the ones the official client defines and then maps to its own
     * strings (`Common.java:28-39` → `error_channel_busy`「录像忙」, `error_sd_full`
     * 「SD卡满」, `error_no_sd`「无SD卡」 …). Two of them answer the multi-client
     * question the app used to have no way to ask: `ERR_CHANNEL_BUSY` is what the
     * camera says when the recording channel is already held — which in practice is
     * the other phone live-previewing the same camera — and `ERR_GET_CHANNEL_STATE_FAIL`
     * is the camera admitting it cannot tell. Before this table both arrived as
     * "Camera refused the command (code -1560182777)", which named the problem in a
     * way nobody could act on.
     *
     * `ERR_CHANNEL_BUSY` is the only contention signal this whole protocol has. The
     * family offers no client count and no station list, `getcamerastatus.cgi` answers
     * an empty body on the XTU S7PRO, and the official client never reads its `count`
     * field — so "someone else is previewing" can only ever be inferred from this
     * refusal, which is why its text names both holders of the channel *and* the way
     * out. The firmware's own string for the same code is just 「录像忙」.
     */
    private val OPERATION_CODES = mapOf(
        "-1560182774" to "Camera rejected the shot parameters (抓拍参数错误)",
        "-1560182775" to "Stopping the recording failed (停止录像失败)",
        "-1560182776" to "Starting the recording failed (启动录像失败)",
        "-1560182777" to "Recording channel busy (录像忙) — another client is previewing, or the camera is already recording. Stop the recording, or take the camera back from the other client, then try again",
        "-1560182778" to "Camera could not read its own recording state (获取录像状态失败)",
        "-1560182779" to "No space left for snapshots (抓拍空间满)",
        "-1560182780" to "No space left for loop recording (循环录像空间满)",
        "-1560182781" to "No space left for recording (录像空间满)",
        "-1560182782" to "SD card error (SD卡错误) — the card may need a reformat",
        "-1560182783" to "SD card full (SD卡满)",
        "-1560182784" to "No SD card in the camera (无SD卡)",
        "-1610579967" to "No space left for recording (录像空间满)",
    )
}
