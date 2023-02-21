package com.cricketGame.view;

import com.cricketGame.models.*;
import com.cricketGame.models.enums.PlayerBattingStatus;
import com.cricketGame.models.innings.Innings;
import com.cricketGame.models.player.Player;
import com.cricketGame.models.stats.BatsmanStats;
import com.cricketGame.models.stats.BowlerStats;
import com.cricketGame.view.showStats.ShowBallingStats;
import com.cricketGame.view.showStats.ShowBattingStats;
import com.cricketGame.view.showStats.ShowTeamBattingInningStatus;


public class ShowInningsDetails {
    public static String showInningsDetails(Innings innings){
        String result = "";
        Team battingTeam = innings.getBattingTeam();
        Team bowlingTeam = innings.getBowlingTeam();
        result += ("Batting Summary : "+ battingTeam.getName()) + "\n";
        result += ("\nPlayer         \t\tRuns\tBalls\tSix\tFour") + "\n";
        for(Player player: battingTeam.getPlayers()) {
            if (((BatsmanStats)(player.getBatsmanStats())).getBattingStatus().equals(PlayerBattingStatus.NOT_BAT_YET)) {
                continue;
            }
            result += (ShowBattingStats.showStats(player)) + "\n";
        }
        result += (ShowTeamBattingInningStatus.showStats(battingTeam)) + "\n";
        result += ("Bowling Summary : "+bowlingTeam.getName()) + "\n";
        result += ("\nPlayer        \t\tOvers\tRuns\tWickets") + "\n";
        for(Player player: bowlingTeam.getPlayers()) {
            if (player.getRole().equals("Batsman") || ((BowlerStats)player.getBowlerStats()).getNoOfBallsThrown()==0)
                continue;
            result += (ShowBallingStats.showStats(player)) + "\n";
        }
        return result;
    }
}
