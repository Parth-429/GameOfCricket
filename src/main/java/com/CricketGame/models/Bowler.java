package com.cricketGame.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Bowler extends Player{
    public Bowler(long playerID, String firstName, String lastName,int age,  int orderNo){
        super(playerID, firstName, lastName,  age, orderNo, "Bowler");
    }
}
