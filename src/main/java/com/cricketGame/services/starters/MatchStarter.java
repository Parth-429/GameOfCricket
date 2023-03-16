package com.cricketGame.services.starters;

import com.cricketGame.models.beans.Match;
import com.cricketGame.models.enums.Coin;
import com.cricketGame.models.beans.Innings;
import com.cricketGame.models.stats.TeamStats;
import com.cricketGame.services.generators.CoinTosser;
import com.cricketGame.view.ScoreCard;
import lombok.Data;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@UtilityClass
public class MatchStarter {

    public String startGame(Match match) {
        Coin tossResult = CoinTosser.tossCoin();
        if (Coin.HEAD.equals(tossResult)) {
            match.swap();
        }
        String result = "";
        result += match.getTeam1().getName() + " won the toss and decided to Bat First:" + "\n";
        result += ("\nInning one is started...")+ "\n";


        Innings firstInning = match.addNewInnings(new Innings(match.getTeam1(), match.getTeam2()));
        int firstInningScore = InningStarter.playInning(firstInning.getBattingTeam(), firstInning.getBowlingTeam(),
                firstInning, false);
        result += (firstInning.getBattingTeam().getName() + " has Scored " + firstInningScore + " by losing " +
                           ((TeamStats) firstInning.getBattingTeam().getTeamStats()).getTotalWickets() + " wickets.") + "\n";

        result += ("\nInning two is started and Target is " + (firstInningScore + 1) + " ...") + "\n";

        Innings secondInning = match.addNewInnings(new Innings(match.getTeam2(), match.getTeam1()));
        int secondInningScore = InningStarter.playInning(secondInning.getBattingTeam(), secondInning.getBowlingTeam(),
                secondInning, true);
        result += (
                secondInning.getBattingTeam().getName() + " has Scored " + secondInningScore + " by losing " +
                ((TeamStats) secondInning.getBattingTeam().getTeamStats()).getTotalWickets() + " wickets.") + "\n";
        result += ScoreCard.showScoreCard(match);
        return result;
    }

}
