package leets.land.controller;

import leets.land.domain.NumberVersionService;
import leets.land.domain.Validator;
import leets.land.view.InputView;
import leets.land.view.OutputView;

import java.io.IOException;

public class NumberVersionController {
    private int min = 1;
    private int max = 100;

    private final OutputView outputView = new OutputView();
    private final NumberVersionService service = new NumberVersionService();

    public int run() throws IOException {
        int tryCount = 0;
        int answer = service.setRandomNumber(min, max);

        while (true) {
            int number = getNumber();
            tryCount++;

            if (checkAnswer(answer, number)){
                break;
            }

            changeRange(checkIsNumberUp(answer, number), number);
        }
        return tryCount;
    }

    private void changeRange(boolean isUp, int number) {
        if (isUp) {
            outputView.showUp();
            min = number + 1;
            return;
        }
        outputView.showDown();
        max = number - 1;

    }

    private boolean checkIsNumberUp(int answer, int number) {
        return service.calcIsNumberUp(answer, number);
    }

    private boolean checkAnswer(int answer, int number) {
        if (service.checkAnswer(answer, number)) {
            outputView.showCorrect();
            return true;
        }
        return false;
    }

    private int getNumber() throws IOException {
        Validator validator = new Validator();

        while (true) {
            String input = getInput();

            if (validator.isInputNumber(input)) {
                if (service.checkRange(input, min, max)) {
                    return service.getNumber(input);
                }
                outputView.showInvalidValueRange();
            }
        }
    }

    private String getInput() throws IOException {
        InputView inputView = new InputView();

        outputView.showInsertValue();
        outputView.showNumberRange(min, max);
        return inputView.getInput();
    }
}
