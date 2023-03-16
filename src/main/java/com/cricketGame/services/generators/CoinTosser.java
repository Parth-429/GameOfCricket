package com.cricketGame.services.generators;

import com.cricketGame.models.enums.Coin;
import lombok.experimental.UtilityClass;
import java.util.Random;

@UtilityClass
public class CoinTosser {
    public Coin tossCoin(){
        Random rm = RandomNumberGenerator.getInstance();
        return Coin.values()[rm.nextInt(Coin.values().length)];
    }
}
