package com.rovecamlink.app.brand.xtu

import com.rovecamlink.app.core.model.CameraSetting

/**
 * The two menu endpoints of the NewAPP firmware, reduced to plain data.
 *
 * Kept apart from [HisiliconProtocol] because this is where every settings bug of
 * the 2026-09-21 XTU S7PRO session lived, and it can be tested against the exact
 * bytes the camera sent without an HTTP client in the way:
 *
 *  - `getprimarymenuitem.cgi` answers **both** variables on one line, which a
 *    line-based reader merges into one mangled item list (20 items became 39,
 *    alternating real names and their current values).
 *  - `getsecondmenuitem.cgi` answers `SvrFuncResult="-2222"` for any name the
 *    camera does not have — with HTTP 200, so only the body tells them apart.
 *  - The authoritative current value is the second menu's `value`, not the
 *    positionally-matched entry of the primary `cur` list.
 */
object HiMenu {

    /** Item names with the current value the primary listing claims for each. */
    fun parsePrimary(body: String?): List<Pair<String, String>> {
        val vars = HiVarParser.parse(body)
        val items = vars["item"].csv()
        val curs = vars["cur"].csv()
        return items.mapIndexed { i, name -> name to (curs.getOrNull(i) ?: "") }
    }

    /**
     * Options and current value for one item, or null when the camera rejected the
     * name. An empty option list is legitimate (a free-value item), a rejection is not.
     */
    fun parseSecondary(name: String, body: String?): Item? {
        val vars = HiVarParser.parse(body)
        vars[Cgi.RESULT_KEY]?.let { return null }
        val options = vars["item"].csv()
        val current = vars["value"]?.trim()?.ifEmpty { null }
            ?: vars["cur"]?.trim()?.ifEmpty { null }
        if (options.isEmpty() && current == null) return null
        return Item(
            name = name,
            value = current ?: "",
            options = options.map { CameraSetting.Option(it, it) },
        )
    }

    data class Item(val name: String, val value: String, val options: List<CameraSetting.Option>)

    private fun String?.csv(): List<String> =
        this?.split(',')?.map { it.trim() }?.filter { it.isNotEmpty() } ?: emptyList()
}
