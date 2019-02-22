package se.casaferre.common

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TempeatureTest {

    @Test
    fun testFromCentigrade() {
        val degrees = Temperature.centigradeToFahrenheit(10.0)
        Assertions.assertEquals(degrees,50.0, .00001)
    }


    @Test
    fun testFromFarenheit() {
        val degrees = Temperature.farenheightToCentigrade(50.0)
        Assertions.assertEquals(degrees,10.0, .00001)
    }

}