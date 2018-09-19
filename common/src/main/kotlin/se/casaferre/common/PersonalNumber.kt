package se.casaferre.common

import java.util.regex.Pattern


/**
 * Purpose of this file is to validate a Swedish SSN
 *
 * Created by Jorgen Andersson on 2018-09-05.
 */
class PersonalNumber(private val ssn: String) {

    private val SWEDISH_SSN_PATTERN_FULL = Pattern.compile("^(19|20)[0-9]{6}[0-9]{4}$")

    fun isValid(): Boolean {
        return isFormatValid() && isChecksumValid()
    }

    fun isFormatValid(): Boolean {
        return SWEDISH_SSN_PATTERN_FULL.matcher(ssn).matches()
    }

    fun isChecksumValid(): Boolean {
        return getChecksumValue(ssn) == Integer.parseInt(ssn.substring(11, 12))
    }

    fun isMale(): Boolean {
        return isFormatValid() && Character.getNumericValue(ssn.get(10)) % 2 != 0
    }

    fun isFemale(): Boolean {
        return isFormatValid() && Character.getNumericValue(ssn.get(10)) % 2 == 0
    }

    private fun getChecksumValue(ssn: String): Int {
        val checksum = ssn
                .subSequence(2, 11)
                .mapIndexed { index, c ->
                    val multiplier = if (index % 2 == 0) 2 else 1
                    val value = Character.getNumericValue(c)
                    if(value < 9) (value * multiplier) % 9 else 9
                }
                .sum()

        return 10 - checksum % 10
    }

    companion object {
        fun isValid(ssn: String): Boolean {
            return PersonalNumber(ssn).isValid()
        }
    }
}