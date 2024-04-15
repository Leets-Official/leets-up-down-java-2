package leets.land.validation.constraint;

import leets.land.domain.Range;
import leets.land.validation.exception.InvalidInputException;

public class EnglishRangeConstraint implements Constraint<String> {

    private final Range range;

    public EnglishRangeConstraint(Range range) {
        this.range = range;
    }

    @Override
    public void isValid(String value) throws InvalidInputException {
        if(value.compareTo(range.getBottom()) < 0       // 입력 값이 범위 사이에 존재하는가
                    || value.compareTo(range.getTop()) > 0)
            throw new InvalidInputException("[ERROR] 범위 내의 알파벳을 입력하세요.");
    }
}
