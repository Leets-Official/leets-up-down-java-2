package leets.land.domain.status;

import leets.land.domain.GuessNumber;
import leets.land.domain.GuessRange;

public class Up implements Status {

    @Override
    public void narrowRange(GuessRange guessRange, GuessNumber guessNumber) {
        guessRange.upMin(guessNumber);
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
