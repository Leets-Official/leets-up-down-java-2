package leets.land.controller;

import leets.land.domain.MainService;
import leets.land.domain.Validator;
import leets.land.view.InputView;
import leets.land.view.OutputView;

import java.io.IOException;

public class MainController {
    private int gameVersion;
    private final OutputView output = new OutputView();
    private final Validator validator = new Validator();
    private final MainService service = new MainService();

    public void run() throws IOException {
        int tryCount;
        gameStart();
        if (gameVersion == 1) {
            NumberVersionController controller = new NumberVersionController();
            tryCount = controller.run();
            System.out.println(tryCount);
            return;
        }
        if (gameVersion == 2) {
            CharVersionController controller = new CharVersionController();
            controller.run();
        }
    }

    private void gameStart() throws IOException {
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
