package leets.land;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AlphabetGame {
    private final Scanner scanner = new Scanner(System.in);
    private char min = 'A';
    private char max = 'z';

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

        while (true) {
            System.out.println("영어를 입력해주세요 (" + min + " ~ " + max + ") : ");
            char userAlphabet = UserInput();

            if (compare(answer, userAlphabet)) {
                System.out.println("정답!");
                break;
            } else {
                tryNum++;
            }
        }

        System.out.println("시도한 횟수 : " + tryNum + "회");
    }
    private char UserInput() {
        char userAlphabet;
        while (true) {
            try {
                userAlphabet = scanner.next().charAt(0);
                if (!Character.isLetter(userAlphabet)) {
                    throw new Exception("[ERROR] 문자를 입력하세요.");
                }
                if (userAlphabet < min || userAlphabet > max) {
                    throw new Exception("[ERROR] 범위 내의 문자를 입력하세요.");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("영어를 입력해주세요 (" + min + " ~ " + max + ") : ");
                scanner.nextLine();
            }
        }
        return userAlphabet;
    }
    private boolean compare(char answer, char userAlphabet) {
        if (answer > userAlphabet) {
            System.out.println("UP");
            min = (char) (userAlphabet + 1);
        } else if (answer < userAlphabet) {
            System.out.println("DOWN");
            max = (char) (userAlphabet - 1);
        } else {
            return true;
        }
        return false;
    }
}
