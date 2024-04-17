package leets.land.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberVersionServiceTest {
    private NumberVersionService numberService = new NumberVersionService();

    @BeforeEach
    void setUp() {
        numberService = new NumberVersionService();
    }

    @Test
    void checkRange() {
        assertThat(numberService.checkRange("5", 1, 10)).isTrue();
        assertThat(numberService.checkRange("15", 1, 10)).isFalse();
    }

    @Test
    void setRandomNumber() {
        int randomNum = numberService.setRandomNumber(1, 100);
        assertThat(randomNum).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(100);
    }

    @Test
    void calcIsNumberUp() {
        assertThat(numberService.calcIsNumberUp(10, 5)).isTrue();
        assertThat(numberService.calcIsNumberUp(5, 10)).isFalse();
    }
}