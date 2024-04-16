package leets.land;

import java.util.Random;
import java.util.Scanner;

public class UpdownApplication {
	Random random = new Random();
	Scanner scan = new Scanner(System.in);
	//실행부
	public void run() {
		//버전 입력
		int version = scan.nextInt();
		//정답 입력

		//정답 출력
	}

	//무작위 수 반환
	public int generateRandomNum(){
		int randomNum = (random.nextInt(100)+1);
		return randomNum;
	}

	//무작위 알파벳 반환
	public char generateRandomChar() {
		if(random.nextBoolean()){
			return (char) (random.nextInt(26) + 65);
		}
		else{
			return (char) (random.nextInt(26) + 97);
		}
	}


	public static void main(String[] args)  {
		UpdownApplication app = new UpdownApplication();
		app.run();
	}
}




