package com.cricketGame.models.player;

import com.cricketGame.models.enums.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Bowler extends Player{
    public Bowler(long playerID, String firstName, String lastName,int age,  int orderNo){
        super(playerID, firstName, lastName,  age, orderNo, Role.BOWLER);
    }
}
