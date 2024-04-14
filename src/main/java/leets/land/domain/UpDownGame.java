package leets.land.domain;

import leets.land.domain.status.GuessStatus;

public interface UpDownGame {

    GuessStatus play(GuessNumber guessNumber);

    GuessRange guessRange();
}
