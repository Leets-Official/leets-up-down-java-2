package leets.land.domain;

import java.util.Objects;

public class GuessNumber {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final String ERROR_FORMAT = "[ERROR] %s";

    private final int value;

    public GuessNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_RANGE || value > MAX_RANGE) {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, "추측값의 범위는 1 이상 100 이하입니다"));
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
        GuessNumber that = (GuessNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
