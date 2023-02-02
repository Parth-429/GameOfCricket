package com.CricketGame.Services;

import com.CricketGame.Entities.*;

import java.util.Random;

public class GenerateRuns {

    public BallStatus generateRun(){
        Random run = new Random();
        return switch (run.nextInt(8)) {
            case 1 -> BallStatus.Single;
            case 2 -> BallStatus.Double;
            case 3 -> BallStatus.Triple;
            case 4 -> BallStatus.Four;
            case 6 -> BallStatus.Six;
            case 7 -> BallStatus.Wicket;
            default -> BallStatus.DotBall;
        };
    }
}
