package leets.land;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class UpdownApplicationTests {
	UpdownApplication app;

	@BeforeEach
	void setUp() {
		app = new UpdownApplication();
	}
	@Test
	void contextLoads() {
	}
	@Test
	void checkNumberValidity(){
		int min = 40;
		int max = 60;
		int userInput = 20;

		assertThrows(Exception.class, ()->{
			app.checkNumberValidity(min, max, userInput);
		});

	}

}
