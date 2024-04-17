package leets.land;

import leets.land.controller.GameController;
import leets.land.service.CharGameService;
import leets.land.service.GameService;
import leets.land.service.NumgameService;
import leets.land.view.InputView;
import leets.land.view.OutputView;

import java.lang.reflect.GenericArrayType;

public class appConfig {
    public static GameController gameController(int versionNum){
        if(versionNum==1) {
            return new GameController(new NumgameService());
        } else {
            return new GameController(new CharGameService());
        }
    }
}
