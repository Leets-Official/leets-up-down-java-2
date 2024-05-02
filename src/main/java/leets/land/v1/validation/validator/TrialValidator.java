package leets.land.v1.validation.validator;

import leets.land.v1.domain.Range;
import leets.land.v1.domain.Version;
import leets.land.v1.validation.constraint.*;
import leets.land.v1.validation.exception.InvalidInputException;

import java.util.List;

import static leets.land.v1.domain.Version.ENGLISH_VERSION;
import static leets.land.v1.domain.Version.NUMBER_VERSION;

public class TrialValidator {

    private List<Constraint<String>> constraints;  // 다른 제약 조건이 생기면 추가

    public void validate(Version version, Object value, Range range) throws InvalidInputException {
        if(version == ENGLISH_VERSION)
            constraints = List.of(new EnglishTypeMismatchConstraint(), new EnglishRangeConstraint(range));
        if(version == NUMBER_VERSION)
            constraints = List.of(new NumberTypeMismatchConstraint(), new NumberRangeConstraint(range));

        for (Constraint<String> constraint : constraints) {
            constraint.checkValidation(value.toString());
        }
    }
}
