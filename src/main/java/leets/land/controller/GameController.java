package leets.land.controller;

import leets.land.model.GameAlphabetModel;
import leets.land.model.GameNumericModel;
import leets.land.view.GameView;

public class GameController {

  private final GameView view;
  private final GameNumericModel numericModel;
  private final GameAlphabetModel alphabetModel;

  public GameController(GameView view, GameNumericModel numericModel,
      GameAlphabetModel alphabetModel) {
    this.view = view;
    this.numericModel = numericModel;
    this.alphabetModel = alphabetModel;
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
    int input = view.getAlphabetInput();
    while (true) {

      if (alphabetModel.up(input)) {
        input = alphabetModel.changeLimitForUp(input);
      } else if (alphabetModel.down(input)) {
        input = alphabetModel.changeLimitForDown(input);
      } else if (alphabetModel.isCorrect(input)) {
        System.out.println("정답 !");
        break;
      }
    }

    System.out.println("시도한 횟수 : " + (GameAlphabetModel.getCount() + 1));
  }
}
