package com.cricketGame.models.stats;

import com.cricketGame.models.beans.Bean;
import com.cricketGame.models.enums.RunStatistics;
import com.cricketGame.models.enums.Runs;
import com.cricketGame.models.beans.player.Player;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Objects;

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
        if(Runs.WICKET.equals(runsGiven))
            totalWicketsTaken++;
        else
            totalRunGiven+=runsGiven.getRun();
        noOfBallsThrown++;
        updateRunStatistics(runsGiven);
    }
    public void updateRunStatistics(Runs runsGiven){
        RunStatistics runConstant = RunStatistics.getRunStatisticConstant(runsGiven);
        if(Objects.isNull(this.runsGivenStatisticsHashMap))
            this.runsGivenStatisticsHashMap = new HashMap<>();
        this.runsGivenStatisticsHashMap.putIfAbsent(runConstant,0);
        this.runsGivenStatisticsHashMap.put(runConstant,runsGivenStatisticsHashMap.get(runConstant)+1);
    }
}
