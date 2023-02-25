package com.cricketGame.validatorAnnotations;


import com.cricketGame.validators.MinimumBowlersRequirementValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = MinimumBowlersRequirementValidator.class)
public @interface MinimumBowlersRequirement {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default "Minimum 2 Bowlers are required in team, Please make choose role of players according to" +
                             " requirement";
}
