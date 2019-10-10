package se.casaferre.webServer.controllers

import se.casaferre.common.Temperature
import se.casaferre.common.Volume
import spark.Request
import spark.Response

/**
 * Purpose of this class holding API paths for various purposes
 *
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-07-17.
 */
class UtilsController {

    companion object {
        val c2f = { request: Request, _: Response ->
            val degree: Double = request.params(":degree").toDouble()
            Temperature.centigradeToFahrenheit(degree)
        }

        val f2c = { request: Request, _: Response ->
            val degree: Double = request.params(":degree").toDouble()
            Temperature.farenheightToCentigrade(degree)
        }

        val l2usg = { request: Request, _: Response ->
            val volume: Double = request.params(":volume").toDouble()
            Volume.liter2usGallon(volume)
        }

        val l2ig = { request: Request, _: Response ->
            val volume: Double = request.params(":volume").toDouble()
            Volume.liter2imperialGallon(volume)
        }

        val usg2l = { request: Request, _: Response ->
            val volume: Double = request.params(":volume").toDouble()
            Volume.usGallon2liter(volume)
        }

        val ig2l = { request: Request, _: Response ->
            val volume: Double = request.params(":volume").toDouble()
            Volume.imperialGallon2liter(volume)
        }
    }
}