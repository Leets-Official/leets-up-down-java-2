package leets.land.view;

import leets.land.UpdownApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    UpdownApplication app;
    InputView inputView;

    @BeforeEach
    void setUp(){
        app = new UpdownApplication();
        inputView = new InputView();
    }

    @Test
    void 버전_입력_범위_확인(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->
             inputView.validVersionNum(0) );
    }
}