package se.casaferre.common

import java.util.regex.Pattern


/**
 * Purpose of this file is to validate a Swedish SSN
 *
 * Created by Jorgen Andersson on 2018-09-05.
 */
class PersonalNumber(private val ssn: String) {

    private val SWEDISH_SSN_PATTERN_FULL = Pattern.compile("^[12]{1}[90]{1}[0-9]{6}[0-9]{4}$")

    fun isValid(): Boolean {
        return SWEDISH_SSN_PATTERN_FULL.matcher(ssn).matches()
    }

    fun isMale(): Boolean {
        return isValid() && Character.getNumericValue(ssn.get(10)) % 2 != 0
    }

    fun isFemale(): Boolean {
        return isValid() && Character.getNumericValue(ssn.get(10)) % 2 == 0
    }

    fun isChecksumValid(): Boolean {
        val checksum = calculateSwedishSsn(Integer.parseInt(ssn.substring(2, 3)), 2) +
                calculateSwedishSsn(Integer.parseInt(ssn.substring(3, 4)), 1) +
                calculateSwedishSsn(Integer.parseInt(ssn.substring(4, 5)), 2) +
                calculateSwedishSsn(Integer.parseInt(ssn.substring(5, 6)), 1) +
                calculateSwedishSsn(Integer.parseInt(ssn.substring(6, 7)), 2) +
                calculateSwedishSsn(Integer.parseInt(ssn.substring(7, 8)), 1) +
                calculateSwedishSsn(Integer.parseInt(ssn.substring(8, 9)), 2) +
                calculateSwedishSsn(Integer.parseInt(ssn.substring(9, 10)), 1) +
                calculateSwedishSsn(Integer.parseInt(ssn.substring(10, 11)), 2)

        return 10 - checksum % 10 == Integer.parseInt(ssn.substring(11, 12))
    }



    private fun calculateSwedishSsn(value: Int, position: Int): Int {
        if (value < 9) {
            return (value * position) % 9
        }
        return 9
    }
}