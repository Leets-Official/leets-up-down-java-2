package leets.land.controller;

import leets.land.domain.CharVersionService;
import leets.land.domain.Validator;
import leets.land.view.InputView;
import leets.land.view.OutputView;

import java.io.IOException;

public class CharVersionController {
    private char min = 'A';
    private char max = 'z';

    private final OutputView outputView = new OutputView();
    private final CharVersionService service = new CharVersionService();

    public int run() throws IOException {
        int tryCount = 0;
        char answer = service.setRandomChar();

        while (true) {
            char value = getValue();
            tryCount++;

            if (checkAnswer(answer, value)) {
                break;
            }

            changeRange(checkIsInputUp(answer, value), value);
        }
        return tryCount;
    }

    private void changeRange(boolean isUp, char value) {
        if (isUp) {
            outputView.showUp();
            if (value == 90) {
                min = (char) (97);
                return;
            }
            min = (char) (value + 1);
            return;
        }
        if (value == 97) {
            max = (char) (90);
            return;
        }
        max = (char) (value - 1);
        outputView.showDown();
    }

    private boolean checkIsInputUp(char answer, char value) {
        return service.calcIsCharUp(answer, value);
    }

    private boolean checkAnswer(char answer, char value) {
        if (service.checkAnswer(answer, value)) {
            outputView.showCorrect();
            return true;
        }
        return false;
    }

    private char getValue() throws IOException {
        Validator validator = new Validator();

        while (true) {
            String input = getInput();
            if (validator.checkInputTypeForCharVersion(input)) {
                outputView.showInvalidInputType();
                continue;
            }

            if (validator.isInputChar(input)) {
                return service.getChar(input);
            }
            outputView.showInvalidCharRange();
        }
    }

    private String getInput() throws IOException {
        InputView inputView = new InputView();

        outputView.showInsertChar();
        outputView.showCharRange(min, max);
        return inputView.getInput();
    }
}
