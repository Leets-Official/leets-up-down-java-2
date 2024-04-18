package leets.land.domain;

public enum Version {
    NUM(1),
    ENG(2),
    ERROR(-1);
    private final int value;

    Version(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
