package leets.land.domain;

import leets.land.controller.AlphabetGameMachine;
import leets.land.controller.GameMachine;
import leets.land.controller.NumberGameMachine;

import java.util.Arrays;

public enum GameVersion {

    NUMBER(1, new NumberGameMachine()),
    ALPHABET(2, new AlphabetGameMachine());

    private final int version;
    private final GameMachine gameMachine;

    GameVersion(int version, GameMachine gameMachine) {
        this.version = version;
        this.gameMachine = gameMachine;
    }

    public static GameVersion match(int version) {
        return Arrays.stream(values())
                .filter(gameVersion -> gameVersion.version == version)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 버전입니다."));
    }

    public void start() {
        gameMachine.run();
    }
}
