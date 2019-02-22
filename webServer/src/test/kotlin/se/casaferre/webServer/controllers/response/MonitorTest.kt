package se.casaferre.webServer.controllers.response

import org.junit.Test
import org.junit.jupiter.api.Assertions

/**
 * Created by Jorgen Andersson on 2018-07-05.
 */
class MonitorTest {

    @Test
    fun monitor_defaultConstructor_ok() {
        Assertions.assertEquals(Monitor().status, "OK")
    }

    @Test
    fun monitor_setter_tada() {
        Assertions.assertEquals(Monitor(status = "tada").status, "tada")
    }
}