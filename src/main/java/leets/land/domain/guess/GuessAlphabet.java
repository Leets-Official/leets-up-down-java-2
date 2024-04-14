package leets.land.domain.guess;

import java.util.Objects;

public class GuessAlphabet implements GuessValue {

    private static final int MIN_RANGE = 'A';
    private static final int MAX_RANGE = 'z';
    private static final String ERROR_FORMAT = "[ERROR] %s";

    private final int value;

    public GuessAlphabet(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_RANGE || value > MAX_RANGE) {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, "추측값의 범위는 A 이상 z 이하입니다"));
        }
    }

    public int compare(int other) {
        return other - value;
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuessAlphabet that = (GuessAlphabet) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
