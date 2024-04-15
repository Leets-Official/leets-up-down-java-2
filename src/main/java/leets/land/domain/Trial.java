package leets.land.domain;

import leets.land.validation.exception.InvalidInputException;
import leets.land.validation.validator.TrialValidator;

public class Trial {

    private Object trial;
    private int count;

    public Trial(Version version, Object trial, Range range) {
        try {
            if (!new TrialValidator().validate(version, trial, range)) {   // !없이 할 수 있도록 수정 예정
                throw new InvalidInputException("[ERROR]"); // 각각 다른 에러 문구가 출력될 수 있도록 수정 예정
            }

            this.trial = trial;
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    public Object getTrial() {
        return trial;
    }

    public int getCount() {
        return count;
    }

    public void updateTrial(Object trial) {
        this.trial = trial;
        count++;
    }

    @Override
    public String toString() {
        return "Trial{" +
                "trial=" + trial +
                ", count=" + count +
                '}';
    }
}
