package com.cricketGame.models.stats;

import com.cricketGame.models.Bean;
import com.cricketGame.models.Team;
import com.cricketGame.models.enums.Runs;
import com.cricketGame.models.player.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team_stats")
@EqualsAndHashCode(callSuper=false)
public class TeamStats extends Bean implements Stats{
    private int totalScore;
    @OneToOne(targetEntity = Team.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;
    private String overs;
    private int totalWickets;
    public void updateStats(Runs runs){
        if(runs.equals(Runs.WICKET))
            totalWickets++;
        else
            totalScore+=runs.getRun();
    }
}
