package se.casaferre.webServer

import se.casaferre.common.Temperature
import se.casaferre.data.services.MonitorService
import se.casaferre.webServer.controllers.FreemarkerController
import se.casaferre.webServer.controllers.MonitorController
import spark.Spark
import spark.Redirect.Status
import spark.Request
import spark.Response

/**
 * Purpose of this file is ...
 *
 * Created by Jorgen Andersson on 2018-06-29.
 */
class WebServer(port: Int, environment: String, filesLocation: String) {

    init {
        // Settings
        Spark.port(port)

        // File Server
        if (environment == "dev") {
            val projectDir = System.getProperty("user.dir")
            val staticDir = "/webServer/src/main/resources/www"
            Spark.staticFiles.externalLocation(projectDir + staticDir)
        } else {
            Spark.staticFiles.location(filesLocation)
        }

        // response.status both get/set, will be 200 even if page not exists
        Spark.before("/*") { request: Request, response: Response ->
            request.session(true)
            println("Before, session is new ${request.session().isNew()} and id is ${request.session().id()}")
        }

        // response.status both get/set, will be 200 even if page not exists
        Spark.after("/*") { request: Request, response: Response ->
            println("AfterAfter, status is ${response.status()}")
        }

        // response.status only get
        Spark.afterAfter("/*") { request: Request, response: Response ->
            if (response.status() == 500) { /* SEND EMAIL*/ }
        }


        // Template server
        FreemarkerController("/")

        // API server
        Spark.get("/hello") { _, _ -> "Hello World" }
        Spark.path("/v1") {
            //
            MonitorController(MonitorService())
            //
            Spark.path("/temps") {
                Spark.get("/c2f/:degree") { request: Request, response: Response ->
                    val degree: Double = request.params(":degree").toDouble()
                    Temperature.centigradeToFahrenheit(degree)
                }
                Spark.get("/f2c/:degree") { request: Request, response: Response ->
                    val degree: Double = request.params(":degree").toDouble()
                    Temperature.farenheightToCentigrade(degree)
                }
                Spark.get("/c2c/:degree") { request: Request, response: Response ->
                    response.status(500)
                    ""
                }
            }
        }

        // Shortcuts
        Spark.redirect.get("/mid99", "https://boiling-torch-802.firebaseapp.com/", Status.TEMPORARY_REDIRECT);

        // GZIP Everything
        Spark.after("/*") { _, response: Response -> response.header("Content-Encoding", "gzip") }

        // Init/Start server
        Spark.init()
    }

}