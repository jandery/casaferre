package se.casaferre.common;


import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class VolumeTest {

    @Test
    public void testFromLiter() {
        Volume volume = Volume.setLiter(100.0);
        assertThat(volume.getUsGallon()).isBetween(26.41721, 26.41722);
        assertThat(volume.getUkGallon()).isBetween(21.99692, 21.99693);
    }

    @Test
    public void testFromUsGallon() {
        Volume volume = Volume.setUsGallon(100.0);
        assertThat(volume.getLiter()).isBetween(378.54, 378.55);
        assertThat(volume.getUkGallon()).isBetween(83.26737, 83.26738);
    }

    @Test
    public void testFromUkGallon() {
        Volume volume = Volume.setUkGallon(100.0);
        assertThat(volume.getLiter()).isBetween(454.60, 454.61);
        assertThat(volume.getUsGallon()).isBetween(120.09504, 120.09505);
    }
}
