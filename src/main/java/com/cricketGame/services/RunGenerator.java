package com.cricketGame.services;

import com.cricketGame.models.enums.Runs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class RunGenerator {
    public static ArrayList<Runs> choices = new ArrayList<>();

    static{
        int i = 1;
        for(Runs runs: Runs.values()){
            choices.addAll(Collections.nCopies(i,runs));
            i*=2;
        }
        Collections.shuffle(choices);
    }
    public static Runs generateRun(){
        Random rm = RandomNumberGenerator.getInstance();
        return choices.get(rm.nextInt(choices.size()));
    }
}