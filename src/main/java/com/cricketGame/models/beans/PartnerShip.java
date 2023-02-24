package com.cricketGame.models.beans;

import com.cricketGame.models.enums.Runs;
import com.cricketGame.models.beans.player.Player;
import com.cricketGame.services.generators.ObjectIDGenerator;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper=false)
public class PartnerShip extends Bean{
    @ManyToOne(targetEntity = Player.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "batsman1", referencedColumnName = "id")
    private Player striker;
    @ManyToOne(targetEntity = Player.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "batsman2", referencedColumnName = "id")
    private Player nonStriker;
    private int runs = 0;
    public PartnerShip(Player striker, Player nonStriker) {
        super(ObjectIDGenerator.getID());
        this.striker = striker;
        this.nonStriker = nonStriker;
    }
    public void swap(){
        Player temp = this.striker;
        this.striker = this.nonStriker;
        this.nonStriker = temp;
    }
    public void updateRunsMadeInPartnerShip(Runs run){
        runs += run.getRun();
    }
}
