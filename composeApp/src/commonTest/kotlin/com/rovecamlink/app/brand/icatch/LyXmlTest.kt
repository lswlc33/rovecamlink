package com.rovecamlink.app.brand.icatch

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

/**
 * Wire shapes are pinned against the official client's parser
 * (`_work/idgo_live_src/sources/com/icatch/golive/utils/XmlParseUtil.java`) and the
 * archive's appendix B, so a refactor that changes what we send or how we read a
 * reply breaks here instead of on a real camera.
 */
class LyXmlTest {

    @Test
    fun firstTagReadsSSIDAndPassphrase() {
        val body = "<?xml version=\"1.0\" ?>\n<Function>\n<SSID>DVR_C5Pro</SSID>\n" +
            "<PASSPHRASE>1234567890</PASSPHRASE>\n</Function>"
        assertEquals("DVR_C5Pro", LyXml.firstTag(body, "SSID"))
        assertEquals("1234567890", LyXml.firstTag(body, "PASSPHRASE"))
        assertNull(LyXml.firstTag(body, "MISSING"))
        assertNull(LyXml.firstTag(null, "SSID"))
        assertNull(LyXml.firstTag("", "SSID"))
    }

    @Test
    fun firstTagDoesNotMatchLongerTagNames() {
        // "<Values>" must not answer a "Value" read.
        val body = "<Function><Values>19</Values></Function>"
        assertNull(LyXml.firstTag(body, "Value"))
        assertEquals("19", LyXml.firstTag(body, "Values"))
    }

    @Test
    fun cmdStatusPairsKeepCmdValueAssociation() {
        // cmd=3014 shape: each Status belongs to the Cmd right before it.
        val body = "<Function>" +
            "<Cmd>2002</Cmd><Status>11</Status>" +
            "<Cmd>2011</Cmd><Status>2</Status>" +
            "<Cmd>8011</Cmd><Status>1</Status>" +
            "</Function>"
        assertEquals(
            mapOf("2002" to "11", "2011" to "2", "8011" to "1"),
            LyXml.cmdStatusPairs(body),
        )
    }

    @Test
    fun cmdStatusPairsDropDanglingStatus() {
        val body = "<Function><Status>7</Status><Cmd>2004</Cmd><Status>1</Status></Function>"
        assertEquals(mapOf("2004" to "1"), LyXml.cmdStatusPairs(body))
    }

    @Test
    fun cmdStatusPairsOnEmptyAndBrokenInput() {
        assertTrue(LyXml.cmdStatusPairs(null).isEmpty())
        assertTrue(LyXml.cmdStatusPairs("").isEmpty())
        // A Cmd with no Status pair contributes nothing.
        assertTrue(LyXml.cmdStatusPairs("<Cmd>2002</Cmd>").isEmpty())
    }

    @Test
    fun fileListParsesAllFileBlocksNewestFirst() {
        val body = "<Function>" +
            "<ALLFile><NAME>20260101120000.mp4</NAME><FPATH>A:\\normal\\20260101120000.mp4</FPATH>" +
            "<SIZE>12582912</SIZE><TIMECODE>32</TIMECODE><TIME>20260101120000</TIME><ATTR>33</ATTR></ALLFile>" +
            "<ALLFile><NAME>2026010112030000.jpg</NAME><FPATH>A:\\photo\\2026010112030000.jpg</FPATH>" +
            "<SIZE>2411724</SIZE><TIMECODE>0</TIMECODE><TIME>20260101120300</TIME><ATTR>32</ATTR></ALLFile>" +
            "</Function>"
        val files = LyXml.fileList(body)
        assertEquals(2, files.size)
        // Document order reversed, like XmlParseUtil.parseXMLWithPull's final reverse.
        assertEquals("2026010112030000.jpg", files[0].name)
        assertEquals("20260101120000.mp4", files[1].name)
        assertEquals("A:\\normal\\20260101120000.mp4", files[1].fpath)
        assertEquals(12_582_912L, files[1].size)
        assertEquals("33", files[1].attr)
    }

    @Test
    fun fileListOnEmptyInput() {
        assertTrue(LyXml.fileList(null).isEmpty())
        assertTrue(LyXml.fileList("<Function></Function>").isEmpty())
    }

    @Test
    fun indicesReadsItemIndexList() {
        // cmd=3030 shape from XmlParseUtil.parseXMLToVideoItemWithPull.
        val body = "<Function><Item Index=\"1\"/><Item Index=\"11\"/><Item Index=\"15\"/></Function>"
        // Attributes do not produce Index elements; a firmware that uses child elements does.
        assertEquals(emptyList(), LyXml.indices(body))
        val childForm = "<Function><Item><Index>1</Index></Item><Item><Index>11</Index></Item></Function>"
        assertEquals(listOf("1", "11"), LyXml.indices(childForm))
    }

    @Test
    fun menuItemsKeepOnlyKnownCmds() {
        val body = "<Function>" +
            "<Cmd>2003</Cmd><Index>0</Index><Id>0</Id>" +
            "<Cmd>2003</Cmd><Index>1</Index><Id>1</Id>" +
            "<Cmd>9999</Cmd><Index>2</Index><Id>9</Id>" +
            "<Cmd>2011</Cmd><Index>0</Index><Id>0</Id>" +
            "</Function>"
        val menus = LyXml.menuItems(body)
        assertEquals(setOf("2003", "2011"), menus.keys)
        assertEquals(2, menus["2003"]?.size)
        assertEquals("0", menus["2011"]?.first()?.index)
    }

    @Test
    fun unescapesXmlEntities() {
        assertEquals("a<b&c", LyXml.firstTag("<R><T>a&lt;b&amp;c</T></R>", "T"))
    }
}
