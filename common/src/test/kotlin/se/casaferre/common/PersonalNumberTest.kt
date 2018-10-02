package se.casaferre.common

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * use http://fejk.se for random Swedish SSN
 * Created by Jorgen Andersson on 2018-09-17.
 */
class PersonalNumberTest {

    @Test
    fun formatValid_tooLong_false() {
        assertThat(PersonalNumber("1993123022691").isFormatValid()).isFalse()
    }

    @Test
    fun formatValid_tooShort_false() {
        assertThat(PersonalNumber("19890911576").isFormatValid()).isFalse()
    }

    @Test
    fun formatValid_containingLetter_false() {
        assertThat(PersonalNumber("19710101s000").isFormatValid()).isFalse()
    }

    @Test
    fun formatValid_correct_true() {
        assertThat(PersonalNumber("195507078755").isFormatValid()).isTrue()
    }

    @Test
    fun checksum_valid_true() {
        assertThat(PersonalNumber("198011035188").isChecksumValid()).isTrue()
    }

    @Test
    fun checksum_invalid_false() {
        assertThat(PersonalNumber("198011035189").isChecksumValid()).isFalse()
    }

    @Test
    fun checksum_endsWith0_valid() {
        assertThat(PersonalNumber("197306195640").isChecksumValid()).isTrue()
    }

    @Test
    fun isMale_male_true() {
        assertThat(PersonalNumber("195507078755").isMale()).isTrue()
    }

    @Test
    fun isMale_male_false() {
        assertThat(PersonalNumber("195507078755").isFemale()).isFalse()
    }

    @Test
    fun isFemale_female_false() {
        assertThat(PersonalNumber("197306195640").isMale()).isFalse()
    }

    @Test
    fun isFemale_female_true() {
        assertThat(PersonalNumber("197306195640").isFemale()).isTrue()
    }

    @Test
    fun static_valid_true() {
        assertThat(PersonalNumber.isValid("198401093573")).isTrue()
    }

    @Test
    fun static_invalid_fakse() {
        assertThat(PersonalNumber.isValid("198401093574")).isFalse()
    }

}