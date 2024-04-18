package leets.land.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int promptForGameType() {
        System.out.print("버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2) : ");
        return scanner.nextInt();
    }

    public String promptForGuess() {
        return scanner.next();
    }
}
