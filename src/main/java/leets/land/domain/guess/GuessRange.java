package leets.land.domain.guess;

import java.util.Objects;

public class GuessRange {

    private static final String ERROR_FORMAT = "[ERROR] %s";

    private final GuessValue min;
    private final GuessValue max;

    public GuessRange(GuessValue min, GuessValue max) {
        this.min = min;
        this.max = max;
    }

    public GuessRange downMax(GuessValue max) {
        return new GuessRange(min, max);
    }

    public GuessRange upMin(GuessValue min) {
        return new GuessRange(min, max);
    }

    public void checkRange(int guessValue) {
        if (guessValue < min() || guessValue > max()) {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, "범위를 벗어납니다."));
        }
    }

    public int min() {
        return min.value();
    }

    public int max() {
        return max.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuessRange that = (GuessRange) o;
        return Objects.equals(min, that.min) && Objects.equals(max, that.max);
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }
}
