package leets.land;

import leets.land.view.InputView;
import leets.land.view.OutputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final UpNumberVersion upNumberVersion = new UpNumberVersion();
    public void run() {
        int version = inputView.versionInput();
        if (version == 1) {
            numberVersion();
        } else {
            alphaVersion();
        }
    }
    public void numberVersion() {
        double randomValue = Math.random();
        int randomNumber = (int)(randomValue *100) +1;
        System.out.println(randomNumber);
        int cnt = 0;
        int correct = -1;
        Range range = new Range(1, 100);
        while (correct != randomNumber) {
            correct = inputView.readNumber(range);
            if (correct < randomNumber) {
                System.out.println("UP");
                range.setMin(correct + 1);
            } else if (correct > randomNumber) {
                System.out.println("DOWN");
                range.setMax(correct - 1);
            }
            cnt ++;
        }
        outputView.printCorrectMessage(cnt);
    }

    public void alphaVersion() {
            char alpha = inputView.readAlpha();
            char randomAlpha = (char)((Math.random() * 26) + 65);
            System.out.println(randomAlpha);
            int cnt = 0;
            char correct = alpha;
            while (correct != randomAlpha) {
                correct = inputView.readAlpha(correct);
                printUpDown(correct, randomAlpha);
                cnt ++;
            outputView.printCorrectMessage(cnt);
        }
    }
    public void printUpDown(char correct, char randomAlpha) {
        if (correct < randomAlpha) {
            System.out.println("UP");
        } else if(correct > randomAlpha) {
            System.out.println("Down");
        }
    }
}
