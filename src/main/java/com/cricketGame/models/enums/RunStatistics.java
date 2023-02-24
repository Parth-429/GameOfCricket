package com.cricketGame.models.enums;

import lombok.Getter;

@Getter
public enum RunStatistics {
    DOT_BALLS,
    ONE_RUNS,
    TWO_RUNS,
    THREE_RUNS,
    FOUR_RUNS,
    FIVE_RUNS,
    SIX_RUNS;
    public static RunStatistics getRunStatisticConstant(Runs run){
        return switch (run){
            case ONE -> RunStatistics.ONE_RUNS;
            case TWO -> RunStatistics.TWO_RUNS;
            case THREE -> RunStatistics.THREE_RUNS;
            case FOUR -> RunStatistics.FOUR_RUNS;
            case SIX -> RunStatistics.SIX_RUNS;
          default -> RunStatistics.DOT_BALLS;
        };
    }
}
