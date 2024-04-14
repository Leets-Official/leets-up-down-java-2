package leets.land.view;

import java.util.Scanner;

public class InputView {

    private static final String GUESS_NUMBER_FORMAT = "숫자를 입력해주세요(%d ~ %d) : ";
    private static final String GUESS_ALPHABET_FORMAT = "영어를 입력해주세요(%c ~ %c) : ";

    private final Scanner scanner = new Scanner(System.in);

    public int readGuessNumberInRange(int start, int end) {
        System.out.print(String.format(GUESS_NUMBER_FORMAT, start, end));
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
            return readGuessNumberInRange(start, end);
        }
    }

    public int readGuessAlphabetInRange(int start, int end) {
        System.out.print(String.format(GUESS_ALPHABET_FORMAT, start, end));
        try {
            return scanner.nextLine().charAt(0);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
            return readGuessNumberInRange(start, end);
        }
    }
}
