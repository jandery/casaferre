package se.casaferre.config;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigVariableTest {

    @Ignore
    @Test
    public void testPort() {
        String portValue = ConfigVariable.getValue(ConfigVariable.PORT);
        assertThat(portValue).isEqualTo("5555");
    }

    @Ignore
    @Test
    public void testPortEquals() {
        boolean portValue = ConfigVariable.PORT.valueEquals("5555");
        assertThat(portValue).isTrue();
    }

    @Ignore
    @Test
    public void testEnvironment() {
        String environmentValue = ConfigVariable.getValue(ConfigVariable.ENVIRONMENT);
        assertThat(environmentValue).isEqualTo("dev");
    }


    @Ignore
    @Test
    public void testEnvironmentEquals() {
        boolean portValue = ConfigVariable.ENVIRONMENT.valueEquals("dev");
        assertThat(portValue).isTrue();
    }
}
