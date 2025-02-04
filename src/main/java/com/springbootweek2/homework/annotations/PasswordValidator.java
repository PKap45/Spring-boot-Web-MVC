package com.springbootweek2.homework.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordValidation, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if (password == null && password.length() < 10) {
            return false;
        }

        boolean hasLowercase = false;
        boolean hasUpperCase = false;
        boolean hasSpecialChar = false;
        String specialCharacter = "@$!%*?&";

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (specialCharacter.contains(String.valueOf(ch))) {
                hasSpecialChar = true;
            }
        }
        if (hasLowercase && hasUpperCase && hasSpecialChar){
            return true;
         }
        return  false;
    }
}
