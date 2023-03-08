package com.cricketGame.services.playerSelector;

import com.cricketGame.models.beans.player.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BatsmanSelector {
    public Player selectBatsman(List<Player> players){
        if(players.isEmpty())
            return null;
        return players.remove(0);
    }
}
