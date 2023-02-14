package com.cricketGame.view.showStats;

import com.cricketGame.models.Player;
import com.cricketGame.models.enums.PlayerBattingStatus;
import com.cricketGame.models.enums.RunStatistics;
import com.cricketGame.models.stats.BatsmanStats;

public class ShowBattingStats{
    public static String showStats(Player batsman) {
        String nameOfBatsman = String.format("%-15s", batsman.getFirstName() + " " + batsman.getLastName());
        BatsmanStats batsmanStats = (BatsmanStats) batsman.getBatsmanStats();
        String stats = String.format("\t\t%4d\t%4d\t%3d\t%4d",batsmanStats.getTotalRunScored(),batsmanStats.getBallTaken(),batsmanStats.getRunTakenStatisticsHashMap().get(RunStatistics.SIX_RUNS),batsmanStats.getRunTakenStatisticsHashMap().get(RunStatistics.FOUR_RUNS));
        if(batsmanStats.getBattingStatus().equals(PlayerBattingStatus.OUT) && batsmanStats.getWicketStats().isPresent())
            stats = nameOfBatsman + stats + String.format("\n(%s)", batsmanStats.getWicketStats().get().getCheckWicket().get().getWicketType().getWicketType() + " by "  + batsmanStats.getWicketStats().get().getBowler().getFirstName() + " " + batsmanStats.getWicketStats().get().getBowler().getLastName() );
        else if(batsmanStats.getBattingStatus().equals(PlayerBattingStatus.NOT_OUT))
            stats = nameOfBatsman + stats + "\n(Not out)";
        return stats;
    }
}
