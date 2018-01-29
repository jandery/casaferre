package se.casaferre.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Purpose of this class is to map volumes
 * <p>
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-01-29.
 */
@Accessors(prefix = "m")
@AllArgsConstructor
public class Volume implements Serializable {

    private static final Double LITER_2_US_GALLON = 3.78541;
    private static final Double LITER_2_UK_GALLON = 4.54609;

    @Getter
    private Double mLiter;
    @Getter
    private Double mUsGallon;
    @Getter
    private Double mUkGallon;

    public static Volume setLiter(Double volume) {
        return new Volume(
                volume,
                volume / LITER_2_US_GALLON,
                volume / LITER_2_UK_GALLON);
    }

    public static Volume setUsGallon(Double volume) {
        return new Volume(
                volume * LITER_2_US_GALLON,
                volume,
                volume * (LITER_2_US_GALLON / LITER_2_UK_GALLON));
    }

    public static Volume setUkGallon(Double volume) {
        return new Volume(
                volume * LITER_2_UK_GALLON,
                volume * (LITER_2_UK_GALLON / LITER_2_US_GALLON),
                volume);
    }
}
