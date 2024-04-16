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
	private static Answer answer;
	private static final Range range = new Range();
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		UpDownApplication app = new UpDownApplication();
		app.run();
	}

	public void run() {
		System.out.print("""
					업다운 게임을 시작합니다.
					     
					버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2):\s""");
		init();	// Answer 생성
		guess(); // 게임 시작 + 결과 출력
	}

	public void init() {
		try {
			answer = new Answer(read());
			initRange();	// 범위 초기화 (숫자면 1~100, 영어면 A~z)
		} catch (InvalidInputException e) {
			System.out.print(e.getMessage());
			init();		// 재귀
		}
	}

	public String read() {
		try {
			return Optional.of(br.readLine())
					.filter(input -> !input.trim().isEmpty())
					.orElseThrow(() -> new InvalidInputException("[ERROR] 값을 입력해주세요: "));
		} catch (InvalidInputException e) {
			System.out.print(e.getMessage());
			return read();
		} catch (IOException e) {
			throw new RuntimeException("[ERROR] 입력을 읽는 중 오류가 발생했습니다: " + e);
		}
	}

	// 비즈니스 로직
	public void guess() {
		while (UNTIL_CORRECT) {
			try {
				System.out.print(answer.getVersion().getName() + "를 입력해주세요(" + range.getBottom() + " ~ " + range.getTop() +"): ");
				Trial trial = Trial.getInstance().init(answer.getVersion(), read(), range);

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
