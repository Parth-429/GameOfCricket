package com.cricketGame.services.generators;

import java.util.Random;

public class RandomNumberGenerator extends Random {
    private final static RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private RandomNumberGenerator(){};
    public static RandomNumberGenerator getInstance(){
        return randomNumberGenerator;
    }
}
