package com.cricketGame.services.factory;

import com.cricketGame.constants.Constants;
import com.cricketGame.models.Match;
import com.cricketGame.models.Team;
import com.cricketGame.services.daoServices.AllService;

public class MatchFactory{
    public static Match create(long matchID) {
        return AllService.matchService.findMatchById(matchID);
    }
}
