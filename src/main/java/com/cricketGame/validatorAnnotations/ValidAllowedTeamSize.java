package com.cricketGame.validatorAnnotations;

import com.cricketGame.validators.ValidAllowedTeamSizeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.PARAMETER, ElementType.FIELD })
@Constraint(validatedBy = ValidAllowedTeamSizeValidator.class)
public @interface ValidAllowedTeamSize {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default "Team size of both team should equal to allowed match size in match";
}
