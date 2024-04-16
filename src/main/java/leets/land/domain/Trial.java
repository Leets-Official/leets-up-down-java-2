package leets.land.domain;

import leets.land.validation.exception.InvalidInputException;
import leets.land.validation.validator.TrialValidator;

public class Trial {

    private Object trial;
    private int count;
    private final TrialValidator validator = new TrialValidator();

    private Trial() {
    }

    public Trial init(Version version, Object trial, Range range) throws InvalidInputException {
        ++this.count;
        validator.validate(version, trial, range);   // !없이 할 수 있도록 수정 예정
        this.trial = trial;

        return this;
    }

    private static class LazyHolder {
        public static final Trial singletonTrial = new Trial();
    }

    public static Trial getInstance() {
        return LazyHolder.singletonTrial;
    }

    public Object getTrial() {
        return trial;
    }

    public int getCount() {
        return count;
    }

}
