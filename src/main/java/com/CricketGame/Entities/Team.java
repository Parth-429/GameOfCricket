package com.CricketGame.Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Team{
    private String Name;
    private Integer InningsPlayed = 0;
    private Integer Wins=0;
    private HashMap<Integer,TeamHistory> MatchWiseHistory;
    private List<Player> Players;

    public List<Player> getPlayers() {
        return Players;
    }

    public void setPlayers(List<Player> players) {
        Players = players;
    }
    public String getName(){
        return this.Name;
    }
    public Team(Builder b){
        this.Name = b.Name;
        this.InningsPlayed = b.InningsPlayed;
        this.Wins = b.Wins;
        this.Players = new ArrayList<>();
        this.MatchWiseHistory = new HashMap<>();
    }

    public void IncrementInnings(){
        this.InningsPlayed++;
    }
    public void IncrementWins(){
        this.Wins++;
    }
    public void addMatchWiseHistory(Integer match_id, ArrayList<Player> players){
        this.MatchWiseHistory.put(match_id, new TeamHistory(match_id, players));
    }

    public TeamHistory getMatchWiseHistory(Integer match_id){
        return this.MatchWiseHistory.get(match_id);
    }
    public static class Builder{
        private String Name;
        private Integer InningsPlayed = 0, Wins=0;
        public Builder(String Name){
            this.Name = Name;
        }

        public Builder setInningsPlayed(Integer inningsPlayed) {
            InningsPlayed = inningsPlayed;
            return this;
        }

        public Builder setWins(Integer wins) {
            Wins = wins;
            return this;
        }

        public Team SaveDetails(){
            return new Team(this);
        }
    }
}
