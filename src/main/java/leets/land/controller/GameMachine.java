package leets.land.controller;

import leets.land.domain.AnswerNumber;
import leets.land.domain.GuessNumber;
import leets.land.domain.GuessRange;
import leets.land.domain.RandomNumberGenerator;
import leets.land.domain.status.GuessStatus;
import leets.land.view.InputView;
import leets.land.view.OutputView;

public class GameMachine {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        AnswerNumber answerNumber = new RandomNumberGenerator().generate();
        GuessRange guessRange = new GuessRange();
        play(answerNumber, guessRange);
    }

    private void play(AnswerNumber answerNumber, GuessRange guessRange) {
        GuessNumber guessNumber = readGuessNumberInRange(guessRange);
        GuessStatus guessStatus = answerNumber.compare(guessNumber);
        outputView.printGuessStatus(guessStatus);
        guessRange = guessStatus.narrowRange(guessNumber, guessRange);
        if (guessStatus.isContinue()) {
            play(answerNumber, guessRange);
        }
    }

    private GuessNumber readGuessNumberInRange(GuessRange guessRange) {
        try {
            int guessNumber = inputView.readGuessNumberInRange(guessRange.min(), guessRange.max());
            return new GuessNumber(guessNumber);
        } catch (IllegalArgumentException e) {
            return readGuessNumberInRange(guessRange);
        }
    }
}
