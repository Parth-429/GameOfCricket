package com.cricketGame.services;

import com.cricketGame.models.enums.Coin;

import java.util.Random;

public class TossCoin {
    public static Coin tossCoin(){
        Random rm = RandomNumberGenerator.getInstance();
        int result = rm.nextInt(2);
        return switch (result) {
            case 0 -> Coin.HEAD;
            case 1 -> Coin.TAIL;
            default -> tossCoin();
        };
    }
}
