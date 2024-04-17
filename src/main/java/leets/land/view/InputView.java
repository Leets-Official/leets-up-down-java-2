package leets.land.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private final Scanner scan = new Scanner(System.in);

    //숫자, 영어 버전 입력. 예외처리
    public int inputVersionNum(){
        System.out.print("게임 버전을 입력해주세요 (숫자: 1, 영어: 2): ");
        try{
            int versionNum = scan.nextInt();
            validVersionNum(versionNum);
            return versionNum;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputVersionNum();
        } catch (InputMismatchException e){
            System.out.println("숫자를 입력해주세요");
            scan.nextLine();// 개행문제 비워주기. 안 하면 StackOverFlow
            return inputVersionNum();
        }
    }



    public void validVersionNum(int versionNum){
        if(versionNum!=1&&versionNum!=2){
            throw new IllegalArgumentException("버전은 1 또는 2만 입력해주세요. ");
        }
    }

}
