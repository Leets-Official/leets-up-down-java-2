package leets.land.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(){
        scanner = new Scanner(System.in);
    }
    public int getVersion(){
        System.out.print("버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2) :");
        return scanner.nextInt();
    }

    public int getNumberFirstInput(){
        System.out.print("숫자를 입력해주세요(1 ~ 100) : ");
        return scanner.nextInt();
    }

    public char getAlphabetFirstInput(){
        System.out.print("영어를 입력해주세요(A ~ z) : ");
        return scanner.next().charAt(0);
    }

    public int getNextNumberGuess(int min, int max){
        System.out.printf("숫자를 입력해주세요(%d ~ %d) : ",min ,max);
        return scanner.nextInt();
    }
    public int getNextAlphabetGuess(char min, char max){
        System.out.printf("영어를 입력해주세요(%c ~ %c) : ",min ,max);
        return scanner.next().charAt(0);
    }
}
