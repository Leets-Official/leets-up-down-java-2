package leets.land.domain;

import leets.land.validation.exception.InvalidInputException;
import leets.land.validation.validator.TrialValidator;

public class Trial {

    private final Object trial;
    private static int count;
    private static final TrialValidator validator = new TrialValidator();

    public Trial(Version version, Object trial, Range range) throws InvalidInputException {
        ++count;
        validator.validate(version, trial, range);   // !없이 할 수 있도록 수정 예정
        this.trial = trial;
    }

    public Object getTrial() {
        return trial;
    }

    public int getCount() {
        return count;
    }

}
