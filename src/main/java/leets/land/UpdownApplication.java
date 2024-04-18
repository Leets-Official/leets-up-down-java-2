package leets.land;

import java.io.*;
import java.util.Random;

public class UpdownApplication {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		//게임 시작 & 버전 입력 받기
		System.out.println("업다운 게임을 시작합니다.\n");
		System.out.print("버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2) : ");
		Integer version = Integer.parseInt(br.readLine());
		if(version == 1){
			//숫자 버전
			UpdownNumber();
		}
		else if(version == 2){
			//영어 버전
			//UpdownEnglish();
		}
		else{
			throw new Exception("[ERROR] 존재하지 않는 버전입니다.");
		}

	}

	private static void UpdownNumber() throws IOException {

		int min = 1;
		int max = 100;

		// 랜덤 정답 생성
		Random random = new Random();
		int answer = random.nextInt(max - min + 1) + min;

		boolean isCorrect = false;
		int tryCnt = 0;
		while(!isCorrect){
			int userInput = getUserInput(min, max);

			if(userInput == answer){
				System.out.println("정답!");
				System.out.println("\n시도한 횟수 : "+tryCnt+"회");
				isCorrect = true;
			}
			else{
				checkRange(userInput);
			}
		}

	}

	//입력 조건을 확인면서 입력 받기
	private static int getUserInput(int min, int max) {
		return 0;
	}

	//사용자의 입력값을 판단하여 up or down 출력
	private static void checkRange(int userInput){

	}



}
