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
        int versionNum = inputView.inputVersionNum(); //게임 버전 입력

        int count = 0;
        if(versionNum == 1){

            int randomNum = generateRandomNum();
            count = numUpdownGame(randomNum);

        } else if (versionNum == 2) {

            char randomAlphabet = generateRandomAlphabet();
            count = alphabetUpdownGame(randomAlphabet);

        }
        outputView.printCount(count);
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
        int[] count = {0}; //잘못된 입력도 증가하기 위해 배열로 선언해 참조하도록 구현
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



    /*
        영어 버전 updown game
     */
    public char generateRandomAlphabet() {
        int randomNum = (int) (Math.random() * 52);

        if (randomNum < 26) {
            return (char) ('a' + randomNum);
        }
        else {
            return (char) ('A' + randomNum - 26);
        }

    }

    public int alphabetUpdownGame(char targetAlphabet){
        char first = 'A';
        char last = 'z';
        int[] count = {0}; //잘못된 입력도 증가하기 위해 배열로 선언해 참조하도록 구현
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

