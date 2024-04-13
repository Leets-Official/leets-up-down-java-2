package leets.land.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class GuessNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 101})
    @DisplayName("범위 외 추측값인 경우 예외가 발생한다.")
    void guessNumber_OutOfRange_ExceptionThrown(int outOfRange) {
        assertThatIllegalArgumentException().
                isThrownBy(() -> new GuessNumber(outOfRange));
    }
}
