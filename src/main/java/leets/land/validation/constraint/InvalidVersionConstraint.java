package leets.land.validation.constraint;

import java.util.regex.Pattern;

public class InvalidVersionConstraint implements Constraint<Integer> {

    Pattern pattern = Pattern.compile("^[12]$");

    @Override
    public boolean isValid(Integer value) {
        return pattern.matcher(value.toString()).matches();
    }
}
