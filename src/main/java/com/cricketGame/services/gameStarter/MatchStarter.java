package com.cricketGame.services.gameStarter;

import com.cricketGame.models.*;
import com.cricketGame.models.enums.Coin;
import com.cricketGame.models.innings.Innings;
import com.cricketGame.models.stats.TeamStats;
import com.cricketGame.services.daoServices.AllService;
import com.cricketGame.services.generators.CoinTosser;
import com.cricketGame.services.factory.MatchFactory;
import com.cricketGame.view.ScoreCard;
import lombok.Data;

import static com.cricketGame.services.gameStarter.InningStarter.playInning;

@Data

public class MatchStarter {

    public static String startGame(Long id) {
        Match match = MatchFactory.create(id);
        if (CoinTosser.tossCoin().equals(Coin.HEAD)) {
            match.swap();
        }
        String result = "";
        result += match.getTeam1().getName() + " won the toss and decided to Bat First:" + "\n";
        System.out.println(result);
        result += ("\nInning one is started...")+ "\n";
        System.out.println(result);

        Innings firstInning = match.addNewInnings(new Innings(match.getTeam1(), match.getTeam2()));
        int firstInningScore = playInning(firstInning.getBattingTeam(), firstInning.getBowlingTeam(),
                firstInning, false);
        result += (firstInning.getBattingTeam().getName() + " has Scored " + firstInningScore + " by losing " +
                           ((TeamStats) firstInning.getBattingTeam().getTeamStats()).getTotalWickets() + " wickets.") + "\n";
        System.out.println(result);
        result += ("\nInning two is started and Target is " + (firstInningScore + 1) + " ...") + "\n";
        System.out.println(result);

        Innings secondInning = match.addNewInnings(new Innings(match.getTeam2(), match.getTeam1()));
        int secondInningScore = playInning(secondInning.getBattingTeam(), secondInning.getBowlingTeam(),
                secondInning, true);
        result += (
                secondInning.getBattingTeam().getName() + " has Scored " + secondInningScore + " by losing " +
                ((TeamStats) secondInning.getBattingTeam().getTeamStats()).getTotalWickets() + " wickets.") + "\n";
        System.out.println(result);
        result += ScoreCard.showScoreCard(match);
        System.out.println(result);
        AllService.matchService.updateMatch(match);
        System.out.println(result);
        return result;
    }

}
