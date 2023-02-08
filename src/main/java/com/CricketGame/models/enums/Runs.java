package com.cricketGame.models.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum Runs {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    WICKET(-1);
    private final int run;
    Runs(int run){
        this.run = run;
    }
}
