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

    /**
     * The firmware's marker for "this row has no value" — a row the user taps to
     * *do* something (`SD Format`, `Information`, `Time Set`) rather than to choose
     * between options.
     */
    const val ACTION = "-"

    /** One row of [parsePrimary]: [isAction] rows are tappable but carry no value. */
    data class PrimaryItem(val name: String, val value: String, val isAction: Boolean)

    /** Item names with the current value the primary listing claims for each. */
    fun parsePrimary(body: String?): List<Pair<String, String>> =
        parsePrimaryItems(body).map { it.name to it.value }

    /**
     * The primary menu as rows, with the action rows marked.
     *
     * An **action row** is one the user taps to *do* something instead of choosing a
     * value (`SD Format`, `Information`, `Time Set` on the device menu). It reaches
     * the UI as a plain [CameraSetting][com.rovecamlink.app.core.model.CameraSetting]
     * with an empty `value` **and** an empty `options` list, because that model has no
     * action flag — a free-value item with no current value looks the same from here.
     *
     * `cur` is positional, and a missing value appears as an **empty slot**
     * (`"ON,,AUTO"`). The previous reader filtered empty entries the way it filters
     * the item names, which slid every later value one item to the left; the
     * official parser pads the holes instead — `SSResponseParse.java:391-399`
     * replaces `,,` with `,-,`, prefixes/suffixes a lone `-`, and appends `,-` until
     * the two lists are the same length — and then types a `-`/empty row as CLICK,
     * i.e. a button with no value to show (`:405-411`). Same rule here, with two
     * deliberate differences:
     *
     *  - When `cur` is **absent or blank as a whole**, no row is called an action. A
     *    firmware that answers only `item` would otherwise turn its entire settings
     *    page into dead buttons; the per-item read still gets a chance to supply the
     *    value.
     *  - An action row's [PrimaryItem.value] is `""`, never the literal `-`, so a
     *    caller that shows "current value" shows nothing instead of a dash.
     */
    fun parsePrimaryItems(body: String?): List<PrimaryItem> {
        val vars = HiVarParser.parse(body)
        val items = vars["item"].orEmpty().split(',').map { it.trim() }.filter { it.isNotEmpty() }
        if (items.isEmpty()) return emptyList()
        val cur = vars["cur"]?.trim()
        val positional = if (cur.isNullOrEmpty()) null else cur.split(',').map { it.trim() }
        return items.mapIndexed { i, name ->
            val slot = positional?.getOrNull(i)?.takeIf { it.isNotEmpty() }
            PrimaryItem(
                name = name,
                value = slot?.takeIf { it != ACTION } ?: "",
                isAction = positional != null && (slot == null || slot == ACTION),
            )
        }
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
