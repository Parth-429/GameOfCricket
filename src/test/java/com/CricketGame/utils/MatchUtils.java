package com.CricketGame.utils;

import com.cricketGame.models.beans.Match;

import com.cricketGame.models.enums.MatchFormat;
import com.cricketGame.services.generators.ObjectIDGenerator;

import java.util.ArrayList;
import java.util.List;

public class MatchUtils {
    public static final int ALLOWED_TEAM_SIZE = 5;
    public static Match getMatch(String team1Name, String team2Name){
        return new Match(ObjectIDGenerator.getID(),TeamHistoryUtils.getTeamHistory(team1Name),
                TeamHistoryUtils.getTeamHistory(team2Name), ALLOWED_TEAM_SIZE, MatchFormat.T20);
    }

    public static List<Match> getMatchList(){
        List<Match> matches = new ArrayList<>();
        matches.add(getMatch("Team1", "Team2"));
        matches.add(getMatch("Team3", "Team4"));
        return matches;
    }
}
