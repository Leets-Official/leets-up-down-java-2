package leets.land.validation.validator;

import leets.land.v1.validation.exception.InvalidInputException;
import leets.land.v1.validation.validator.VersionValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VersionValidatorTest {

    private final VersionValidator versionValidator = new VersionValidator();

    @Test
    @DisplayName("버젼 잘못 입력 시, 에러 출력")
    public void validate() {
        Assertions.assertThrows(InvalidInputException.class,
                () -> versionValidator.validate(3));
    }
}