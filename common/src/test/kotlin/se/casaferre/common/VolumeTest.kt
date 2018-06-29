package se.casaferre.common

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class VolumeTest {

    @Test
    fun generalTest() {
        assertThat(Volume.liter2usGallon(100.0)).isBetween(26.41721, 26.41722)
        assertThat(Volume.liter2imperialGallon(100.0)).isBetween(21.99692, 21.99693)
        assertThat(Volume.usGallon2liter(100.0)).isBetween(378.54, 378.55)
        assertThat(Volume.imperialGallon2liter(100.0)).isBetween(454.60, 454.61)
    }

}