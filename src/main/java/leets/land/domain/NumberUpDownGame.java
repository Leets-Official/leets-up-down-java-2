package leets.land.domain;

import leets.land.domain.status.GuessStatus;

public class NumberUpDownGame implements UpDownGame {

    private final AnswerNumber answerNumber = new RandomNumberGenerator().generate();
    private GuessRange guessRange = new GuessRange(new GuessNumber(1), new GuessNumber(100));

    @Override
    public GuessStatus play(GuessNumber guessNumber) {
        GuessStatus guessStatus = answerNumber.compare(guessNumber);
        guessRange = guessStatus.narrowRange(guessNumber, guessRange);
        return guessStatus;
    }

    @Override
    public GuessRange guessRange() {
        return guessRange;
    }
}
