package com.cricketGame.services;

import com.cricketGame.models.*;
import com.cricketGame.view.ShowInningsDetails;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class StartGame {

    public void startGame(){
        SetGame gameSetter = new SetGame();
        Match match = gameSetter.createMatch();
        TossCoin toss = new TossCoin();
        if(toss.tossCoin().equals(Coin.HEAD))
            match.swap();

        System.out.println(match.getTeam1().getName()+" won the toss and decided to Bat First:");
        System.out.println("\nInning one is started...");
        int firstInning = playInning(match, match.getTeam1(), match.getTeam2(), false);
        System.out.println(match.getTeam1().getName()+ " has Scored "+firstInning+" by losing "+match.getTeam1().getWickets()+" wickets.");
        System.out.println("\nInning two is started and Target is "+(firstInning+1)+" ...");
        int secondInning = playInning(match, match.getTeam2(), match.getTeam1(), true);
        System.out.println(match.getTeam2().getName()+ " has Scored "+secondInning+" by losing "+match.getTeam2().getWickets()+" wickets.");

        System.out.println("\n Scorecard :\n");
        System.out.println("1st Inning Summary :");
        ShowInningsDetails obj = new ShowInningsDetails();
        obj.showInningsDetails(match.getTeam1(), match.getTeam2());
        System.out.println("\n\n2nd Inning Summary :");
        obj.showInningsDetails(match.getTeam2(), match.getTeam1());
        System.out.println("Result of Match:");
        if(firstInning>secondInning) {
            System.out.printf("\nTeam %s won by %d runs%n", match.getTeam1().getName(),firstInning-secondInning);
            match.setWinner(match.getTeam1());
        }
        else if(firstInning<secondInning) {
            System.out.printf("Team %s won by %d wickets%n", match.getTeam2().getName(),match.getTeam2().getNoPlayers()-match.getTeam2().getWickets());
            match.setWinner(match.getTeam2());
        }
        else
            System.out.println("\nMatch has been Tied");
    }

    public int playInning(Match match, Team team1, Team team2, Boolean isSecondInning){
        ArrayList<Player> players = new ArrayList<>(team1.getPlayers());
        final int OVERS = match.getOvers();
        final int BALLS = 6;
        Bowler bowler = null;
        Player striker = addPlayer(players,null);
        Player nonStriker = addPlayer(players,null);
        boolean isAllOut = false;
        RunGenerator runGenerator = new RunGenerator();
        int Target = Integer.MAX_VALUE;
        if(isSecondInning) Target = team2.getTotalScore();
        int totalScore = 0, totalWickets = 0;

        for(int over = 0; over<OVERS; over++){
            bowler = chooseBowler(bowler, team2);
            System.out.println();
            StringBuilder temp = new StringBuilder("\nBowler : " + bowler.getName() + " , " + "Over " + over + " :");
            int overScore = 0, overWickets = 0;
            for(int ball=0; ball<BALLS; ball++) {
                Runs run = runGenerator.generateRun();
                temp.append(" ").append(run.getRun());
                if (run.equals(Runs.WICKET)) {
                    overWickets++;
                    totalWickets++;
                    striker.updateBattingStatistics(0);
                    striker = addPlayer(players, striker);
                    if (striker == null) {
                        isAllOut = true;
                        striker = nonStriker;
                    }
                } else {
                    int currentRun = Integer.parseInt(run.getRun());
                    totalScore += currentRun;
                    overScore += currentRun;
                    striker.updateBattingStatistics(currentRun);
                    if (currentRun % 2 == 1)
                        changeStricker(striker, nonStriker);
                }
                if (isAllOut || totalScore > Target) {
                    bowler.updateBowlingStatistics(overScore, ball + 1, overWickets);
                    team1.setTotalScore(totalScore);
                    team1.setWickets(totalWickets);
                    team1.setOvers(Integer.toString(over) + "." + Integer.toString(ball+1));
                    System.out.println(temp);
                    return totalScore;
                }
            }
            changeStricker(striker, nonStriker);
            System.out.print(temp);
            bowler.updateBowlingStatistics(overScore,6,overWickets);
        }

        System.out.println();
        team1.setTotalScore(totalScore);
        team1.setWickets(totalWickets);
        team1.setOvers(Integer.toString(OVERS)+".0");
        return totalScore;
    }

    public void changeStricker(Player p1, Player p2){
        Player temp = p1;
        p1 = p2;
        p2 = temp;
    }

    public Player addPlayer(ArrayList<Player> players, Player outBatsman){
        if(players.isEmpty())
            return null;
        int i = 0;
        if(outBatsman==null)
            System.out.println("\nChoose Striker/Non-Striker :");
        else
            System.out.println("\nWho is going next to Bat? Select Index no. from Following:");
        for(Player player: players){
            i++;
            System.out.println(i+". "+player.getName());
        }
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        return players.remove(index-1);
    }

    public Bowler chooseBowler(Player prevBowler, Team bowling){
        Random rc = new Random();
        List<Bowler> bowlers = bowling.getBowlers();
        int totalBowlers = bowlers.size();
        int num = rc.nextInt(totalBowlers);
        if(prevBowler==null) return bowlers.get(num);
        if(prevBowler.equals(bowlers.get(num)))
            return chooseBowler(prevBowler,bowling);
        else
            return bowlers.get(num);
    }
}
