package com.cricketGame.view.showStats;

import com.cricketGame.models.Match;
import com.cricketGame.models.stats.TeamStats;

public class ShowMatchStats{

    public static String showStats(Match match) {
        String result = "\nResult of Match:";
        int firstInningScore = ((TeamStats)(match.getInnings().get(0).getBattingTeam().getTeamStats())).getTotalScore();
        int secondInningScore = ((TeamStats)(match.getInnings().get(1).getBattingTeam().getTeamStats())).getTotalScore();
        if (firstInningScore > secondInningScore) {
            result += String.format("\nTeam %s won by %d runs%n", match.getInnings().get(0).getBattingTeam().getName(), firstInningScore - secondInningScore);
            match.setWinner(match.getInnings().get(0).getBattingTeam());
        } else if (firstInningScore < secondInningScore) {
            result += String.format("\nTeam %s won by %d wickets%n", match.getInnings().get(1).getBattingTeam().getName(), match.getInnings().get(1).getBattingTeam().getTeamSize() - ((TeamStats) match.getInnings().get(1).getBattingTeam().getTeamStats()).getTotalWickets());
            match.setWinner(match.getInnings().get(1).getBattingTeam());
        } else
            result += ("\nMatch has been Tied");
        return result;
    }
}
