package se.casaferre.webServer.controllers.utils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

/**
 * Created by Jorgen Andersson on 2018-07-05.
 */
class ControllerUtilTest {

    data class Ctr(val title: String, val value: Long, val created: LocalDateTime)

    private val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("UTC"))

    private val SingleObject = Ctr(
            title = "Single object title",
            value = 500L,
            created = LocalDateTime.parse("2018-05-09 01:00:00", dateTimeFormatter))

    private val MultipleObjects = listOf(
            Ctr(
                    title = "First Multilist title",
                    value = 400L,
                    created = LocalDateTime.parse("2018-05-09 02:00:00", dateTimeFormatter)),
            Ctr(
                    title = "Second Mutilist title",
                    value = 300L,
                    created = LocalDateTime.parse("2018-05-09 03:00:00", dateTimeFormatter)),
            SingleObject)

    private val SingleString = """{"title":"Single object title","value":500,"created":"2018-05-09T01:00:00.000Z"}"""
    private val MultipleString = """[{"title":"First Multilist title","value":400,"created":"2018-05-09T02:00:00.000Z"},{"title":"Second Mutilist title","value":300,"created":"2018-05-09T03:00:00.000Z"},{"title":"Single object title","value":500,"created":"2018-05-09T01:00:00.000Z"}]"""

    @Test
    fun `Deserialize Object`() {
        val str = ControllerUtil.objectToString(SingleObject)
        Assertions.assertEquals(str, SingleString) {
            "'$str' does not match '$SingleString'"
        }
    }

    @Test
    fun `Serialize Object`() {
        val obj = ControllerUtil.stringToObject(SingleString, Ctr::class.java)
        Assertions.assertEquals(obj.title, "Single object title") {
            "'${obj.title}' does not match 'Single object title'"
        }
    }

    @Test
    fun `Deserialize list of objects`() {
        val str = ControllerUtil.objectListToString(MultipleObjects)
        Assertions.assertEquals(str, MultipleString) {
            "Failed to Deserialize $str"
        }
    }

    @Test
    fun `Serialize list of objects`() {
        val objs = ControllerUtil.stringToObjectList(MultipleString, Ctr::class.java)
        Assertions.assertEquals(objs, MultipleObjects) {
            "Failed to Serialize to $MultipleString"
        }
    }
}