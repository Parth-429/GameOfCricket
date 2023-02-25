package com.cricketGame.validatorAnnotations;

import com.cricketGame.validators.IsMatchExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsMatchExistValidator.class)
@Target(ElementType.FIELD)
public @interface IsMatchExist {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default "Match with given id is not exist";
}
