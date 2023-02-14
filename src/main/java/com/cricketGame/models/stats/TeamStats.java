package com.cricketGame.models.stats;

import com.cricketGame.models.enums.Runs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamStats implements Stats{
    private int totalScore;
    private String overs;
    private int totalWickets;
    public void updateStats(Runs runs){
        if(runs.equals(Runs.WICKET))
            totalWickets++;
        else
            totalScore+=runs.getRun();
    }
}
