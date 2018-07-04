package se.casaferre.webServer

import se.casaferre.webServer.controllers.FreemarkerController
import spark.Spark
import spark.Redirect.Status
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

        // Template server
        FreemarkerController("/")

        // API server
        Spark.get("/hello") { _, _ -> "Hello World" }

        // Shortcuts
        Spark.redirect.get("/mid99", "https://boiling-torch-802.firebaseapp.com/", Status.TEMPORARY_REDIRECT);

        // GZIP Everything
        Spark.after("/*") { _, response: Response -> response.header("Content-Encoding", "gzip") }

        // Init/Start server
        Spark.init()
    }

}