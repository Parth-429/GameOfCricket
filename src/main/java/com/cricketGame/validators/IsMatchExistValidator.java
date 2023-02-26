package com.cricketGame.validators;

import com.cricketGame.models.beans.Match;
import com.cricketGame.services.daoServices.AllService;
import com.cricketGame.validatorAnnotations.ValidMatchID;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class IsMatchExistValidator implements ConstraintValidator<ValidMatchID,Long> {

    @Override
    public void initialize(ValidMatchID constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long matchID, ConstraintValidatorContext context) {
        if(Objects.isNull(matchID))
            return false;
        Match match = AllService.matchService.findMatchById(matchID);
        return !Objects.isNull(match);
    }
}
