package leets.land;


import leets.land.controller.GameController;
import leets.land.view.InputView;

public class UpdownApplication {


	public static void main(String[] args)  {
		InputView inputView = new InputView();
		int versionNum = inputView.inputVersionNum();
		GameController gameController = appConfig.gameController(versionNum);
		gameController.runApp();
	}
}




