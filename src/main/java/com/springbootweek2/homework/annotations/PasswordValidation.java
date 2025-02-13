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
        validatedBy = {PasswordValidator.class}
)
public @interface PasswordValidation  {

    String message() default "The password must contains a.contains one uppercase letter\n" +
            "b. contains one lowercase letter\n" +
            "c. contains one special character\n" +
            "d. minimum length is 10 characters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
