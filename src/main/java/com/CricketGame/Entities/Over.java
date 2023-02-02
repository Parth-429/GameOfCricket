package com.CricketGame.Entities;

import java.util.ArrayList;
import java.util.List;

public class Over {
    private Player bowler;
    private List<String> balls;
    private Integer runMade = 0;
    private Integer totalWickets = 0;
    public Over(){
        this.balls = new ArrayList<>();
        this.runMade = 0;
    }

    public Integer getTotalWickets() {
        return totalWickets;
    }

    public void addBall(BallStatus b){
        if(b.equals(BallStatus.Wicket))
            this.totalWickets++;
        else
            this.runMade += Integer.parseInt(b.getStatus());
        this.balls.add(b.getStatus());
    }

    public void setBowler(Player bowler) {
        this.bowler = bowler;
    }

    public Player getBowler() {
        return bowler;
    }

    public List<String> getBalls() {
        return balls;
    }

    public Integer getRunMade() {
        return runMade;
    }
}
