package com.cricketGame.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WicketType {
    CATCH_OUT("catch out"),
    BOWLED("bowled"),
    RUN_OUT("runout"),
    LBW("lbw");
    private final String displayValue;

}
