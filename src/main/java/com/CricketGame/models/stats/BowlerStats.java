package com.cricketGame.models.stats;

import com.cricketGame.models.enums.RunStatistics;
import com.cricketGame.models.enums.Runs;
import lombok.Data;

import java.util.HashMap;

@Data
public class BowlerStats implements Stats{
    private int totalRunGiven;
    private int noOfBallsThrown;
    private int totalWicketsTaken;
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
