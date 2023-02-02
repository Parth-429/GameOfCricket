package com.CricketGame.Views;

import com.CricketGame.Entities.BatsmanHistory;
import com.CricketGame.Entities.Match;
import com.CricketGame.Entities.Player;

public class ShowScoreBoard {
    public void Show(Match match){
        System.out.println(match);
        System.out.println("1st Inning ScoreCard :\n");
        System.out.println(match.getTeam1().getName() + " Batting Summary:");
        for(Player player: match.getTeam1().getMatchWiseHistory(match.getMatch_id()).getPlayerList()){
            System.out.println(player.getName()+player.getBatsman().getMatchWiseHistory(match.getMatch_id()));
        }
        System.out.println(match.getTeam2().getName() + " Bowling Summary: ");
        for(Player player: match.getTeam2().getMatchWiseHistory(match.getMatch_id()).getPlayerList()){
            System.out.println(player.getName()+player.getBowler().getMatchWiseHistory(match.getMatch_id()));
        }

        System.out.println("\n2nd Inning ScoreCard :\n");
        System.out.println(match.getTeam2().getName() + " Batting Summary:");
        for(Player player: match.getTeam2().getMatchWiseHistory(match.getMatch_id()).getPlayerList()){
            System.out.println(player.getName()+player.getBatsman().getMatchWiseHistory(match.getMatch_id()));
        }
        System.out.println(match.getTeam1().getName() + " Bowling Summary: ");
        for(Player player: match.getTeam1().getMatchWiseHistory(match.getMatch_id()).getPlayerList()){
            System.out.println(player.getName()+player.getBowler().getMatchWiseHistory(match.getMatch_id()));
        }
    }
}
