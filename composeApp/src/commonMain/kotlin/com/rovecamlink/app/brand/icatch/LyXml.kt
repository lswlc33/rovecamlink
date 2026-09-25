package com.rovecamlink.app.brand.icatch

/**
 * Parsers for the LyIC (Novatek-style) XML dialect — the `?custom=1&cmd=` family on
 * `192.168.1.254`.
 *
 * Every shape here is copied from the official client's parser
 * (`_work/idgo_live_src/sources/com/icatch/golive/utils/XmlParseUtil.java`), which
 * reads with an XmlPullParser and therefore tolerates attribute noise, extra
 * whitespace and mixed nesting the same way a tag-scanning parser does. Two shapes
 * matter beyond a plain tag read and are pinned by tests:
 *
 * - `cmd=3014` answers paired `<Cmd>NNNN</Cmd><Status>value</Status>` elements; the
 *   value belongs to the *preceding* Cmd tag, not to any global stream position
 *   (`parseXMLToStringWithPull`, XmlParseUtil.java:54-77).
 * - `cmd=3031` answers triples `<Cmd>NNNN</Cmd><Index>k</Index><Id>…</Id>` where only
 *   Cmd ∈ {2003, 2011, 8010, 8011} survive upstream (`parseXMLToMenuItemWithPull`,
 *   XmlParseUtil.java:19-52) — a firmware may list more, and the official app drops
 *   the rest.
 */
object LyXml {

    /** First `name` element's text, or null. Used by the single-value replies (Value, SSID, …). */
    fun firstTag(body: String?, name: String): String? {
        if (body.isNullOrEmpty()) return null
        val idx = indexOfTagOpen(body, name) ?: return null
        val start = idx + name.length + 2
        val close = body.indexOf("</$name", start)
        if (close < 0) return null
        return unescape(body.substring(start, close)).trim()
    }

    /**
     * The `cmd=3014` reply: pairs of `<Cmd>NNNN</Cmd>` + `<Status>…</Status>`.
     * Returns cmd -> status in document order. A `<Status>` with no preceding
     * `<Cmd>` is dropped, mirroring the official parser's `strNextText != null` guard.
     */
    fun cmdStatusPairs(body: String?): Map<String, String> {
        if (body.isNullOrEmpty()) return emptyMap()
        val out = linkedMapOf<String, String>()
        var pos = 0
        while (pos < body.length) {
            val cmd = nextElement(body, "Cmd", pos) ?: break
            val status = nextElement(body, "Status", cmd.end)
            if (status == null) {
                // A Cmd with no following Status ends the parse — nothing later can pair.
                break
            }
            out[cmd.text] = status.text
            pos = status.end
        }
        return out
    }

    /**
     * The `cmd=3031&str=all` menu-capability reply, restricted to the four Cmds the
     * official app consumes. Returns (cmd -> Index) for Cmd2003's Id lookup and
     * (cmd -> [Id]) for the others, exactly as `parseXMLToMenuItemWithPull` buckets them.
     */
    fun menuItems(body: String?): Map<String, List<MenuItem>> {
        if (body.isNullOrEmpty()) return emptyMap()
        val out = linkedMapOf<String, MutableList<MenuItem>>()
        var pos = 0
        while (true) {
            val cmd = nextElement(body, "Cmd", pos) ?: break
            val index = nextElement(body, "Index", cmd.end)
            val id = index?.let { nextElement(body, "Id", it.end) }
            if (id != null && cmd.text in KNOWN_MENU_CMDS) {
                out.getOrPut(cmd.text) { mutableListOf() }
                    .add(MenuItem(cmd = cmd.text, index = index.text, id = id.text))
            }
            pos = if (id != null) id.end else cmd.end
        }
        return out
    }

    /**
     * The `cmd=3015` file-list reply: a sequence of `<ALLFile>` blocks, each carrying
     * `NAME / FPATH / SIZE / TIMECODE / TIME / ATTR`. Returned in document order —
     * the official parser reverses the list at the end, but its UI then sorts/feeds it
     * by date anyway; we keep newest-first by reversing here like the official parser.
     */
    fun fileList(body: String?): List<LyFile> {
        if (body.isNullOrEmpty()) return emptyList()
        val out = mutableListOf<LyFile>()
        var pos = 0
        while (true) {
            val open = body.indexOf("<ALLFile", pos)
            if (open < 0) break
            val close = body.indexOf("</ALLFile", open)
            val blockEnd = if (close < 0) body.length else close
            val block = body.substring(open, blockEnd)
            out += LyFile(
                name = firstTag(block, "NAME").orEmpty(),
                fpath = firstTag(block, "FPATH").orEmpty(),
                size = firstTag(block, "SIZE")?.toLongOrNull() ?: 0L,
                timecode = firstTag(block, "TIMECODE").orEmpty(),
                time = firstTag(block, "TIME").orEmpty(),
                attr = firstTag(block, "ATTR").orEmpty(),
            )
            pos = blockEnd
        }
        out.reverse()
        return out
    }

    /** One `<Item Index>` from `cmd=3030` (recording-resolution capability indices). */
    fun indices(body: String?): List<String> {
        if (body.isNullOrEmpty()) return emptyList()
        val out = mutableListOf<String>()
        var pos = 0
        while (true) {
            val idx = indexOfTagOpen(body, "Index", pos) ?: break
            val start = idx + "Index".length + 2
            val close = body.indexOf("</Index", start)
            if (close < 0) break
            out += unescape(body.substring(start, close)).trim()
            pos = close
        }
        return out
    }

    data class MenuItem(val cmd: String, val index: String, val id: String)

    data class LyFile(
        val name: String,
        val fpath: String,
        val size: Long,
        val timecode: String,
        val time: String,
        val attr: String,
    )

    /** Cmds the official menu parser keeps (XmlParseUtil.java:16-52); the rest are dropped. */
    val KNOWN_MENU_CMDS = setOf("2003", "2011", "8010", "8011")

    private data class Element(val text: String, val end: Int)

    /**
     * The first `name` element at/after [from]. Returns the element's text and the
     * index just past its `</name>` close tag, so pairing loops can chain from there.
     */
    private fun nextElement(body: String, name: String, from: Int): Element? {
        val open = indexOfTagOpen(body, name, from) ?: return null
        val start = open + name.length + 2
        val close = body.indexOf("</$name", start)
        if (close < 0) return null
        return Element(unescape(body.substring(start, close)).trim(), close + name.length + 3)
    }

    /**
     * Index of the `<` that opens the first `<name…>` element at/after [from], or null.
     * "<Value>" must not match "<ValueX>" — the char after the name has to be a tag
     * terminator (whitespace, '/', or '>').
     */
    private fun indexOfTagOpen(body: String, name: String, from: Int = 0): Int? {
        var i = from
        while (true) {
            val candidate = body.indexOf("<$name", i)
            if (candidate < 0) return null
            val after = candidate + name.length + 1
            if (after >= body.length) return null
            val c = body[after]
            if (c == '>' || c == '/' || c.isWhitespace()) return candidate
            i = candidate + 1
        }
    }

    private fun unescape(s: String): String = s
        .replace("&lt;", "<")
        .replace("&gt;", ">")
        .replace("&quot;", "\"")
        .replace("&apos;", "'")
        .replace("&amp;", "&")
}
