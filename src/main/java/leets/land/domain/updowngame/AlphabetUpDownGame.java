package leets.land.domain.updowngame;

import leets.land.domain.AnswerNumber;
import leets.land.domain.guess.GuessAlphabet;
import leets.land.domain.guess.GuessNumber;
import leets.land.domain.guess.GuessRange;
import leets.land.domain.status.GuessStatus;

public class AlphabetUpDownGame implements UpDownGame {

    private final AnswerNumber answerNumber = new RandomAlphabetGenerator().generate();
    private GuessRange guessRange = new GuessRange(new GuessAlphabet('A'), new GuessAlphabet('z'));

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
