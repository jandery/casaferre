package se.casaferre.webServer.controllers.response

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

/**
 * Created by Jorgen Andersson on 2018-07-05.
 */
class MonitorTest {

    @Test
    fun `Status with argument is OK`() {
        Assertions.assertEquals(Monitor().status, "OK") {
            "Status without argument failed"
        }
    }

    @Test
    fun `Status with argument is Tada`() {
        Assertions.assertEquals(Monitor(status = "tada").status, "tada") {
            "Status with argument failed"
        }
    }
}