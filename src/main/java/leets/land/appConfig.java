package leets.land;

import leets.land.controller.MatchController;
import leets.land.controller.AlphabetGameController;
import leets.land.controller.NumgameController;

//자바 코드로 의존성 주입을 하기 위한 클래스
public class appConfig {

    // 버전에 맞는 Game 객체를 컨트롤러로 주입
    public static MatchController gameController(int versionNum){
        if(versionNum==1) {
            return new MatchController(new NumgameController());
        } else {
            return new MatchController(new AlphabetGameController());
        }
    }
}
