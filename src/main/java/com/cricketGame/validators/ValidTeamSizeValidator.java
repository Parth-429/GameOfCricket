package com.cricketGame.validators;

import com.cricketGame.dto.TeamDTO;
import com.cricketGame.validatorAnnotations.ValidTeamSize;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidTeamSizeValidator implements ConstraintValidator<ValidTeamSize, TeamDTO> {

    @Override
    public void initialize(ValidTeamSize constraintAnnotation) {

    }

    @Override
    public boolean isValid(TeamDTO teamDTO, ConstraintValidatorContext context) {
        return teamDTO.getTeamSize() == teamDTO.getPlayers().size();
    }
}
