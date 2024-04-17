package leets.land.service;

import leets.land.view.InputView;

import java.util.Scanner;

public class NumgameService implements GameService{
//    public static Scanner scan = new Scanner(System.in);
//    private final InputView inputView = new InputView();
//    public static int low = 0;
//    public static int high = 100;
//    // 난수발생
//
//    // 입력값이 들어오면 값을 확인.
//
//
//    public int generateRandomNum(){
//        int randomNum = (int) (Math.random() * 100) + 1;
//        return randomNum;
//    }
//
//    public boolean checkValidNum(int targetNum, int inputNumAnswer){
//        if(inputNumAnswer==targetNum){
//            System.out.println("정답입니다! ");
//            return true;
//        } else if (inputNumAnswer < targetNum) { // 정답 67, 입력 34
//            low = inputNumAnswer;
//            System.out.println("틀렸습니다. 정답을 다시 입력하세요( " + low + "부터 " + high + "사이 )");
//            return false;
//        }else {
//            high = inputNumAnswer;
//            System.out.println("틀렸습니다. 정답을 다시 입력하세요( " + low + "부터 " + high + "사이 )");
//            return false;
//        }
//    }//low 와 high 사이값을 입력하지 않으면 예외 날리기.
//
//    public void checkNum(int num){
//        if((low>num)||(num>high)){
//            throw new IllegalArgumentException();
//        }
//    }
//
//    public static void main(String[] args) {
//        NumgameService numgameService = new NumgameService();
//        int num = numgameService.generateRandomNum();
//        System.out.println(num);
//
//        boolean tf = false;
//        int answer;
//        System.out.print("정답을 입력해주세요(1-100사이): ");
//        try{
//            numgameService.checkNum(answer);
//            numgameService.checkValidNum(num, answer);
//        }catch (IllegalArgumentException e){
//
//        }
//    }
}
