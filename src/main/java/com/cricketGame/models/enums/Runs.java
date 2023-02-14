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

    private static Map<Runs,Integer> runProbabilityMapForBatsman = new HashMap<>(Map.ofEntries(Map.entry(ZERO,32), Map.entry(ONE,32),Map.entry(TWO,16),Map.entry(THREE,2),Map.entry(FOUR,8),Map.entry(SIX,4), Map.entry(WICKET,4)));
    private static Map<Runs,Integer> runProbabilityMapForBowler = new HashMap<>(Map.ofEntries(Map.entry(ZERO,32), Map.entry(ONE,16),Map.entry(TWO,8),Map.entry(THREE,1),Map.entry(FOUR,4),Map.entry(SIX,4), Map.entry(WICKET,16)));

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
