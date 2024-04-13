package leets.land.domain;

import leets.land.domain.status.GuessStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static leets.land.domain.status.GuessStatus.*;
import static org.assertj.core.api.Assertions.assertThat;

class GuessStatusTest {

    @Test
    @DisplayName("차가 양수라면 Up을 반환한다.")
    void match_Positive_Up() {
        GuessStatus guessStatus = GuessStatus.match(1);

        assertThat(guessStatus).isEqualTo(UP);
    }

    @Test
    @DisplayName("차가 음수라면 Down을 반환한다.")
    void match_Negative_Up() {
        GuessStatus guessStatus = GuessStatus.match(-1);

        assertThat(guessStatus).isEqualTo(DOWN);
    }

    @Test
    @DisplayName("차가 0이라면 Correct을 반환한다.")
    void match_Zero_Correct() {
        GuessStatus guessStatus = GuessStatus.match(0);

        assertThat(guessStatus).isEqualTo(CORRECT);
    }
}
