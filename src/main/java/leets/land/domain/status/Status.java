package leets.land.domain.status;

import leets.land.domain.guess.GuessRange;
import leets.land.domain.guess.GuessValue;

public interface Status {

    GuessRange narrowRange(GuessRange guessRange, GuessValue guessValue);

    boolean isValid(int gap);

    boolean isContinue();
}
