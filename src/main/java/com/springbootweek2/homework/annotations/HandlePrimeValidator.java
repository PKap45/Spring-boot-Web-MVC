package com.springbootweek2.homework.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class HandlePrimeValidator implements ConstraintValidator<HandlePrime, Integer> {

    @Override
    public boolean isValid(Integer input, ConstraintValidatorContext constraintValidatorContext) {

        if (input <= 1) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(input); i++) {
            if (input % i == 0) {
                return true;
            }
        }

        return false;
    }
}

