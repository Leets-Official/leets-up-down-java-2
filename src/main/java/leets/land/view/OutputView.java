package leets.land.view;

import static leets.land.view.constants.ConstantMessages.*;

public class OutputView {

    public void showIntro() {
        System.out.println(GAME_START.getMessage());
        System.out.print(NEWLINE.getMessage());
    }

    public void showGameVersion() {
        System.out.print(GAME_VERSION.getMessage());
    }

    public void showInsertValue() {
        System.out.print(INSERT_VALUE.getMessage());
    }

    public void showInsertChar() {
        System.out.print(INSERT_CHAR.getMessage());
    }

    public void showUp() {
        System.out.println(UP.getMessage());
    }

    public void showDown() {
        System.out.println(DOWN.getMessage());
    }

    public void showCorrect() {
        System.out.println(CORRECT.getMessage());
    }

    public void showTryCount(int tryCount) {
        System.out.println(TRY_COUNT.getMessage() + DELIMITER + tryCount + SUFFIX_TRY_COUNT);
    }

    public void showInvalidVersionError() {
        System.out.println(ERROR_INVALID_GAME_VERSION.getMessage());
    }

    public void showInvalidValueRange() {
        System.out.println(ERROR_INVALID_RANGE_VALUE.getMessage());
    }

    public void showInvalidCharRange() {
        System.out.println(ERROR_INVALID_RANGE_CHAR.getMessage());
    }

    public void showInvalidInputType() {
        System.out.println(ERROR_INVALID_INPUT_TYPE.getMessage());
    }

    public void showNumberRange(int min, int max) {
        System.out.print(PREFIX_RANGE.getMessage() + min + DELIMITER_RANGE.getMessage() + max + SUFFIX_RANGE.getMessage() + DELIMITER.getMessage());
    }
}
