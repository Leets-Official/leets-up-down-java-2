package leets.land.domain.updowngame;

import leets.land.domain.AnswerNumber;

import java.util.Random;

public class RandomNumberGenerator {

    private static final int ORIGIN_RANDOM = 1;
    private static final int BOUND_RANDOM = 101;

    private final Random random = new Random();

    public AnswerNumber generate() {
        int randomNumber = random.nextInt(ORIGIN_RANDOM, BOUND_RANDOM);
        return new AnswerNumber(randomNumber);
    }
}
