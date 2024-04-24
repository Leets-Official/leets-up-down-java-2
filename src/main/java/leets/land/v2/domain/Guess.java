package leets.land.v2.domain;

import leets.land.v2.validation.exception.InvalidInputException;

public class Guess {
    private int guess; // 영어 버전일 때 영어의 아스키코드 값 담기
    private int count;

    private Guess() {}

    public Guess init(int guess) throws InvalidInputException {
        ++this.count;
        this.guess = guess;
        return this;
    }

    private static class LazyHolder {   // singleton
        public static final Guess singletonTrial = new Guess();
    }

    public static Guess getInstance() {
        return Guess.LazyHolder.singletonTrial;
    }

    public int getTrial() {
        return guess;
    }

    public int getCount() {
        return count;
    }
}
