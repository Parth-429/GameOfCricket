package com.cricketGame.models.innings;

import com.cricketGame.models.Bean;
import com.cricketGame.models.enums.Runs;
import com.cricketGame.models.player.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PartnerShip{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Transient
    private Player striker;
    @Transient
    private Player nonStriker;
    private int runs;
    public PartnerShip(Player striker, Player nonStriker, int runs) {
        this.striker = striker;
        this.nonStriker = nonStriker;
        this.runs = runs;
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
