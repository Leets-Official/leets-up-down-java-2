package leets.land.domain;

import leets.land.domain.guess.GuessValue;
import leets.land.domain.status.GuessStatus;

public class AnswerNumber {

    private final int value;

    public AnswerNumber(int value) {
        this.value = value;
    }

    public GuessStatus compare(GuessValue guessValue) {
        int compared = guessValue.compare(value);
        return GuessStatus.match(compared);
    }
}
