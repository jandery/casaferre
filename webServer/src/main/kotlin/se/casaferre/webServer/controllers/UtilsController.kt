package se.casaferre.webServer.controllers

import se.casaferre.common.Temperature
import se.casaferre.common.Volume
import spark.Request
import spark.Response
import spark.Spark

/**
 * Purpose of this class holding API paths for various purposes
 *
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-07-17.
 */
class UtilsController {

    init {
        // Temperatures
        Spark.path("/temps") {
            // For converting Celsius to Farenheit degrees
            Spark.get("/c2f/:degree") { request: Request, response: Response ->
                val degree: Double = request.params(":degree").toDouble()
                Temperature.centigradeToFahrenheit(degree)
            }
            // For converting  Farenheit to Celsius degrees
            Spark.get("/f2c/:degree") { request: Request, response: Response ->
                val degree: Double = request.params(":degree").toDouble()
                Temperature.farenheightToCentigrade(degree)
            }
        }
        // Volumes
        Spark.path("/volume") {
            // For converting liters to US Gallons
            Spark.get("/l2usg/:volume") { request: Request, response: Response ->
                val volume: Double = request.params(":volume").toDouble()
                Volume.liter2usGallon(volume)
            }
            // For converting liters to Imperial Gallons
            Spark.get("/l2ig/:volume") { request: Request, response: Response ->
                val volume: Double = request.params(":volume").toDouble()
                Volume.liter2imperialGallon(volume)
            }
            // For converting US gallons to liters
            Spark.get("/usg2l/:volume") { request: Request, response: Response ->
                val volume: Double = request.params(":volume").toDouble()
                Volume.usGallon2liter(volume)
            }
            // For converting Imperial Gallons to liters
            Spark.get("/ig2l/:volume") { request: Request, response: Response ->
                val volume: Double = request.params(":volume").toDouble()
                Volume.imperialGallon2liter(volume)
            }
        }
    }
}