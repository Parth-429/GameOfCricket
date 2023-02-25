package com.cricketGame.validators;

import com.cricketGame.dto.MatchDTO;
import com.cricketGame.validatorAnnotations.ValidAllowedTeamSize;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidAllowedTeamSizeValidator implements ConstraintValidator<ValidAllowedTeamSize, MatchDTO> {

    @Override
    public void initialize(ValidAllowedTeamSize constraintAnnotation) {

    }

    @Override
    public boolean isValid(MatchDTO matchDTO, ConstraintValidatorContext context) {
        return (matchDTO.getAllowedTeamSize()==matchDTO.getTeam1DTO().getTeamSize()) && (matchDTO.getAllowedTeamSize()==matchDTO.getTeam2DTO().getTeamSize());
    }
}
