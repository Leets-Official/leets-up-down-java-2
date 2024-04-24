package leets.land.v2.validation.constraint;

import leets.land.v2.domain.Range;
import leets.land.v2.validation.exception.InvalidInputException;

public class EnglishRangeConstraint implements Constraint<String> {

    private final Range range;

    public EnglishRangeConstraint(Range range) {
        this.range = range;
    }

    @Override
    public void checkValidation(String value) throws InvalidInputException {
        if(range.getBottom() > (int) value.charAt(0)       // 입력 값이 범위 사이에 존재하는가
                    || value.charAt(0) > range.getTop())
            throw new InvalidInputException("[ERROR] 범위 내의 알파벳을 입력하세요.");
    }
}
