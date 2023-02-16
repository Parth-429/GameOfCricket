package com.cricketGame.services.daoServices;

import com.cricketGame.models.stats.BatsmanStats;
import com.cricketGame.models.stats.BowlerStats;
import com.cricketGame.repository.BowlingStatsRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class BowlingStatsService {
    @Autowired
    private BowlingStatsRepository bowlingStatsRepository;
    public void saveBowlerStats(BowlerStats bowlerStats){
        this.bowlingStatsRepository.save(bowlerStats);
    }
}
