package com.CricketGame.Entities;

public class BatsmanHistory {
    private Integer orderNumber;
    private Integer runs=0;
    private Integer balls = 0;
    private Integer six = 0;
    private Integer fours = 0;

    public BatsmanHistory(int orderNumber){
        this.orderNumber = orderNumber;
    }

    public Player getBowledBy() {
        return BowledBy;
    }

    public void setBowledBy(Player bowledBy) {
        BowledBy = bowledBy;
    }

    private Player BowledBy;

    public void addRuns(Integer runs) {
        this.runs += runs;
        this.balls++;
    }
    public void IncrementSix() {
        this.six++;
    }

    public void IncrementFours() {
        this.fours++;
    }

    public Integer getRuns() {
        return runs;
    }

    public Integer getBalls() {
        return balls;
    }

    public Integer getSix() {
        return six;
    }
    public Integer getFours() {
        return fours;
    }

    @Override
    public String toString() {
        String bowler = "Out by " + BowledBy.getName();
        if(BowledBy==null && balls==0)
            bowler = "Not Out";
        return bowler+"\t" + runs + "\t" + balls + "\t" + six + "\t" + fours +"\n";
    }
}
