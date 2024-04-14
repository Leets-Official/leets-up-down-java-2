package leets.land.validation.validator;

import leets.land.validation.constraint.Constraint;
import leets.land.validation.constraint.InvalidVersionConstraint;

import java.util.List;

public class VersionValidator {

    private final List<Constraint<Integer>> constraints = List.of(new InvalidVersionConstraint());  // 다른 제약 조건이 생기면 추가

    public boolean validate(int value) {
        return constraints.stream().allMatch(constraint -> constraint.isValid(value));
    }
}
