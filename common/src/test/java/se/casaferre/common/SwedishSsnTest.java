package se.casaferre.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SwedishSsnTest {

    @Test
    public void testIsSsnMale() {
        assertThat(SwedishSsn.isSsnMale.convert("196509033939")).isTrue();
        assertThat(SwedishSsn.isSsnMale.convert("196509033949")).isFalse();
    }

    @Test
    public void testIsSsnFemale() {
        assertThat(SwedishSsn.isSsnFemale.convert("196509033939")).isFalse();
        assertThat(SwedishSsn.isSsnFemale.convert("196509033949")).isTrue();
    }

    @Test
    public void testValidateSsnWithChecksum() {
        assertThat(SwedishSsn.validateSsnWithChecksum("196509033939")).isTrue();
        assertThat(SwedishSsn.validateSsnWithChecksum("196509033949")).isFalse();
    }
}
