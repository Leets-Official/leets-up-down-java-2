package leets.land.domain.status;

import leets.land.domain.GuessNumber;
import leets.land.domain.GuessRange;

import java.util.Arrays;

public enum GuessStatus {

    UP(new Up()),
    DOWN(new Down()),
    CORRECT(new Correct());

    private final Status status;
    private final GuessRange guessRange;

    GuessStatus(Status status) {
        this.status = status;
        this.guessRange = new GuessRange();
    }

    public static GuessStatus match(int gap) {
        return Arrays.stream(values())
                .filter(status -> status.status.isValid(gap))
                .findFirst()
                .orElseThrow();
    }

    public void narrowRange(GuessNumber guessNumber) {
        status.narrowRange(guessRange, guessNumber);
    }

    public boolean isContinue() {
        return status.isContinue();
    }

    public GuessRange guessRange() {
        return guessRange;
    }
}
