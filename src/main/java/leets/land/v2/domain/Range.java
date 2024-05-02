package leets.land.v2.domain;

import static leets.land.v2.domain.Version.*;

public class Range {

    private int top;
    private int bottom;

    public Range(Version version) {

        this.top = 'z';
        this.bottom = 'A';

        if(version == NUMBER_VERSION) {
            this.top = 1;
            this.bottom = 100;
        }
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

}
