package com.cricketGame.models;

public enum Runs {
    ZERO("0"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    WICKET("W");
    private final String run;
    public String getRun(){
        return this.run;
    }
    Runs(String run){
        this.run = run;
    }
}
