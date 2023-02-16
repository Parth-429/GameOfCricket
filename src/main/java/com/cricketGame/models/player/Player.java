package com.cricketGame.models.player;
import com.cricketGame.models.enums.Role;
import com.cricketGame.models.stats.BatsmanStats;
import com.cricketGame.models.stats.BowlerStats;
import com.cricketGame.models.stats.Stats;
import com.cricketGame.services.generators.ObjectIDGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "player")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Player extends Person{
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne(targetEntity = BowlerStats.class, mappedBy = "player", cascade = CascadeType.ALL)
    private Stats bowlerStats;
    @OneToOne(targetEntity = BatsmanStats.class, mappedBy = "player", cascade = CascadeType.ALL)
    private Stats batsmanStats;
    private int batsmanOrderNo;

    public Player(long playerID, String firstName, String lastName,  int age, int orderNo, Role role) {
        super(firstName,lastName,age);
        this.setId(playerID);
        this.batsmanOrderNo = orderNo;
        this.role = role;
    }
    public Stats getBowlerStats(){
        if(this.bowlerStats == null) {
            this.bowlerStats = new BowlerStats();
            ((BowlerStats)(this.bowlerStats)).setId(ObjectIDGenerator.getID());
            ((BowlerStats)(this.bowlerStats)).setPlayer(this);
        }
        return this.bowlerStats;
    }
    public Stats getBatsmanStats(){
        if(this.batsmanStats ==null){
            this.batsmanStats = new BatsmanStats();
            ((BatsmanStats)(this.batsmanStats)).setId(ObjectIDGenerator.getID());
            ((BatsmanStats)(this.batsmanStats)).setPlayer(this);
        }
        return this.batsmanStats;
    }

}
