package com.CricketGame.Services;

import com.CricketGame.Entities.AsABowler;
import com.CricketGame.Entities.Player;

public class UpdateBowler {
    private AsABowler bowler;
    public UpdateBowler(Player player) {
        this.bowler = player.getBowler();
    }
    public void updateWickets(int wickets){
        this.bowler.setWicketTaken(this.bowler.getWicketTaken()+1);
    }
    public void update(int wickets){
        this.updateWickets(wickets);
    }
}
