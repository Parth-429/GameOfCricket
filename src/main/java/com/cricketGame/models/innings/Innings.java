package com.cricketGame.models.innings;

import com.cricketGame.models.ScoreCard;
import com.cricketGame.models.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Innings {
    private final Team battingTeam;
    private final Team bowlingTeam;
    private ScoreCard inningScoreCard;
    public Innings(Team battingTeam, Team bowlingTeam){
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.inningScoreCard = new ScoreCard();
    }
}