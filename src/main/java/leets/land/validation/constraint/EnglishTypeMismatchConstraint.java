package leets.land.validation.constraint;

import java.util.regex.Pattern;

public class EnglishTypeMismatchConstraint implements Constraint<Object> {

    Pattern pattern = Pattern.compile("^[a-zA-Z]$");

    @Override
    public boolean isValid(Object value) {
        return pattern.matcher(value.toString()).matches();
    }
}
