package leets.land.controller;

import leets.land.domain.UpDown;

public interface Game {
    void run();
    void play(UpDown upDown);
}
