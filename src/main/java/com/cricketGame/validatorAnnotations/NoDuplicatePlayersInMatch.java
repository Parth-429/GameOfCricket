package com.cricketGame.validatorAnnotations;

import com.cricketGame.validators.NoDuplicatePlayersInMatchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NoDuplicatePlayersInMatchValidator.class)
@Target({ ElementType.FIELD, ElementType.TYPE })
public @interface NoDuplicatePlayersInMatch {

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String message() default "The same person is playing from  both team or may be you are " +
                             "allowing same person with different role&/Batting order in one team which is not " +
                             "allowed  , " + "please " + "check " + "person " + "ids of " + "both team once";
}
