package leets.land.domain.status;

import leets.land.domain.guess.GuessRange;
import leets.land.domain.guess.GuessValue;

import java.util.Arrays;

public enum GuessStatus {

    UP(new Up()),
    DOWN(new Down()),
    CORRECT(new Correct());

    private final Status status;

    GuessStatus(Status status) {
        this.status = status;
    }

    public static GuessStatus match(int gap) {
        return Arrays.stream(values())
                .filter(status -> status.status.isValid(gap))
                .findFirst()
                .orElseThrow();
    }

    public GuessRange narrowRange(GuessValue guessValue, GuessRange guessRange) {
        return status.narrowRange(guessRange, guessValue);
    }

    public boolean isContinue() {
        return status.isContinue();
    }
}
