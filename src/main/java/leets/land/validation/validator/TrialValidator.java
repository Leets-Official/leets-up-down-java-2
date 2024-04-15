package leets.land.validation.validator;

import leets.land.domain.Range;
import leets.land.domain.Version;
import leets.land.validation.constraint.*;

import java.util.List;

import static leets.land.domain.Version.ENGLISH_VERSION;
import static leets.land.domain.Version.NUMBER_VERSION;

public class TrialValidator {

    private List<Constraint> constraints;  // 다른 제약 조건이 생기면 추가

    public boolean validate(Version version, Object value, Range range) {
        if(version == ENGLISH_VERSION)
            constraints = List.of(new EnglishTypeMismatchConstraint(), new EnglishRangeConstraint(range));
        if(version == NUMBER_VERSION)
            constraints = List.of(new NumberTypeMismatchConstraint(), new NumberRangeConstraint(range));

        constraints.listIterator().forEachRemaining(System.out::println);

        return constraints.stream().allMatch(constraint -> constraint.isValid(value));
    }
}
