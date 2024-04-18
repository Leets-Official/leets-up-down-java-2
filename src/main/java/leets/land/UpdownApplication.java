package leets.land;


import leets.land.controller.MatchController;
import leets.land.view.InputView;

public class UpdownApplication {


	public static void main(String[] args)  {
		InputView inputView = new InputView();
		int versionNum = inputView.inputVersionNum();
		MatchController matchController = appConfig.gameController(versionNum);
		matchController.runApp();
	}
}




