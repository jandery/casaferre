package se.casaferre.webServer.controllers

import spark.ModelAndView
import spark.Request
import spark.Response
import spark.Spark
import spark.template.freemarker.FreeMarkerEngine

/**
 * Purpose of this file is to handle Freemarker pages
 * i.e. pages containing serverside variables and client side includes
 *
 * Created by Jorgen Andersson on 2018-07-03.
 */
class FreemarkerController (private val cdnUrl: String) {

    init {
        Spark.get("/mid", ::getMidIndex, FreeMarkerEngine())
    }

    private fun getMidIndex(request: Request, response: Response): ModelAndView {
        val model: Map<String, Any> = mutableMapOf(
                "baseHref" to cdnUrl,
                "title" to "MID99"
        )
        // Return the Spark model and view object
        return ModelAndView(model, "mid.ftl")
    }
}