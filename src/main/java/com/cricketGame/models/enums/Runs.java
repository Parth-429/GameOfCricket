package com.cricketGame.models.enums;

import lombok.Getter;

import java.util.*;

@Getter
public enum Runs {
    ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), SIX(6), WICKET(-1);
    private final int run;
    Runs(int run) {
        this.run = run;
    }
    private static final Map<Runs, Integer> runProbabilityMapForBatsman = new HashMap<>(
            Map.ofEntries(Map.entry(ZERO, 20), Map.entry(ONE, 25), Map.entry(TWO, 15), Map.entry(THREE, 2),
                    Map.entry(FOUR, 10), Map.entry(SIX, 6), Map.entry(WICKET, 4)));
    private static final Map<Runs, Integer> runProbabilityMapForBowler = new HashMap<>(
            Map.ofEntries(Map.entry(ZERO, 20), Map.entry(ONE, 20), Map.entry(TWO, 8), Map.entry(THREE, 1),
                    Map.entry(FOUR, 4), Map.entry(SIX, 4), Map.entry(WICKET, 10)));

    private static final List<Runs> listOfRunsForBatsman;
    private static final List<Runs> listOfRunsForBowler;

    static {
        listOfRunsForBatsman = new ArrayList<>();
        for (Runs runs : Runs.values()) {
            listOfRunsForBatsman.addAll(Collections.nCopies(runProbabilityMapForBatsman.get(runs), runs));
        }
        Collections.shuffle(listOfRunsForBatsman);

        listOfRunsForBowler = new ArrayList<>();
        for (Runs runs : Runs.values()) {
            listOfRunsForBowler.addAll(Collections.nCopies(runProbabilityMapForBowler.get(runs), runs));
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
