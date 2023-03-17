package com.cricketGame.mappers;

import com.cricketGame.dto.PlayerDTO;
import com.cricketGame.dto.TeamDTO;
import com.cricketGame.models.beans.team.TeamHistory;
import com.cricketGame.models.beans.team.Team;
import com.cricketGame.models.beans.player.Player;
import com.cricketGame.services.daoServices.PlayerService;
import com.cricketGame.services.daoServices.TeamService;
import com.cricketGame.services.daoServicesImpl.PlayerServiceImpl;
import com.cricketGame.services.daoServicesImpl.TeamServiceImpl;
import com.cricketGame.services.generators.ObjectIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class TeamMapper {
    @Autowired
    private PlayerMapper playerMapper;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private TeamService teamService;

    public TeamDTO toTeamDto(TeamHistory team){
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamId(team.getId());
        teamDTO.setTeamSize(team.getTeamSize());
        List<PlayerDTO> playerDTOS = new ArrayList<>();
        for(Player player : team.getPlayers()){
            playerDTOS.add(playerMapper.toPlayerDto(player));
        }
        teamDTO.setPlayers(playerDTOS);
        return teamDTO;
    }

    public TeamHistory toTeam(TeamDTO teamDTO){
        Team team = teamService.findTeamById(teamDTO.getTeamId());
        int teamSize = teamDTO.getTeamSize();
        Long teamID = ObjectIDGenerator.getID();
        List<Player> players = new ArrayList<>();
        for(PlayerDTO player: teamDTO.getPlayers()){
            players.add(playerService.savePlayer(player));
        }
        players.sort(Comparator.comparingInt(Player::getBatsmanOrderNo));
        return new TeamHistory(teamID, team, players, teamSize);
    }
}
