package leets.land.controller;

import leets.land.domain.MainService;
import leets.land.domain.Validator;
import leets.land.view.InputView;
import leets.land.view.OutputView;

import java.io.IOException;

public class MainController {
    private int gameVersion;
    private final OutputView output = new OutputView();

    public void run() throws IOException {
        int tryCount = 0;
        gameStart();

        if (gameVersion == 1) {
            NumberVersionController controller = new NumberVersionController();
            tryCount = controller.run();
        }

        if (gameVersion == 2) {
            CharVersionController controller = new CharVersionController();
            tryCount = controller.run();
        }
        output.showTryCount(tryCount);
    }

    private void gameStart() throws IOException {
        Validator validator = new Validator();
        MainService service = new MainService();
        InputView inputView = new InputView();

        output.showIntro();

        while (true) {
            output.showGameVersion();
            String inputValue = inputView.getInput();
            if (validator.versionInputIsValid(inputValue)) {
                gameVersion = service.sortVersionInput(inputValue);
                return;
            }
            output.showInvalidVersionError();
        }
    }
}
