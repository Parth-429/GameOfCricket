package com.cricketGame.services;

import com.cricketGame.models.Runs;

import java.util.Random;

public class RunGenerator {
    public Runs generateRun(){
        Random run = new Random();
        return switch (run.nextInt(8)) {
            case 1 -> Runs.ONE;
            case 2 -> Runs.TWO;
            case 3 -> Runs.THREE;
            case 4 -> Runs.FOUR;
            case 5 -> Runs.FIVE;
            case 6 -> Runs.SIX;
            case 7 -> Runs.WICKET;
            default -> Runs.ZERO;
        };
    }
}
