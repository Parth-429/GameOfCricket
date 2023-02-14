package com.cricketGame.models.innings;

import com.cricketGame.models.Bean;
import com.cricketGame.models.ScoreCard;
import com.cricketGame.models.Team;
import com.cricketGame.services.generators.ObjectIDGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
public class Innings extends Bean {
    private final Team battingTeam;
    private final Team bowlingTeam;
    private ScoreCard inningScoreCard;
    public Innings(Team battingTeam, Team bowlingTeam){
        this.setId(ObjectIDGenerator.getID());
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.inningScoreCard = new ScoreCard();
    }
}
