package se.casaferre.common

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class VolumeTest {

    @Test
    fun generalTest() {
        Assertions.assertEquals(Volume.liter2usGallon(100.0),26.41721, 0.0001)
        Assertions.assertEquals(Volume.liter2imperialGallon(100.0),21.99692, 0.0001)
        Assertions.assertEquals(Volume.usGallon2liter(100.0),378.54, 0.0001)
        Assertions.assertEquals(Volume.imperialGallon2liter(100.0),454.60, 0.0001)
    }

}