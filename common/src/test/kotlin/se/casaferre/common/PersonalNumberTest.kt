package se.casaferre.common

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * use http://fejk.se for random Swedish SSN
 * Created by Jorgen Andersson on 2018-09-17.
 */
class PersonalNumberTest {

    @Test
    fun formatValid_tooLong_false() {
        Assertions.assertFalse(PersonalNumber("1993123022691").isFormatValid())
    }

    @Test
    fun formatValid_tooShort_false() {
        Assertions.assertFalse(PersonalNumber("19890911576").isFormatValid())
    }

    @Test
    fun formatValid_containingLetter_false() {
        Assertions.assertFalse(PersonalNumber("19710101s000").isFormatValid())
    }

    @Test
    fun formatValid_correct_true() {
        Assertions.assertTrue(PersonalNumber("195507078755").isFormatValid())
    }

    @Test
    fun checksum_valid_true() {
        Assertions.assertTrue(PersonalNumber("198011035188").isChecksumValid())
    }

    @Test
    fun checksum_invalid_false() {
        Assertions.assertFalse(PersonalNumber("198011035189").isChecksumValid())
    }

    @Test
    fun checksum_endsWith0_valid() {
        Assertions.assertTrue(PersonalNumber("197306195640").isChecksumValid())
    }

    @Test
    fun isMale_male_true() {
        Assertions.assertTrue(PersonalNumber("195507078755").isMale())
    }

    @Test
    fun isMale_male_false() {
        Assertions.assertFalse(PersonalNumber("195507078755").isFemale())
    }

    @Test
    fun isFemale_female_false() {
        Assertions.assertFalse(PersonalNumber("197306195640").isMale())
    }

    @Test
    fun isFemale_female_true() {
        Assertions.assertTrue(PersonalNumber("197306195640").isFemale())
    }

    @Test
    fun static_valid_true() {
        Assertions.assertTrue(PersonalNumber.isValid("198401093573"))
    }

    @Test
    fun static_invalid_fakse() {
        Assertions.assertFalse(PersonalNumber.isValid("198401093574"))
    }

}