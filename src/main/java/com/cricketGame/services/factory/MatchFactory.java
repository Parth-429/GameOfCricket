package com.cricketGame.services.factory;

import com.cricketGame.constants.Constants;
import com.cricketGame.models.Match;
import com.cricketGame.models.Team;
import com.cricketGame.services.daoServices.AllService;

public class MatchFactory{
    public static Match create(long matchID) {
        Team team1 = TeamFactory.create(matchID);
        Team team2 = TeamFactory.create(matchID);
        return new Match(matchID,team1,team2, Constants.ALLOWED_TEAM_SIZE);
    }
}
