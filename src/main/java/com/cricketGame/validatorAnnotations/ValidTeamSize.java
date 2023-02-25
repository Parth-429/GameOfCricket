package com.cricketGame.validatorAnnotations;


import com.cricketGame.validators.ValidTeamSizeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ValidTeamSizeValidator.class)
public @interface ValidTeamSize {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default "Team size given and no of players in list should be equal";
}
