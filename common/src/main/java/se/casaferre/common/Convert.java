package se.casaferre.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

/**
 * Purpose of this file is ...
 * <p>
 * Created by Jorgen Andersson on 2018-01-29.
 */
public class Convert {

    @FunctionalInterface
    public interface Converter<T, R> {
        R convert(T t);
    }

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


    /**
     * Check a Swedish Personal number (SSN) to see if this is a male
     */
    public static Converter<String, Boolean> isSsnMale = x -> {
        if (x.length() != 12) {
            return false;
        }
        return Character.getNumericValue(x.charAt(10)) % 2 != 0;
    };

    /**
     * Check a Swedish Personal number (SSN) to see if this is a female
     */
    public static Converter<String, Boolean> isSsnFemale = x -> {
        if (x.length() != 12) {
            return false;
        }
        return Character.getNumericValue(x.charAt(10)) % 2 == 0;
    };




    public static Converter<String, LocalDateTime> parseStringToLocalDateTime = x -> LocalDateTime.parse(x);

    public static Converter<String, LocalDate> parseStringToLocalDate = x -> LocalDate.parse(x, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    public static Converter<String, Boolean> isValidAreaCode = x -> Pattern.compile("^[0-9]{3} [0-9]{2}$").matcher(x).matches();

}
