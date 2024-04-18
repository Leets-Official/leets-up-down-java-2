package leets.land;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

public class UpdownApplication {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 난수
	public static int randNum = (int)(Math.random()*100);

	// 랜덤 단어
	public static int randChar = (int)(Math.random()*52)+65;

	public static void main(String[] args) throws Exception {
		int ver = 0; // 버전 저장
		int cnt = 1; // 시도횟수 저장

		bw.write("업다운 게임을 시작합니다.\n\n");

		bw.write("버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2) : ");
		ver = br.read();

		//숫자 게임 진행
		if(ver == 1){

			bw.write("숫자를 입력해주세요(1 ~ 100) : ");
			int num = br.read();

			if (Pattern.matches("^(?:[1-9][0-9]?|100)$", String.valueOf(num))) {
				// 초기에 입력한 숫자값과 랜덤 숫자값을 넣어줌.
				cnt = numGame(num, 100, 1, cnt);
			} else {
				throw new IllegalArgumentException("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
			}

		} else if(ver == 2){	//영어게임 진행

			bw.write("영어를 입력해주세요(A ~ z) : ");
			int c = (char)br.read();

			if (Pattern.matches("^[A-Za-z]+$", String.valueOf(c))) {
				// 초기에 입력한 숫자값과 랜덤 숫자값을 넣어줌.
				cnt = numGame(c, 100, 1, cnt);
			} else {
				throw new IllegalArgumentException("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
			}

			// 초기에 입력한 단어값과 랜덤 단어값을 넣어줌.
			cnt = engGame(c, 65, 122, cnt);

		} else	// 에러슈팅
			throw new IllegalArgumentException("[ERROR] 존재하지 않는 버전입니다.");

		bw.write("시도한 횟수 : " + cnt);

		br.close();
		bw.flush();
		bw.close();
	}

	public static int numGame(int num, int max, int min, int cnt) throws Exception {
		if(num > max || num < min){
			bw.write("[ERROR] 범위 내의 숫자를 입력하세요.");
			numGame(num, max, min, cnt++);
		}

		if(num < randNum){
			bw.write("UP");
			min = num;
		} else if (num > randNum) {
			bw.write("DOWN");
			max = num;
		} else if (num == randNum) {
			bw.write("정답!");
			return cnt;
		}

		bw.write("숫자를 입력해주세요(" + min + " ~ " + max + ") : ");
		num = br.read();

		if (Pattern.matches("^(?:[1-9][0-9]?|100)$", String.valueOf(num))) {
			// 초기에 입력한 숫자값과 랜덤 숫자값을 넣어줌.
			cnt = numGame(num, 100, 1, cnt);
		} else {
			throw new IllegalArgumentException("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
		}

		return numGame(num, max, min, cnt++);
	}

	public static int engGame(int c, int max, int min, int cnt) throws Exception{
		if(c > max || c < min){
			bw.write("[ERROR] 범위 내의 알파벳을 입력하세요.");
			return engGame(c, max, min, cnt++);
		}

		if(c < randChar){
			bw.write("UP");
			min = c;
		} else if (c > randChar) {
			bw.write("DOWN");
			max = c;
		} else if (c == randChar) {
			bw.write("정답!");
			return cnt;
		}

		bw.write("영어를 입력해주세요(" + min + " ~ " + max + ") : ");
		c = (char)br.read();

		if (Pattern.matches("^[A-Za-z]+$", String.valueOf(c))) {
			// 초기에 입력한 숫자값과 랜덤 숫자값을 넣어줌.
			cnt = numGame(c, 100, 1, cnt);
		} else {
			throw new IllegalArgumentException("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
		}

		return engGame(c, max, min, cnt++);
	}

}
