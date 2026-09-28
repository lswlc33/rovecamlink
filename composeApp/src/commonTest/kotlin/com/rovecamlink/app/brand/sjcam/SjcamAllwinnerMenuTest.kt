package com.rovecamlink.app.brand.sjcam

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Guard for the Allwinner `Menu` reader.
 *
 * The vendor's own nesting is the contract (`AllWinnerCameraHttp.java:360-425`): each entry is
 * a setting whose `Value` is an **index** into its `MenuList`, while the wire value to write is
 * that option's `Index` and the label is its `id`. Reading `Value` as the value itself — the
 * obvious mistake — would send the wrong number back to the camera.
 */
class SjcamAllwinnerMenuTest {

    private val menu = """
        {"Menu":[
          {"Cmd":2002,"Name":"Resolution","Value":1,"Type":3,
           "MenuList":[{"id":"4K30","Index":0},{"id":"1080P60","Index":11},{"id":"720P120","Index":14}]},
          {"Cmd":2008,"Name":"Date Stamp","Value":0,"Type":1,
           "MenuList":[{"id":"Close","Index":0},{"id":"Open","Index":1}]}
        ]}
    """.trimIndent()

    @Test
    fun `each menu entry becomes a setting with its option list`() {
        val rows = SjcamAllwinnerChannel.parseMenu(menu)
        assertEquals(2, rows.size)

        val resolution = rows[0]
        assertEquals("2002", resolution.id)
        assertEquals("Resolution", resolution.title)
        assertEquals(listOf("0" to "4K30", "11" to "1080P60", "14" to "720P120"), resolution.options.map { it.value to it.label })
    }

    @Test
    fun `the current value is the index resolved through the option list`() {
        val rows = SjcamAllwinnerChannel.parseMenu(menu)
        // Value=1 → MenuList[1] → Index 11. Not "1", and not "1080P60".
        assertEquals("11", rows[0].value)
        assertEquals("0", rows[1].value)
    }

    @Test
    fun `a body that is not this menu yields nothing`() {
        assertTrue(SjcamAllwinnerChannel.parseMenu(null).isEmpty())
        assertTrue(SjcamAllwinnerChannel.parseMenu("not json").isEmpty())
        assertTrue(SjcamAllwinnerChannel.parseMenu("""{"result":0}""").isEmpty())
    }
}
