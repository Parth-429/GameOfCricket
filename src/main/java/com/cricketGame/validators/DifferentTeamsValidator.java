package com.cricketGame.validators;

import com.cricketGame.dto.MatchDTO;
import com.cricketGame.validatorAnnotations.DifferentTeams;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DifferentTeamsValidator implements ConstraintValidator<DifferentTeams, MatchDTO> {

    @Override
    public void initialize(DifferentTeams constraintAnnotation) {
    }

    @Override
    public boolean isValid(MatchDTO matchDTO, ConstraintValidatorContext context) {
            return (!matchDTO.getTeam1DTO().getTeamId().equals(matchDTO.getTeam2DTO().getTeamId()));
    }
}
