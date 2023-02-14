package com.cricketGame.services.generators;

import com.cricketGame.models.enums.Coin;

import java.util.Random;

public class TossCoin {
    public static Coin tossCoin(){
        Random rm = RandomNumberGenerator.getInstance();
        if(rm.nextBoolean())
            return Coin.HEAD;
        else
            return Coin.TAIL;
    }
}
