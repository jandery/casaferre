package se.casaferre.common;

/**
 * Purpose of this class ...
 * <p>
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-01-29.
 */
public class Temperature {
    /**
     * Convert Centigrades to Farenheit
     * Usage: Convert.centigradeToFahrenheit.convert(4);
     */
    public static Converter<Integer, Double> centigradeToFahrenheit = x -> new Double((x * 1.8) + 32.0);

    /**
     * Convert Farenheight to Centigrades
     * Usage: Convert.farenheightToCentigrade.convert(36);
     */
    public static Converter<Integer, Double> farenheightToCentigrade = x -> new Double((x - 32.0)  / 1.8);
}
