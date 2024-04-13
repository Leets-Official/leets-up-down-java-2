package leets.land.domain.status;

import leets.land.domain.GuessNumber;
import leets.land.domain.GuessRange;

public interface Status {

    void narrowRange(GuessRange guessRange, GuessNumber guessNumber);

    boolean isValid(int gap);

    boolean isContinue();
}
