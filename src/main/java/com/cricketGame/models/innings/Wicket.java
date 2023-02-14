package com.cricketGame.models.innings;

import com.cricketGame.models.Bean;
import com.cricketGame.models.enums.WicketType;
import com.cricketGame.services.generators.ObjectIDGenerator;
import lombok.Data;

@Data
public class Wicket extends Bean {
    private final long playerID;
    private static int wicketNo=0;
    private final WicketType wicketType;
    private Ball onWhichBall;
    public Wicket(long playerId, WicketType wicketType){
        this.setId(ObjectIDGenerator.getID());
        this.playerID = playerId;
        this.wicketType = wicketType;
        wicketNo++;
    }
    public static void resetWicketNo(){
        wicketNo = 0;
    }
}
