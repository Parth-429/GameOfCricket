package com.cricketGame.services.objectCreation;

import com.cricketGame.models.Bowler;
import com.cricketGame.models.Player;
import com.cricketGame.models.Team;
import com.cricketGame.services.ObjectIDGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TeamFactory{
    public static Team create(long match_ID) {
        String name = "TeamX";
        long teamID = ObjectIDGenerator.getID();
        int teamSize = 10;
        List<Player> players = new ArrayList<>();
        for(int i=0; i<teamSize; i++){
            Player player = PlayerFactory.create(teamID);
            players.add(player);
        }
        PlayerFactory.resetPlayerNo();
        Collections.sort(players, Comparator.comparingInt(Player::getBatsmanOrderNo));
        return new Team(teamID, name, players);
    }
}
