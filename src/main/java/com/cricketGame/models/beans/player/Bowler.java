package com.cricketGame.models.beans.player;

import com.cricketGame.models.enums.Role;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@NoArgsConstructor
public class Bowler extends Player{
    public Bowler(Long playerID, Person person, int orderNo){
        super(playerID, person, orderNo, Role.BOWLER);
    }
}
