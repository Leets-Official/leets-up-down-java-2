package leets.land.domain.status;

import leets.land.domain.GuessNumber;

public class Up implements Status {

    private final GuessNumber min;

    public Up(GuessNumber min) {
        this.min = min;
    }

    @Override
    public boolean isEnd() {
        return false;
    }
}
