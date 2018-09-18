package se.casaferre.webServer

import se.casaferre.data.services.MonitorService
import se.casaferre.webServer.controllers.MidFreemarkerController
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

        Spark.before("/*") { request: Request, response: Response ->
            request.session(true)
        }

        // GZIP Everything
        Spark.after("/*") { _, response: Response -> response.header("Content-Encoding", "gzip") }


        // Template server
        setupFreemarkerPages()

        // API server
        setupRestPaths()

        // Shortcuts
        Spark.redirect.get("/mid99", "https://boiling-torch-802.firebaseapp.com/", Status.TEMPORARY_REDIRECT);


        Spark.post("/set/:key/:value") { request: Request, response: Response ->
            val key = request.params(":key")
            val value = request.params(":value")
            request.session().attribute(key, value)

            println("In set")
            println(request.session().attributes())
            "success"
        }

        // Init/Start server
        Spark.init()
    }

    private fun setupFreemarkerPages() {
        MidFreemarkerController("/")
    }

    private fun setupRestPaths() {
        // Controller for monitoring
        MonitorController(MonitorService())

        Spark.path("/v1") {
            // Various good to have
            UtilsController()
        }

    }

}