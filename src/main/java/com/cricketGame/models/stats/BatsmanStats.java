package com.cricketGame.models.stats;

import com.cricketGame.models.innings.Ball;
import com.cricketGame.models.enums.PlayerBattingStatus;
import com.cricketGame.models.enums.RunStatistics;
import com.cricketGame.models.enums.Runs;
import lombok.Data;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

@Data
public class BatsmanStats implements Stats{
    private int runsScoredByBatsman =0;
    private int ballPlayedByBatsman =0;
    private double strikeRate=0;
    private PlayerBattingStatus battingStatus = PlayerBattingStatus.NOT_BAT_YET;
    private HashMap<RunStatistics, Integer> runStatisticsHashMap;
    private Optional<Ball> wicketStats;
    public void updateStats(Runs runsTaken){
        this.battingStatus = PlayerBattingStatus.NOT_OUT;
        this.ballPlayedByBatsman++;
        if(Objects.isNull(this.runStatisticsHashMap)){
            this.runStatisticsHashMap = new HashMap<>();
            initializeHashMap();
        }

        if(Runs.WICKET.equals(runsTaken)) {
            battingStatus = PlayerBattingStatus.OUT;
        }
        else {
            this.runsScoredByBatsman += runsTaken.getRun();
            this.updateRunStatistics(runsTaken);
        }
    }

    private void initializeHashMap() {
        this.runStatisticsHashMap.put(RunStatistics.FOUR_RUNS,0);
        this.runStatisticsHashMap.put(RunStatistics.ONE_RUNS,0);
        this.runStatisticsHashMap.put(RunStatistics.THREE_RUNS,0);
        this.runStatisticsHashMap.put(RunStatistics.SIX_RUNS,0);
        this.runStatisticsHashMap.put(RunStatistics.DOT_BALLS,0);
        this.runStatisticsHashMap.put(RunStatistics.TWO_RUNS,0);
    }

    public void updateRunStatistics(Runs runsTaken){
            RunStatistics runConstant = RunStatistics.getRunStatisticConstant(runsTaken);
            this.runStatisticsHashMap.put(runConstant, runStatisticsHashMap.get(runConstant) + 1);
    }
}
