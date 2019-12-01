package se.casaferre.common

import java.lang.Math.pow
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin

/**
 * Purpose of this file is holding a Geolocation position
 *
 * Created by Jorgen Andersson on 2018-06-29.
 */
data class Geolocation(val latitude: Double, val longitude: Double) {
    // Equator radius: 6 378 km
    // Polar radius: 6 356 km
    private val earthRadius = 6370.693485653068


    /**
     * Calculate distance in km to
     */
    fun distanceTo(geolocation: Geolocation): Double {
        val dLat = Math.toRadians(geolocation.latitude - this.latitude)
        val dLng = Math.toRadians(geolocation.longitude - this.longitude)

        val sindLat = sin(dLat / 2)
        val sindLng = sin(dLng / 2)

        val a = pow(sindLat, 2.0) + (pow(sindLng, 2.0)
                * cos(Math.toRadians(this.latitude)) * cos(Math.toRadians(geolocation.latitude)))

        val c = 2 * atan2(kotlin.math.sqrt(a), kotlin.math.sqrt(1 - a))

        return earthRadius * c
    }
}