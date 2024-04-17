package leets.land.domain.updowngame;

import leets.land.domain.AnswerNumber;
import leets.land.domain.guess.GuessNumber;
import leets.land.domain.guess.GuessRange;
import leets.land.domain.guess.GuessValue;
import leets.land.domain.status.GuessStatus;

public class NumberUpDownGame implements UpDownGame {

    private final AnswerNumber answerNumber = new RandomNumberGenerator().generate();
    private GuessRange guessRange = new GuessRange(new GuessNumber(1), new GuessNumber(100));

    @Override
    public GuessStatus play(GuessValue guessValue) {
        GuessStatus guessStatus = answerNumber.compare(guessValue);
        guessRange = guessStatus.narrowRange(guessValue, guessRange);
        return guessStatus;
    }

    @Override
    public GuessRange guessRange() {
        return guessRange;
    }
}
