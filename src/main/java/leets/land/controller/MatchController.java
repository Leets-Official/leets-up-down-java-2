package leets.land.controller;

import leets.land.service.CharGameService;
import leets.land.service.GameService;
import leets.land.service.NumgameService;
import leets.land.view.InputView;
import leets.land.view.OutputView;

import java.lang.reflect.GenericArrayType;

public class MatchController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();




    //버전을 입력 받아 서비스에 전달

    //서비스에서 돌린 중간 결과를 전달받아 outputview로 출력
    public void runApp(){
        int versionNum = inputView.inputVersionNum();

        if(versionNum == 1){

        } else if (versionNum == 2) {

        }

    }




}
