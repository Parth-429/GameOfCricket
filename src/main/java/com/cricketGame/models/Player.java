package com.cricketGame.models;
import com.cricketGame.models.enums.Role;
import com.cricketGame.models.stats.BatsmanStats;
import com.cricketGame.models.stats.BowlerStats;
import com.cricketGame.models.stats.Stats;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Player extends Person{
    private Role role;
    private Stats bowlerStats;
    private Stats batsmanStats;
    private int batsmanOrderNo;

    public Player(long playerID, String firstName, String lastName,  int age, int orderNo, Role role) {
        super(playerID,firstName,lastName,age);
        this.batsmanOrderNo = orderNo;
        this.role = role;
    }
    public Stats getBowlerStats(){
        if(this.bowlerStats == null)
            this.bowlerStats = new BowlerStats();
        return this.bowlerStats;
    }
    public Stats getBatsmanStats(){
        if(this.batsmanStats ==null)
            this.batsmanStats = new BatsmanStats();
        return this.batsmanStats;
    }

}
