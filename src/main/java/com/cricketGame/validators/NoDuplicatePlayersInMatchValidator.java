package com.cricketGame.validators;

import com.cricketGame.dto.MatchDTO;
import com.cricketGame.dto.PlayerDTO;
import com.cricketGame.validatorAnnotations.NoDuplicatePlayersInMatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashMap;
import java.util.Map;

public class NoDuplicatePlayersInMatchValidator implements ConstraintValidator<NoDuplicatePlayersInMatch,MatchDTO> {


    @Override
    public void initialize(NoDuplicatePlayersInMatch constraintAnnotation) {

    }

    @Override
    public boolean isValid(MatchDTO matchDTO, ConstraintValidatorContext context) {
        Map<Long, Boolean> isAddedToPlayerList = new HashMap<>();
        for(PlayerDTO playerDTO: matchDTO.getTeam1DTO().getPlayers()){
            if(isAddedToPlayerList.containsKey(playerDTO.getPersonId()))
                return false;
            isAddedToPlayerList.put(playerDTO.getPersonId(),true);
        }

        for(PlayerDTO playerDTO: matchDTO.getTeam2DTO().getPlayers()){
            if(isAddedToPlayerList.containsKey(playerDTO.getPersonId()))
                return false;
            isAddedToPlayerList.put(playerDTO.getPersonId(),true);
        }
        return true;
    }
}
