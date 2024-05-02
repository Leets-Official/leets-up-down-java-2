package leets.land.validation.validator;

import leets.land.v1.domain.Range;
import leets.land.v1.domain.Version;
import leets.land.v1.validation.exception.InvalidInputException;
import leets.land.v1.validation.validator.TrialValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static leets.land.v1.domain.Version.ENGLISH_VERSION;
import static leets.land.v1.domain.Version.NUMBER_VERSION;

class TrialValidatorTest {

    private TrialValidator trialValidator;
    private Range range;

    @BeforeEach
    public void beforeEach() {
        trialValidator = new TrialValidator();
        range = new Range();
    }

    private void initRange(Version version) {
        if(version == NUMBER_VERSION) {
            range.setBottom("1");
            range.setTop("100");
        } else {
            range.setBottom("A");
            range.setTop("z");
        }
    }

    @Test
    @DisplayName("숫자 버젼 업다운 게임 시, 숫자가 아닌 다른 값을 입력하면 에러 출력")
    public void validateNumberTypeMismatch() {
        initRange(NUMBER_VERSION);

        Assertions.assertThrows(InvalidInputException.class,
                () -> trialValidator.validate(NUMBER_VERSION, "김경규", range));
    }

    @Test
    @DisplayName("영어 버젼 업다운 게임 시, 영어가 아닌 다른 값을 입력하면 에러 출력")
    public void validateEnglishTypeMismatch() {
        initRange(ENGLISH_VERSION);

        Assertions.assertThrows(InvalidInputException.class,
                () -> trialValidator.validate(ENGLISH_VERSION, "김경규", range));
    }

    @Test
    @DisplayName("숫자 버젼 업다운 게임 시, 정해진 범위를 넘는 값을 입력하면 에러 출력")
    public void validateNumberRange() {
        initRange(NUMBER_VERSION);

        Assertions.assertThrows(InvalidInputException.class,
                () -> trialValidator.validate(NUMBER_VERSION, 10000, range));
    }

    @Test
    @DisplayName("영어 버젼 업다운 게임 시, 정해진 범위를 넘는 값을 입력하면 에러 출력")
    public void validateEnglishRange() {
        initRange(ENGLISH_VERSION);

        Assertions.assertThrows(InvalidInputException.class,
                () -> trialValidator.validate(ENGLISH_VERSION, "HelloWorld", range));
    }
}