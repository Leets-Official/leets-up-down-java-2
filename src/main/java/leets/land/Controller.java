package leets.land;

public class Controller {
    private final InputView inputView = new InputView();
    public void run() {
        int version = inputView.versionInput();
    }
    public void numberVersion() {
        int number = inputView.readNumber();
    }
}
