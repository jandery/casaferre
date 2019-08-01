package se.casaferre.webServer

import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import se.casaferre.data.connection.MongoConnection
import se.casaferre.data.services.MongoMonitorService
import se.casaferre.webServer.controllers.*
import se.casaferre.webServer.controllers.api.UsbController
import spark.*
import spark.Redirect.Status
import spark.template.freemarker.FreeMarkerEngine

/**
 * Purpose of this file is to run a SparkJava WebServer
 *
 * Created by Jorgen Andersson on 2018-06-29.
 */
class WebServer(kodein: KodeinAware) {
    private val serverServer: ServerSettings by kodein.instance()
    private val mongoConnection: String by kodein.instance(ContextVariable.MONGO_URL)
    private val freeMarkerEngine: FreeMarkerEngine by kodein.instance()

    private val service = Service.ignite().port(serverServer.port)

    init {
        //
        MongoConnection.setConnection(mongoConnection)
        // File Server
        service.staticFileLocation("/www")
        service.before("/*") { request: Request, _: Response -> request.session(true) }
        service.after("/*") { _, response: Response -> response.header("Content-Encoding", "gzip") }

        // Template server
        WebPage.values().forEach {
            service.get(it.path, { _, _ -> getIndex(it) }, freeMarkerEngine)
        }

        // Rest server
        // Controller for monitoring
        service.path("/monitor") { MonitorController(service, MongoMonitorService()) }
        // Controller for Various good to have functions
        service.path("/v1") {
            UtilsController(service)
            UsbController(service)
        }

        // Shortcuts
        service.redirect.get("/mid99", "https://boiling-torch-802.firebaseapp.com/", Status.TEMPORARY_REDIRECT)

    }

    fun start() {
        service.init()
        service.awaitInitialization()
        consoleLog("started")
    }

    fun stop() {
        service.stop()
        service.awaitStop()
        consoleLog("stopped")
    }

    private fun getIndex(page: WebPage): ModelAndView {
        val model: Map<String, Any> = mutableMapOf(
                "baseHref" to "/",
                "title" to page.title
        )
        // Return the Spark model and view object
        return ModelAndView(model, page.fileName)
    }

    private fun consoleLog(action: String) {
        println("************************************************")
        println("*****  Spark server $action on port ${serverServer.port}  ******")
        println("************************************************")
    }

    companion object {

        fun setupServer(kodein: KodeinAware = wwwContext): WebServer {
            val webServer = WebServer(kodein)
            webServer.start()
            return webServer
        }
    }
}