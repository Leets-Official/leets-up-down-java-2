package leets.land.controller;

import leets.land.domain.guess.GuessAlphabet;
import leets.land.domain.guess.GuessRange;
import leets.land.domain.guess.GuessValue;
import leets.land.domain.status.GuessStatus;
import leets.land.domain.updowngame.AlphabetUpDownGame;
import leets.land.domain.updowngame.UpDownGame;
import leets.land.view.InputView;
import leets.land.view.OutputView;

public class AlphabetGameMachine {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        UpDownGame upDownGame = new AlphabetUpDownGame();
        play(upDownGame);
    }

    private void play(UpDownGame upDownGame) {
        GuessValue guessValue = readGuessValueInRange(upDownGame.guessRange());
        GuessStatus guessStatus = upDownGame.play(guessValue);
        outputView.printGuessStatus(guessStatus);
        if (guessStatus.isContinue()) {
            play(upDownGame);
        }
    }

    private GuessValue readGuessValueInRange(GuessRange guessRange) {
        try {
            int guessValue = inputView.readGuessAlphabetInRange(guessRange.min(), guessRange.max());
            guessRange.checkRange(guessValue);
            return new GuessAlphabet(guessValue);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGuessValueInRange(guessRange);
        }
    }
}
