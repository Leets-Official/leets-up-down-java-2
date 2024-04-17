package leets.land.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {
    private Validator validator = new Validator();

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    void versionInputIsValid() {
        assertThat(validator.versionInputIsValid("1")).isTrue();
        assertThat(validator.versionInputIsValid("2")).isTrue();
        assertThat(validator.versionInputIsValid("3")).isFalse();
    }

    @ValueSource(strings = {"1", "100"})
    @ParameterizedTest
    void isInputNumberWithNumber(String input) {
        assertThat(validator.isInputNumber(input)).isTrue();
    }

    @ValueSource(strings = {"", " ", "abc"})
    @ParameterizedTest
    void isInputNumberWithInvalids(String input) {
        assertThat(validator.isInputNumber(input)).isFalse();
    }

    @ValueSource(strings = {"a", "b", "c"})
    @ParameterizedTest
    void isInputCharWithChars(String input) {
        assertThat(validator.isInputChar(input)).isTrue();
    }

    @ValueSource(strings = {"A", "Z"})
    @ParameterizedTest
    void isInputCharWithInvalids(String input) {
        assertThat(validator.isInputChar(input)).isFalse();
    }
}