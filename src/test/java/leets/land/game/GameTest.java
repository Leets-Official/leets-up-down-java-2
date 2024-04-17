package leets.land.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class GameTest {



    @Test
    void 난수_범위_확인(){
        Game game = new Numgame();
        assertThat(game.generateRandomVal()).isBetween(1, 100);
    }

    @Test
    void 랜덤_알파벳_범위_확인() {
        Game game = new AlphabetGame();
        int randomValue = game.generateRandomVal();
        assertThat(randomValue)
                .satisfiesAnyOf(
                        value -> assertThat(value).isBetween(65, 90),
                        value -> assertThat(value).isBetween(97, 122)
                );
    }
}