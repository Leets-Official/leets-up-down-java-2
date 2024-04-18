package leets.land;

import leets.land.domain.Game;
import leets.land.domain.Version;
import leets.land.view.Inputs;
import leets.land.view.Prints;


public class UpdownApplication {
    Inputs inputs = new Inputs();
    Prints prints = new Prints();

    public void run() {
        prints.opening();

        Version version = inputs.version();
        Game game = new Game(version);
        int tryTimes = game.playAndGetTryTimes(version);

        prints.ending(tryTimes);
    }

    public static void main(String[] args) {
        UpdownApplication app = new UpdownApplication();
        app.run();
    }
}
