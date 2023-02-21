package com.cricketGame.models.enums;

import com.cricketGame.constants.Constants;
import lombok.Data;
import lombok.Getter;

@Getter
public enum MatchFormat {
    T20(Constants.OVERS_FOR_T20),ODI(Constants.OVERS_FOR_ODI),TEST(Constants.OVERS_FOR_TEST);
    private int noOfOvers;
    MatchFormat(int oversForT20) {
        this.noOfOvers = oversForT20;
    }
}
