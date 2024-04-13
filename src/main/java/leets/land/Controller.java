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
    }
}
