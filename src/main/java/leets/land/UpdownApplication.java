package leets.land;

import leets.land.controller.GameController;
import leets.land.model.GameAlphabetModel;
import leets.land.model.GameNumericModel;
import leets.land.view.GameView;

public class UpdownApplication {

	public static void main(String[] args) {
		GameView view = new GameView();
		GameNumericModel numericModel = new GameNumericModel();
		GameAlphabetModel alphabetModel = new GameAlphabetModel();
		GameController controller = new GameController(view, numericModel, alphabetModel);
		controller.play();
	}
}
