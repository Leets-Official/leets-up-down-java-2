package leets.land;

import leets.land.controller.UpDownApplication;
import leets.land.validation.exception.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class UpDownApplicationTests {

	private UpDownApplication app;

	@BeforeEach
	public void beforeEach() {
		app = new UpDownApplication();
	}

	@Test
	@DisplayName("입력 값이 없을 때 에러 출력 -> 5회 이상 입력 실패 시 에러 출력")
	public void readEmpty() throws IOException {
		String emptyInput = "";

		BufferedReader bufferedReaderMock = Mockito.mock(BufferedReader.class);
		when(bufferedReaderMock.readLine()).thenReturn(emptyInput);
		app.setBr(bufferedReaderMock);

		assertThrows(InvalidInputException.class, () -> app.read(0));
	}
}
