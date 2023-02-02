package com.CricketGame.Entities;

class WicketHistory{
    private final Integer wicketNo;
    private final Integer atRun;

    private final Player batsman;
    private final Player bowler;

    public WicketHistory(Integer wicketNo, Integer atRun, Player batsman, Player bowler) {
        this.wicketNo = wicketNo;
        this.atRun = atRun;
        this.batsman = batsman;
        this.bowler = bowler;
    }

    public Integer getWicketNo() {
        return wicketNo;
    }

    public Integer getAtRun() {
        return atRun;
    }
}