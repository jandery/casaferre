package se.casaferre.webServer.controllers.utils

import org.junit.Test
import org.junit.jupiter.api.Assertions
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

/**
 * Created by Jorgen Andersson on 2018-07-05.
 */
class ControllerUtilTest {

    data class Ctr(val title: String, val value: Long, val created: LocalDateTime)

    val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("UTC"))

    private val SINGLE_OBJECT = Ctr(
            title = "Single object title",
            value = 500L,
            created = LocalDateTime.parse("2018-05-09 01:00:00", dateTimeFormatter))

    private val MULTIPLE_OBJECTS = listOf(
            Ctr(
                    title = "First Multilist title",
                    value = 400L,
                    created = LocalDateTime.parse("2018-05-09 02:00:00", dateTimeFormatter)),
            Ctr(
                    title = "Second Mutilist title",
                    value = 300L,
                    created = LocalDateTime.parse("2018-05-09 03:00:00", dateTimeFormatter)),
            SINGLE_OBJECT)

    private val SINGLE_STRING = """{"title":"Single object title","value":500,"created":"2018-05-09T01:00:00.000Z"}"""

    private val MULTIPLE_STRING = """[{"title":"First Multilist title","value":400,"created":"2018-05-09T02:00:00.000Z"},{"title":"Second Mutilist title","value":300,"created":"2018-05-09T03:00:00.000Z"},{"title":"Single object title","value":500,"created":"2018-05-09T01:00:00.000Z"}]"""

    @Test
    fun objectToString_searilize_singleString() {
        val str = ControllerUtil.objectToString(SINGLE_OBJECT)
        Assertions.assertEquals(str,SINGLE_STRING)
    }

    @Test
    fun stringToObject_deserailize_singleObject() {
        val obj = ControllerUtil.stringToObject(SINGLE_STRING, Ctr::class.java)
        Assertions.assertEquals(obj.title,"Single object title")
    }

    @Test
    fun objectListToString_serialize_mutipleString() {
        val str = ControllerUtil.objectListToString(MULTIPLE_OBJECTS)
        Assertions.assertEquals(str,MULTIPLE_STRING)
    }

    @Test
    fun stringToObjects_deserialize_multipleObjects() {
        val objs = ControllerUtil.stringToObjectList(MULTIPLE_STRING, Ctr::class.java)
        Assertions.assertEquals(objs,MULTIPLE_OBJECTS)
    }
}