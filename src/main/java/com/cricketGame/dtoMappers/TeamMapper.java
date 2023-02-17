package com.cricketGame.dtoMappers;

import com.cricketGame.dto.TeamDTO;
import com.cricketGame.models.Team;
import com.cricketGame.models.player.Player;
import com.cricketGame.services.daoServices.AllService;
import com.cricketGame.services.generators.ObjectIDGenerator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class TeamMapper {

    public TeamDTO toDto(Team team){
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setName(team.getName());
        teamDTO.setTeamSize(team.getTeamSize());
        List<Long> playerIds = new ArrayList<>();
        for(Player player: team.getPlayers()){
            playerIds.add(player.getId());
        }
        teamDTO.setPlayerIds(playerIds);
        return teamDTO;
    }

    public Team toTeam(TeamDTO teamDTO){
        String teamName = teamDTO.getName();
        int teamSize = teamDTO.getTeamSize();
        long teamID = ObjectIDGenerator.getID();
        List<Player> players = new ArrayList<>();
        for(Long id:teamDTO.getPlayerIds()){
            players.add(AllService.playerService.findPlayerById(id));
        }
        Collections.sort(players, Comparator.comparingInt(Player::getBatsmanOrderNo));
        return new Team(teamID, teamName, players, teamSize);
    }
}
