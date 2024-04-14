package leets.land.view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final String VERSION_FORMAT = "버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2) : ";
    private static final String GUESS_NUMBER_FORMAT = "숫자를 입력해주세요(%d ~ %d) : ";
    private static final String GUESS_ALPHABET_FORMAT = "영어를 입력해주세요(%c ~ %c) : ";
    private static final Pattern ALPHABET_FORMAT = Pattern.compile("[A-Z|a-z]");
    private static final Pattern VERSION = Pattern.compile("[1|2]");

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
        String input = scanner.nextLine();
        if (!ALPHABET_FORMAT.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 범위 내의 알파벳을 입력하세요.");
        }
        return input.charAt(0);
    }

    public int readGameVersion() {
        System.out.print(VERSION_FORMAT);
        String version = scanner.nextLine();
        if (!VERSION.matcher(version).matches()) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 버전입니다.");
        }
        return Integer.parseInt(version);
    }
}
