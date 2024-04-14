package leets.land.domain.status;

import leets.land.domain.guess.GuessNumber;
import leets.land.domain.guess.GuessRange;

public class Correct implements Status {

    @Override
    public GuessRange narrowRange(GuessRange guessRange, GuessNumber guessNumber) {
        GuessRange downMaxed = guessRange.downMax(guessNumber);
        return downMaxed.upMin(guessNumber);
    }

    @Override
    public boolean isValid(int gap) {
        return gap == 0;
    }

    @Override
    public boolean isContinue() {
        return false;
    }
}
