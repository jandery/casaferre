package se.casaferre.webServer

import se.casaferre.common.Temperature
import se.casaferre.data.services.MonitorService
import se.casaferre.webServer.controllers.FreemarkerController
import se.casaferre.webServer.controllers.MonitorController
import se.casaferre.webServer.controllers.UtilsController
import spark.Spark
import spark.Redirect.Status
import spark.Request
import spark.Response

/**
 * Purpose of this file is to run a SparkJava WebServer
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
            println(request.pathInfo())
        }

        // response.status both get/set, will be 200 even if page not exists
        Spark.after("/*") { request: Request, response: Response ->
            println("After, status is ${response.status()}")
            println(request.pathInfo())
        }

        // GZIP Everything
        Spark.after("/*") { _, response: Response -> response.header("Content-Encoding", "gzip") }

        // response.status only get
        Spark.afterAfter("/*") { request: Request, response: Response ->
            println("AfterAfter, status is ${response.status()}")
            println(request.pathInfo())
            if (response.status() == 500) {
                /* SEND EMAIL TO DEV */
            }
        }


        // Template server
        FreemarkerController("/")

        // API server
        // Test halt vill end up in Spark.after and Spark.afterAfter
        Spark.get("/halt/:code") { request: Request, response: Response ->
            val code = request.params(":code").toInt()
            if (code != 200) {
                // Spark.after is NOT called here but Spark.afterAfter is
                Spark.halt(code, "This is a custom status code")
            }
            ""
        }

        // Controller for monitoring
        MonitorController(MonitorService())

        Spark.path("/v1") {
            // Various good to have
            UtilsController()
        }

        // Shortcuts
        Spark.redirect.get("/mid99", "https://boiling-torch-802.firebaseapp.com/", Status.TEMPORARY_REDIRECT);


        // Init/Start server
        Spark.init()
    }

}