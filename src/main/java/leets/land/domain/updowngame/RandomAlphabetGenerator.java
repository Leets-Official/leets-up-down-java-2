package leets.land.domain.updowngame;

import leets.land.domain.AnswerNumber;

import java.util.Random;

public class RandomAlphabetGenerator {

    private static final int CAPITAL_ORIGIN_RANDOM = 'A';
    private static final int CAPITAL_BOUND_RANDOM = 'Z';
    private static final int TO_SMALL = 'a' - 'A';

    private final Random random = new Random();

    public AnswerNumber generate() {
        int randomNumber = random.nextInt(CAPITAL_ORIGIN_RANDOM, CAPITAL_BOUND_RANDOM);
        boolean isSmall = random.nextBoolean();
        if (isSmall) {
            randomNumber += TO_SMALL;
        }
        return new AnswerNumber(randomNumber);
    }
}
