package leets.land.view;

public enum Exceptions {
    NOT_EXIST_VERSIOM("[ERROR] 존재하지 않는 버전입니다."),
    NOT_GOOD_FORMAT("[ERROR] 올바른 형식의 데이터를 입력하세요."),
    NOT_GOOD_RANGE("[ERROR] 범위 내의 데이터를 입력하세요.");
    private final String value;

    Exceptions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
