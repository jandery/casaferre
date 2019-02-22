package se.casaferre.common

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GeolocationTest {

    private val mOffice = Geolocation(55.6044973, 13.005021)
    private val mBjornstorp = Geolocation(55.656372399999995, 13.369866799999999)
    private val mNewYork = Geolocation(40.7493302, -73.9898485)
    private val mSydney = Geolocation(-33.8632658, 151.2285838)

    private val DELTA = .000001

    @Test
    fun office2bjornstorp_km_23() {
        Assertions.assertEquals(mOffice.distanceTo(mBjornstorp),23.61643034, DELTA)
        Assertions.assertEquals(mBjornstorp.distanceTo(mOffice),23.61643034, DELTA)
    }

    @Test
    fun office2newyork_km_6212() {
        Assertions.assertEquals(mOffice.distanceTo(mNewYork),6212.271674, DELTA)
        Assertions.assertEquals(mNewYork.distanceTo(mOffice),6212.271674, DELTA)
    }

    @Test
    fun office2sydney_km_16017() {
        Assertions.assertEquals(mOffice.distanceTo(mSydney),16017.657761, DELTA)
        Assertions.assertEquals(mSydney.distanceTo(mOffice),16017.657761, DELTA)
    }
}