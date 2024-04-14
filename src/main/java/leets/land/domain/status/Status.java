package leets.land.domain.status;

import leets.land.domain.guess.GuessNumber;
import leets.land.domain.guess.GuessRange;

public interface Status {

    GuessRange narrowRange(GuessRange guessRange, GuessNumber guessNumber);

    boolean isValid(int gap);

    boolean isContinue();
}
