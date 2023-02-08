package com.cricketGame.models;

import lombok.Data;

@Data
public class Wicket {
    private long playerID;
    private static int wicketNo=0;
    private String wicketType;
    private Ball onWhichBall;
    public Wicket(long playerId, String wicketType){
        this.playerID = playerId;
        this.wicketType = wicketType;
        wicketNo++;
    }
    public static void resetWicketNo(){
        wicketNo = 0;
    }
}
