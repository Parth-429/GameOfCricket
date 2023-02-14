package com.cricketGame.models.player;
import com.cricketGame.models.enums.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Batsman extends Player {
    public Batsman(long playerID, String firstName, String lastName, int age, int orderNo){
        super(playerID, firstName, lastName, age, orderNo, Role.BATSMAN);
    }
}
