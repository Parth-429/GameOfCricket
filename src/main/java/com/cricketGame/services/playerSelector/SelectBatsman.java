package com.cricketGame.services.playerSelector;

import com.cricketGame.models.player.Player;

import java.util.List;

public class SelectBatsman {
    public static Player selectBatsman(List<Player> players){
        if(players.isEmpty())
            return null;
        return players.remove(0);
    }
}
