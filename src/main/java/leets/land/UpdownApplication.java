package leets.land;

import java.io.*;
public class UpdownApplication {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		//게임 시작 & 버전 입력 받기
		System.out.println("업다운 게임을 시작합니다.\n");
		System.out.print("버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2) : ");
		Integer version = Integer.parseInt(br.readLine());
		if(version == 1){
			//숫자 버전

		}
		else if(version == 2){
			//영어 버전
		}
		else{
			throw new Exception("[ERROR] 올바른 버전을 선택해주세요.");
		}


	}

}
