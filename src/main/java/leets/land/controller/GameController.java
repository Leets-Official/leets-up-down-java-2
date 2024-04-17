package leets.land.controller;

import leets.land.model.GameNumericModel;
import leets.land.view.GameView;

public class GameController {

  private final GameView view;
  private final GameNumericModel numericModel;

  public GameController(GameView view, GameNumericModel numericModel) {
    this.view = view;
    this.numericModel = numericModel;
  }

  public void play() {
    int version = view.getVersionInput();

    if (version == 1) {
      numericPlay();
    } else if (version == 2) {
      alphabetPlay();
    }
  }

  public void numericPlay() {

    int input = view.getNumericInput();
    while (true) {

      if (numericModel.up(input)) {
        input = numericModel.changeLimitForUp(input);
      } else if (numericModel.down(input)) {
        input = numericModel.changeLimitForDown(input);
      } else if (numericModel.isCorrect(input)) {
        System.out.println("정답 !");
        break;
      }
    }

    System.out.println("시도한 횟수 : " + (GameNumericModel.getCount() + 1));
  }

  public void alphabetPlay() {

  }
}
