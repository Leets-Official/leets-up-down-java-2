package leets.land.v2.domain;

public enum Status {
    UP("UP"),
    DOWN("DOWN"),
    CORRECT("정답!z시도한 횟수 : 4회");

    private final String printFormat;

    Status(String printFormat) {
        this.printFormat = printFormat;
    }
}
