package com.CricketGame.Services;

import com.CricketGame.Entities.*;
import com.CricketGame.Views.ShowScoreBoard;

import java.util.ArrayList;
import java.util.Random;


public class Game {
    public void Start(){
        MatchManager matchCreater = new MatchManager();
        Match match = matchCreater.createMatch();
        TossCoin toss = new TossCoin();
        if(toss.TossTheCoin().equals(Coin.Head))
            match.swap();
        Integer FirstInning = PlayInning(match, match.getTeam1(), match.getTeam2(), false, match.getFirstInningScoreCard());
        Integer SecondInning = PlayInning(match, match.getTeam2(), match.getTeam1(), true, match.getFirstInningScoreCard());
        if(FirstInning>=SecondInning)
            match.setWinner(match.getTeam1());
        else
            match.setWinner(match.getTeam2());
        ShowScoreBoard show = new ShowScoreBoard();
        show.Show(match);
    }

    public Integer PlayInning(Match Match, Team T1, Team T2, Boolean isSecondInning, ScoreCard sc){
        TeamHistory team1History = T1.getMatchWiseHistory(Match.getMatch_id());
        ArrayList<Player> players = (ArrayList<Player>) team1History.getPlayerList();
        Integer overs = Match.getOvers();
        ArrayList<Player> Played = new ArrayList<>();
        Player bowler = null;
        Player Striker = addPlayer(players,Played);
        Player NonStriker = addPlayer(players,Played);
        Boolean isAllOut = false;
        GenerateRuns runGenerator = new GenerateRuns();
        Integer Target = Integer.MAX_VALUE;

        if(isSecondInning) Target = T2.getMatchWiseHistory(Match.getMatch_id()).getTotalRuns();

        for(Over over : sc.getScoreCard()){
            bowler = chooseBowler(bowler,T2);
            over.setBowler(bowler);
            for(int ball=0; ball<6; ball++)
            {
                BallStatus score = runGenerator.generateRun();
                over.addBall(score);
                if(score.equals(BallStatus.Wicket)) {
                    team1History.IncrementWickets();
                    Striker = addPlayer(players, Played);
                    if(Striker==null) {
                        isAllOut = true;
                        Striker = NonStriker;
                        break;
                    }
                }
                else {
                    Integer run = Integer.parseInt(score.getStatus());
                    team1History.AddTotalRuns(run);
                    updateBatsManHistory(Match.getMatch_id(),Striker,run);
                    if(Integer.parseInt(score.getStatus())%2==1)
                        ChangeStricker(Striker,NonStriker);
                }

                if(team1History.getTotalRuns()>Target){
                    updateBowlerHistory(Match.getMatch_id(),bowler, over.getRunMade(),over.getTotalWickets());
                    return team1History.getTotalRuns();
                }
            }
            updateBowlerHistory(Match.getMatch_id(),bowler, over.getRunMade(),over.getTotalWickets());
        }
        return team1History.getTotalRuns();
    }

    public void ChangeStricker(Player p1, Player p2){
        Player temp = p1;
        p1 = p2;
        p2 = temp;
    }
    public void updateBatsManHistory(Integer Match_ID, Player p, int runs){
        BatsmanHistory temp = p.getBatsman().getMatchWiseHistory(Match_ID);
        temp.addRuns(runs);
        if(runs==4) temp.IncrementFours();
        if(runs==6) temp.IncrementSix();
    }

    public void updateBowlerHistory(Integer Match_ID, Player p, int runs, int totalwickets){
        BowlerHistroy temp = p.getBowler().getMatchWiseHistory(Match_ID);
        temp.addRuns(runs);
        temp.IncrementWickets(totalwickets);
        if(runs==0)
            temp.addMadens();
    }

    public Player addPlayer(ArrayList<Player> players, ArrayList<Player> played){
        if(players.isEmpty())
            return null;
        played.add(players.get(0));
        return (Player)players.remove(0);
    }

    public Player chooseBowler(Player PrevBowler, Team Bowling){
        Random rc = new Random();
        int totalPlayer = Bowling.getPlayers().size();
        int num = rc.nextInt(0,totalPlayer);
        if(PrevBowler==null) return Bowling.getPlayers().get(num);
        if(PrevBowler.equals(Bowling.getPlayers().get(num)))
            return chooseBowler(PrevBowler,Bowling);
        else
            return Bowling.getPlayers().get(num);
    }
}
