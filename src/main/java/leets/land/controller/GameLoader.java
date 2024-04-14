package leets.land.controller;

import leets.land.domain.GameVersion;
import leets.land.view.InputView;

public class GameLoader {

    private final InputView inputView = new InputView();

    public void load() {
        GameVersion gameVersion = readGameVersion();
        gameVersion.start();
    }

    private GameVersion readGameVersion() {
        int gameVersion = inputView.readGameVersion();
        return GameVersion.match(gameVersion);
    }
}
