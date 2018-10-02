package se.casaferre.common

import java.util.regex.Pattern


/**
 * Purpose of this file is to validate a Swedish SSN
 * Valid format is YYYYMMDDXXXY where
 * - YYYY is birth year 4 digits
 * - MM birth month of year 2 digits
 * - DD birth day of month, 2 digits
 * - XXX number where last digit is even for female and odd for male - 3 digits
 * - Y checksum, 1 digit
 *
 * Created by Jorgen Andersson on 2018-09-05.
 */
class PersonalNumber(private val ssn: String) {

    private val SWEDISH_SSN_PATTERN_FULL = Pattern.compile("^(19|20)[0-9]{6}[0-9]{4}$")

    /**
     * Is the Format and Checksum valid
     */
    fun isValid(): Boolean {
        return isFormatValid() && isChecksumValid()
    }

    /**
     * Is the format valid
     */
    fun isFormatValid(): Boolean {
        return SWEDISH_SSN_PATTERN_FULL.matcher(ssn).matches()
    }

    /**
     * Check if the checksum digit (Y from above) is correct
     */
    fun isChecksumValid(): Boolean {
        return getChecksumValue(ssn) == Integer.parseInt(ssn.substring(11, 12))
    }

    /**
     * Does this SSN belong to male
     */
    fun isMale(): Boolean {
        return isValid() && Character.getNumericValue(ssn.get(10)) % 2 != 0
    }

    /**
     * Does this SSN belong to female
     */
    fun isFemale(): Boolean {
        return isValid() && Character.getNumericValue(ssn.get(10)) % 2 == 0
    }

    /**
     * Calculate the checksum number as follows
     * Example: 198011035188
     * 8 x 2 = 16
     * 0 x 1 = 0
     * 1 x 2 = 2
     * 1 x 1 = 1
     * 0 x 2 = 0
     * 3 x 1 = 3
     * 5 x 2 = 10
     * 1 x 1 = 1
     * 8 x 2 = 16
     *  => 1 + 6 + 0 + 2 + 1 + 0 + 3 + 1 + 0 + 1 + 1 + 6 = 22
     * Checksum is 10 - (rest(22/10)) 2 = 8
     * @param ssn string to validate
     * @return the correct last integer in a Swedish SSN
     */
    private fun getChecksumValue(ssn: String): Int {
        val checksum = ssn
                .subSequence(2, 11)
                .mapIndexed { index, c ->
                    val multiplier = if (index % 2 == 0) 2 else 1
                    val value = Character.getNumericValue(c)
                    if(value < 9) (value * multiplier) % 9 else 9
                }
                .sum()

        // Calculated like:
        // Use 10 - rest division of 10 to avoid cumbersum calculation
        // case checksum = 47 => 50 - 47, last digit is 3
        // case checksum = 32 => 40 - 32, last digit is 8
        // Special case for when checksum is 10, 20, 30 or 40, use extra rest divistion
        return (10 - checksum % 10) % 10
    }

    companion object {
        fun isValid(ssn: String): Boolean {
            return PersonalNumber(ssn).isValid()
        }
    }
}