package com.CricketGame.Services;

import com.CricketGame.Entities.AsABatsman;
import com.CricketGame.Entities.Player;

public class UpdateBatsman {
    private AsABatsman player;

    public UpdateBatsman(Player player) {
        this.player = player.getBatsman();
    }

    public void addRuns(int run){
        this.player.setTotalRuns(this.player.getTotalRuns()+run);
    }

    public void addSix(int sixes){
        this.player.setNoSixes(this.player.getNoSixes()+sixes);
    }

    public void addFour(int fours){
        this.player.setNoFours(this.player.getNoFours()+fours);
    }

    public void updateStrikeRate(int run, int ball){
        //It will be implemented later
    }

    public void updateAverage(int run){
        //It will be implemented later
    }

    public void addCentury() {
        this.player.setCenturies(this.player.getCenturies()+1);
    }

    public void addHalfCentury(){
        this.player.setHalfCenturies(this.player.getCenturies()+1);
    }
    public void update(int run, int ball,int six, int four){
        this.addRuns(run);
        this.addSix(six);
        this.addFour(four);
        this.updateAverage(run);
        this.updateStrikeRate(run, ball);
        if(run>=100)
            this.addHalfCentury();
        else if(run>=50)
            this.addCentury();
        if(run>this.player.getHighestRun()) this.player.setHighestRun(run);
    }
}
