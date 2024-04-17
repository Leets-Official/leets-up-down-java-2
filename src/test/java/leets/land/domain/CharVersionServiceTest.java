package leets.land.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CharVersionServiceTest {
    private CharVersionService charVersionService = new CharVersionService();

    @BeforeEach
    void setUp() {
        charVersionService = new CharVersionService();
    }

    @Test
    void setRandomChar() {
        char randomChar = charVersionService.setRandomChar();
        assertThat(randomChar).isGreaterThanOrEqualTo('a').isLessThanOrEqualTo('z');
    }

    @Test
    void calcIsCharUp() {
        assertThat(charVersionService.calcIsCharUp('b', 'a'))
                .isTrue();
        assertThat(charVersionService.calcIsCharUp('a', 'b'))
                .isFalse();

    }
}