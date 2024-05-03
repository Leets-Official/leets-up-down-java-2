package leets.land;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberGame {
    private final Scanner scanner = new Scanner(System.in);

    public int getRandomNumber() {
        return (int) (Math.random() * 100) + 1;
    }
    public void run() throws Exception {
        int answer = getRandomNumber();
        int tryNum = 0;
        int min = 1;
        int max = 100;

        while (true) {
            System.out.println("숫자를 입력해주세요 (" + min + " ~ " + max + ") : ");
            int userNumber;
            try {
                userNumber = scanner.nextInt();
                if (userNumber < min || userNumber > max) {
                    throw new InputMismatchException("[ERROR] 범위 내의 숫자를 입력하세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
                scanner.next();
                continue;
            }

            if (answer > userNumber) {
                System.out.println("UP");
                min = userNumber + 1;
            } else if (answer < userNumber) {
                System.out.println("DOWN");
                max = userNumber - 1;
            } else {
                System.out.println("정답!");
                break;
            }
            tryNum++;
        }

        System.out.println("시도한 횟수 : " + tryNum + "회");
    }
}
