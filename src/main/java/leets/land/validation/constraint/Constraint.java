package leets.land.validation.constraint;

public interface Constraint<T> {
    boolean isValid(T value);
}
