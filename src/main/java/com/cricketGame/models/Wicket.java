package com.cricketGame.models;

import com.cricketGame.models.enums.WicketType;
import lombok.Data;

@Data
public class Wicket {
    private long playerID;
    private static int wicketNo=0;
    private WicketType wicketType;
    private Ball onWhichBall;
    public Wicket(long playerId, WicketType wicketType){
        this.playerID = playerId;
        this.wicketType = wicketType;
        wicketNo++;
    }
    public static void resetWicketNo(){
        wicketNo = 0;
    }
}
