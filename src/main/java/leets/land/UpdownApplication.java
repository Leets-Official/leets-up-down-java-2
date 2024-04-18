package leets.land;

import java.io.*;
import java.util.Random;

public class UpdownApplication {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int tryCnt = 0;
	static int numMin = 1; static int numMax = 100; static int numAnswer = 0;
	static char charMin = 'A'; static char charMax = 'z'; static char charAnswer;

	public static void main(String[] args) throws Exception {

		//게임 시작 & 버전 입력 받기
		System.out.println("업다운 게임을 시작합니다.\n");
		System.out.print("버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2) : ");
		Integer version = Integer.parseInt(br.readLine());
		if(version == 1){
			//숫자 버전
			updownNumber();
		}
		else if(version == 2){
			//영어 버전
			updownEnglish();
		}
		else{
			throw new IllegalArgumentException("[ERROR] 존재하지 않는 버전입니다.");
		}

	}

	private static void updownNumber() throws IOException {
		// 랜덤 정답 생성
		Random random = new Random();
		numAnswer = random.nextInt(numMax - numMin + 1) + numMin;

		//정답 맞출때까지 게임 진행
		boolean isCorrect = false;
		while(!isCorrect){
			tryCnt += 1;
			int userInput = getUserInputNum();

			if(userInput == numAnswer){
				System.out.println("정답!");
				System.out.println("\n시도한 횟수 : "+tryCnt+"회");
				isCorrect = true;
			}
			else{
				checkRangeNum(userInput);
			}
		}
	}

	//입력 조건을 확인면서 입력 받기
	private static int getUserInputNum() throws IOException{
		int userInput = 0;
		boolean isValidInput = false;

		while(!isValidInput){
			try{
         		System.out.print("숫자를 입력해주세요(" + numMin + " ~ " + numMax + ") : ");
         		userInput = Integer.parseInt(br.readLine());

				 if(IsRightValueNum(userInput)){
					isValidInput = true;
				 } 
				 else{
					 tryCnt += 1;
					System.out.println("[ERROR] 범위 내의 숫자를 입력하세요.");
				 }
      		}
			catch (NumberFormatException e){
				tryCnt += 1;
				System.out.println("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
			}

        }
		
		return userInput;
	}

	//값이 범위 내에 있는지 확인
	private static boolean IsRightValueNum(int value) {
		if (numMin <= value && value <= numMax){
			return true;
		}
		return false;
	}

	//사용자의 입력값을 판단하여 up or down 출력
	private static void checkRangeNum(int userInput){
		if(userInput > numAnswer){
			System.out.println("DOWN");
			numMax = userInput-1;
		}
		else if(userInput < numAnswer){
			System.out.println("UP");
			numMin = userInput+1;
		}
	}

	private static void updownEnglish() throws IOException {
		// 랜덤 정답 생성
		Random random = new Random();
		if (random.nextBoolean()) {
			charAnswer = (char) (random.nextInt(26) + 'A'); // 대문자 A-Z
		} else {
			charAnswer = (char) (random.nextInt(26) + 'a'); // 소문자 a-z
		}

		//정답 맞출때까지 게임 진행
		boolean isCorrect = false;
		while(!isCorrect){
			tryCnt += 1;
			char userInput = (char) getUserInputChar();

			if(userInput == charAnswer){
				System.out.println("정답!");
				System.out.println("\n시도한 횟수 : "+tryCnt+"회");
				isCorrect = true;
			}
			else{
				checkRangeChar(userInput);
			}
		}
	}

	private static int getUserInputChar() throws IOException{
		char userInput = 0;
		boolean isValidInput = false;

		while(!isValidInput){
			System.out.print("알파벳을 입력해주세요 (" + charMin + " ~ " + charMax + ") : ");
			String input = br.readLine();
			if(input.length() == 1){
				userInput = input.charAt(0);
				if (userInput < 'A' || (userInput > 'z') || (userInput > 'Z' && userInput < 'a')) {
					tryCnt += 1;
					System.out.println("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
				}
				else{
					if(IsRightValueChar(userInput)){
						isValidInput = true;
					}
					else{
						tryCnt += 1;
						System.out.println("[ERROR] 범위 내의 숫자를 입력하세요.");
					}
				}
			}
			else{
				tryCnt += 1;
				System.out.println("[ERROR] 한 글자만 입력하세요.");
			}

		}
		return userInput;
	}

	private static boolean IsRightValueChar(char userInput) {
		if(charMin <= userInput && userInput <= charMax){
			return true;
		}
		return false;
	}

	private static void checkRangeChar(char userInput){
		if(userInput > charAnswer){
			System.out.println("DOWN");
			charMax = (char) (userInput-1);
		}
		else if(userInput < charAnswer){
			System.out.println("UP");
			charMin = (char) (userInput+1);
		}
	}

}
