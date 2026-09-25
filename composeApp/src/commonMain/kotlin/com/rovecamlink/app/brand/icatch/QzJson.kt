package com.rovecamlink.app.brand.icatch

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.longOrNull

/**
 * Parsers for the QzIC / YzIC JSON dialect — the `/app/…` + `/api/…` family served on
 * `192.168.169.1` (and, via the never-selected `LyCmdWithYzIC` profile, on `.254`).
 *
 * Envelope: `{"result": <int, 0 = success>, "info": …}` — the official client gates
 * every handler on `getInt("result") != 0 → failure` (e.g. QzIC.java:203, :252), so a
 * reply without a `result` key is not this family's shape at all.
 *
 * File list: `{"result":0,"info":[{"folder":"loop","files":[{name, duration, size,
 * createtime, createtimestr, type}, …]}, …]}` — `name` is the **full device path**
 * (`/mnt/sdcard/…/xxx.mp4`), `size` sits beside a `MediaInformation.KEY_SIZE` key that
 * is literally `"size"`, and the official client sorts the flattened list by name
 * descending (`handleFileType`, QzIC.java:61-87). Pagination windows are
 * `start = prev_end + 1`, `end = prev_end + 101` (QzIC.java:279-286) — a stride of
 * **101**, not 100.
 */
object QzJson {

    private val json = Json { ignoreUnknownKeys = true; isLenient = true }

    /**
     * True when a reply means "the camera accepted this" for a write endpoint.
     * A body that is not a JSON object carries no verdict and is judged by the
     * transport alone — the same rule TuwinRestProtocol applies.
     */
    fun accepted(body: String?): Boolean {
        val text = body ?: return false
        val obj = runCatching { json.parseToJsonElement(text).jsonObject }.getOrNull() ?: return true
        val result = (obj["result"] as? JsonPrimitive)?.contentOrNull ?: return true
        return result.trim() == "0"
    }

    /** The whole `info` element of a `{result, info}` envelope, or null. */
    fun info(body: String?): JsonElement? {
        val text = body ?: return null
        val obj = runCatching { json.parseToJsonElement(text).jsonObject }.getOrNull() ?: return null
        return obj["info"]
    }

    fun infoObject(body: String?): JsonObject? = info(body) as? JsonObject

    /**
     * Flattens a `getfilelist` reply into per-file rows across every `folder` block,
     * newest-name first (the official client's `Collections.sort` by name, descending).
     */
    fun fileList(body: String?): List<QzFile> {
        val info = info(body) as? JsonArray ?: return emptyList()
        val out = mutableListOf<QzFile>()
        for (group in info) {
            val groupObj = group as? JsonObject ?: continue
            val folder = groupObj.string("folder") ?: continue
            val files = groupObj["files"] as? JsonArray ?: continue
            for (f in files) {
                val o = f as? JsonObject ?: continue
                val name = o.string("name") ?: continue
                out += QzFile(
                    folder = folder,
                    name = name,
                    // Leaf name = path's last segment; the official client splits the
                    // same way (`strArrSplit[strArrSplit.length - 1]`, FileInfo.java:19).
                    leafName = name.substringAfterLast('/').ifEmpty { name },
                    durationSec = o.int("duration") ?: 0,
                    sizeBytes = o.long("size") ?: 0L,
                    createTime = o.long("createtime"),
                    createTimeStr = o.string("createtimestr"),
                    type = o.int("type") ?: 0,
                )
            }
        }
        out.sortByDescending { it.name }
        return out
    }

    /**
     * The `getparamitems?param=all` capability rows: `{info:[{name, items[], index[]}]}`.
     * `items` and `index` are parallel arrays (label ↔ wire value).
     */
    fun paramItems(body: String?): Map<String, List<ParamOption>> {
        val info = info(body) as? JsonArray ?: return emptyMap()
        val out = linkedMapOf<String, List<ParamOption>>()
        for (row in info) {
            val o = row as? JsonObject ?: continue
            val name = o.string("name") ?: continue
            val items = o["items"] as? JsonArray ?: continue
            val index = o["index"] as? JsonArray ?: continue
            val options = items.mapIndexedNotNull { i, label ->
                val value = index.getOrNull(i) ?: return@mapIndexedNotNull null
                ParamOption(
                    value = (value as? JsonPrimitive)?.contentOrNull ?: value.toString(),
                    label = (label as? JsonPrimitive)?.contentOrNull ?: label.toString(),
                )
            }
            out[name] = options
        }
        return out
    }

    data class QzFile(
        val folder: String,
        val name: String,
        val leafName: String,
        val durationSec: Int,
        val sizeBytes: Long,
        val createTime: Long?,
        val createTimeStr: String?,
        val type: Int,
    )

    data class ParamOption(val value: String, val label: String)

    private fun JsonObject.string(key: String): String? =
        (get(key) as? JsonPrimitive)?.contentOrNull

    private fun JsonObject.int(key: String): Int? =
        (get(key) as? JsonPrimitive)?.intOrNull

    private fun JsonObject.long(key: String): Long? =
        (get(key) as? JsonPrimitive)?.longOrNull
}
