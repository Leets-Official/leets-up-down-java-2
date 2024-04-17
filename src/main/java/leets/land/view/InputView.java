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



    //사용자에게 입력을 받으며 예외처리
    public int inputNum(int low, int high, int[] count){
        try{
            int inputNum = scan.nextInt();
            count[0]++;
            checkValidNumRange(low, high, inputNum);
            return inputNum;
        } catch (IllegalArgumentException e){
            System.out.print(low + "~" + high + " 내의 숫자를 입력하세요: ");
            return inputNum(low, high, count);
        } catch (InputMismatchException e){
            System.out.print("숫자를 입력하세요");
            scan.nextLine();// 개행문제 비워주기. 안 하면 StackOverFlow
            return inputNum(low, high, count);
        }
    }

    //입력 범위를 벗어난 입력이 들어오면 예외 날리기
    public void checkValidNumRange(int low, int high, int inputNum){
        if((inputNum<low)||(inputNum>high)){
            throw new IllegalArgumentException("[ERROR] 범위 내의 숫자를 입력하세요.");
        }
    }

    /*
        영어버전 입력부
     */


    public char inputChar(char first, char last, int[] count){
        Scanner scanner = new Scanner(System.in);//inputNum이랑 scanner를 공유하다보니 문제가 발생.
        try{
            char inputAlphabet = (scanner.nextLine()).charAt(0);
            count[0]++;
            checkValidCharRange(first, last, inputAlphabet);
            return inputAlphabet;
        } catch (IllegalArgumentException e){
            System.out.print(first + "~" + last + " 내의 알파벳을 입력하세요: ");
            return inputChar(first, last, count);
        } catch (InputMismatchException e){
            System.out.print("영어 알파벳을 입력하세요");
            scan.nextLine();// 개행문제 비워주기. 안 하면 StackOverFlow
            return inputChar(first, last, count);
        }
    }

    //입력 범위를 벗어난 입력이 들어오면 예외 날리기
    public void checkValidCharRange(char first, char last, char inputAlphabet) {
        if ((inputAlphabet < first) || (inputAlphabet > last)) {
            throw new IllegalArgumentException("[ERROR] 범위 내의 알파벳을 입력하세요.");
        }
    }

}
