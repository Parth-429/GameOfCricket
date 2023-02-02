package com.CricketGame.Entities;

import java.util.HashMap;

public class AsABowler{

    private String BowlingStyle;
    private Integer WicketTaken = 0;
    private Double EconomyRate = 0.0;
    private HashMap<Integer,BowlerHistroy> MatchWiseHistory;

    public String getBowlingStyle() {
        return BowlingStyle;
    }

    public void setBowlingStyle(String bowlingStyle) {
        BowlingStyle = bowlingStyle;
    }

    public Integer getWicketTaken() {
        return WicketTaken;
    }

    public void setWicketTaken(Integer wicketTaken) {
        WicketTaken = wicketTaken;
    }

    public Double getEconomyRate() {
        return EconomyRate;
    }

    public void setEconomyRate(Double economyRate) {
        EconomyRate = economyRate;
    }

    public AsABowler(){
        this.MatchWiseHistory = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Bowling Summary: \n" +
                "Bowling Style=" + BowlingStyle + "\n" +
                "Wicket Taken=" + WicketTaken + "\n" +
                "Economy Rate=" + EconomyRate + "\n";
    }

    public void addMatchWiseHistory(Integer match_id, BowlerHistroy bowlerHistroy){
        this.MatchWiseHistory.put(match_id,bowlerHistroy);
    }

    public BowlerHistroy getMatchWiseHistory(Integer match_id){
        return this.MatchWiseHistory.get(match_id);
    }
}
