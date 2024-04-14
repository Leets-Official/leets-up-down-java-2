package leets.land.controller;

import leets.land.domain.GuessNumber;
import leets.land.domain.GuessRange;
import leets.land.domain.NumberUpDownGame;
import leets.land.domain.UpDownGame;
import leets.land.domain.status.GuessStatus;
import leets.land.view.InputView;
import leets.land.view.OutputView;

public class GameMachine {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        UpDownGame upDownGame = new NumberUpDownGame();
        play(upDownGame);
    }

    private void play(UpDownGame upDownGame) {
        GuessNumber guessNumber = readGuessNumberInRange(upDownGame.guessRange());
        GuessStatus guessStatus = upDownGame.play(guessNumber);
        outputView.printGuessStatus(guessStatus);
        if (guessStatus.isContinue()) {
            play(upDownGame);
        }
    }

    private GuessNumber readGuessNumberInRange(GuessRange guessRange) {
        try {
            int guessNumber = inputView.readGuessNumberInRange(guessRange.min(), guessRange.max());
            guessRange.checkRange(guessNumber);
            return new GuessNumber(guessNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGuessNumberInRange(guessRange);
        }
    }
}
