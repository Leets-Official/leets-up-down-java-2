package leets.land;

import leets.land.controller.AlphabetGameMachine;

public class UpdownApplication {

    public static void main(String[] args) {
//        GameMachine gameMachine = new GameMachine();
        AlphabetGameMachine gameMachine = new AlphabetGameMachine();
        gameMachine.run();
    }
}
