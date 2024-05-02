package leets.land.v1.validation.constraint;

import leets.land.v1.domain.Range;
import leets.land.v1.validation.exception.InvalidInputException;

public class NumberRangeConstraint implements Constraint<String> {

    private final Range range;

    public NumberRangeConstraint(Range range) {
        this.range = range;
    }

    @Override
    public void checkValidation(String value) throws InvalidInputException {
        if(Integer.parseInt(range.getBottom()) > Integer.parseInt(value)     // 입력 값이 범위 사이에 존재하는가
                    || Integer.parseInt(value) > Integer.parseInt(range.getTop()))
            throw new InvalidInputException("[ERROR] 범위 내의 숫자를 입력하세요.");
    }
}
