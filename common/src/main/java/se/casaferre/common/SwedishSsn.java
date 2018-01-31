package se.casaferre.common;

import java.util.regex.Pattern;

/**
 * Purpose of this class ...
 * <p>
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-01-29.
 */
public class SwedishSsn {
    /**
     * Reg ex for Swedish social security number, a.k.a. personnummer.
     */
    private static final Pattern SWEDISH_SSN_PATTERN_FULL = Pattern.compile("^[12]{1}[90]{1}[0-9]{6}[0-9]{4}$");
    private static final Pattern SWEDISH_SSN_PATTERN_SHORT = Pattern.compile("^[0-9]{6}[0-9]{4}$");

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


    /**
     * Validate a Swedish SSN to validate if checksum is correct
     *
     * @param ssn Swedish SSN
     * @return True if checksum matches else fals
     */
    public static boolean validateSsnWithChecksum(String ssn) {
        // Fix SSN to match YYMMDDXXXZ
        ssn = fixSwedishSsn(ssn);
        if (ssn == null) {
            return false;
        }

        int checksum = calculateSwedishSsn(Integer.parseInt(ssn.substring(0, 1)), 2) +
                calculateSwedishSsn(Integer.parseInt(ssn.substring(1, 2)), 1) +
                calculateSwedishSsn(Integer.parseInt(ssn.substring(2, 3)), 2) +
                calculateSwedishSsn(Integer.parseInt(ssn.substring(3, 4)), 1) +
                calculateSwedishSsn(Integer.parseInt(ssn.substring(4, 5)), 2) +
                calculateSwedishSsn(Integer.parseInt(ssn.substring(5, 6)), 1) +
                calculateSwedishSsn(Integer.parseInt(ssn.substring(6, 7)), 2) +
                calculateSwedishSsn(Integer.parseInt(ssn.substring(7, 8)), 1) +
                calculateSwedishSsn(Integer.parseInt(ssn.substring(8, 9)), 2);

        return (10 - (checksum % 10)) == Integer.parseInt(ssn.substring(9, 10));
    }

    private static String fixSwedishSsn(String ssn) {
        ssn = ssn.replaceAll("-", "");

        if (SWEDISH_SSN_PATTERN_FULL.matcher(ssn).matches()) {
            return ssn.substring(2);
        }
        if (SWEDISH_SSN_PATTERN_SHORT.matcher(ssn).matches()) {
            return ssn;
        }

        return null;
    }

    private static int calculateSwedishSsn(int value, int position) {
        return value < 9 ? (value * position) % 9 : 9;
    }
}
