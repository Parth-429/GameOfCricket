package com.cricketGame.models.stats;

import com.cricketGame.models.enums.Runs;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team_stats")
public class TeamStats implements Stats{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
