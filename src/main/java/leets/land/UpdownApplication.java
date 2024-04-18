package leets.land;

import java.util.Random;
import java.util.Scanner;

public class UpdownApplication {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("숫자 버전(1)과 영어 버전(2) 중 선택해주세요:");
		int version;
		do{
			version=scanner.nextInt();
			switch(version){
				case 1:
					numVersion(scanner);
					break;
				case 2:
					engVersion(scanner);
					break;
				default:
					System.out.println("[ERROR] 존재하지 않는 버전입니다.");
			}
		}while(version!=1&&version!=2);
		scanner.close();
	}
	public static void numVersion(Scanner x) {
		Random random = new Random();
		int answer = random.nextInt(100) + 1;
		int number;
		int tried = 0;
		int tryMin = 1;
		int tryMax = 100;
		Scanner scanner = new Scanner(System.in);
		System.out.println("1부터 100 사이의 숫자를 맞춰보세요.");
		System.out.println("숫자를 입력해주세요(1~100):");
		do {
			while (!scanner.hasNextInt()) {
				System.out.println("[ERROR] 존재하지 않는 버전입니다.");
				scanner.next(); // 버퍼에서 입력 제거
			}
			number = scanner.nextInt();
			if (number < tryMin || number > tryMax ) {
				System.out.println("[ERROR] 범위 내의 숫자를 입력하세요.");
				continue;
			}
			tried++;
			if (number < answer) {
				System.out.println("UP");
				tryMin = Math.max(tryMin, number + 1);
				System.out.println("숫자를 입력해주세요("+tryMin+"~"  +tryMax+"): " );
			} else if (number > answer) {
				System.out.println("DOWN");
				tryMax = Math.min(tryMax, number - 1);
				System.out.println("숫자를 입력해주세요("+tryMin+"~"  +tryMax+"): " );
			} else {
				System.out.println("정답!");
				System.out.println("시도한 횟수:" + tried);
			}
		} while (number != answer);
		scanner.close();
	}
	public static void engVersion(Scanner y){
		Random random=new Random();
		char answer= (char)(random.nextInt(26)+'A');
		char english;
		int tried=0;
		char tryMin='A';
		char tryMax='z';
		Scanner scanner=new Scanner(System.in);
		System.out.println("영어를 입력해주세요(A ~ z) : ");
		do{
			english=scanner.next().charAt(0);
			if ((english < 'A' || english > 'Z') && (english < 'a' || english > 'z')) {
				System.out.println("[ERROR] 범위 내의 알파벳을 입력하세요.");
				System.out.println("영어를 입력해주세요("+tryMin+ "~" +tryMax+")");
				continue;
			}
			tried++;
			if(english<answer){
				System.out.println("UP");
				tryMin=(char)Math.max(tryMin,(char)(english+1));
				System.out.println("영어를 입력해주세요("+tryMin+ "~" +tryMax+")");
			}
			else if(english>answer){
				System.out.println("DOWN");
				tryMax=(char)Math.min(tryMax,(char)(english-1));
				System.out.println("영어를 입력해주세요("+tryMin+ "~" +tryMax+")");
			}
			else{
				System.out.println("정답!");
				System.out.println("시도한 횟수:"+tried);
			}
		}while(english!=answer);
		scanner.close();
	}
}