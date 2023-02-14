package com.cricketGame.services.playerSelector;

import com.cricketGame.models.Player;
import com.cricketGame.services.RandomNumberGenerator;

import java.util.List;
import java.util.Random;

public class SelectBatsman {
    public static Player selectBatsman(List<Player> players){
        if(players.isEmpty())
            return null;
        return players.remove(0);
    }
}
