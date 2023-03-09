package com.CricketGame.utils;

import com.cricketGame.models.beans.team.TeamHistory;
import com.cricketGame.services.generators.ObjectIDGenerator;

public class TeamHistoryUtils {

    public static final int TEAM_SIZE = 5;
    public static TeamHistory getTeamHistory(String name){
        return new TeamHistory(ObjectIDGenerator.getID(), TeamUtils.getTeam(name), PlayerUtils.getPlayerList(TEAM_SIZE),
                TEAM_SIZE);
    }

}
