package com.cricketGame.dtoMappers;

import com.cricketGame.constants.Constants;
import com.cricketGame.dto.PlayerDTO;
import com.cricketGame.models.player.Batsman;
import com.cricketGame.models.player.Bowler;
import com.cricketGame.models.player.Player;
import com.cricketGame.services.generators.ObjectIDGenerator;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {
    public PlayerDTO toDto(Player player){
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setFirstName(player.getFirstName());
        playerDTO.setLastName(player.getLastName());
        playerDTO.setAge(player.getAge());
        playerDTO.setRole(player.getRole().getRoleOfPlayer());
        playerDTO.setBattingOrderNo(player.getBatsmanOrderNo());
        return playerDTO;
    }

    public Player toPlayer(PlayerDTO playerDTO){
        String firstName = playerDTO.getFirstName();
        String lastName = playerDTO.getLastName();
        String role = playerDTO.getRole();
        int age = playerDTO.getAge();
        int battingOrderNo = playerDTO.getBattingOrderNo();
        long playerID = ObjectIDGenerator.getID();
        if(Constants.BOWLING_ROLE.equals(role))
            return new Bowler(playerID, firstName, lastName, age, battingOrderNo);
        else
            return new Batsman(playerID, firstName, lastName, age, battingOrderNo);
    }
}
