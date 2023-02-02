package com.CricketGame.Services;

import com.CricketGame.Entities.Coin;

import java.util.Random;

public class TossCoin {
    public Coin TossTheCoin(){
        Random rm = new Random();
        int temp = rm.nextInt(2);

        switch (temp){
            case 0 : return Coin.Head;
            case 1 : return Coin.Tail;
            default: return TossTheCoin();
        }
    }
}
