package com.cricketGame.services.daoServices;

import com.cricketGame.dto.TeamDTO;
import com.cricketGame.dtoMappers.TeamMapper;
import com.cricketGame.models.Team;
import com.cricketGame.models.enums.Role;
import com.cricketGame.models.player.Player;
import com.cricketGame.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TeamMapper teamMapper;
    public Team saveTeam(TeamDTO teamDTO){
        Team team = teamMapper.toTeam(teamDTO);
        return this.teamRepository.save(team);
    }
    public void savePlayerStats(Team team){
        for(Player player: team.getPlayers()){
            if(Role.BOWLER.equals(player.getRole()))
                player.setBatsmanOrderNo(player.getBatsmanOrderNo()-100);
           //AllService.playerService.savePlayer(player);
        }
    }
    public Team findTeamById(Long id){
        return this.teamRepository.findById(id).get();
    }
}
