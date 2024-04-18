package leets.land.controller;

import leets.land.model.AlphabetComputer;
import leets.land.model.NumberComputer;
import leets.land.view.InputView;
import leets.land.view.OutputView;

public class Controller {
    private final static AlphabetComputer alphabetComputer = new AlphabetComputer();
    private final static NumberComputer numberComputer = new NumberComputer();
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();

    public void play(){
        outputView.printStart();
        int version = inputView.getVersion();

        if(version == 1){
            numberPlay();
        }else if( version == 2) {
            alphabetPlay();
        }else{
            outputView.printErrorMessage("존재하지 않는 버전입니다.");
            play();
        }
    }
    public void numberPlay(){
        while (true){
            int input = inputView.getNextNumberGuess(numberComputer.getMin(), numberComputer.getMax());
            if (!numberComputer.isValidInput(input)) {
                outputView.printErrorMessage("범위 내의 숫자를 입력하세요.");
                continue;
            }
            if(numberComputer.up(input)){
                numberComputer.judgeUp(input);
                outputView.printUpDownResult("UP");
            }else if(numberComputer.down(input)){
                numberComputer.judgeDown(input);
                outputView.printUpDownResult("DOWN");
            }else if(numberComputer.correct(input)){
                outputView.printUpDownResult("정답 !");
                outputView.printCount(numberComputer.getCount());
                break;
            }
        }
    }

    public void alphabetPlay(){
        while (true){
            char input = inputView.getNextAlphabetGuess(alphabetComputer.getMin(), alphabetComputer.getMax());
            if (!alphabetComputer.isValidInput(input)) {
                outputView.printErrorMessage("범위 내의 알파벳을 입력하세요.");
                continue;
            }

            if(alphabetComputer.up(input)){
                alphabetComputer.judgeUp(input);
                outputView.printUpDownResult("UP");
            } else if(alphabetComputer.down(input)){
                alphabetComputer.judgeDown(input);
                outputView.printUpDownResult("DOWN");
            } else if(alphabetComputer.correct(input)){
                outputView.printUpDownResult("정답 !");
                outputView.printCount(alphabetComputer.getCount());
                break;
            }
        }

    }
}
