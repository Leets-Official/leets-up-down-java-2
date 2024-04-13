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
        GuessNumber guessNumber = readFirstGuessNumber();
        GuessStatus guessStatus = play(answerNumber, guessNumber);
        guessRange = guessStatus.narrowRange(guessNumber, guessRange);
        while (guessStatus.isContinue()) {
            guessNumber = readGuessNumberInRange(guessRange);
            guessStatus = play(answerNumber, guessNumber);
            guessRange = guessStatus.narrowRange(guessNumber, guessRange);
        }
    }

    private GuessStatus play(AnswerNumber answerNumber, GuessNumber guessNumber) {
        GuessStatus guessStatus = answerNumber.compare(guessNumber);
        outputView.printGuessStatus(guessStatus);
        return guessStatus;
    }

    private GuessNumber readFirstGuessNumber() {
        try {
            int guessNumber = inputView.readFirstGuessNumber();
            return new GuessNumber(guessNumber);
        } catch (IllegalArgumentException e) {
            return readFirstGuessNumber();
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
