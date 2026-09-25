package com.rovecamlink.app.brand.icatch

import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

/** QzIC `{result, info}` envelope + file-list shapes, from QzIC.java handlers. */
class QzJsonTest {

    @Test
    fun acceptedReadsTheResultKey() {
        assertTrue(QzJson.accepted("""{"result":0,"info":{}}"""))
        assertFalse(QzJson.accepted("""{"result":1,"info":{}}"""))
        assertFalse(QzJson.accepted("""{"result":-1}"""))
        // A non-JSON body carries no verdict → transport decides (same rule as TUWIN).
        assertTrue(QzJson.accepted("<html>ok</html>"))
        assertFalse(QzJson.accepted(null))
        assertTrue(QzJson.accepted(""))
    }

    @Test
    fun infoExtractsTheEnvelopePayload() {
        assertEquals("1", QzJson.infoObject("""{"result":0,"info":{"value":"1"}}""")?.stringOf("value"))
        assertNull(QzJson.infoObject("""{"result":1}"""))
        assertNull(QzJson.infoObject("not json"))
    }

    @Test
    fun fileListFlattensFoldersAndSortsNameDescending() {
        // Shape from QzIC.getFileList: info[] groups by folder, files[] carries the
        // full device path in `name` (handleFileType, QzIC.java:61-87).
        val body = """
            {"result":0,"info":[
              {"folder":"loop","files":[
                {"name":"/mnt/sdcard/normal/20260101_120001.mp4","duration":61,"size":12582912,
                 "createtime":1767225600,"createtimestr":"2026-01-01 12:00:01","type":1},
                {"name":"/mnt/sdcard/normal/20260101_120002.mp4","duration":60,"size":11582912,
                 "createtime":1767225660,"createtimestr":"2026-01-01 12:01:00","type":1}
              ]},
              {"folder":"event","files":[
                {"name":"/mnt/sdcard/photo/20260101_120003.jpg","duration":0,"size":2411724,
                 "createtime":1767225720,"createtimestr":"2026-01-01 12:02:00","type":2}
              ]}
            ]}
        """.trimIndent()
        val files = QzJson.fileList(body)
        assertEquals(3, files.size)
        // Sorted by full name descending — the official client's Collections.sort.
        assertEquals("20260101_120003.jpg", files[0].leafName)
        assertEquals("20260101_120002.mp4", files[1].leafName)
        assertEquals("loop", files[1].folder)
        assertEquals(12_582_912L, files[2].sizeBytes)
        assertEquals(61, files[2].durationSec)
        assertEquals(1_767_225_600L, files[2].createTime)
    }

    @Test
    fun fileListOnEmptyAndBrokenReplies() {
        assertTrue(QzJson.fileList("""{"result":0,"info":[]}""").isEmpty())
        assertTrue(QzJson.fileList("""{"result":1,"info":[]}""").isEmpty())
        assertTrue(QzJson.fileList("gateway timeout").isEmpty())
        assertTrue(QzJson.fileList(null).isEmpty())
    }

    @Test
    fun paramItemsPairsItemsWithIndex() {
        // getparamitems shape: info[{name, items[], index[]}] parallel arrays.
        val body = """
            {"result":0,"info":[
              {"name":"rec_resolution","items":["1080P","720P"],"index":[0,1]},
              {"name":"switchcam","items":["front","back"],"index":[0,1]}
            ]}
        """.trimIndent()
        val items = QzJson.paramItems(body)
        assertEquals(2, items.size)
        val res = items["rec_resolution"].orEmpty()
        assertEquals(2, res.size)
        assertEquals("1080P", res[0].label)
        assertEquals("0", res[0].value)
        assertEquals("720P", res[1].label)
    }

    @Test
    fun paramItemsOnBrokenReply() {
        assertTrue(QzJson.paramItems(null).isEmpty())
        assertTrue(QzJson.paramItems("""{"result":0,"info":{}}""").isEmpty())
    }

    private fun kotlinx.serialization.json.JsonObject.stringOf(key: String): String? =
        (this[key] as? kotlinx.serialization.json.JsonPrimitive)?.contentOrNull
}
