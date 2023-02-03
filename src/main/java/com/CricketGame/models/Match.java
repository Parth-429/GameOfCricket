package com.cricketGame.models;

import lombok.Data;

@Data
public class Match {
    private Team team1, team2;
    private final int overs;
    private Team winner;
    public Match(Team team1, Team team2, int overs){
        this.team1 = team1;
        this.team2 = team2;
        this.overs = overs;
    }
    public void swap(){
        Team temp = this.team1;
        this.team1 = this.team2;
        this.team2 = temp;
    }
}
