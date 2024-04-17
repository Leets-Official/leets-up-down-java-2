package leets.land.game;

import leets.land.view.InputView;

public class AlphabetGame implements Game {

    private final InputView inputView = new InputView();

    @Override
    public int generateRandomVal() {
        int randomNum = (int) (Math.random() * 52);

        if (randomNum < 26) {
            return (char) ('a' + randomNum);
        }
        else {
            return (char) ('A' + randomNum - 26);
        }
    }

    @Override
    public int updownGameStart(int targetAlphabet) {
        char first = 'A';
        char last = 'z';
        int[] count = {0};
        boolean isCorrect = false;
        char inputAlphabet;

        while(!isCorrect){
            System.out.print("정답을 입력하세요(" + first + "~" + last + ") : ");
            inputAlphabet = inputView.inputChar(first, last, count);

            if(inputAlphabet == targetAlphabet){
                System.out.println("정답입니다!");
                isCorrect = true;
            } else if (inputAlphabet<targetAlphabet) {
                first = inputAlphabet;
                System.out.println("UP");
            } else {
                last = inputAlphabet;
                System.out.println("DOWN");
            }
        }
        return count[0];
    }

}
