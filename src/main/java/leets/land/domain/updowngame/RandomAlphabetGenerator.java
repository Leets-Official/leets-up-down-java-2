package leets.land.domain.updowngame;

import leets.land.domain.AnswerNumber;

import java.util.Random;

public class RandomAlphabetGenerator {

    private static final int CAPITAL_ORIGIN_RANDOM = 'A';
    private static final int CAPITAL_BOUND_RANDOM = 'Z';

    private final Random random = new Random();

    public AnswerNumber generate() {
        int randomNumber = random.nextInt(CAPITAL_ORIGIN_RANDOM, CAPITAL_BOUND_RANDOM);
        boolean isSmall = random.nextBoolean();
        if (isSmall) {
            randomNumber = Character.toLowerCase(randomNumber);
        }
        return new AnswerNumber(randomNumber);
    }
}
