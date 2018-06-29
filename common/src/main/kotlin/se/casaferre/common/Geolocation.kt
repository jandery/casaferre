package se.casaferre.common

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

        val sindLat = Math.sin(dLat / 2)
        val sindLng = Math.sin(dLng / 2)

        val a = Math.pow(sindLat, 2.0) + (Math.pow(sindLng, 2.0)
                * Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(geolocation.latitude)))

        val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))

        return earthRadius * c
    }
}