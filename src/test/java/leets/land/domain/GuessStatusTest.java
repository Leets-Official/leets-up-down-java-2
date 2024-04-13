package leets.land.domain;

import leets.land.domain.status.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static leets.land.domain.status.GuessStatus.*;
import static org.assertj.core.api.Assertions.assertThat;

class GuessStatusTest {

    @Test
    @DisplayName("차가 양수라면 Up을 반환한다.")
    void match_Positive_Up() {
        GuessStatus guessStatus = match(1);

        assertThat(guessStatus).isEqualTo(UP);
    }

    @Test
    @DisplayName("차가 음수라면 Down을 반환한다.")
    void match_Negative_Up() {
        GuessStatus guessStatus = match(-1);

        assertThat(guessStatus).isEqualTo(DOWN);
    }

    @Test
    @DisplayName("차가 0이라면 Correct을 반환한다.")
    void match_Zero_Correct() {
        GuessStatus guessStatus = match(0);

        assertThat(guessStatus).isEqualTo(CORRECT);
    }

    @Test
    @DisplayName("추측값을 하한값으로 가지는 Up을 생성한다.")
    void match_Up() {
        GuessNumber guessNumber = new GuessNumber(51);

        Status up = UP.match(guessNumber);

        assertThat(up).isInstanceOf(Up.class);
    }

    @Test
    @DisplayName("추측값을 상한값으로 가지는 Down을 생성한다.")
    void match_Down() {
        GuessNumber guessNumber = new GuessNumber(51);

        Status down = DOWN.match(guessNumber);

        assertThat(down).isInstanceOf(Down.class);
    }

    @Test
    @DisplayName("추측값을 정답으로 가지는 Correct을 생성한다.")
    void match_Correct() {
        GuessNumber guessNumber = new GuessNumber(50);

        Status correct = CORRECT.match(guessNumber);

        assertThat(correct).isInstanceOf(Correct.class);
    }
}
