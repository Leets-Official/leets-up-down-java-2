package leets.land.domain.updowngame;

import leets.land.domain.guess.GuessRange;
import leets.land.domain.guess.GuessValue;
import leets.land.domain.status.GuessStatus;

public interface UpDownGame {

    GuessStatus play(GuessValue guessValue);

    GuessRange guessRange();
}
