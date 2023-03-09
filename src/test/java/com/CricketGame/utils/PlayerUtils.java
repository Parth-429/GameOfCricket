package com.CricketGame.utils;

import com.cricketGame.models.beans.player.Batsman;
import com.cricketGame.models.beans.player.Bowler;
import com.cricketGame.models.beans.player.Player;
import com.cricketGame.services.generators.ObjectIDGenerator;

import java.util.ArrayList;
import java.util.List;

public class PlayerUtils {

    public static Player getBowler(int orderNo){
        return new Bowler(ObjectIDGenerator.getID(), PersonUtils.getPerson("Parth", "Prajapati", 25), orderNo);
    }

    public static Player getBatsman(int orderNo){
        return new Batsman(ObjectIDGenerator.getID(), PersonUtils.getPerson("Parth", "Prajapati", 25), orderNo);
    }

    public static List<Player> getPlayerList(int teamSize){
        List<Player> players = new ArrayList<>();
        int orderNo = 1;
        for(int i =0; i<teamSize; i++){
            players.add(PlayerUtils.getBowler(orderNo++));
        }
        return players;
    }
}
