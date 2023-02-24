package com.cricketGame.mappers;

import com.cricketGame.dto.PlayerDTO;
import com.cricketGame.models.enums.Role;
import com.cricketGame.models.beans.player.Batsman;
import com.cricketGame.models.beans.player.Bowler;
import com.cricketGame.models.beans.player.Person;
import com.cricketGame.models.beans.player.Player;
import com.cricketGame.services.daoServices.AllService;
import com.cricketGame.services.generators.ObjectIDGenerator;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {
    public PlayerDTO toPlayerDto(Player player){
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setPersonId(player.getPerson().getId());
        playerDTO.setRole(player.getRole().getDisplayValue());
        playerDTO.setBattingOrderNo(player.getBatsmanOrderNo());
        return playerDTO;
    }
    public Player toPlayer(PlayerDTO playerDTO){
        String role = playerDTO.getRole();
        int battingOrderNo = playerDTO.getBattingOrderNo();
        Person person = AllService.personService.findPersonById(playerDTO.getPersonId());
        Long playerID = ObjectIDGenerator.getID();
        if(Role.BOWLER.name().equalsIgnoreCase(role))
            return new Bowler(playerID, person, battingOrderNo);
        else
            return new Batsman(playerID,person, battingOrderNo);
    }
}
