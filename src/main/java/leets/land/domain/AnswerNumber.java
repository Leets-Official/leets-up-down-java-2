package leets.land.domain;

public class AnswerNumber {

    private final int value;

    public AnswerNumber(int value) {
        this.value = value;
    }

    public GuessStatus compare(GuessNumber guessNumber) {
        int compared = guessNumber.compare(value);
        if (compared > 0) {
            return GuessStatus.UP;
        }
        if (compared < 0) {
            return GuessStatus.DOWN;
        }
        return GuessStatus.CORRECT;
    }
}
