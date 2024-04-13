package leets.land.domain.status;

import leets.land.domain.GuessNumber;

public class Down implements Status {

    private final GuessNumber max;

    public Down(GuessNumber max) {
        this.max = max;
    }
}
