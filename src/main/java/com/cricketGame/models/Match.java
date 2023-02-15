package com.cricketGame.models;

import com.cricketGame.models.innings.Innings;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "match_of_cricket")
public class Match extends Bean{
    @Transient
    private Team team1;
    @Transient
    private Team team2;
    private final int allowedTeamSize;
    @Transient
    private List<Innings> innings;
    @Transient
    private Team winner;
    public Match(long matchId, Team team1, Team team2, int allowedTeamSize){
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
