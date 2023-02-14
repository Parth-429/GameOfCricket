package com.cricketGame.services.playerSelector;

import com.cricketGame.models.player.Player;
import com.cricketGame.services.generators.RandomNumberGenerator;

import java.util.List;
import java.util.Random;

public class SelectBowler {
    public static Player selectBowler(Player prevBowler, List<Player> bowlers){
        Random rm = RandomNumberGenerator.getInstance();
        int totalBowlers = bowlers.size();
        if(prevBowler==null)
            return bowlers.get(rm.nextInt(totalBowlers));

        int i = 0;
        for(Player player: bowlers) {
            if (player.getPersonID() == prevBowler.getPersonID())
                break;
            i++;
        }

        bowlers.remove(i);
        Player nextBowler = bowlers.get(rm.nextInt(totalBowlers-1));
        bowlers.add(prevBowler);
        return nextBowler;
    }
}
