package leets.land.v1.domain;

import leets.land.v1.validation.exception.InvalidInputException;
import leets.land.v1.validation.validator.VersionValidator;

import java.util.Random;

import static leets.land.v1.domain.Version.ENGLISH_VERSION;
import static leets.land.v1.domain.Version.NUMBER_VERSION;

public class Answer {

    private final Object answer;
    private final Version version;

    public Answer(String version) throws InvalidInputException {
        new VersionValidator().validate(version);

        if (Integer.parseInt(version) == NUMBER_VERSION.getValue())
            this.version = NUMBER_VERSION;
        else
            this.version = ENGLISH_VERSION;
        this.answer = generateRandomAnswer();
    }

    public Object generateRandomAnswer() {
        // 숫자 버젼일 때
        if (this.version == NUMBER_VERSION) {
            return (int) ((Math.random() * 100) + 1);    // 1~100 사이 난수 생성
        }

        // 알파벳 버젼일 때
        char[] alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Random random = new Random();
        return alphabets[random.nextInt(alphabets.length)];
    }

    public Version getVersion() {
        return version;
    }

    public int compareTo(Version version, Object trial) {
        if (version == NUMBER_VERSION)
            return Integer.compare(Integer.parseInt(answer.toString()), Integer.parseInt(trial.toString()));
        return answer.toString().compareTo(trial.toString());
    }
}
