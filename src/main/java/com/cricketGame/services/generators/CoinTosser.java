package com.cricketGame.services.generators;

import com.cricketGame.models.enums.Coin;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class CoinTosser {
    public Coin tossCoin(){
        Random rm = RandomNumberGenerator.getInstance();
        return Coin.values()[rm.nextInt(Coin.values().length)];
    }
}
