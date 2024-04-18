package leets.land.controller;

import leets.land.model.Game;
import leets.land.view.InputView;
import leets.land.view.OutputView;

public class GameController {
    private Game game;
    private InputView inputView;
    private OutputView outputView;

    public GameController() {
        this.game = new Game();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        outputView.displayWelcomeMessage();
        int gameType = inputView.promptForGameType();
        game.initializeGame(gameType);

        while (!game.isGameOver()) {
            String range = game.getCurrentRange();
            outputView.displayPrompt("값을 입력해주세요 " + range + " : ");
            String guess = inputView.promptForGuess();
            if (!game.isValidGuess(guess)) {
                outputView.displayError("범위 내의 올바른 값을 입력하세요.");
                continue;
            }
            game.processGuess(guess); // 변경된 부분
            if (game.isGameOver()) {
                outputView.displayGameOverMessage(game.getGuessCount());
            }
        }
    }
}