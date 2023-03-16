package com.cricketGame.view;

import com.cricketGame.models.beans.Match;
import com.cricketGame.view.showStats.MatchStats;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;

@UtilityClass
public class ScoreCard {
    public String showScoreCard(Match match){
        String result = "";
        result += ("\n Scorecard :\n") + "\n";
        result += ("1st Inning Summary :") + "\n";
        result += InningsDetails.showInningsDetails(match.getInnings().get(0)) + "\n";
        result += ("\n\n2nd Inning Summary :") + "\n";
        result += InningsDetails.showInningsDetails(match.getInnings().get(1)) + "\n";
        result += (MatchStats.showStats(match)) + "\n";
        return result;
    }
}
