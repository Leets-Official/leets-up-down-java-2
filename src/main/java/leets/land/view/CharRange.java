package leets.land.view;

public class CharRange {
    private char min;
    private char max;

    public CharRange(char min, char max) {
        this.min = min;
        this.max = max;
    }

    public char getMin() {
        return min;
    }

    public char getMax() {
        return max;
    }

    public void setMin(char min) {
        this.min = min;
    }

    public void setMax(char max) {
        this.max = max;
    }
}