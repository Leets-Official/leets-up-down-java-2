package leets.land.v1.validation.constraint;

import leets.land.v1.validation.exception.InvalidInputException;

import java.util.regex.Pattern;

public class NumberTypeMismatchConstraint implements Constraint<String> {

    private final Pattern pattern = Pattern.compile("\\d+");

    @Override
    public void checkValidation(String value) throws InvalidInputException {
        if(!pattern.matcher(value).matches())    // 숫자를 입력해야 하는데 그 외의 값을 입력했는가
            throw new InvalidInputException("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
    }
}
