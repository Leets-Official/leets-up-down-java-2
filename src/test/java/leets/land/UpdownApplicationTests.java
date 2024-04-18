package leets.land;

import leets.land.view.InputView;
import leets.land.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;


class UpdownApplicationTests {
	UpdownApplication app;
	private Controller controller;
	private InputView inputViewMock;
	private OutputView outputViewMock;


	@Test
	public void setUp() {
		controller = new Controller();
	}
}
