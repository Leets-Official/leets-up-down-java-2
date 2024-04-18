package leets.land.domain;

public enum Feedback {
    UP("UP"),
    DOWN("DOWN"),
    CORRECT("정답!");

    private final String value;

    Feedback(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
