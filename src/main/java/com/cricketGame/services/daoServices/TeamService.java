package com.cricketGame.services.daoServices;

import com.cricketGame.models.Team;
import com.cricketGame.models.enums.Role;
import com.cricketGame.models.player.Player;
import com.cricketGame.models.stats.BatsmanStats;
import com.cricketGame.models.stats.BowlerStats;
import com.cricketGame.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;
    public void saveTeam(Team team){
        this.teamRepository.save(team);
    }
    public void savePlayerStats(Team team){
        for(Player player: team.getPlayers()){
            if(Role.BOWLER.equals(player.getRole()))
                player.setBatsmanOrderNo(player.getBatsmanOrderNo()-100);
            AllService.playerService.savePlayer(player);
        }
    }
}
