package leets.land.controller;

import leets.land.view.InputView;
import leets.land.view.OutputView;

import java.util.Scanner;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Scanner scanner = new Scanner(System.in);

    //서비스에서 돌린 중간 결과를 전달받아 outputview로 출력
    public void runApp(){
        outputView.printStartMessage();
        int versionNum = inputView.inputVersionNum();

        if(versionNum == 1){
            int randomNum = generateRandomNum();
            int count = numUpdownGame(randomNum);
            outputView.printCount(count);
        } else if (versionNum == 2) {

        }
    }


    /*
        숫자 버전 updown game
     */
    public int generateRandomNum(){
        int randomNum = (int) (Math.random() * 100) + 1;
        return randomNum;
    }

    public int numUpdownGame(int targetNum){
        int low = 1;
        int high = 100;
        int count = 0;
        boolean isCorrect = false;
        int inputNum;

        while(!isCorrect){
            System.out.print("정답을 입력하세요(" + low + "~" + high + ") : ");
            inputNum = inputNum(low, high);
            checkValidNumRange(low, high, inputNum);
            count++;

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
        return count;
    }
    public void checkValidNumRange(int low, int high, int inputNum){
        if((inputNum<low)||(inputNum>high)){
            throw new IllegalArgumentException("[ERROR] 범위 내의 숫자를 입력하세요.");
        }
    }

    public int inputNum(int low, int high){
        int inputNum;
        try{
            inputNum = scanner.nextInt();
            checkValidNumRange(low, high, inputNum);
            return inputNum;
        } catch (IllegalArgumentException e){
            return inputNum(low, high);
        }
    }

    /*
        영어 버전 updown game
     */
}
