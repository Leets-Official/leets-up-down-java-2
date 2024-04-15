package leets.land.domain;

public enum Version {
    NUMBER_VERSION(1, "숫자"),
    ENGLISH_VERSION(2, "영어");

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
