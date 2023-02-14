package com.cricketGame.models;

import com.cricketGame.models.innings.Innings;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public class Match extends Bean{
    private Team team1, team2;
    private final int allowedTeamSize;
    private List<Innings> innings;
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
