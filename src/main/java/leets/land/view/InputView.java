package leets.land.view;

import leets.land.Range;

import java.util.Scanner;

public class InputView {
    private final Scanner sc = new Scanner(System.in);
    public int versionInput() {
        System.out.print("버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2) : ");
        String version = sc.next();
        return validateNumberType(version);
    }

    public int readNumber(int min, int max) {
        System.out.printf("숫자를 입력해주세요(%d ~ %d) : ", min, max);
        String number = sc.next();
        return checkNumberRange(checkNumberType(number), min, max);
    }

    public int checkNumberRange(int number, int min, int max) {
        if (number < min || number > max) {
            System.out.println("[ERROR] 범위 내의 숫자를 입력하세요. ");
            return readNumber(min, max);
        } else {
            return number;
        }
    }

    public int checkNumberRange(int number, Range range) {
        if (number < range.getMin() || number > range.getMax()) {
            System.out.println("[ERROR] 범위 내의 숫자를 입력하세요. ");
            return readNumber(range);
        } else {
            return number;
        }
    }

    public int checkNumberType(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
            return readNumber(1, 100);
        }
    }

    public int readNumber(Range range) {
        System.out.printf("숫자를 입력해주세요(%d ~ %d) : ", range.getMin(), range.getMax());
        String number = sc.next();
        return checkNumberRange(checkNumberType(number, range), range);
    }

    public int checkNumberType(String number, Range range) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
            return readNumber(range);
        }
    }

    public char readAlpha() {
        System.out.print("영어를 입력해주세요(A ~ z) : ");
        String alpha = sc.next();
        return validateAlpha(alpha);
    }

    public char readAlpha(char c) {
        char start = (char)(c + 1);
        System.out.printf("영어를 입력해주세요(%c ~ Z) : ",start);
        String alpha = sc.next();
        char validAlpha = validateAlpha(alpha);
        if(validAlpha < 'A' || validAlpha > 'Z'){
            System.out.println("[ERROR]: 범위 내의 알파벳을 입력하세요.");
            return readAlpha();
        }
        return validAlpha;
    }

    public char validateAlpha(String alpha) {
        if (alpha.length() >= 2) {
            System.out.println("[ERROR] 입력 문자의 길이는 1을 넘을 수 없습니다.");
            return readAlpha();
        }
        for (char c : alpha.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                System.out.println("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
                return readAlpha();
            }
        }
        return alpha.charAt(0);
    }



    public int validateNumberType(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
            return versionInput();
        }
    }


}
