package com.cricketGame.models;
import com.cricketGame.models.enums.Role;
import lombok.Data;
@Data
public class Batsman extends Player {
    public Batsman(long playerID, String firstName, String lastName, int age, int orderNo){
        super(playerID, firstName, lastName, age, orderNo, Role.Batsman);
    }
}
