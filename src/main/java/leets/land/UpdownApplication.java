package leets.land;

import leets.land.controller.GameLoader;

public class UpdownApplication {
    public static void main(String[] args) {
        GameLoader gameLoader = new GameLoader();
        gameLoader.load();
    }
}