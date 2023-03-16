package com.cricketGame.services.playerSelector;

import com.cricketGame.models.beans.player.Player;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class BatsmanSelector {
    public Player selectBatsman(List<Player> players){
        if(players.isEmpty())
            return null;
        return players.remove(0);
    }
}
