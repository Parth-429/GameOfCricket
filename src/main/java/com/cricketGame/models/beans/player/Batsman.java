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
public class Batsman extends Player {
    public Batsman(Long playerID, Person person, int orderNo){
        super(playerID, person, orderNo, Role.BATSMAN);
    }
}
