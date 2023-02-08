package com.cricketGame.services;

import com.cricketGame.models.*;
import com.cricketGame.models.enums.Coin;
import com.cricketGame.models.stats.TeamStats;
import com.cricketGame.services.objectCreation.MatchFactory;
import com.cricketGame.view.ShowScoreCard;

import static com.cricketGame.services.StartInning.playInning;


public class GameLauncher {

    public static void startGame() {
        Match match = MatchFactory.create(ObjectIDGenerator.getID());
        TossCoin toss = new TossCoin();
        if (toss.tossCoin().equals(Coin.HEAD))
            match.swap();
        System.out.println(match.getTeam1().getName() + " won the toss and decided to Bat First:");
        System.out.println("\nInning one is started...");

        Innings firstInning = match.addNewInnings(new Innings(match.getTeam1(), match.getTeam2(), match.getOvers()));
        int firstInningScore = playInning(firstInning.getBattingTeam(), firstInning.getBowlingTeam(), firstInning.getInningScoreCard(), false);
        System.out.println(firstInning.getBattingTeam().getName() + " has Scored " + firstInningScore + " by losing " + ((TeamStats)firstInning.getBattingTeam().getTeamStats()).getTotalWickets() + " wickets.");
        System.out.println("\nInning two is started and Target is " + (firstInningScore + 1) + " ...");

        Innings secondInning = match.addNewInnings(new Innings(match.getTeam2(), match.getTeam1(), match.getOvers()));
        int secondInningScore = playInning(secondInning.getBattingTeam(), secondInning.getBowlingTeam(), secondInning.getInningScoreCard(), true);
        System.out.println(secondInning.getBattingTeam().getName() + " has Scored " + secondInningScore + " by losing " + ((TeamStats)secondInning.getBattingTeam().getTeamStats()).getTotalWickets() + " wickets.");
        ShowScoreCard.showScoreCard(match);
    }

}
