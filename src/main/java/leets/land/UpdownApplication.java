package leets.land;
import java.util.InputMismatchException;
import java.util.Random;

import java.util.Scanner;

public class UpdownApplication {
	public int get_random_number(){
		Random r = new Random();

		return r.nextInt(100)+1;
	}
	public char get_random_alphabet(){
		Random r = new Random();
		int randomChar = r.nextInt(52); // 0부터 51까지의 난수 생성
		if (randomChar < 26) {
			// 대문자 선택
			return (char)('A' + randomChar);
		} else {
			// 소문자 선택
			return (char)('a' + randomChar - 26);
		}
	}

	public int select_version() throws Exception {
		Scanner sc = new Scanner(System.in);
		int version = 0;
		boolean valid = false;
		while (!valid) {
			try {
				System.out.println("버전을 선택하세요 (1 또는 2): ");
				String input = sc.nextLine();
				version = Integer.parseInt(input);
				if(version != 1 && version != 2) {
					throw new Exception(); // 1과 2 아닌 숫자여도 예외
				}
				valid = true; // 1또는 2 입력
			}
			catch (NumberFormatException e) {
				System.out.println("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
			}
			catch (Exception e) {
				System.out.println("[ERROR] 존재하지 않는 버전입니다.");
			}

		}

		if(version==1){
			return 1;
		}
		else if (version==2){
			return 2;
		}
		return 0;

	}

	void checkNumberValidity(int min, int max, int userInput) throws Exception {
		if(userInput<min || userInput>max){
			throw new Exception("[ERROR] 범위 내의 숫자를 입력하세요.");
		}
	}
	void run() throws Exception {
		System.out.println("버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2) : ");
		Scanner sc = new Scanner(System.in);
		int version = select_version();
		int tryNum = 0;
		if(version == 1){
			int answer = get_random_number();
			int userNumber = -1;
			int min = 1;
			int max = 100;
			while(answer != userNumber){
				System.out.println("숫자를 입력해주세요 (" +min +" ~ "+max + ") : ");
				try{
					String input = sc.nextLine();
					userNumber = Integer.parseInt(input);
				}
				catch (NumberFormatException  e){
					System.out.println("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
					continue;
				}
				try {
					checkNumberValidity(min, max, userNumber);

				}
				catch(Exception e){
					System.out.println(e.getMessage());
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
				}
				tryNum++;

			}

		}
		else if(version == 2){
			char answer = get_random_alphabet();
			char userAlphabet = ' ';
			char min = 'A';
			char max = 'z';
			while(answer != userAlphabet){
				System.out.println("영어를 입력해주세요 (" +min +" ~ "+max + ") : ");
				try{
					userAlphabet = sc.nextLine().charAt(0);
					if(!Character.isLetter(userAlphabet)) {
						throw new InputMismatchException(); // 문자가 아닌 경우 예외 발생
					}
				}
				catch (InputMismatchException e){
					System.out.println("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
					continue;
				}
				try {
					checkNumberValidity(min, max, userAlphabet);

				}
				catch(Exception e){
					System.out.println(e.getMessage());
					continue;
				}
				if(answer>userAlphabet){
					System.out.println("UP");
					min = (char)(userAlphabet+1);
					if(min == '[') {
						min = 'a';
					}
				}
				else if(answer<userAlphabet){
					System.out.println("DOWN");
					max = (char)(userAlphabet-1);
					if(max == '`') {
						max = 'Z';
					}
				}
				else{
					System.out.println("정답!");
				}
				tryNum++;
			}
		}
		System.out.println("시도한 횟수 : " + tryNum + "회");

	}



	public static void main(String[] args) throws Exception {
		UpdownApplication app = new UpdownApplication();
		app.run();
	}
}
