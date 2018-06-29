package se.casaferre.common

/**
 * Purpose of this file is ...
 *
 * Created by Jorgen Andersson on 2018-06-29.
 */
object Temperature {
    /**
     * Convert Centigrades to Farenheit
     * Usage: Temperature.centigradeToFahrenheit.convert(4);
     */
    val centigradeToFahrenheit = { x: Double -> x * 1.8 + 32.0 }

    /**
     * Convert Farenheight to Centigrades
     * Usage: Temperature.farenheightToCentigrade.convert(36);
     */
    val farenheightToCentigrade = { x: Double -> (x - 32.0) / 1.8 }
}