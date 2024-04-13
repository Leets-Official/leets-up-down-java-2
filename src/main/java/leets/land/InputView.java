package leets.land;

import java.util.Scanner;

public class InputView {
    private final Scanner sc = new Scanner(System.in);

    public int versionInput() {
        System.out.print("버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2) : ");
        String version = sc.next();
        return validateNumberType(version);
    }

    public int readNumber() {
        System.out.println("숫자를 입력해주세요(1 ~ 100) : ");
        String number = sc.next();
        return validateNumberType(number);
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
