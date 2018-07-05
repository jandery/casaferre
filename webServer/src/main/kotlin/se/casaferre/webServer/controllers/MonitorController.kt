package se.casaferre.webServer.controllers

import se.casaferre.data.objects.MonitorDBO
import se.casaferre.data.services.IBaseService
import se.casaferre.webServer.controllers.response.Monitor
import se.casaferre.webServer.controllers.utils.ControllerUtil
import spark.Spark

/**
 * Purpose of this class to check status of Server
 *
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-07-05.
 */
class MonitorController(mService: IBaseService<MonitorDBO>) {

    init {
        Spark.path("/monitor") {
            //
            Spark.get("/status") { _, _ -> ControllerUtil.objectToString(Monitor()) }
            //
            // Monitoring DB is read/writable
            Spark.path("/db") {
                // Write monitoring
                Spark.post("/write") { _, _ ->
                    val insert = mService.insert(MonitorDBO(value = "Item to insert"))
                    insert._id.isNotEmpty().toString()
                }
                // Read monitoring
                Spark.get("/read") { _, _ ->
                    val list = mService.getAll()
                    list.isNotEmpty().toString()
                }
            }
        }
    }
}