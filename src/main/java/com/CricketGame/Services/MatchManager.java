package com.CricketGame.Services;

import com.CricketGame.Entities.Match;
import com.CricketGame.Entities.Player;
import com.CricketGame.Entities.ScoreCard;
import com.CricketGame.Entities.Team;

import java.util.ArrayList;
import java.util.Scanner;

public class MatchManager {
    private static Integer MATCH_NO = 0;
   public Match createMatch(){
       Integer match_id = MATCH_NO++;
       TeamManager TeamCreater = new TeamManager();
       Team T1 = TeamCreater.CreateNewTeam();
       Team T2 = TeamCreater.CreateNewTeam();
       T1.addMatchWiseHistory(match_id, (ArrayList<Player>) TeamCreater.ChoosePlayersAndSetOrderNumber(T1,match_id));
       T2.addMatchWiseHistory(match_id, (ArrayList<Player>) TeamCreater.ChoosePlayersAndSetOrderNumber(T2,match_id));
       System.out.println("How many over's match do you want be played? \n");
       Scanner sc = new Scanner(System.in);
       Integer overs = sc.nextInt();
       return new Match(match_id,T1,T2,overs,new ScoreCard(overs),new ScoreCard(overs));
   }
}
