package com.cricketGame.view;

import com.cricketGame.models.beans.team.TeamHistory;
import com.cricketGame.models.enums.PlayerBattingStatus;
import com.cricketGame.models.beans.Innings;
import com.cricketGame.models.beans.player.Player;
import com.cricketGame.models.stats.BatsmanStats;
import com.cricketGame.models.stats.BowlerStats;
import com.cricketGame.view.showStats.BallingStats;
import com.cricketGame.view.showStats.BattingStats;
import com.cricketGame.view.showStats.TeamBattingInningStatus;
import lombok.experimental.UtilityClass;

@UtilityClass
public class InningsDetails {
    public static String showInningsDetails(Innings innings){
        String result = "";
        TeamHistory battingTeam = innings.getBattingTeam();
        TeamHistory bowlingTeam = innings.getBowlingTeam();
        result += ("Batting Summary : "+ battingTeam.getName()) + "\n";
        result += ("\nPlayer         \t\tRuns\tBalls\tSix\tFour") + "\n";
        for(Player player: battingTeam.getPlayers()) {
            if (((BatsmanStats)(player.getBatsmanStats())).getBattingStatus().equals(PlayerBattingStatus.NOT_BAT_YET)) {
                continue;
            }
            result += (BattingStats.showStats(player)) + "\n";
        }
        result += (TeamBattingInningStatus.showStats(battingTeam)) + "\n";
        result += ("Bowling Summary : "+bowlingTeam.getName()) + "\n";
        result += ("\nPlayer        \t\tOvers\tRuns\tWickets") + "\n";
        for(Player player: bowlingTeam.getPlayers()) {
            if (player.getRole().equals("Batsman") || ((BowlerStats)player.getBowlerStats()).getNoOfBallsThrown()==0)
                continue;
            result += (BallingStats.showStats(player)) + "\n";
        }
        return result;
    }
}
