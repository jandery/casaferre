package se.casaferre.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TemperatureTest {

    @Test
    public void testFromCentigrade() {
        Double degrees = Temperature.centigradeToFahrenheit.convert(10);
        assertThat(degrees).isBetween(49.99999, 50.00001);
    }


    @Test
    public void testFromFarenheit() {
        Double degrees = Temperature.farenheightToCentigrade.convert(50);
        assertThat(degrees).isBetween(9.99999, 10.00001);
    }
}
