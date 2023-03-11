package com.cricketGame.validatorAnnotations;

import com.cricketGame.validators.MatchIDValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MatchIDValidator.class)
@Target(ElementType.FIELD)
public @interface ValidMatchID {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default "Match with given id is not exist";
}
