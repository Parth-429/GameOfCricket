package com.cricketGame.services.factory;

import com.cricketGame.models.beans.Match;
import com.cricketGame.services.daoServices.AllService;

public class MatchFactory{
    public static Match create(long matchID) {
        return AllService.matchService.findMatchById(matchID);
    }
}
