package leets.land.domain;

public enum Version {
    ENGLISH_VERSION(1, "영어"),
    NUMBER_VERSION(2, "숫자");

    private final int value;
    private final String name;

    Version(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
