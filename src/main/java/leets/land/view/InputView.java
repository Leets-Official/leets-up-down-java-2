package leets.land.view;

import java.util.Scanner;

public class InputView {

    private static final String GUESS_NUMBER_FORMAT = "숫자를 입력해주세요(%d ~ %d)";

    private final Scanner scanner = new Scanner(System.in);

    public int readFirstGuessNumber() {
        return readGuessNumberInRange(1, 100);
    }

    public int readGuessNumberInRange(int start, int end) {
        System.out.println(String.format(GUESS_NUMBER_FORMAT, start, end));
        return scanner.nextInt();
    }
}
