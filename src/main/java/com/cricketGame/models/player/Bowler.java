package com.cricketGame.models.player;

import com.cricketGame.models.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@NoArgsConstructor
public class Bowler extends Player{
    public Bowler(long playerID, String firstName, String lastName,int age,  int orderNo){
        super(playerID, firstName, lastName,  age, orderNo, Role.BOWLER);
    }
}
