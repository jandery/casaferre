package se.casaferre.webServer

import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import se.casaferre.data.services.MonitorService
import se.casaferre.webServer.controllers.*
import se.casaferre.webServer.controllers.utils.FreemarkerUtil
import se.casaferre.webServer.controllers.utils.ResourceLocation
import spark.ModelAndView
import spark.Spark
import spark.Redirect.Status
import spark.Request
import spark.Response

/**
 * Purpose of this file is to run a SparkJava WebServer
 *
 * Created by Jorgen Andersson on 2018-06-29.
 */
class WebServer(kodein: KodeinAware = wwwContext) {
    private val port: Int by kodein.instance(ContextVariable.PORT)

    init {
        val freeMarkerEngine = FreemarkerUtil.getFreemarkerEngine(ResourceLocation.DEV)
        // Settings
        Spark.port(port)
        // File Server
        Spark.staticFiles.location("")

        //
        Spark.before("/*") { request: Request, _: Response ->
            request.session(true)
        }

        // GZIP Everything
        Spark.after("/*") { _, response: Response -> response.header("Content-Encoding", "gzip") }

        ExampleController()

        // Template server
        Spark.get(WebPage.CASAFERRE.path, { _, _ -> getIndex(WebPage.CASAFERRE) }, freeMarkerEngine)
        Spark.get(WebPage.MID.path, { _, _ -> getIndex(WebPage.MID) }, freeMarkerEngine)
        Spark.get(WebPage.LYX.path, { _, _ -> getIndex(WebPage.LYX) }, freeMarkerEngine)

        // API server
        setupRest()

        // Shortcuts
        Spark.redirect.get("/mid99", "https://boiling-torch-802.firebaseapp.com/", Status.TEMPORARY_REDIRECT)


        Spark.post("/set/:key/:value") { request: Request, _: Response ->
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

    private fun setupRest() {
        // Controller for monitoring
        MonitorController(MonitorService())

        Spark.path("/v1") {
            // Various good to have
            UtilsController()
        }

    }

    private fun getIndex(page: WebPage): ModelAndView {
        val model: Map<String, Any> = mutableMapOf(
                "baseHref" to "/",
                "title" to page.title
        )
        // Return the Spark model and view object
        return ModelAndView(model, page.fileName)
    }

}