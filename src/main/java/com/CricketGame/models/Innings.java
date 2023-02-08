package com.cricketGame.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Innings {
    private final Team battingTeam;
    private final Team bowlingTeam;
    private ScoreCard inningScoreCard;
    public Innings(Team battingTeam, Team bowlingTeam, int overs){
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.inningScoreCard = new ScoreCard(overs);
    }
}
