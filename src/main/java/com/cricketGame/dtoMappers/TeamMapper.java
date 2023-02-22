package com.cricketGame.dtoMappers;

import com.cricketGame.dto.PlayerDTO;
import com.cricketGame.dto.TeamDTO;
import com.cricketGame.models.TeamHistory;
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

    public TeamDTO toDto(TeamHistory team){
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamSize(team.getTeamSize());
        return teamDTO;
    }

    public TeamHistory toTeam(TeamDTO teamDTO){
        Team _team = AllService._teamService.findTeamById(teamDTO.getTeamId());
        int teamSize = teamDTO.getTeamSize();
        System.out.println(teamSize);
        Long teamID = ObjectIDGenerator.getID();
        List<Player> players = new ArrayList<>();
        for(PlayerDTO player: teamDTO.getPlayers()){
            players.add(AllService.playerService.savePlayer(player));
        }
        Collections.sort(players, Comparator.comparingInt(Player::getBatsmanOrderNo));
        return new TeamHistory(teamID, _team, players, teamSize);
    }
}
