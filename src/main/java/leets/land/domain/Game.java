package leets.land.domain;

import leets.land.view.InputHandler;
import leets.land.view.Inputs;
import leets.land.view.Prints;

import java.util.Random;

import static leets.land.view.InputHandler.NON_ENG_CHAR_END;
import static leets.land.view.InputHandler.NON_ENG_CHAR_START;

public class Game {
    private int minLimitValue;
    private int maxLimitValue;
    private int randomValue;
    private int tryTimes;
    Inputs inputs = new Inputs();
    Prints prints = new Prints();

    public Game(Version version) {
        this.initLimitValue(version);
        this.generateRandomValue(version);
    }

    public int playAndGetTryTimes(Version version) {
        while (true) {
            tryTimes++;

            int expectation = inputs.expectation(minLimitValue, maxLimitValue, version);
            Feedback feedback = this.getFeedBack(expectation, randomValue);
            prints.feedback(feedback);
            this.chagneLimit(version, feedback, expectation);

            if (feedback == Feedback.CORRECT) {
                return tryTimes;
            }
        }
    }

    public Feedback getFeedBack(int expectation, int randomValue) {
        if (expectation < randomValue) {
            return Feedback.UP;
        } else if (expectation > randomValue) {
            return Feedback.DOWN;
        }
        return Feedback.CORRECT;
    }

    public void chagneLimit(Version version, Feedback feedback, int expectation) {
        if (feedback == Feedback.UP) {
            minLimitValue = expectation + 1;
            if (version == Version.ENG && minLimitValue == NON_ENG_CHAR_START) {
                minLimitValue = 'a';
            }
        }
        if (feedback == Feedback.DOWN) {
            maxLimitValue = expectation - 1;
            if (version == Version.ENG && maxLimitValue == NON_ENG_CHAR_END) {
                maxLimitValue = 'Z';
            }
        }
    }

    public void initLimitValue(Version version) {
        if (version == Version.NUM) {
            this.minLimitValue = 1;
            this.maxLimitValue = 100;
        } else if (version == Version.ENG) {
            this.minLimitValue = 'A';
            this.maxLimitValue = 'z';
        }
    }

    public void generateRandomValue(Version version) {
        Random random = new Random();
        if (version == Version.NUM) {
            int randomNumber = random.nextInt(100) + 1;
            this.randomValue = randomNumber;
            return;
        }
        while (true) {
            int randomNumber = random.nextInt(122 - 65 + 1) + 65;
            if (isAlphabet(randomNumber)) {
                this.randomValue = randomNumber;
                return;
            }
        }
    }

    private boolean isAlphabet(int asciiValue) {
        return (asciiValue >= 65 && asciiValue <= 90) || (asciiValue >= 97 && asciiValue <= 122);
    }
}
