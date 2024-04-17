package leets.land;

import leets.land.controller.GameController;
import leets.land.game.AlphabetGame;
import leets.land.game.Numgame;

//자바 코드로 의존성 주입을 하기 위한 클래스
public class appConfig {

    // 버전에 맞는 Game 객체를 컨트롤러로 주입
    public static GameController gameController(int versionNum){
        if(versionNum==1) {
            return new GameController(new Numgame());
        } else {
            return new GameController(new AlphabetGame());
        }
    }
}
