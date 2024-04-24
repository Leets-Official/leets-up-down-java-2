package leets.land.domain;

import leets.land.controller.AlphabetGame;
import leets.land.controller.Game;
import leets.land.controller.NumberGame;

public enum Version {

    NUMBER(1, new NumberGame()),
    ALPHABET(2, new AlphabetGame());

    private final int version;
    private final Game game;

    Version(int version, Game game) {
        this.version = version;
        this.game = game;
    }

   public static Version versionValidator(int version) {
        for (Version gameVersion : Version.values()) {
            if (gameVersion.version == version) {
                return gameVersion;
            }
        }
        throw new IllegalArgumentException("[ERROR] 존재하지 않는 버전입니다.");
    }

    public void run() {
        game.run();
    }
}