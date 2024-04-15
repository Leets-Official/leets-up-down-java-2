package leets.land.validation.constraint;

import leets.land.validation.exception.InvalidInputException;

import java.util.regex.Pattern;

public class EnglishTypeMismatchConstraint implements Constraint<String> {

    Pattern pattern = Pattern.compile("^[a-zA-Z]$");

    @Override
    public void isValid(String value) throws InvalidInputException {
        if(!pattern.matcher(value).matches())    // 영어를 입력해야 하는데 그 외의 값을 입력했는가
            throw new InvalidInputException("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
    }
}
