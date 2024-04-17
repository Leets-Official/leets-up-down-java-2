package leets.land.controller;

import leets.land.domain.MainService;
import leets.land.domain.Validator;
import leets.land.view.InputView;
import leets.land.view.OutputView;

import java.io.IOException;

public class MainController {
    private int gameVersion;
    private final OutputView output = new OutputView();
    private final InputView input = new InputView();
    private final Validator validator = new Validator();
    private final MainService service = new MainService();

    public void run() throws IOException {
        gameStart();
        if (gameVersion == 1) {

        }
        if (gameVersion == 2) {

        }
    }

    private void gameStart() throws IOException {
        output.showIntro();

        while (true) {
            output.showGameVersion();
            String inputValue = input.getInput();
            if (validator.versionInputIsValid(inputValue)) {
                gameVersion = service.sortVersionInput(inputValue);
                return;
            }
            output.showInvalidVersionError();
        }
    }
}
