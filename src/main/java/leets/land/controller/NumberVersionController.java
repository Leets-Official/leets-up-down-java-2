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

            if (service.checkAnswer(answer, number)) {
                outputView.showCorrect();
                break;
            }

            if (service.calcIsNumberUp(answer, number)) {
                outputView.showUp();
                continue;
            }
            outputView.showDown();
        }
        return tryCount;
    }

    private int getNumber() throws IOException {
        InputView inputView = new InputView();
        Validator validator = new Validator();

        while (true) {
            outputView.showInsertValue();
            outputView.showNumberRange(min, max);
            String input = inputView.getInput();

            if (validator.isInputNumber(input)) {
                if (service.checkRange(input, min, max)) {
                    return service.getNumber(input);
                }
                outputView.showInvalidValueRange();
            }
        }
    }
}
