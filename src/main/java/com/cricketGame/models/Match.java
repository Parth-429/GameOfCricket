package com.cricketGame.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class Match {
    private long matchId;
    private Team team1, team2;
    private List<Innings> innings;
    private Team winner;
    public Match(long matchId, Team team1, Team team2){
        this.matchId = matchId;
        this.team1 = team1;
        this.team2 = team2;
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
