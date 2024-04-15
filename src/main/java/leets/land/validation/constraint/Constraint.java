package leets.land.validation.constraint;

import leets.land.validation.exception.InvalidInputException;

public interface Constraint<T> {
    void isValid(T value) throws InvalidInputException;
}
