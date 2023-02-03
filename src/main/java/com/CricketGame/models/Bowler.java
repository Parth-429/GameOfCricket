package com.cricketGame.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bowler extends Batsman{
    private int wickets;
    private int ball;
    private double economyRate;
    private int runGiven;
    public Bowler(String name){
        super(name);
        setRole("Bowler");
    }
    public void updateBowlingStatistics(int runs, int balls, int wickets){
        this.runGiven += runs;
        this.wickets += wickets;
        this.ball += balls;
        this.economyRate = (this.getRunGiven()/(this.getBall()*1.0))*6;
    }
}
