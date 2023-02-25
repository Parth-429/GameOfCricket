package com.cricketGame.validators;

import com.cricketGame.dto.PlayerDTO;
import com.cricketGame.dto.TeamDTO;
import com.cricketGame.models.enums.Role;
import com.cricketGame.validatorAnnotations.MinimumBowlersRequirement;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MinimumBowlersRequirementValidator implements ConstraintValidator<MinimumBowlersRequirement, TeamDTO> {

    @Override
    public void initialize(MinimumBowlersRequirement constraintAnnotation) {

    }
    @Override
    public boolean isValid(TeamDTO teamDTO, ConstraintValidatorContext context) {
       int bowlers = 0;
        for(PlayerDTO playerDTO: teamDTO.getPlayers()){
           if(Role.BOWLER.equals(playerDTO.getRole())) bowlers++;
        }
       return bowlers>=2;
    }
}
