package com.cricketGame.models.stats;

import com.cricketGame.models.Ball;
import com.cricketGame.models.enums.PlayerBattingStatus;
import com.cricketGame.models.enums.RunStatistics;
import com.cricketGame.models.enums.Runs;
import lombok.Data;

import java.util.HashMap;
import java.util.Optional;

@Data
public class BatsmanStats implements Stats{
    private int totalRunScored=0;
    private int ballTaken=0;
    private double strikeRate=0;
    private PlayerBattingStatus battingStatus = PlayerBattingStatus.NOT_BAT_YET;
    private HashMap<RunStatistics, Integer> runTakenStatisticsHashMap;
    private Optional<Ball> wicketStats;
    public void updateStats(Runs runsTaken){
        this.battingStatus = PlayerBattingStatus.NOT_OUT;
        this.ballTaken++;
        if(this.runTakenStatisticsHashMap==null) {
            this.runTakenStatisticsHashMap = new HashMap<>();
            this.runTakenStatisticsHashMap.put(RunStatistics.FOUR_RUNS,0);
            this.runTakenStatisticsHashMap.put(RunStatistics.ONE_RUNS,0);
            this.runTakenStatisticsHashMap.put(RunStatistics.THREE_RUNS,0);
            this.runTakenStatisticsHashMap.put(RunStatistics.SIX_RUNS,0);
            this.runTakenStatisticsHashMap.put(RunStatistics.DOT_BALLS,0);
            this.runTakenStatisticsHashMap.put(RunStatistics.TWO_RUNS,0);
        }

        if(runsTaken.equals(Runs.WICKET)) {
            battingStatus = PlayerBattingStatus.OUT;
        }
        else {
            this.totalRunScored += runsTaken.getRun();
            this.updateRunStatistics(runsTaken);
        }
    }
    public void updateRunStatistics(Runs runsTaken){
            RunStatistics runConstant = RunStatistics.getRunStatisticConstant(runsTaken);
            this.runTakenStatisticsHashMap.put(runConstant, runTakenStatisticsHashMap.get(runConstant)+1);
    }
}
