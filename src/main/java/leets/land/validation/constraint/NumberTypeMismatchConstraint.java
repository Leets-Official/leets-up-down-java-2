package leets.land.validation.constraint;

import java.util.regex.Pattern;

public class NumberTypeMismatchConstraint implements Constraint<Object> {

    Pattern pattern = Pattern.compile("\\d+");

    @Override
    public boolean isValid(Object value) {
        return pattern.matcher(value.toString()).matches();
    }
}
