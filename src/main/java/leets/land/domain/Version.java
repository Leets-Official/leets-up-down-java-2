package leets.land.domain;

public enum Version {
    ENGLISH_VERSION(1),
    NUMBER_VERSION(2);

    private final int value;

    Version(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
