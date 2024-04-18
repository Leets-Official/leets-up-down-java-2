package leets.land.controller;

import leets.land.domain.NumberUpDown;
import leets.land.domain.UpDown;
import leets.land.view.InputView;
import leets.land.view.OutputView;

public class NumberGame implements Game {
    final InputView inputView = new InputView();
    final OutputView outputView = new OutputView();

    @Override
    public void run() {
        UpDown updown = new NumberUpDown();
        play(updown);
    }

    @Override
    public void play(UpDown updown) {
        int answer = updown.getAnswerAsInt();

        while (true) {
            int number = inputView.inputNumberInRange(updown.getStartAsInt(), updown.getEndAsInt());

            try {
                updown.validator(number);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            updown.increaseCount();

            if (number == answer) {
                System.out.println("Correct!");
                outputView.printCount(updown.getCount());
                break;
            } else if (number < answer) {
                System.out.println("UP");
                updown.setStart(number + 1);
            } else {
                System.out.println("DOWN");
                updown.setEnd(number - 1);
            }
        }
    }
}
