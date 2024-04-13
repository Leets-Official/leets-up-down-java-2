package leets.land;

public class Controller {
    private final InputView inputView = new InputView();
    public void run() {
        int version = inputView.versionInput();
        if (version == 1) {
            numberVersion();
        } else {
            alphaVersion();
        }
    }
    public void numberVersion() {
        int number = inputView.readNumber();
    }
    public void alphaVersion() {
        String alpha = inputView.readString();
    }
}
