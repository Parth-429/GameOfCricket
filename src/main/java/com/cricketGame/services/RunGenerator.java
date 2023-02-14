package com.cricketGame.services;

import com.cricketGame.models.enums.Role;
import com.cricketGame.models.enums.Runs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class RunGenerator {

    public static Runs generateRun(Role role){
        Random rm = RandomNumberGenerator.getInstance();
        if(Role.BATSMAN.equals(role))
            return Runs.getListOfRunsForBatsman().get(rm.nextInt(Runs.getListOfRunsForBatsman().size()));
        else
            return Runs.getListOfRunsForBowler().get(rm.nextInt(Runs.getListOfRunsForBowler().size()));
    }
}