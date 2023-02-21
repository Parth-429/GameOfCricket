package com.cricketGame.models.beans;

import com.cricketGame.models.Bean;
import com.cricketGame.models.Team;
import com.cricketGame.models.innings.Innings;
import com.cricketGame.models.stats.TeamStats;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "match_of_cricket")
@NoArgsConstructor
public class Match extends Bean {
    @OneToOne(targetEntity = com.cricketGame.models.Team.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "team1_id", referencedColumnName = "id")
    private com.cricketGame.models.Team team1;
    @OneToOne(targetEntity = com.cricketGame.models.Team.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "team2_id", referencedColumnName = "id")
    private com.cricketGame.models.Team team2;
    private int allowedTeamSize;

    @OneToMany(targetEntity = Innings.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "match_id", referencedColumnName = "id")
    private List<Innings> innings;
    @OneToOne(targetEntity = com.cricketGame.models.Team.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "winner", referencedColumnName = "id")
    private com.cricketGame.models.Team winner;
    public Match(long matchId, com.cricketGame.models.Team team1, com.cricketGame.models.Team team2, int allowedTeamSize){
        super(matchId);
        this.team1 = team1;
        this.team2 = team2;
        this.allowedTeamSize = allowedTeamSize;
        this.innings = new ArrayList<>();
    }
    public void swap(){
        Team temp = this.team1;
        this.team1 = this.team2;
        this.team2 = temp;
    }

    public Innings addNewInnings(Innings inning){
        this.innings.add(inning);
        return inning;
    }
}
