package leets.land;

import leets.land.view.CharRange;
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
        int cnt = 0;
        int correct = -1;
        Range range = new Range(1, 100);
        while (correct != randomNumber) {
            correct = inputView.readNumber(range);
            printUpDown(correct, randomNumber, range); // Call printUpDown function
            cnt ++;
        }
        outputView.printCorrectMessage(cnt);
    }

    public void printUpDown(int correct, int randomNumber, Range range) {
        if (correct < randomNumber) {
            System.out.println("UP");
            range.setMin(correct + 1);
        } else if (correct > randomNumber) {
            System.out.println("DOWN");
            range.setMax(correct - 1);
        }
    }

    public void alphaVersion() {
        char randomAlpha = (char)((Math.random() * 58) + 65);
        int cnt = 0;
        char correct = 'A'-1;
        CharRange range = new CharRange('A', 'z');
        while (correct != randomAlpha) {
            correct = inputView.readAlpha(range);
            printUpDown(correct, randomAlpha, range);
            cnt ++;
        }
        outputView.printCorrectMessage(cnt);
    }

    public void printUpDown(char correct, char randomAlpha, CharRange range) {
        if (correct < randomAlpha) {
            System.out.println("UP");
            range.setMin((char)(correct + 1));
        } else if (correct > randomAlpha) {
            System.out.println("DOWN");
            range.setMax((char)(correct - 1));
        }
    }
}
