package leets.land.domain;

import leets.land.validation.constraint.Constraint;
import leets.land.validation.constraint.InvalidVersionConstraint;
import leets.land.validation.exception.InvalidInputException;
import leets.land.validation.validator.VersionValidator;

public class Answer {

    private String answer;
    private static final Constraint<Integer> constraint = new InvalidVersionConstraint();


    // constructor -> 버젼에 따라 난수 생성
    public Answer(String answer, int version) {
        try {

            if(constraint.isValid(version))
                throw new InvalidInputException("[ERROR] 존재하지 않는 버전입니다.");



        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
