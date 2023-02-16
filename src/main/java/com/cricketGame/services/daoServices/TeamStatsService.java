package com.cricketGame.services.daoServices;

import com.cricketGame.models.innings.Wicket;
import com.cricketGame.models.stats.TeamStats;
import com.cricketGame.repository.TeamStatsRepository;
import com.cricketGame.repository.WicketRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class TeamStatsService {
    @Autowired
    private TeamStatsRepository teamStatsRepository;

    public void saveTeamStats(TeamStats teamStats){
        this.teamStatsRepository.save(teamStats);
    }
}
