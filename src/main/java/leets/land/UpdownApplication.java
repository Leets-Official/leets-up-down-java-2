package leets.land;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class UpdownApplication {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		// 입력: 숫자 또는 영어
		// 사용자가 입력하는 숫자, 영어등을 계속 입력
		// 정답을 맞추게 되면 정답! 메시지를 출력하고 시도한 횟수도 출력
		int ver = 0; // 버전 저장

		bw.write("업다운 게임을 시작합니다.\n\n");

		bw.write("버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2) : ");
		ver = br.read();

		//숫자 게임 진행
		if(ver == 1){

			bw.write("숫자를 입력해주세요(1 ~ 100) : ");
			int num = br.read();

			// 초기에 입력한 숫자값과 랜덤 숫자값을 넣어줌.
			numGame(num, randNum(), 1);

		} else if(ver == 2){	//영어게임 진행

			bw.write("영어를 입력해주세요(A ~ z) : ");
			char c = (char)br.read();

			// 초기에 입력한 단어값과 랜덤 단어값을 넣어줌.
			engGame(ChartoASCII(c), randChar(), 1);

		} else throw new IllegalArgumentException("[ERROR] 존재하지 않는 버전입니다.");



		/* error

		[ERROR] 범위 내의 숫자를 입력하세요.
		[ERROR] 범위 내의 알파벳을 입력하세요.
		[ERROR] 입력 문자의 타입이 맞지 않습니다.
		*/

		br.close();
		bw.flush();
		bw.close();
	}

	public static int numGame(int num, int target, int cnt) {
		
		// 시도한 횟수
		return 0;
	}

	public static int engGame(int c, int target, int cnt){

		// 시도한 횟수
		return 0;
	}

	// 난수 생성
	public static int randNum(){
		return ((int) (Math.random()*100));
	}

	// 랜덤 영어문자 생성
	public static int randChar(){
		return ((int)(Math.random()*52)+65);
	}

	// 아스키코드값을 단어로 바꿔주는 코드
	public static char ASCIItoChar(int c){
		return (char) c;
	}

	// 단어를 아스키 코드값으로 바꿔주는 코드
	public static char ChartoASCII(int c){
		return (char) c;
	}
}
