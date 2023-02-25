package com.cricketGame.validatorAnnotations;

import com.cricketGame.validators.IsTeamExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsTeamExistValidator.class)
@Target(ElementType.FIELD)
public @interface IsTeamExist {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default "Team with given id is not exist";
}
