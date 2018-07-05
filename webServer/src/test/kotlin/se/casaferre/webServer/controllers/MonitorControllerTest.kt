package se.casaferre.webServer.controllers

import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.BeforeClass
import org.junit.Test
import se.casaferre.webServer.controllers.mocks.MockedMonitorService

/**
 * Created by Jorgen Andersson on 2018-07-05.
 */
class MonitorControllerTest {

    companion object {
        val mockedService = MockedMonitorService()
        val testController = ControllerServer()

        @BeforeClass
        @JvmStatic
        fun setupClass() {
            MonitorController(mockedService)
            spark.Spark.awaitInitialization()
        }
    }

    /**
     * Clear Mock after each test
     */
    @After
    fun afterTest() {
        mockedService.clear()
    }

    @Test
    fun monitorController_monitorStatus_StillAlive() {
        //
        val request = testController.testServer.get("/monitor/status", false)
        val response = testController.testServer.execute(request)
        assertThat(response.code()).isEqualTo(200)
        val body = String(response.body())
        assertThat(body).isEqualTo("""{"status":"OK"}""")
    }

    @Test
    fun monitorController_monitorDbWrite_true() {
        //
        val request = testController.testServer.post("/monitor/db/write", "", false)
        val response = testController.testServer.execute(request)
        assertThat(response.code()).isEqualTo(200)
        val body = String(response.body())
        assertThat(body).isEqualTo("true")
    }

    @Test
    fun monitorController_monitorDbRead_true() {
        //
        testController.testServer.execute(testController.testServer.post("/monitor/db/write", "", false))
        //
        val request = testController.testServer.get("/monitor/db/read", false)
        val response = testController.testServer.execute(request)
        assertThat(response.code()).isEqualTo(200)
        val body = String(response.body())
        assertThat(body).isEqualTo("true")
    }
}