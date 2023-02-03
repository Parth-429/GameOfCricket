package com.cricketGame.services;

import com.cricketGame.models.Coin;

import java.util.Random;

public class TossCoin {
    public Coin tossCoin(){
        Random rm = new Random();
        int result = rm.nextInt(2);
        return switch (result) {
            case 0 -> Coin.HEAD;
            case 1 -> Coin.TAIL;
            default -> tossCoin();
        };
    }
}
