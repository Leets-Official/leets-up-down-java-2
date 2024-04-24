package leets.land.v2.controller;

import leets.land.v2.view.InputView;

import static leets.land.v2.domain.Version.NUMBER_VERSION;

public class GameLoader {

    private final InputView inputView = new InputView();

    public void start() {
        GameController controller;

        controller = new EnglishGameController();
        if(inputView.readVersion() == NUMBER_VERSION.getValue())
            controller = new NumberGameController();

        System.out.println("업다운 게임을 시작합니다.\n");
        controller.run();
    }
}
