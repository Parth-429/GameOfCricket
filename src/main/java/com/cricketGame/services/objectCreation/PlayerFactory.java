package com.cricketGame.services.objectCreation;

import com.cricketGame.models.Batsman;
import com.cricketGame.models.Bowler;
import com.cricketGame.models.Player;
import com.cricketGame.models.enums.Role;
import com.cricketGame.models.enums.Runs;
import com.cricketGame.services.ObjectIDGenerator;
import com.cricketGame.services.RandomNumberGenerator;

import java.util.List;

public class PlayerFactory{
    public static final String BOWLER = "Bowler";

    public static int playerNo = 0;
    public static Player create(long teamID) {
        long playerID = ObjectIDGenerator.getID();
        String firstName = "PlayerX" + playerID;
        String lastName = "ABC";
        List<Role> roles = List.of(Role.values());
        Role role = roles.get(RandomNumberGenerator.getInstance().nextInt((roles.size())));
        int age = 32;
        int battingOrderNo = ++playerNo;
        if(Role.BOWLER.equals(role))
            battingOrderNo+=100;
        if(Role.BOWLER.equals(role))
            return new Bowler(playerID, firstName, lastName, age, battingOrderNo);
        else
            return new Batsman(playerID, firstName, lastName, age, battingOrderNo);
    }

    public static void resetPlayerNo(){
        playerNo = 0;
    }
}
