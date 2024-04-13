package leets.land.controller;

import leets.land.domain.AnswerNumber;
import leets.land.domain.GuessNumber;
import leets.land.domain.RandomNumberGenerator;
import leets.land.domain.status.GuessStatus;
import leets.land.domain.status.Status;
import leets.land.view.InputView;

public class GameMachine {

    private final InputView inputView = new InputView();

    public void run() {
        AnswerNumber answerNumber = new RandomNumberGenerator().generate();
        Status status = play(answerNumber);
        while (status.isEnd()) {
            status = play(answerNumber);
        }
    }

    private Status play(AnswerNumber answerNumber) {
        GuessNumber guessNumber = readGuessNumber();
        GuessStatus guessStatus = answerNumber.compare(guessNumber);
        return guessStatus.match(guessNumber);
    }

    private GuessNumber readGuessNumber() {
        try {
            int guessNumber = inputView.readGuessNumber();
            return new GuessNumber(guessNumber);
        } catch (IllegalArgumentException e) {
            return readGuessNumber();
        }
    }
}
