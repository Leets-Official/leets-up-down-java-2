package leets.land.v2.view;

import leets.land.v2.domain.Range;
import leets.land.v2.validation.exception.InvalidInputException;
import leets.land.v2.validation.validator.GuessValidator;
import leets.land.v2.validation.validator.VersionValidator;

import java.util.Scanner;

import static leets.land.v2.domain.Version.*;

public class InputView {

    private final Scanner sc = new Scanner(System.in);
    private final VersionValidator versionValidator = new VersionValidator();
    private final GuessValidator guessValidator = new GuessValidator();

    // 사용자로부터 버전 입력받는 메서드
    public int readVersion() {
        try {
            System.out.println("버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2) : ");

            String version = sc.nextLine();     // 입력

            versionValidator.validate(version); // 검증

            return Integer.parseInt(version);   // 타입 변환 후 리턴
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            return readVersion();
        }
    }

    // 사용자로부터 추측값 입력받는 메서드 - 숫자버전
    public int readNumberGuess(Range range) {
        try {
            System.out.printf("숫자를 입력해주세요(%d ~ %d) : ", range.getBottom(), range.getTop());

            String guess = sc.nextLine();   // 입력

            guessValidator.validate(NUMBER_VERSION, guess, range);  // 검증

            return Integer.parseInt(guess); // 타입 변환 후 리턴
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            return readNumberGuess(range);
        }
    }

    // 사용자로부터 추측값 입력받는 메서드 - 영어버전
    public char readEnglishGuess(Range range) {
        try {
            System.out.printf("영어를 입력해주세요(%c ~ %c) : ", range.getBottom(), range.getTop());

            String guess = sc.nextLine();

            guessValidator.validate(ENGLISH_VERSION, guess, range); // 검증

            return guess.charAt(0);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            return readEnglishGuess(range);
        }
    }
}
