package com.cricketGame.services.objectCreation;

import com.cricketGame.models.Match;
import com.cricketGame.models.Team;

public class MatchFactory{
    public static Match create(long matchID) {
        int over = 10;
        Team team1 = TeamFactory.create(matchID);
        Team team2 = TeamFactory.create(matchID);
        return new Match(matchID,team1,team2,over);
    }
}