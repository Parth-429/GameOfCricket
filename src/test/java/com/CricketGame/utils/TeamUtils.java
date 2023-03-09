package com.CricketGame.utils;

import com.cricketGame.dto.TeamDTO;
import com.cricketGame.models.beans.team.Team;
import com.cricketGame.services.generators.ObjectIDGenerator;

public class TeamUtils {
    public static final int TEAM_SIZE = 5;
    public static Team getTeam(String name){
        return new Team(ObjectIDGenerator.getID(), name);
    }

}
