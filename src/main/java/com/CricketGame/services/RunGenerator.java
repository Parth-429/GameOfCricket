package com.cricketGame.services;

import com.cricketGame.models.enums.Runs;

import java.util.List;
import java.util.Random;
public class RunGenerator {
    public static Runs generateRun(){
        Random rm = RandomNumberGenerator.getInstance();
        List<Runs> runs = List.of(Runs.values());
        return runs.get(rm.nextInt(runs.size()));
    }
}