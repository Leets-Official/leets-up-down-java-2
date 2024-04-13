package leets.land.domain.status;

import leets.land.domain.GuessNumber;

public class Correct implements Status {

    private final GuessNumber max;

    public Correct(GuessNumber max) {
        this.max = max;
    }

    @Override
    public boolean isEnd() {
        return true;
    }
}
