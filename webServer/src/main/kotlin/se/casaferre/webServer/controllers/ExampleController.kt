package se.casaferre.webServer.controllers

import spark.Request
import spark.Response
import spark.Spark

/**
 * Purpose of this file is ...
 */
class ExampleController {

    data class Person(val firstName: String, val lastName: String, val mobile: String)

    init {

        Spark.get("/testapi"){ request: Request, response: Response ->
            val qp = request.queryParamOrDefault("jojje", "")
            Person("Jörgen", "Andersson", "0733-124426").toString()
        }
    }
}