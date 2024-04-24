package leets.land.v1.validation.constraint;

import leets.land.v1.validation.exception.InvalidInputException;

public interface Constraint<T> {
    void checkValidation(T value) throws InvalidInputException;
}
