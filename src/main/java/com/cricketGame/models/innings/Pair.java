package com.cricketGame.models.innings;

import com.cricketGame.models.player.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pair {
    private Player striker;
    private Player nonStriker;
    public void swap(){
        Player temp = this.striker;
        this.striker = this.nonStriker;
        this.nonStriker = temp;
    }
}
