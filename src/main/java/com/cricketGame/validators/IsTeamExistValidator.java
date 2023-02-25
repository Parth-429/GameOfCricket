package com.cricketGame.validators;


import com.cricketGame.models.beans.team.Team;
import com.cricketGame.services.daoServices.AllService;
import com.cricketGame.validatorAnnotations.IsTeamExist;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;


public class IsTeamExistValidator implements ConstraintValidator<IsTeamExist, Long> {

    @Override
    public void initialize(IsTeamExist constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long teamID, ConstraintValidatorContext context) {
        if(Objects.isNull(teamID))
            return false;
        Team team = AllService.teamService.findTeamById(teamID);
        return !Objects.isNull(team);
    }
}
