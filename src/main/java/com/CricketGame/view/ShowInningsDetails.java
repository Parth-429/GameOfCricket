package com.cricketGame.view;

import com.cricketGame.models.Batsman;
import com.cricketGame.models.Bowler;
import com.cricketGame.models.Player;
import com.cricketGame.models.Team;


public class ShowInningsDetails {
    public void showInningsDetails(Team batting, Team bowling){
        System.out.println("Batting Summary : "+batting.getName());
        System.out.println("\nPlayer\t\tRuns\tBalls\tSix\tFour");
        for(Player player: batting.getPlayers()){
            Batsman batsman = (Batsman) player;
            if(batsman.getBallsPlayed()==0)
                continue;
            System.out.printf("%6s\t\t%4d\t%4d\t%3d\t%4d%n",player.getName(),batsman.getRuns(),batsman.getBallsPlayed(),batsman.getSix(),batsman.getFour());
        }
        System.out.printf("%s Total Score = %d/%d, Overs: %s%n",batting.getName(), batting.getTotalScore(), batting.getWickets(), batting.getOvers());
        System.out.println();
        System.out.println("Bowling Summary : "+bowling.getName());
        System.out.println("\nPlayer\t\tOvers\tRuns\tWickets\tEconomyRate");
        for(Bowler bowler: bowling.getBowlers()){
            if(bowler.getBall()==0)
                continue;
            String over = Integer.toString(bowler.getBall()/6)+"."+Integer.toString(bowler.getBall()%6);
            System.out.printf("%6s\t\t%5s\t%4d\t%7d\t%10.2f%n",bowler.getName(),over,bowler.getRunGiven(),bowler.getWickets(), bowler.getEconomyRate());
        }
    }
}
