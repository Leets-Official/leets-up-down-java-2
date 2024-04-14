package leets.land.validation.constraint;

public class TypeMismatchConstraint implements Constraint<Object> {

    @Override
    public boolean isValid(Object value) {
        return false;
    }
}
