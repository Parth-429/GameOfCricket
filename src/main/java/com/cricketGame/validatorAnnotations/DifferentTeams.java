package com.cricketGame.validatorAnnotations;

import com.cricketGame.validators.DifferentTeamsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DifferentTeamsValidator.class)
@Target({ ElementType.TYPE, ElementType.FIELD })
public @interface DifferentTeams {

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default "Both Teams should be different";
}
