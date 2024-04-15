package leets.land.validation.constraint;

import leets.land.domain.Range;

public class NumberRangeConstraint implements Constraint<Integer> {

    private final Range range;

    public NumberRangeConstraint(Range range) {
        this.range = range;
    }

    @Override
    public boolean isValid(Integer value) {
        return (int) range.getBottom() <= value     // 값이 사이에 존재하는가?
                    && value <= (int) range.getTop();
    }
}
