package leets.land.domain;

import leets.land.domain.status.GuessStatus;

public class UpDownGame {

    private final AnswerNumber answerNumber = new RandomNumberGenerator().generate();
    private GuessRange guessRange = new GuessRange();

    public GuessStatus play(GuessNumber guessNumber) {
        GuessStatus guessStatus = answerNumber.compare(guessNumber);
        guessRange = guessStatus.narrowRange(guessNumber, guessRange);
        return guessStatus;
    }

    public GuessRange guessRange() {
        return guessRange;
    }
}
