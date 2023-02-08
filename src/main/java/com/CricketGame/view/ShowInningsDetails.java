package com.cricketGame.view;

import com.cricketGame.models.*;
import com.cricketGame.models.enums.PlayerStatusInBattingInning;
import com.cricketGame.models.stats.BatsmanStats;
import com.cricketGame.models.stats.BowlerStats;
import com.cricketGame.view.showStats.ShowBallingStats;
import com.cricketGame.view.showStats.ShowBattingStats;
import com.cricketGame.view.showStats.ShowTeamBattingInningStatus;


public class ShowInningsDetails {
    public static void showInningsDetails(Innings innings){
        Team battingTeam = innings.getBattingTeam();
        Team bowlingTeam = innings.getBowlingTeam();
        System.out.println("Batting Summary : "+ battingTeam.getName());
        System.out.println("\nPlayer         \t\tRuns\tBalls\tSix\tFour");
        for(Player player: battingTeam.getPlayers()) {
            if (((BatsmanStats)(player.getBatsmanStats())).getBattingStatus().equals(PlayerStatusInBattingInning.NOT_BATTED_YET)) {
                continue;
            }
            System.out.println(ShowBattingStats.showStats(player));
        }
        System.out.println(ShowTeamBattingInningStatus.showStats(battingTeam));
        System.out.println();
        System.out.println("Bowling Summary : "+bowlingTeam.getName());
        System.out.println("\nPlayer        \t\tOvers\tRuns\tWickets");
        for(Player player: bowlingTeam.getPlayers()) {
            if (player.getRole().equals("Batsman") || ((BowlerStats)player.getBowlerStats()).getNoOfBallsThrown()==0)
                continue;
            System.out.println(ShowBallingStats.showStats(player));
        }
    }
}
