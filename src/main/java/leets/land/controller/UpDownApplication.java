package leets.land.controller;

import leets.land.domain.Answer;
import leets.land.domain.Range;
import leets.land.domain.Trial;
import leets.land.validation.exception.InvalidInputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import static leets.land.domain.Version.NUMBER_VERSION;

public class UpDownApplication {

	private static final boolean UNTIL_CORRECT = true;
	private static final int MAX_ERROR_COUNT = 5;
	private static final int INIT_ERROR_COUNT = 0;

	private static Answer answer;
	private static final Range range = new Range();
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// 테스트를 위한 Setter
	public static void setBr(BufferedReader br) {
		UpDownApplication.br = br;
	}

	public static void main(String[] args) {
		UpDownApplication app = new UpDownApplication();
		app.run();
	}

	public void run() {
		System.out.print("""
					업다운 게임을 시작합니다.
					     
					버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2):\s""");
		init(INIT_ERROR_COUNT);	// Answer 생성
		guess(INIT_ERROR_COUNT); // 게임 시작 + 결과 출력
	}

	public void init(int errorCnt) {
		try {
			answer = new Answer(read(errorCnt));
			initRange();	// 범위 초기화 (숫자면 1~100, 영어면 A~z)
		} catch (InvalidInputException e) {
			System.out.print(e.getMessage());
			init(++errorCnt);		// 재귀
		}
	}

										// 테스트를 위한 throws
	public String read(int errorCnt) /*throws InvalidInputException*/ {
		try {
			if (errorCnt >= MAX_ERROR_COUNT)
				throw new InvalidInputException("[ERROR] 5회 이상 잘못 입력하셨습니다.\n프로그램을 종료합니다.");

			return Optional.of(br.readLine())
					.filter(input -> !input.trim().isEmpty())
					.orElseThrow(() -> new InvalidInputException("[ERROR] 값을 입력해주세요: "));
		} catch (InvalidInputException e) {
			System.out.print(e.getMessage());

			if (errorCnt >= MAX_ERROR_COUNT)
				System.exit(0);

			return read(++errorCnt);
			// 테스트를 위한 throw
//			throw new InvalidInputException(e.getMessage());
		} catch (IOException e) {
			throw new RuntimeException("[ERROR] 입력을 읽는 중 오류가 발생했습니다: " + e);
		}
	}

	// 비즈니스 로직
	public void guess(int errorCnt) {
		while (UNTIL_CORRECT) {
			try {
				System.out.print(answer.getVersion().getName() + "를 입력해주세요(" + range.getBottom() + " ~ " + range.getTop() +"): ");
				Trial trial = Trial.getInstance().init(answer.getVersion(), read(errorCnt), range);

				int result = answer.compareTo(answer.getVersion(), trial.getTrial());	// 조건문의 조건 내에서 연산하면 여러번 수행해야 하므로 따로 뺌

				if(result == 0) {	// 정답일 때
					System.out.println("시도한 횟수 : " + trial.getCount() + " 회");
					break;
				}

				if(result > 0) {	// trial < answer
					System.out.println("UP");
					range.setBottom(trial.getTrial().toString());
				}

				if(result < 0) {	// trial > answer
					System.out.println("DOWN");
					range.setTop(trial.getTrial().toString());
				}
			} catch (InvalidInputException e) {
				System.out.println(e.getMessage());
				++errorCnt;
			}
		}
	}

	private static void initRange() {
		if(answer.getVersion() == NUMBER_VERSION) {
			range.setBottom("1");
			range.setTop("100");
		} else {
			range.setBottom("A");
			range.setTop("z");
		}
	}
}
