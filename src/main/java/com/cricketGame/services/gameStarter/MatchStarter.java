package com.cricketGame.services.gameStarter;

import com.cricketGame.models.*;
import com.cricketGame.models.enums.Coin;
import com.cricketGame.models.innings.Innings;
import com.cricketGame.models.stats.TeamStats;
import com.cricketGame.services.daoServices.AllService;
import com.cricketGame.services.generators.CoinTosser;
import com.cricketGame.services.factory.MatchFactory;
import com.cricketGame.view.ShowScoreCard;
import lombok.Data;

import static com.cricketGame.services.gameStarter.InningStarter.playInning;

@Data

public class MatchStarter {

    public static void startGame(Long id) {
        Match match = MatchFactory.create(id);
        if (CoinTosser.tossCoin().equals(Coin.HEAD)) {
            match.swap();
        }
        System.out.println(match.getTeam1().getName() + " won the toss and decided to Bat First:");
        System.out.println("\nInning one is started...");

        Innings firstInning = match.addNewInnings(new Innings(match.getTeam1(), match.getTeam2()));
        int firstInningScore = playInning(firstInning.getBattingTeam(), firstInning.getBowlingTeam(),
                firstInning, false);
        System.out.println(firstInning.getBattingTeam().getName() + " has Scored " + firstInningScore + " by losing " +
                           ((TeamStats) firstInning.getBattingTeam().getTeamStats()).getTotalWickets() + " wickets.");
        System.out.println("\nInning two is started and Target is " + (firstInningScore + 1) + " ...");

        Innings secondInning = match.addNewInnings(new Innings(match.getTeam2(), match.getTeam1()));
        int secondInningScore = playInning(secondInning.getBattingTeam(), secondInning.getBowlingTeam(),
                secondInning, true);
        System.out.println(
                secondInning.getBattingTeam().getName() + " has Scored " + secondInningScore + " by losing " +
                ((TeamStats) secondInning.getBattingTeam().getTeamStats()).getTotalWickets() + " wickets.");
        ShowScoreCard.showScoreCard(match);
        AllService.matchService.updateMatch(match);
    }

}
