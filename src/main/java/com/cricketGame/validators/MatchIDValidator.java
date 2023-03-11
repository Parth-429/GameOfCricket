package com.cricketGame.validators;

import com.cricketGame.models.beans.Match;
import com.cricketGame.services.daoServices.MatchService;
import com.cricketGame.validatorAnnotations.ValidMatchID;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class MatchIDValidator implements ConstraintValidator<ValidMatchID,Long> {

    @Autowired
    private MatchService matchService;

    @Override
    public void initialize(ValidMatchID constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long matchID, ConstraintValidatorContext context) {
        if(Objects.isNull(matchID))
            return false;
        Match match = matchService.findMatchById(matchID);
        return !Objects.isNull(match);
    }
}
