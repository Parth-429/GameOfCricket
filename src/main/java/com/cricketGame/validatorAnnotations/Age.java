package com.cricketGame.validatorAnnotations;

import com.cricketGame.validators.AgeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {
    int lower() default 20;
    int uper() default 45;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default "Age should be between 20 and 45";
}

