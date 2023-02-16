package com.cricketGame.models.player;
import com.cricketGame.models.enums.Role;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@NoArgsConstructor
public class Batsman extends Player {
    public Batsman(long playerID, String firstName, String lastName, int age, int orderNo){
        super(playerID, firstName, lastName, age, orderNo, Role.BATSMAN);
    }
}
