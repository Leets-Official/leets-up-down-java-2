package leets.land.v2.validation.constraint;

import leets.land.v2.validation.exception.InvalidInputException;

public interface Constraint<T> {
    void checkValidation(T value) throws InvalidInputException;
}
