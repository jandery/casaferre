package se.casaferre.webServer.controllers.utils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PropertyUtilTest {

    @Test
    fun `read message from POM in test environment`() {
        val expected = "Message for test"
        val msg = PropertyUtil.readHejmo()
        Assertions.assertEquals(expected, msg) {
            "'$msg' does not match '$expected'"
        }
    }
}