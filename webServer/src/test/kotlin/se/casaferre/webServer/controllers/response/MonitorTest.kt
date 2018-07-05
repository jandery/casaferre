package se.casaferre.webServer.controllers.response

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * Created by Jorgen Andersson on 2018-07-05.
 */
class MonitorTest {

    @Test
    fun monitor_defaultConstructor_ok() {
        assertThat(Monitor().status).isEqualTo("OK")
    }

    @Test
    fun monitor_setter_tada() {
        assertThat(Monitor(status = "tada").status).isEqualTo("tada")
    }
}