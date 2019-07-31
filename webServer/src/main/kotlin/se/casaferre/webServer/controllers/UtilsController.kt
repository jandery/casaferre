package se.casaferre.webServer.controllers

import se.casaferre.common.Temperature
import se.casaferre.common.Volume
import spark.Request
import spark.Response
import spark.Service
import spark.Spark

/**
 * Purpose of this class holding API paths for various purposes
 *
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-07-17.
 */
class UtilsController(service: Service) {

    init {
        // Temperatures
        service.path("/temps") {
            // For converting Celsius to Farenheit degrees
            service.get("/c2f/:degree") { request: Request, response: Response ->
                val degree: Double = request.params(":degree").toDouble()
                Temperature.centigradeToFahrenheit(degree)
            }
            // For converting  Farenheit to Celsius degrees
            service.get("/f2c/:degree") { request: Request, response: Response ->
                val degree: Double = request.params(":degree").toDouble()
                Temperature.farenheightToCentigrade(degree)
            }
        }
        // Volumes
        service.path("/volume") {
            // For converting liters to US Gallons
            service.get("/l2usg/:volume") { request: Request, response: Response ->
                val volume: Double = request.params(":volume").toDouble()
                Volume.liter2usGallon(volume)
            }
            // For converting liters to Imperial Gallons
            service.get("/l2ig/:volume") { request: Request, response: Response ->
                val volume: Double = request.params(":volume").toDouble()
                Volume.liter2imperialGallon(volume)
            }
            // For converting US gallons to liters
            service.get("/usg2l/:volume") { request: Request, response: Response ->
                val volume: Double = request.params(":volume").toDouble()
                Volume.usGallon2liter(volume)
            }
            // For converting Imperial Gallons to liters
            service.get("/ig2l/:volume") { request: Request, response: Response ->
                val volume: Double = request.params(":volume").toDouble()
                Volume.imperialGallon2liter(volume)
            }
        }
    }
}