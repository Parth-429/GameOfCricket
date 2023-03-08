package com.cricketGame.services.playerSelector;

import com.cricketGame.models.beans.player.Player;
import com.cricketGame.services.generators.RandomNumberGenerator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Random;

@Component
public class BowlerSelector {
    public Player selectBowler(Player prevBowler, List<Player> bowlers){
        Random rm = RandomNumberGenerator.getInstance();
        int totalBowlers = bowlers.size();
        if(prevBowler==null)
            return bowlers.get(rm.nextInt(totalBowlers));
        int i = 0;
        for(Player player: bowlers) {
            if (Objects.equals(player.getId(), prevBowler.getId()))
                break;
            i++;
        }
        bowlers.remove(i);
        Player nextBowler = bowlers.get(rm.nextInt(totalBowlers-1));
        bowlers.add(prevBowler);
        return nextBowler;
    }
}
