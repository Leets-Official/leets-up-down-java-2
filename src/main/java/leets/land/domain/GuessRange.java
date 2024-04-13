package leets.land.domain;

import java.util.Objects;

public class GuessRange {

    private final GuessNumber min;
    private final GuessNumber max;

    public GuessRange(GuessNumber min, GuessNumber max) {
        this.min = min;
        this.max = max;
    }

    public GuessRange() {
        this(new GuessNumber(1), new GuessNumber(100));
    }

    public GuessRange downMax(GuessNumber max) {
        return new GuessRange(min, max);
    }

    public GuessRange upMin(GuessNumber min) {
        return new GuessRange(min, max);
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
