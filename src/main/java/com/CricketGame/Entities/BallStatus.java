package com.CricketGame.Entities;

import lombok.Getter;

@Getter
public enum BallStatus {
    DotBall("0"),Single("1"),Double("2"),Triple("3"),Four("4"),Six("6"),Wicket("W");
    public final String Status;
    public String getStatus(){
        return this.Status;
    }
    BallStatus(String c) {
        this.Status = c;
    }
}

