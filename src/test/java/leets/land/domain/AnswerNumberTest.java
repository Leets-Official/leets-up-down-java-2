package leets.land.domain;

import leets.land.domain.status.GuessStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static leets.land.domain.status.GuessStatus.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AnswerNumberTest {

    @Test
    @DisplayName("추측값이 정답과 일치하면 CORRECT를 반환한다.")
    void answer_Grade_Correct() {
        GuessNumber guessNumber = new GuessNumber(50);
        AnswerNumber answerNumber = new AnswerNumber(50);

        GuessStatus guessStatus = answerNumber.compare(guessNumber);

        assertThat(guessStatus).isEqualTo(CORRECT);
    }

    @Test
    @DisplayName("추측값이 정답보다 크다면 DOWN을 반환한다.")
    void answer_Grade_Down() {
        GuessNumber guessNumber = new GuessNumber(51);
        AnswerNumber answerNumber = new AnswerNumber(50);

        GuessStatus guessStatus = answerNumber.compare(guessNumber);

        assertThat(guessStatus).isEqualTo(DOWN);
    }

    @Test
    @DisplayName("추측값이 정답보다 작으면 UP을 반환한다.")
    void answer_Grade_Up() {
        GuessNumber guessNumber = new GuessNumber(49);
        AnswerNumber answerNumber = new AnswerNumber(50);

        GuessStatus guessStatus = answerNumber.compare(guessNumber);

        assertThat(guessStatus).isEqualTo(UP);
    }
}
