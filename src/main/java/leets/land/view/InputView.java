package leets.land.view;

import leets.land.domain.CharRange;
import leets.land.domain.Range;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int getVersionInput() {
        System.out.print("버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2) : ");
        try {
            int version = scanner.nextInt();
            validateVersion(version);
            return version;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getVersionInput();
        } catch (InputMismatchException e) {
            System.out.println("[ERROR] 버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2) : ");
            scanner.nextLine();
            return getVersionInput();
        }
    }

    public void validateVersion(int version) {
        if (version != 1 && version != 2) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 버전입니다.");
        }
    }

    public int getNumberInput(Range range) {
        System.out.printf("숫자를 입력해주세요(%d ~ %d) : ",range.getMin(),range.getMax());
        try {
            int number = scanner.nextInt();
            validateNumberRange(range, number);
            return number;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getNumberInput(range);
        } catch (InputMismatchException e) {
            System.out.println("[ERROR] 숫자를 입력해주세요 ");
            scanner.nextLine();
            return getNumberInput(range);
        }
    }

    public void validateNumberRange(Range range, int number) {
        if (!range.isInRange(number)) {
            throw new IllegalArgumentException("[ERROR] 범위 내의 숫자를 입력하세요. ");
        }
    }

    public char getCharInput(CharRange range) {
        System.out.printf("영어를 입력해주세요(%c ~ %c) : ",range.getMin(),range.getMax());
        String input = scanner.next();
        try {
            validCharLength(input);
            char character = input.charAt(0);
            validateCharRange(range, character);
            return character;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCharInput(range);
        } catch (InputMismatchException e) {
            System.out.println("입력 문자의 타입이 맞지 않습니다. ");
            scanner.nextLine();
            return getCharInput(range);
        }
    }
    public void validateCharRange(CharRange range, char character) {
        if (!range.isInRange(character)) {
            throw new IllegalArgumentException("[ERROR] 범위 내의 알파벳을 입력하세요. ");
        }
    }
    public void validCharLength(String s) {
        if (s.length() >= 2) {
            throw new IllegalArgumentException("[ERROR] 알파벳 한 글자만 입력해주세요 ");
        }
    }

}
