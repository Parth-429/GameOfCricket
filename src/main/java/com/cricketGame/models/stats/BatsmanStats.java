package com.cricketGame.models.stats;

import com.cricketGame.models.beans.Bean;
import com.cricketGame.models.beans.Ball;
import com.cricketGame.models.enums.PlayerBattingStatus;
import com.cricketGame.models.enums.RunStatistics;
import com.cricketGame.models.enums.Runs;
import com.cricketGame.models.beans.player.Player;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Data
@Entity
@Table(name = "batsman_stats")
@EqualsAndHashCode(callSuper=false)
public class BatsmanStats extends Bean implements Stats {
    @OneToOne(targetEntity = Player.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;
    private int runsScoredByBatsman =0;
    private int ballPlayedByBatsman =0;
    private double strikeRate=0;
    @Enumerated(EnumType.STRING)
    private PlayerBattingStatus battingStatus = PlayerBattingStatus.NOT_BAT_YET;

    @ElementCollection
    @CollectionTable(name = "run_statistics",
                     joinColumns = { @JoinColumn(name = "id") })
    @MapKeyEnumerated(EnumType.ORDINAL)
    @MapKeyColumn(name = "run")
    @Column(name = "frequency")
    private Map<RunStatistics, Integer> runStatisticsHashMap;

    @Transient
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
