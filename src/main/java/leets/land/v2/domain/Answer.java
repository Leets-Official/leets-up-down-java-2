package leets.land.v2.domain;

import java.util.Random;

import static leets.land.v2.domain.Version.NUMBER_VERSION;

public class Answer {

    private final int answer;

    public Answer(Version version) {
        this.answer = generateRandomAnswer(version);
    }

    private int generateRandomAnswer(Version version) {
        // 숫자 버젼일 때
        if (version == NUMBER_VERSION) {
            return (int) ((Math.random() * 100) + 1);    // 1~100 사이 난수 생성
        }

        // 알파벳 버젼일 때
        char[] alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Random random = new Random();
        return alphabets[random.nextInt(alphabets.length)];
    }

    public int getAnswer() {
        return answer;
    }
}
