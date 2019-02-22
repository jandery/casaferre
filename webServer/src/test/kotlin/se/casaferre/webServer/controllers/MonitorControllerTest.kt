package se.casaferre.webServer.controllers

import org.junit.After
import org.junit.BeforeClass
import org.junit.Test
import org.junit.jupiter.api.Assertions
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
        Assertions.assertEquals(response.code(),200)
        val body = String(response.body())
        Assertions.assertEquals(body,"""{"status":"OK"}""")
    }

    @Test
    fun monitorController_monitorDbWrite_true() {
        //
        val request = testController.testServer.post("/monitor/db/write", "", false)
        val response = testController.testServer.execute(request)
        Assertions.assertEquals(response.code(),200)
        val body = String(response.body())
        Assertions.assertEquals(body,"true")
    }

    @Test
    fun monitorController_monitorDbRead_true() {
        //
        testController.testServer.execute(testController.testServer.post("/monitor/db/write", "", false))
        //
        val request = testController.testServer.get("/monitor/db/read", false)
        val response = testController.testServer.execute(request)
        Assertions.assertEquals(response.code(),200)
        val body = String(response.body())
        Assertions.assertEquals(body,"true")
    }
}