package leets.land.domain;

public class AnswerNumber {

    private final int value;

    public AnswerNumber(int value) {
        this.value = value;
    }

    public GuessStatus compare(GuessNumber guessNumber) {
        int compared = guessNumber.compare(value);
        return GuessStatus.match(compared);
    }
}
