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

    public static MatchFormat getMatchFormat(String format) {
        if(Constants.ODI_FORMAT.equals(format))
            return MatchFormat.ODI;
        else if(Constants.T20_FORMAT.equals(format))
            return  MatchFormat.T20;
        else if(Constants.TEST_FORMAT.equals(format))
            return  MatchFormat.TEST;
        return MatchFormat.T20;
    }
}
