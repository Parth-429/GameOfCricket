package com.cricketGame.view.showStats;

import com.cricketGame.models.TeamHistory;
import com.cricketGame.models.stats.TeamStats;

public class TeamBattingInningStatus {
    public static String showStats(TeamHistory team) {
        String stats = String.format("%-15s:",team.getName());
        TeamStats teamStats = (TeamStats) team.getTeamStats();
        stats += String.format("Total Score = %d/%d, Overs: %s%n",teamStats.getTotalScore(), teamStats.getTotalWickets(), teamStats.getOvers());
        return stats;
    }
}
