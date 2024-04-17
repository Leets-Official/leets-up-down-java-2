package leets.land.view;

import leets.land.UpdownApplication;
import leets.land.controller.GameController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    UpdownApplication app;
    InputView inputView;
    GameController gameController;

    @BeforeEach
    void setUp(){
        app = new UpdownApplication();
        inputView = new InputView();
        gameController = new GameController();
    }

    @Test
    void 버전_입력_범위_확인(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->
             inputView.validVersionNum(0) );
    }

    @Test
    void 숫자_입력_범위_확인(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->
                inputView.checkValidNumRange(50,100, 20) );
    }

    @Test
    void 영어_입력_범위_확인(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,  ()->
                inputView.checkValidCharRange('a', 'c', 's'));
    }


}