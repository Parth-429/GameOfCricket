package com.cricketGame.models;
import lombok.Data;

import java.util.List;

@Data
public class Team {
    private String name;
    private int totalScore;
    private String overs;
    private int wickets;
    private final int noPlayers;
    private List<Player> players;
    private List<Bowler> bowlers;
    public Team(String name, List<Player> players, List<Bowler> bowler){
        this.name = name;
        this.noPlayers = players.size();
        this.players = players;
        this.bowlers = bowler;
        this.teamStats = new TeamStats();
    }
}
