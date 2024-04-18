package leets.land;

import leets.land.controller.GameController;

public class UpdownApplication {

	public static void main(String[] args) {
		GameController gameController = new GameController();
		gameController.startGame();
	}
}
