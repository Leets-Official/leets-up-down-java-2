package leets.land.domain.updowngame;

import leets.land.domain.AnswerNumber;
import leets.land.domain.guess.GuessAlphabet;
import leets.land.domain.guess.GuessRange;
import leets.land.domain.guess.GuessValue;
import leets.land.domain.status.GuessStatus;

public class AlphabetUpDownGame implements UpDownGame {

    private final AnswerNumber answerNumber = new RandomAlphabetGenerator().generate();
    private GuessRange guessRange = new GuessRange(new GuessAlphabet('A'), new GuessAlphabet('z'));

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
