package leets.land.domain.status;

import leets.land.domain.GuessNumber;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

public enum GuessStatus {

    UP(compared -> compared > 0, Up::new),
    DOWN(compared -> compared < 0, Down::new),
    CORRECT(compared -> compared == 0, Correct::new);

    private final Predicate<Integer> compare;
    private final Function<GuessNumber, Status> status;

    GuessStatus(Predicate<Integer> compare, Function<GuessNumber, Status> status) {
        this.compare = compare;
        this.status = status;
    }

    public static GuessStatus match(int gap) {
        return Arrays.stream(values())
                .filter(status -> status.compare.test(gap))
                .findFirst()
                .orElseThrow();
    }

    public Status match(GuessNumber guessNumber) {
        return status.apply(guessNumber);
    }
}
