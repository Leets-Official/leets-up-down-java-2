package leets.land.view;

import leets.land.domain.CharRange;
import leets.land.domain.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    InputView inputView;
    Range range;
    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("지정 버전 이외에 버전을 입력하면 예외처리")
    @Test
    void getVersionInput() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->
                inputView.validateVersion(0) );
    }

    @DisplayName("범위 외의 숫자가 입력되면 예외처리")
    @Test
    void validateNumberRange() {
        range = new Range(1,100);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->
                inputView.validateNumberRange(range,101) );
    }

    @DisplayName("범위 외의 알파벳이 입력되면 예외처리")
    @Test
    void validateCharRange() {
        CharRange charRange = new CharRange('A','z');
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->
                inputView.validateCharRange(charRange,',') );
    }
    @DisplayName("알파벳이 두개 입력되면 예외처리")
    @Test
    void validCharLength() {
        String doubleString = "ab";
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->
                inputView.validCharLength(doubleString));
    }
}