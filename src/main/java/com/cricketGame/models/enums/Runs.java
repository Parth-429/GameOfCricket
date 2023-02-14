package com.cricketGame.models.enums;

import com.cricketGame.models.Wicket;
import lombok.Data;
import lombok.Getter;

import java.util.*;

@Getter
public enum Runs {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    SIX(6),
    WICKET(-1);

    private final int run;
    Runs(int run){
        this.run = run;
    }

    private static Map<Runs,Integer> runProbabilityMapForBatsman = new HashMap<>(Map.ofEntries(Map.entry(ZERO,15), Map.entry(ONE,30),Map.entry(TWO,25),Map.entry(THREE,5),Map.entry(FOUR,15),Map.entry(SIX,10), Map.entry(WICKET,5)));
    private static Map<Runs,Integer> runProbabilityMapForBowler = new HashMap<>(Map.ofEntries(Map.entry(ZERO,25), Map.entry(ONE,25),Map.entry(TWO,10),Map.entry(THREE,1),Map.entry(FOUR,5),Map.entry(SIX,5), Map.entry(WICKET,20)));

    private static List<Runs> listOfRunsForBatsman;
    private static List<Runs> listOfRunsForBowler;

    static{
        listOfRunsForBatsman = new ArrayList<>();
        for(Runs runs: Runs.values()){
            listOfRunsForBatsman.addAll(Collections.nCopies(runProbabilityMapForBatsman.get(runs),runs));
        }
        Collections.shuffle(listOfRunsForBatsman);

        listOfRunsForBowler = new ArrayList<>();
        for(Runs runs: Runs.values()){
            listOfRunsForBowler.addAll(Collections.nCopies(runProbabilityMapForBowler.get(runs),runs));
        }
        Collections.shuffle(listOfRunsForBowler);
    }

    public static List<Runs> getListOfRunsForBatsman() {
        return listOfRunsForBatsman;
    }

    public static List<Runs> getListOfRunsForBowler() {
        return listOfRunsForBowler;
    }
}
