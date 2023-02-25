package com.cricketGame.validatorAnnotations;


import com.cricketGame.validators.UniqueBattingOrderValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueBattingOrderValidator.class)
public @interface UniqueBattingOrderForAllPlayer {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default "Batting order for all players should be unique";
}
