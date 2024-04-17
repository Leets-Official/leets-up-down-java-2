package leets.land.game;

import leets.land.view.InputView;

public class Numgame implements Game {
    private final InputView inputView = new InputView();

    @Override
    public int generateRandomVal() {
        int randomNum = (int) (Math.random() * 100) + 1;
        return randomNum;
    }

    @Override
    public int updownGameStart(int targetNum) {
        int low = 1;
        int high = 100;
        int[] count = {0};
        boolean isCorrect = false;
        int inputNum;

        while(!isCorrect){
            System.out.print("정답을 입력하세요(" + low + "~" + high + ") : ");
            inputNum = inputView.inputNum(low, high, count);

            if(inputNum == targetNum){
                System.out.println("정답입니다!");
                isCorrect = true;
            } else if (inputNum<targetNum) {
                low = inputNum;
                System.out.println("UP");
            } else {
                high = inputNum;
                System.out.println("DOWN");
            }
        }
        return count[0];
    }
}
