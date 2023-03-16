package com.cricketGame.services.generators;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class RandomNumberGenerator extends Random {
    private final static Random randomNumberGenerator = new Random();
    public static Random getInstance(){
        return randomNumberGenerator;
    }
}
