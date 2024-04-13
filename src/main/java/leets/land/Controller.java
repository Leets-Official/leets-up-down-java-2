package leets.land;

import leets.land.view.InputView;
import leets.land.view.OutputView;

import java.util.Random;

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
        while (correct != randomNumber) {
            correct = inputView.readNumber();
            upNumberVersion.printUpDown(correct, randomNumber);
            cnt ++;
        }
        outputView.printCorrectMessage(cnt);
    }

    public void alphaVersion() {
        String alpha = inputView.readString();
        if (Character.isUpperCase(alpha.charAt(0))) {
            char randomAlpha = (char)((Math.random() * 26) + 65);
            System.out.println(randomAlpha);
            int cnt = 1;
            char correct = alpha.charAt(0);
            while (correct != randomAlpha) {
                correct = inputView.readUpperAlpha(correct);
                printUpDown(correct, randomAlpha);
                cnt ++;
            }
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
