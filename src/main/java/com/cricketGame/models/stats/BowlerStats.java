package com.cricketGame.models.stats;

import com.cricketGame.models.Bean;
import com.cricketGame.models.enums.RunStatistics;
import com.cricketGame.models.enums.Runs;
import com.cricketGame.models.player.Player;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;

@Data
@Entity
@Table(name = "bowler_stats")
@EqualsAndHashCode(callSuper=false)
public class BowlerStats extends Bean implements Stats{
    @OneToOne(targetEntity = Player.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;
    private int totalRunGiven;
    private int noOfBallsThrown;
    private int totalWicketsTaken;
    @Transient
    private HashMap<RunStatistics, Integer> runsGivenStatisticsHashMap;
    public void updateStats(Runs runsGiven){
        if(runsGiven.equals(Runs.WICKET))
            totalWicketsTaken++;
        else
            totalRunGiven+=runsGiven.getRun();
        noOfBallsThrown++;
        updateRunStatistics(runsGiven);
    }
    public void updateRunStatistics(Runs runsGiven){
        RunStatistics runConstant = RunStatistics.getRunStatisticConstant(runsGiven);
        if(this.runsGivenStatisticsHashMap==null)
            this.runsGivenStatisticsHashMap = new HashMap<>();
        this.runsGivenStatisticsHashMap.putIfAbsent(runConstant,0);
        this.runsGivenStatisticsHashMap.put(runConstant,runsGivenStatisticsHashMap.get(runConstant)+1);
    }
}
