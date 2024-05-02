package leets.land;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AlphabetGame {
    private final Scanner scanner = new Scanner(System.in);

    public char getRandomAlphabet() {
        int randomChar = (int) (Math.random() * 52); // 0부터 51까지의 난수 생성
        if (randomChar < 26) {
            // 대문자 선택
            return (char) ('A' + randomChar);
        } else {
            // 소문자 선택
            return (char) ('a' + randomChar - 26);
        }
    }

    public void run() throws Exception {
        char answer = getRandomAlphabet();
        int tryNum = 1;
        char min = 'A';
        char max = 'z';

        while (true) {
            System.out.println("영어를 입력해주세요 (" + min + " ~ " + max + ") : ");
            char userAlphabet;
            try {
                userAlphabet = scanner.next().charAt(0);
                if (!Character.isLetter(userAlphabet)) {
                    throw new InputMismatchException("[ERROR] 문자를 입력하세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
                scanner.next(); // 잘못된 입력값 버퍼에서 제거
                continue;
            }

            if (answer > userAlphabet) {
                System.out.println("UP");
                min = (char) (userAlphabet + 1);
            } else if (answer < userAlphabet) {
                System.out.println("DOWN");
                max = (char) (userAlphabet - 1);
            } else {
                System.out.println("정답!");
                break;
            }
            tryNum++;
        }

        System.out.println("시도한 횟수 : " + tryNum + "회");
    }
}
