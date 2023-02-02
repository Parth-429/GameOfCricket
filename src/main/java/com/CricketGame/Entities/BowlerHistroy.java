package com.CricketGame.Entities;

public class BowlerHistroy {

    private Integer balls = 0;
    private Integer wickets=0;

    private Integer runs = 0;
    private Integer madens = 0;
    private Double economy = 0.0;

    public Integer getRuns() {
        return runs;
    }

    public Integer getWickets() {
        return wickets;
    }

    public void addBalls(){
        this.balls++;
    }
    public void addRuns(Integer runs) {
        this.runs += runs;
        this.addBalls();
    }

    public void addMadens() {
        this.madens++;
    }

    public Integer getBalls() {
        return balls;
    }

    public void IncrementWickets(Integer wickets) {
        this.wickets += wickets;
    }

    public void IncrementMadens() {
        this.madens++;
    }

    public void updateEconomy() {
        //it will be implemented letter
    }
    public Integer getMadens() {
        return madens;
    }

    public Double getEconomy() {
        return economy;
    }

    @Override
    public String toString() {
        return String.format("\t %.1f \t %d \t %d \t %d \t %..2f\n",(Double)(balls/6.0), wickets, madens, runs, (Double)(runs/(Double)(balls/6.0)));
    }
}
