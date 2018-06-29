package se.casaferre.common

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class TempeatureTest {

    @Test
    fun testFromCentigrade() {
        val degrees = Temperature.centigradeToFahrenheit(10.0)
        assertThat(degrees).isBetween(49.99999, 50.00001)
    }


    @Test
    fun testFromFarenheit() {
        val degrees = Temperature.farenheightToCentigrade(50.0)
        assertThat(degrees).isBetween(9.99999, 10.00001)
    }

}