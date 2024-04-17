package leets.land.controller;

import leets.land.game.Game;
import leets.land.view.OutputView;

public class GameController {

    private final OutputView outputView = new OutputView();
    private final Game game;

    //버전에 맞는 Game을 appConfig 클래스에서 주입
    public GameController(Game game) {
        this.game = game;
    }

    //구동부
    public void runApp() {
        outputView.printStartMessage();

        int count = 0;// 사용자 입력횟수를 저장하기 위한 변수 초기화
        int randomNum = game.generateRandomVal();
        count = game.updownGameStart(randomNum);

        //결과 출력
        outputView.printCount(count);
    }
}

