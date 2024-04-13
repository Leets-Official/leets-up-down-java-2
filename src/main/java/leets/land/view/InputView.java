package leets.land.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int readGuessNumber() {
        return scanner.nextInt();
    }
}
