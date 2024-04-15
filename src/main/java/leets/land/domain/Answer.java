package leets.land.domain;

import leets.land.validation.exception.InvalidInputException;
import leets.land.validation.validator.VersionValidator;

import java.util.Random;

import static leets.land.domain.Version.ENGLISH_VERSION;
import static leets.land.domain.Version.NUMBER_VERSION;

public class Answer {

    private final Object answer;
    private final Version version;

    public Answer(String version) throws InvalidInputException {
        VersionValidator versionValidator = new VersionValidator();
        versionValidator.validate(version);

        if(Integer.parseInt(version) == NUMBER_VERSION.getValue()) {
            this.version = NUMBER_VERSION;
        }
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
        if (this.version == ENGLISH_VERSION) {
            char[] alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
            Random random = new Random();
            return alphabets[random.nextInt(alphabets.length)];
        }

        // 이미 validate 해서 둘 말곤 값이 들어올 수가 없음
        return null;
    }

    public Version getVersion() {
        return version;
    }

    public int compareTo(Version version, Object trial) {
        if(version == NUMBER_VERSION)
            return Integer.compare(Integer.parseInt(answer.toString()), Integer.parseInt(trial.toString()));
        else
            return answer.toString().compareTo(trial.toString());
    }
}
