package com.cricketGame.services.generators;

import com.cricketGame.models.enums.Role;
import com.cricketGame.models.enums.Runs;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RunGenerator {

    public Runs generateRun(Role role){
        Random rm = RandomNumberGenerator.getInstance();
        if(Role.BATSMAN.equals(role))
            return Runs.getListOfRunsForBatsman().get(rm.nextInt(Runs.getListOfRunsForBatsman().size()));
        else
            return Runs.getListOfRunsForBowler().get(rm.nextInt(Runs.getListOfRunsForBowler().size()));
    }
}