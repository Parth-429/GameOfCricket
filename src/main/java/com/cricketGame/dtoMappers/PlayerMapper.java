package com.cricketGame.dtoMappers;

import com.cricketGame.constants.Constants;
import com.cricketGame.dto.PlayerDTO;
import com.cricketGame.models.player.Batsman;
import com.cricketGame.models.player.Bowler;
import com.cricketGame.models.player.Person;
import com.cricketGame.models.player.Player;
import com.cricketGame.services.daoServices.AllService;
import com.cricketGame.services.generators.ObjectIDGenerator;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {
    public PlayerDTO toDto(Player player){
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setPersonId(player.getPerson().getId());
        playerDTO.setRole(player.getRole().getRoleOfPlayer());
        playerDTO.setBattingOrderNo(player.getBatsmanOrderNo());
        return playerDTO;
    }
    public Player toPlayer(PlayerDTO playerDTO){
        String role = playerDTO.getRole();
        int battingOrderNo = playerDTO.getBattingOrderNo();
        Person person = AllService.personService.findPersonById(playerDTO.getPersonId());
        Long playerID = ObjectIDGenerator.getID();
        if(Constants.BOWLING_ROLE.equals(role))
            return new Bowler(playerID, person, battingOrderNo);
        else
            return new Batsman(playerID,person, battingOrderNo);
    }
}
