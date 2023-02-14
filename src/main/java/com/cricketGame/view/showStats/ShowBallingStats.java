package com.cricketGame.view.showStats;

import com.cricketGame.models.Player;
import com.cricketGame.models.stats.BowlerStats;

public class ShowBallingStats{
    public static String showStats(Player bowler) {
        String stats = String.format("%-15s", bowler.getFirstName() + " " + bowler.getLastName());
        BowlerStats bowlerstats = (BowlerStats) bowler.getBowlerStats();
        String overTaken = bowlerstats.getNoOfBallsThrown() / 6 + "." + bowlerstats.getNoOfBallsThrown()%6;
        stats += String.format("\t\t%5s\t%4d\t%7d",overTaken,bowlerstats.getTotalRunGiven(),bowlerstats.getTotalWicketsTaken());
        return stats;
    }
}
