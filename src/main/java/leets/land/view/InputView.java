package leets.land.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    //하나의 스캐너로 입력을 받았을 때 사소한 문제들이 발생해서 분리. [어떤 문젠지 파악하도록 하겠음]
    private final Scanner numScan = new Scanner(System.in);
    private final Scanner charScan = new Scanner(System.in);

    /*
        게임 버전 입력
     */
    public int inputVersionNum(){
        System.out.print("게임 버전을 입력해주세요 (숫자: 1, 영어: 2): ");
        try{
            int versionNum = numScan.nextInt();
            validVersionNum(versionNum);
            return versionNum;
        } catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
            return inputVersionNum();
        } catch (InputMismatchException e){
            System.out.print("[ERROR] 숫자를 입력해주세요 (숫자: 1, 영어: 2): ");
            numScan.nextLine();// 개행문제 비워주기. 안 하면 StackOverFlow 발생
            return inputVersionNum();
        }
    }

    /*
        버전 입력이 1과 2인지 검증
     */
    public void validVersionNum(int versionNum){
        if(versionNum!=1&&versionNum!=2){
            throw new IllegalArgumentException("버전은 1 또는 2만 입력해주세요. (숫자: 1, 영어: 2): ");
        }
    }

    /*
        숫자 버전 정답 입력
     */
    public int inputNum(int low, int high, int[] count){
        try{
            int inputNum = numScan.nextInt();
            count[0]++;
            checkValidNumRange(low, high, inputNum);
            return inputNum;
        } catch (IllegalArgumentException e){
            System.out.print(low + "~" + high + " 내의 숫자를 입력하세요: ");
            return inputNum(low, high, count);
        } catch (InputMismatchException e){
            System.out.print("[ERROR] 숫자를 입력하세요: ");
            numScan.nextLine();// 개행문제 비워주기. 안 하면 StackOverFlow
            return inputNum(low, high, count);
        }
    }

    /*
        입력 범위를 벗어난 입력이 들어오면 예외 날리기
     */
    public void checkValidNumRange(int low, int high, int inputNum){
        if((inputNum<low)||(inputNum>high)){
            throw new IllegalArgumentException("[ERROR] 범위 내의 숫자를 입력하세요 :");
        }
    }


    /*
        영어버전 입력부
     */
    public char inputChar(char first, char last, int[] count){
        try{
            char inputAlphabet = (charScan.nextLine()).charAt(0);//한글을 입력했을 때 필터링
            count[0]++;
            checkValidCharRange(first, last, inputAlphabet);
            return inputAlphabet;
        } catch (IllegalArgumentException e){
            System.out.print(first + "~" + last + " 내의 알파벳을 입력하세요: ");
            return inputChar(first, last, count);
        } catch (InputMismatchException e){
            System.out.print("[ERROR] 영어 알파벳을 입력하세요 : ");
            charScan.nextLine();// 개행문제 비워주기. 안 하면 StackOverFlow
            return inputChar(first, last, count);
        }
    }

    /*
     입력 범위를 벗어난 입력이 들어오면 예외 날리기
     */
    public void checkValidCharRange(char first, char last, char inputAlphabet) {
        if ((inputAlphabet < first) || (inputAlphabet > last)) {
            throw new IllegalArgumentException("[ERROR] 범위 내의 알파벳을 입력하세요 : ");
        }
    }
}
