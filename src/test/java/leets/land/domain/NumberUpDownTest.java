package leets.land.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberUpDownTest {
    NumberUpDown app = new NumberUpDown();

    @Test
    void 범위_외의_숫자를_입력한_경우_예외를_반환한다() {
        assertThrows(Exception.class, () -> {
            app.validator(0);
        });
    }
}