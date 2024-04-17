package leets.land.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scan = new Scanner(System.in);

    //숫자, 영어 버전 입력
    public int inputVersionNum(){

        System.out.print("게임 버전을 입력해주세요 (숫자: 1, 영어: 2): ");
        int versionNum = scan.nextInt();
        try{
            validVersionNum(versionNum);
            return versionNum;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputVersionNum();
        }
    }

    public void validVersionNum(int versionNum){
        if(versionNum!=1&&versionNum!=2){
            throw new IllegalArgumentException("버전은 1 또는 2만 입력해주세요. ");
        }
    }

    //초기 정답 입력
    public int inputNumericAnswer(){
        System.out.print("정답을 입력해주세요: ");
        int numericAnswer = scan.nextInt();
        return numericAnswer;
    }

    //입력 예외처리
}
