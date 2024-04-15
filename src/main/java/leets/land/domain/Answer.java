package leets.land.domain;

import leets.land.validation.exception.InvalidInputException;

public class Answer {

    private String answer;
    private Version version;

    // constructor -> 버젼에 따라 난수 생성
    public Answer(String answer, Version version) {
        try {
            throw new InvalidInputException("[TEMP]");

        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
