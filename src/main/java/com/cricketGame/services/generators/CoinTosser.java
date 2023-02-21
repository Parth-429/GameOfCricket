package com.cricketGame.services.generators;

import com.cricketGame.models.enums.Coin;

import java.util.List;
import java.util.Random;

public class CoinTosser {
    public static Coin tossCoin(){
        Random rm = RandomNumberGenerator.getInstance();
        return Coin.values()[rm.nextInt(Coin.values().length)];
    }
}
