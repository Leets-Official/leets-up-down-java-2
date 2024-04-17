package leets.land.controller;

import leets.land.domain.AlphabetUpDown;
import leets.land.domain.UpDown;
import leets.land.view.InputView;
import leets.land.view.OutputView;

public class AlphabetGame implements Game{
    final InputView inputView = new InputView();
    final OutputView outputView = new OutputView();

    @Override
    public void run() {
        UpDown updown = new AlphabetUpDown();
        play(updown);
    }

    @Override
    public void play(UpDown updown) {
        while (true) {
            char alphabet = inputView.inputAlphabetInRange(updown.getStartAsChar(), updown.getEndAsChar());

            try{
                updown.validator(alphabet);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            updown.increaseCount();

            if (alphabet == updown.getAnswerAsChar()) {
                outputView.printCount(updown.getCount());
                break;
            } else if (alphabet < updown.getAnswerAsChar()) {
                System.out.println("UP");
                updown.setStart(alphabet + 1);
            } else {
                System.out.println("DOWN");
                updown.setEnd(alphabet - 1);
            }
        }
    }
}
