package com.cricketGame.view;

import com.cricketGame.models.Match;
import com.cricketGame.view.showStats.ShowMatchStats;

public class ShowScoreCard {
    public static void showScoreCard(Match match){
        System.out.println("\n Scorecard :\n");
        System.out.println("1st Inning Summary :");
        ShowInningsDetails.showInningsDetails(match.getInnings().get(0));
        System.out.println("\n\n2nd Inning Summary :");
        ShowInningsDetails.showInningsDetails(match.getInnings().get(1));
        System.out.println(ShowMatchStats.showStats(match));
    }
}
