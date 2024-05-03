package leets.land;
import java.util.Scanner;

public class UpdownApplication {
    public static void main(String[] args) {
        try {
            int version = selectVersion();
            if (version == 1) {
                NumberGame numberGame = new NumberGame();
                numberGame.run();
            } else if (version == 2) {
                AlphabetGame alphabetGame = new AlphabetGame();
                alphabetGame.run();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static int selectVersion() throws Exception {
        int version;

        while (true) {
            version = readVersion();
            if (isValidVersion(version)) {
                break;
            }
        }
        return version;
    }
    private static int readVersion() {
        Scanner sc = new Scanner(System.in);
        System.out.print("버전을 선택하세요 (1 또는 2): ");
        while (!sc.hasNextInt()) {
            System.out.println("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
            System.out.print("버전을 선택하세요 (1 또는 2): ");
            sc.next();
        }
        int version = sc.nextInt();
        return version;
    }
    private static boolean isValidVersion(int version) throws Exception {
        if (version != 1 && version != 2) {
            throw new Exception("[ERROR] 존재하지 않는 버전입니다.");
        }
        return true;
    }
}
