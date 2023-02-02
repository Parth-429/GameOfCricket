package com.CricketGame.Entities;

import java.util.HashMap;

public class AsABatsman{
    private Integer TotalRuns = 0;
    private Double Average = 0.0;
    private Double StrikeRate = 0.0;
    private Integer Centuries = 0;
    private Integer HalfCenturies = 0;
    private Integer NoSixes = 0;
    private Integer NoFours = 0;
    private Integer HighestRun = 0;
    private String BattingStyle;

    private HashMap<Integer,BatsmanHistory> MatchWiseHistory;

    public AsABatsman(){
        this.MatchWiseHistory = new HashMap<>();
    }

    public Integer getHighestRun() {
        return HighestRun;
    }

    public void setHighestRun(Integer highestRun) {
        HighestRun = highestRun;
    }

    public Integer getTotalRuns() {
        return TotalRuns;
    }

    public void setTotalRuns(Integer totalRuns) {
        this.TotalRuns += totalRuns;
    }

    public Double getAverage() {
        return Average;
    }

    public void setAverage(Double average) {
        Average = average;
    }

    public Double getStrikeRate() {
        return StrikeRate;
    }

    public void setStrikeRate(Double strikeRate) {
        StrikeRate = strikeRate;
    }

    public Integer getCenturies() {
        return Centuries;
    }

    public void setCenturies(Integer centuries) {
        Centuries = centuries;
    }

    public Integer getHalfCenturies() {
        return HalfCenturies;
    }

    public void setHalfCenturies(Integer halfCenturies) {
        HalfCenturies = halfCenturies;
    }

    public Integer getNoSixes() {
        return NoSixes;
    }

    public void setNoSixes(Integer noSixes) {
        NoSixes = noSixes;
    }

    public Integer getNoFours() {
        return NoFours;
    }

    public void setNoFours(Integer noFours) {
        NoFours = noFours;
    }

    public String getBattingStyle() {
        return BattingStyle;
    }

    public void setBattingStyle(String battingStyle) {
        BattingStyle = battingStyle;
    }

    @Override
    public String toString() {
        return "Batting Summary :\n" +
                "BattingStyle = " + BattingStyle + "\n" +
                "Total Runs = " + TotalRuns + "\n" +
                "Highest Runs = " + HighestRun + "\n" +
                "Average = " + Average + "\n" +
                "Strike Rate = " + StrikeRate + "\n" +
                "Centuries = " + Centuries + "\n" +
                "Half Centuries = " + HalfCenturies + "\n" +
                "NoSixes = " + NoSixes + "\n" +
                "NoFours = " + NoFours + "\n" ;
    }

    public void addMatchWiseHistory(Integer match_id, Integer order_num){
        this.MatchWiseHistory.put(match_id, new BatsmanHistory(order_num));
    }

    public BatsmanHistory getMatchWiseHistory(Integer match_id){
        return this.MatchWiseHistory.get(match_id);
    }
}
