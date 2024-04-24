package leets.land.v1.validation.validator;

import leets.land.v1.validation.constraint.Constraint;
import leets.land.v1.validation.exception.InvalidInputException;
import leets.land.v1.validation.constraint.InvalidVersionConstraint;

import java.util.List;

public class VersionValidator {

    private final List<Constraint<String>> constraints = List.of(new InvalidVersionConstraint());  // 다른 제약 조건이 생기면 추가

    public void validate(Object value) throws InvalidInputException {
        for (Constraint<String> constraint : constraints) {
            constraint.checkValidation(value.toString());
        }
    }
}
