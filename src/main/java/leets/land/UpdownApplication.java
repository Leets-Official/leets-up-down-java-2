package leets.land;

import leets.land.controller.MainController;

import java.io.IOException;

public class UpdownApplication {

	public static void main(String[] args) throws IOException {
		final MainController mainController = new MainController();
		mainController.run();
	}
}
