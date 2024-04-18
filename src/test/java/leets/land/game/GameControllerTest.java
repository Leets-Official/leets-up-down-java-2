package leets.land.game;

import leets.land.controller.AlphabetGameController;
import leets.land.controller.GameController;
import leets.land.controller.NumgameController;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameControllerTest {



    @Test
    void 난수_범위_확인(){
        GameController gameController = new NumgameController();
        assertThat(gameController.generateRandomVal()).isBetween(1, 100);
    }

    @Test
    void 랜덤_알파벳_범위_확인() {
        GameController gameController = new AlphabetGameController();
        int randomValue = gameController.generateRandomVal();
        assertThat(randomValue)
                .satisfiesAnyOf(
                        value -> assertThat(value).isBetween(65, 90),
                        value -> assertThat(value).isBetween(97, 122)
                );
    }
}