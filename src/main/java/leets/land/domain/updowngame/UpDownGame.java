package leets.land.domain.updowngame;

import leets.land.domain.guess.GuessNumber;
import leets.land.domain.guess.GuessRange;
import leets.land.domain.status.GuessStatus;

public interface UpDownGame {

    GuessStatus play(GuessNumber guessNumber);

    GuessRange guessRange();
}
