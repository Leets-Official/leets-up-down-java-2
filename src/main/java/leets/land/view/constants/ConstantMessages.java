package leets.land.view.constants;

public enum ConstantMessages {
    NEWLINE("\n"),
    GAME_START("업다운 게임을 시작합니다."),
    GAME_VERSION("버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2) : "),
    INSERT_VALUE("숫자를 입력해주세요"),
    INSERT_CHAR("영어를 입력해주세요"),
    DELIMITER(" : "),
    UP("UP"),
    DOWN("DOWN"),
    CORRECT("정답!"),
    TRY_COUNT("시도한 횟수 : "),
    ERROR_INVALID_GAME_VERSION("[ERROR] 존재하지 않는 버전입니다. 1 또는 2를 입력해주세요."),
    ERROR_INVALID_RANGE_VALUE("[ERROR] 범위 내의 숫자를 입력하세요."),
    ERROR_INVALID_RANGE_CHAR("[ERROR] 범위 내의 알파벳을 입력하세요."),
    ERROR_INVALID_INPUT_TYPE("[ERROR] 입력 문자의 타입이 맞지 않습니다."),
    PREFIX_RANGE("("),
    DELIMITER_RANGE(" ~ "),
    SUFFIX_RANGE(")");

    private final String message;

    ConstantMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
