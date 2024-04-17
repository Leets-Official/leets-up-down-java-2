package leets.land.controller;

import leets.land.service.CharGameService;
import leets.land.service.GameService;
import leets.land.service.NumgameService;
import leets.land.view.InputView;
import leets.land.view.OutputView;

import java.util.Scanner;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    private final Scanner scanner = new Scanner(System.in);

    //서비스에서 돌린 중간 결과를 전달받아 outputview로 출력
    public void runApp(){
        outputView.printStartMessage();
        int count = 0;
        int randomNum = gameService.generateNum();
        count = gameService.updownGame(randomNum);
        outputView.printCount(count);
    }
}

