package com.cricketGame.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Batsman extends Player{
    private int runs,ballsPlayed,six,four;
    private double strikeRate;
    public Batsman(String name){
        this.setName(name);
        this.setRole("Batsman");
    }
    public void updateBattingStatistics(int run){
        this.runs += run;
        this.ballsPlayed++;
        if(run==4) this.six++;
        if(run==6) this.four++;
    }
}
