package leets.land.view;

import java.util.*;

public class InputView {
    final String VERSION_MESSAGE = "버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2) : ";
    final String NUMBER_MESSAGE = "숫자를 입력해주세요(%d ~ %d) : ";
    final String ALPHABET_MESSAGE = "영어를 입력해주세요(%c ~ %c) : ";
    final Scanner sc = new Scanner(System.in);
    final String newline = System.lineSeparator();

    // 실행할 버전을 입력받는 함수입니다.
    public int inputVersion() {
        System.out.print(VERSION_MESSAGE);
        try{
            return sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
            sc.nextLine();
            return inputVersion();
        }
    }

    // 범위 내 숫자를 입력 받는 함수입니다.
    public int inputNumberInRange(int startNumber, int endNumber) {
        System.out.print(String.format(NUMBER_MESSAGE, startNumber, endNumber));
        int number;

        try {
            number = sc.nextInt();
            sc.nextLine();
            return number;
        } catch (InputMismatchException e) {
            System.out.println("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
            sc.nextLine();
            return inputNumberInRange(startNumber, endNumber);
        }
    }

    // 범위 내 영어를 입력 받는 함수입니다.
    public char inputAlphabetInRange(char startAlphabet, char endAlphabet) {
        System.out.print(String.format(ALPHABET_MESSAGE, startAlphabet, endAlphabet));
        String alphabet = sc.nextLine();

        if(alphabet.length() != 1) {
            System.out.println("[ERROR] 한 글자만 입력해주세요.");
            return inputAlphabetInRange(startAlphabet, endAlphabet);
        }

        if(!alphabet.matches("[a-zA-Z]")) {
            System.out.println("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
            return inputAlphabetInRange(startAlphabet, endAlphabet);
        }

        return alphabet.charAt(0);
    }
}