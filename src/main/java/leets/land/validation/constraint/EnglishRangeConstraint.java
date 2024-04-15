package leets.land.validation.constraint;

import leets.land.domain.Range;

public class EnglishRangeConstraint implements Constraint<String> {

    private final Range range;

    public EnglishRangeConstraint(Range range) {
        this.range = range;
    }

    @Override
    public boolean isValid(String value) {  // if (하한값 <= value <= 상한값)
        return value.compareTo((String) range.getBottom()) >= 0
                    && value.compareTo((String) range.getTop()) <= 0;
    }
}
