package se.casaferre.common

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class GeolocationTest {

    private val mOffice = Geolocation(55.6044973, 13.005021)
    private val mBjornstorp = Geolocation(55.656372399999995, 13.369866799999999)
    private val mNewYork = Geolocation(40.7493302, -73.9898485)
    private val mSydney = Geolocation(-33.8632658, 151.2285838)

    @Test
    fun office2bjornstorp_km_23() {
        assertThat(mOffice.distanceTo(mBjornstorp)).isBetween(23.61643034, 23.61643035)
        assertThat(mBjornstorp.distanceTo(mOffice)).isBetween(23.61643034, 23.61643035)
    }

    @Test
    fun office2newyork_km_6212() {
        assertThat(mOffice.distanceTo(mNewYork)).isBetween(6212.271674, 6212.271675)
        assertThat(mNewYork.distanceTo(mOffice)).isBetween(6212.271674, 6212.271675)
    }

    @Test
    fun office2sydney_km_16017() {
        assertThat(mOffice.distanceTo(mSydney)).isBetween(16017.657761, 16017.657762)
        assertThat(mSydney.distanceTo(mOffice)).isBetween(16017.657761, 16017.657762)
    }
}