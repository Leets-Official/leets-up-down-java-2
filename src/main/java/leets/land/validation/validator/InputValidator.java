package leets.land.validation.validator;

import leets.land.domain.Version;
import leets.land.validation.constraint.*;

import java.util.List;

import static leets.land.domain.Version.ENGLISH_VERSION;
import static leets.land.domain.Version.NUMBER_VERSION;

public class InputValidator {

    private List<Constraint<?>> constraints;  // 다른 제약 조건이 생기면 추가

    public boolean validate(Version version, Object value) {
        if(version == ENGLISH_VERSION)
            constraints = List.of(new TypeMismatchConstraint(), new EnglishRangeConstraint());
        if(version == NUMBER_VERSION)
            constraints = List.of(new TypeMismatchConstraint(), new NumberRangeConstraint());

        return constraints.stream().allMatch(constraint -> constraint.isValid(value));
    }
}
