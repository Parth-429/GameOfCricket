package com.cricketGame.services.factory;

import com.cricketGame.models.player.Player;
import com.cricketGame.models.Team;
import com.cricketGame.services.daoServices.AllService;
import com.cricketGame.services.generators.ObjectIDGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TeamFactory{
//    public static Team create(long match_ID) {
////        long teamID = ObjectIDGenerator.getID();
////        String name = "Team_" + teamID + "_" + match_ID;
////        int teamSize = 11;
////        List<Player> players = new ArrayList<>();
////        for(int i=0; i<teamSize; i++){
////            Player player = PlayerFactory.create(teamID);
////            players.add(player);
////        }
////        PlayerFactory.resetPlayerNo();
////        Collections.sort(players, Comparator.comparingInt(Player::getBatsmanOrderNo));
////        return new Team(teamID, name, players, teamSize );
//    }
}
