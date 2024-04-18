package leets.land.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlphabetUpDownTest {
    AlphabetUpDown app = new AlphabetUpDown();

    @Test
    void 범위_외의_알파벳를_입력한_경우_예외를_반환한다() {
        assertThrows(Exception.class, () -> {
            app.validator((char)('A'-1));
        });
    }
}