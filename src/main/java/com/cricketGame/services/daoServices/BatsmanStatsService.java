package com.cricketGame.services.daoServices;

import com.cricketGame.models.stats.BatsmanStats;
import com.cricketGame.repository.BatsmanStatsRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Data
@Service
public class BatsmanStatsService {
    private final BatsmanStatsRepository batsmanStatsRepository;
    @Autowired
    public BatsmanStatsService(BatsmanStatsRepository batsmanStatsRepository) {
        this.batsmanStatsRepository = batsmanStatsRepository;
    }
    public void saveBatsmanStats(BatsmanStats batsmanStats){
        this.batsmanStatsRepository.save(batsmanStats);
    }
}
