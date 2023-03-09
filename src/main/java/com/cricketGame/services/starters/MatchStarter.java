package com.cricketGame.services.starters;

import com.cricketGame.models.beans.Match;
import com.cricketGame.models.enums.Coin;
import com.cricketGame.models.beans.Innings;
import com.cricketGame.models.stats.TeamStats;
import com.cricketGame.services.generators.CoinTosser;
import com.cricketGame.view.ScoreCard;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class MatchStarter {
    @Autowired
    private CoinTosser coinTosser;
    @Autowired
    private InningStarter inningStarter;

    public String startGame(Match match) {
        if (coinTosser.tossCoin().equals(Coin.HEAD)) {
            match.swap();
        }
        String result = "";
        result += match.getTeam1().getName() + " won the toss and decided to Bat First:" + "\n";
        result += ("\nInning one is started...")+ "\n";


        Innings firstInning = match.addNewInnings(new Innings(match.getTeam1(), match.getTeam2()));
        int firstInningScore = inningStarter.playInning(firstInning.getBattingTeam(), firstInning.getBowlingTeam(),
                firstInning, false);
        result += (firstInning.getBattingTeam().getName() + " has Scored " + firstInningScore + " by losing " +
                           ((TeamStats) firstInning.getBattingTeam().getTeamStats()).getTotalWickets() + " wickets.") + "\n";

        result += ("\nInning two is started and Target is " + (firstInningScore + 1) + " ...") + "\n";

        Innings secondInning = match.addNewInnings(new Innings(match.getTeam2(), match.getTeam1()));
        int secondInningScore = inningStarter.playInning(secondInning.getBattingTeam(), secondInning.getBowlingTeam(),
                secondInning, true);
        result += (
                secondInning.getBattingTeam().getName() + " has Scored " + secondInningScore + " by losing " +
                ((TeamStats) secondInning.getBattingTeam().getTeamStats()).getTotalWickets() + " wickets.") + "\n";
        result += ScoreCard.showScoreCard(match);

        return result;
    }

}
