package com.cricketGame.services;

import com.cricketGame.models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class SetGame {
    private Player createPlayer(){
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.println("Is a Bowler/Batsman?[Bowler=0, Batsman=1]");
        String role = sc.next();
        if(role.equals("0"))
            return new Bowler(name);
        else
            return new Batsman(name);
    }
    private Team createTeam(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of your team: ");
        String name = sc.next();
        System.out.println("Enter number of players in your team: ");
        int noPlayers = sc.nextInt();
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Bowler> bowler = new ArrayList<>();
        System.out.println("\n Now, Enter the details of each player---");
        for(int i=0; i<noPlayers; i++){
            System.out.println("\nEnter the name of player "+i+" :");
            Player player = createPlayer();
            players.add(player);
            if(player.getRole().equals("Bowler"))
                bowler.add((Bowler)player);
        }
        System.out.println("\n");
        return new Team(name, players, bowler);
    }
    public Match createMatch(){
        System.out.println("Enter the Number of Overs :");
        Scanner sc = new Scanner(System.in);
        int over = sc.nextInt();
        Team team1 = createTeam();
        Team team2 = createTeam();
        return new Match(team1,team2,over);
    }
}
