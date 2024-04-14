package leets.land.domain.status;

import leets.land.domain.guess.GuessNumber;
import leets.land.domain.guess.GuessRange;

public class Up implements Status {

    @Override
    public GuessRange narrowRange(GuessRange guessRange, GuessNumber guessNumber) {
        return guessRange.upMin(guessNumber);
    }

    @Override
    public boolean isValid(int gap) {
        return gap > 0;
    }

    @Override
    public boolean isContinue() {
        return true;
    }
}
