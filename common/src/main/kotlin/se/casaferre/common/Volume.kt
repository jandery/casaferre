package se.casaferre.common

/**
 * Purpose of this file is ...
 *
 * Created by Jorgen Andersson on 2018-06-29.
 */
object Volume {

    fun liter2usGallon(value: Double): Double {
        return value / 3.78541
    }

    fun liter2imperialGallon(value: Double): Double {
        return value / 4.54609
    }

    fun usGallon2liter(value: Double): Double {
        return value * 3.78541
    }

    fun imperialGallon2liter(value: Double): Double {
        return value * 4.54609
    }
}