package com.cricketGame.validators;

import com.cricketGame.validatorAnnotations.Age;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {
    private int upper;
    private int lower;

    @Override
    public void initialize(Age constraintAnnotation) {
        upper = constraintAnnotation.uper();
        lower = constraintAnnotation.lower();
    }

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext context) {
        return age >= lower && age <= upper;
    }
}
