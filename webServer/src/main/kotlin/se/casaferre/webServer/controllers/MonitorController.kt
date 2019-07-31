package se.casaferre.webServer.controllers

import se.casaferre.data.objects.MonitorDBO
import se.casaferre.data.services.IBaseService
import se.casaferre.webServer.controllers.response.Monitor
import se.casaferre.webServer.controllers.utils.ControllerUtil
import spark.Service

/**
 * Purpose of this class to check status of Server
 *
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-07-05.
 */
class MonitorController(sparkService: Service, databaseService: IBaseService<MonitorDBO>) {

    init {
        sparkService.get("/status") { _, _ -> ControllerUtil.objectToString(Monitor()) }
        //
        // Monitoring DB is read/writable
        sparkService.path("/db") {
            // Write monitoring
            sparkService.post("/write") { _, _ ->
                val insert = databaseService.insert(MonitorDBO(value = "Item to insert"))
                insert._id.isNotEmpty().toString()
            }
            // Read monitoring
            sparkService.get("/read") { _, _ ->
                val list = databaseService.getAll()
                list.isNotEmpty().toString()
            }
        }
    }
}