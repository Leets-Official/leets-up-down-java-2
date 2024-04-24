package leets.land.v2.controller;

import leets.land.v2.domain.Answer;
import leets.land.v2.domain.Range;
import leets.land.v2.view.InputView;
import leets.land.v2.view.OutputView;

import static leets.land.v2.domain.Version.NUMBER_VERSION;

public class NumberGameController implements GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Answer answer = new Answer(NUMBER_VERSION);
    private final Range range = new Range(NUMBER_VERSION);

    @Override
    public void run() {
        while(true) {
            inputView.readNumberGuess(range);
        }
    }

    public boolean isContinue(int guess) {
        if(guess > answer.getAnswer()) {
            outputView.printResult("UP");
            range.setBottom(guess + 1);
        }

        if(guess < answer.getAnswer()) {
            outputView.printResult("DOWN");
            range.setTop(guess - 1);
        }

        if(guess == answer.getAnswer()) {

        }
    }
}
