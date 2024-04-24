package leets.land.controller;

import leets.land.domain.Version;
import leets.land.view.InputView;

public class GameLoader {
    final InputView inputView = new InputView();

    public void load() {
        Version version = inputVersion();
        version.run();
    }

    private Version inputVersion() {
        int gameVersion = inputView.inputVersion();
        return Version.versionValidator(gameVersion);
    }
}