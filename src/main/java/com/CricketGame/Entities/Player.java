package com.CricketGame.Entities;

import java.sql.SQLOutput;

public class Player {
    private String Name;
    private AsABatsman batsman;
    private AsABowler bowler;
    private String Type;
    private Integer InningsPlayed;
    public void addInningPlayed(){
        this.InningsPlayed++;
    }
    public String getName() {
        return Name;
    }
    public AsABatsman getBatsman() {
        return batsman;
    }

    public AsABowler getBowler() {
        return bowler;
    }

    public String getType() {
        return Type;
    }

    public Integer getInningsPlayed() {
        return InningsPlayed;
    }

    public Player(Builder b){
        this.Name = b.Name;
        this.batsman = b.batsman;
        this.bowler = b.bowler;
        this.Type = b.Type;
        this.InningsPlayed = b.InningsPlayed;
    }

    public static class Builder{
        private String Name;
        private Double Average, StrikeRate, EconomyRate;
        private Integer InningsPlayed, Centuries, HalfCenturies, NoSixes, NoFours, TotalRuns, WicketTaken;
        private String BallingStyle, BattingStyle;
        private AsABowler bowler;
        private AsABatsman batsman;
        private String Type;

        public Builder(String Name, String Type){
            this.Name = Name;
            this.Type = Type;
            this.bowler = new AsABowler();
            this.batsman = new AsABatsman();
        }

        public Builder setAverage(Double average) {
            this.batsman.setAverage(average);
            return this;
        }

        public Builder setStrikeRate(Double strikeRate) {
            this.batsman.setStrikeRate(strikeRate);
            return this;
        }

        public Builder setInningsPlayed(Integer inningsPlayed) {
            InningsPlayed = inningsPlayed;
            return this;
        }

        public Builder setCenturies(Integer centuries) {
            this.batsman.setCenturies(centuries);
            return this;
        }

        public Builder setHalfCenturies(Integer halfCenturies) {
            this.batsman.setHalfCenturies(halfCenturies);
            return this;
        }

        public Builder setNoSixes(Integer noSixes) {
            this.batsman.setNoSixes(noSixes);
            return this;
        }

        public Builder setNoFours(Integer noFours) {
            this.batsman.setNoFours(noFours);
            return this;
        }

        public Builder setTotalRuns(Integer totalRuns) {
            this.batsman.setTotalRuns(totalRuns);
            return this;
        }

        public Builder setWicketTaken(Integer wicketTaken) {
            this.bowler.setWicketTaken(wicketTaken);
            return this;
        }

        public Builder setEconomyRate(Double economyRate) {
            this.bowler.setEconomyRate(economyRate);
            return this;
        }

        public Builder setBallingStyle(String ballingStyle) {
            this.bowler.setBowlingStyle(ballingStyle);
            return this;
        }
        public Builder setBattingStyle(String battingStyle) {
            this.batsman.setBattingStyle(battingStyle);
            return this;
        }
        public Player SaveDetails() {
            return new Player(this);
        }

    }

    @Override
    public String toString() {
        return "Player Details: \n" +
                "Name =" + Name + "\n" +
                "Type = " + Type + "\n " +
                "InningsPlayed = " + InningsPlayed + "\n";
    }
    public void showDetails(){
        System.out.println(this.batsman);
        System.out.println(this.bowler);
    }
}
