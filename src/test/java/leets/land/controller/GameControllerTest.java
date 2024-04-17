package leets.land.controller;

import leets.land.UpdownApplication;
import leets.land.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

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
    void 숫자_입력_범위_확인(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->
                gameController.checkValidNumRange(50,100, 20) );
    }

}