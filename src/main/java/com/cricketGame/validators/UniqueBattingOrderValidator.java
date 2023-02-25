package com.cricketGame.validators;

import com.cricketGame.dto.PlayerDTO;
import com.cricketGame.dto.TeamDTO;
import com.cricketGame.validatorAnnotations.UniqueBattingOrderForAllPlayer;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashSet;
import java.util.Set;

public class UniqueBattingOrderValidator implements ConstraintValidator<UniqueBattingOrderForAllPlayer, TeamDTO> {

    @Override
    public void initialize(UniqueBattingOrderForAllPlayer constraintAnnotation) {

    }

    @Override
    public boolean isValid(TeamDTO teamDTO, ConstraintValidatorContext context) {
        Set<Integer> battingOrders = new HashSet<>();
        for(PlayerDTO playerDTO: teamDTO.getPlayers()){
            battingOrders.add(playerDTO.getBattingOrderNo());
        }

        return battingOrders.size() == teamDTO.getPlayers().size();
    }
}
