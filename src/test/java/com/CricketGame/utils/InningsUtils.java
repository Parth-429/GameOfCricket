package com.CricketGame.utils;

import com.cricketGame.models.beans.Innings;

public class InningsUtils {

    public static Innings getInnings(){
        return new Innings(TeamHistoryUtils.getTeamHistory("TeamX"), TeamHistoryUtils.getTeamHistory("TeamY"));
    }

}
