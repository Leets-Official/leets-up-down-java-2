package leets.land.service;

public interface GameService {
    //난수발생
    int generateNum();

    //게임 시작
    int updownGame(int randomNum);
}
