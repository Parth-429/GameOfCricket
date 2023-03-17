package com.cricketGame.validators;


import com.cricketGame.models.beans.team.Team;
import com.cricketGame.services.daoServicesImpl.TeamServiceImpl;
import com.cricketGame.validatorAnnotations.ValidTeamId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;


public class TeamIDValidator implements ConstraintValidator<ValidTeamId, Long> {

    @Autowired
    private TeamServiceImpl teamService;

    @Override
    public void initialize(ValidTeamId constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long teamID, ConstraintValidatorContext context) {
        if(Objects.isNull(teamID))
            return false;
        Team team = teamService.findTeamById(teamID);
        return !Objects.isNull(team);
    }
}
