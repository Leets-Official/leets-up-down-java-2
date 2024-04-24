package leets.land.v2.domain;

import java.util.Arrays;

public enum Version {
    NUMBER_VERSION(1, "숫자"),
    ENGLISH_VERSION(2, "영어");

    private final int value;
    private final String name;

    Version(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static Version getVersion(int version) {
        return Arrays.stream(values())
                .filter(gameVersion -> gameVersion.value == version)
                .findFirst()
                .get();
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

}
