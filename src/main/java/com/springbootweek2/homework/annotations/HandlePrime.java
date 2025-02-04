package com.springbootweek2.homework.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {HandlePrimeValidator.class}
)
public @interface HandlePrime {

    String message() default "The Value Should not be a prime number";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
